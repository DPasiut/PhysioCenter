package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.message.AddMessageDto;
import com.example.PhysioCenter.domain.dto.message.MessageDto;
import com.example.PhysioCenter.domain.dto.message.MessageListDto;
import com.example.PhysioCenter.domain.exceptions.FailedSendMessage;

import java.util.List;

public interface MessageService {
    MessageListDto getLastMessages(Long currentUserId);
    MessageDto postMessage(AddMessageDto message) throws FailedSendMessage;
    List<MessageDto> getMessageWithPatient(Long patientId, Long userId);
    List<MessageDto> getMessageWithPhysio(Long userId, Long patientId);

    List<MessageDto> findByPatientId(Long id);
}
