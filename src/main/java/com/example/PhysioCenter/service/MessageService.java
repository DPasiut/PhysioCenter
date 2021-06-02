package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.message.AddMessageDto;
import com.example.PhysioCenter.domain.dto.message.MessageDto;
import com.example.PhysioCenter.domain.dto.message.LastMessageListDto;
import com.example.PhysioCenter.domain.exceptions.FailedSendMessage;

import java.util.List;

public interface MessageService {
    LastMessageListDto getLastMessages(Long currentUserId);
    MessageDto postMessage(AddMessageDto message) throws FailedSendMessage;
    List<MessageDto> getMessageWithPerson(Long physioId, Long patientId);
}
