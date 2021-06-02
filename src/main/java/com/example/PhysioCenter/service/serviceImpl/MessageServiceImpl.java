package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.controller.PatientApiController;
import com.example.PhysioCenter.domain.dto.message.MessageDto;
import com.example.PhysioCenter.domain.dto.message.MessageListDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.entity.Message;
import com.example.PhysioCenter.domain.repository.MessageRepository;
import com.example.PhysioCenter.service.MessageService;
import com.example.PhysioCenter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final UserService userService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApiController.class);


    @Autowired
    public MessageServiceImpl(UserService userService, MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    private MessageListDto getPatientMessages(Long patientId) {
        LOGGER.info("getPatientMessages(" + patientId + ")");
        List<Long> lastMessageIds = messageRepository.getPhysioMessageIds(patientId);
        List<MessageDto> lastMessages = new ArrayList<>();
        LOGGER.info("getPatientMessages(" + patientId + ") lastMessageIds: " + lastMessageIds.toString());

        for (Long physioId: lastMessageIds) {
            Message m = messageRepository.getLastMessage(patientId, physioId);
            if (m != null) {
                lastMessages.add(m.dto());
            }
        }

        return new MessageListDto(lastMessages);
    }

    private MessageListDto getPhysioMessages(Long physioId) {
        LOGGER.info("getPhysioMessages(" + physioId + ")");
        List<Long> lastMessageIds = messageRepository.getPatientMessageIds(physioId);
        List<MessageDto> lastMessages = new ArrayList<>();
        LOGGER.info("getPhysioMessages(" + physioId + ") lastMessageIds: " + lastMessageIds.toString());

        for (Long patientId: lastMessageIds) {
            Message m = messageRepository.getLastMessage(patientId, physioId);
            if (m != null) {
                lastMessages.add(m.dto());
            }
        }

        return new MessageListDto(lastMessages);
    }

    @Override
    public MessageListDto getLastMessages(Long currentUserId) {
        UserDto user = userService.getUserById(currentUserId);
        if (user != null) {
            if (user.getPatientId() !=  null) {
                return this.getPatientMessages(user.getPatientId());
            } else if (user.getPhysioId() != null) {
                return this.getPhysioMessages(user.getPhysioId());
            }

            return null;
        }

        return null;
    }

    @Override
    public MessageDto postMessage(MessageDto message) {
        return null;
    }

    @Override
    public List<MessageDto> getMessageWithPatient(Long patientId, Long userId) {
        return null;
    }

    @Override
    public List<MessageDto> getMessageWithPhysio(Long userId, Long patientId) {
        return null;
    }

    @Override
    public List<MessageDto> findByPatientId(Long id) {
        return null;
    }
}
