package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.controller.PatientApiController;
import com.example.PhysioCenter.domain.dto.message.AddMessageDto;
import com.example.PhysioCenter.domain.dto.message.MessageDto;
import com.example.PhysioCenter.domain.dto.message.LastMessageListDto;
import com.example.PhysioCenter.domain.dto.message.MessageObjectDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.entity.Message;
import com.example.PhysioCenter.domain.exceptions.FailedSendMessage;
import com.example.PhysioCenter.domain.repository.MessageRepository;
import com.example.PhysioCenter.service.MessageService;
import com.example.PhysioCenter.service.PatientService;
import com.example.PhysioCenter.service.PhysioService;
import com.example.PhysioCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final PatientService patientService;
    private final PhysioService physioService;
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);

    @Autowired
    public MessageServiceImpl(
            UserService userService,
            MessageRepository messageRepository,
            PatientService patientService,
            PhysioService physioService
    ) {
        this.messageRepository = messageRepository;
        this.patientService = patientService;
        this.physioService = physioService;
        this.userService = userService;
    }

    private LastMessageListDto getPatientMessages(Long patientId) {
        LOGGER.info("getPatientMessages(" + patientId + ")");
        List<Long> lastMessageIds = messageRepository.getPhysioMessageIds(patientId);
        List<MessageObjectDto> lastMessages = new ArrayList<>();
        LOGGER.info("getPatientMessages(" + patientId + ") lastMessageIds: " + lastMessageIds.toString());

        for (Long physioId: lastMessageIds) {
            Message m = messageRepository.getLastMessage(patientId, physioId);
            if (m != null) {
                lastMessages.add(new MessageObjectDto(
                        m.dto(),
                        patientService.getPatientById(m.getPatientId()),
                        physioService.getPhysioById(m.getPhysioId())
                ));
            }
        }

        return new LastMessageListDto(lastMessages);
    }

    private LastMessageListDto getPhysioMessages(Long physioId) {
        LOGGER.info("getPhysioMessages(" + physioId + ")");
        List<Long> lastMessageIds = messageRepository.getPatientMessageIds(physioId);
        List<MessageObjectDto> lastMessages = new ArrayList<>();
        LOGGER.info("getPhysioMessages(" + physioId + ") lastMessageIds: " + lastMessageIds.toString());

        for (Long patientId: lastMessageIds) {
            Message m = messageRepository.getLastMessage(patientId, physioId);
            if (m != null) {
                lastMessages.add(new MessageObjectDto(
                        m.dto(),
                        patientService.getPatientById(m.getPatientId()),
                        physioService.getPhysioById(m.getPhysioId())
                ));
            }
        }

        return new LastMessageListDto(lastMessages);
    }

    @Override
    public LastMessageListDto getLastMessages(Long currentUserId) {
        UserDto user = userService.getUserById(currentUserId);
        if (user != null) {
            if (user.getPatientId() !=  null) {
                return this.getPatientMessages(user.getPatientId());
            } else if (user.getPhysioId() != null) {
                return this.getPhysioMessages(user.getPhysioId());
            }
        }

        return null;
    }

    @Override
    public MessageDto postMessage(AddMessageDto message) throws FailedSendMessage {
        Message createdMessage = messageRepository.save(
                new Message().toBuilder()
                        .patientId(message.getPatientId())
                        .physioId(message.getPhysioId())
                        .directionToPhysio(message.getDirectionToPhysio())
                        .message(message.getMessage())
                        .build()
        );

        if (createdMessage == null) {
            throw new FailedSendMessage();
        }

        return createdMessage.dto();
    }

    @Override
    public List<MessageDto> getMessageWithPerson(Long physioId, Long patientId) {
        return StreamSupport.stream(messageRepository
                    .getMessageWithPerson(physioId, patientId)
                    .spliterator(), false)
                    .map(Message::dto)
                    .collect(Collectors.toList()
        );
    }
}
