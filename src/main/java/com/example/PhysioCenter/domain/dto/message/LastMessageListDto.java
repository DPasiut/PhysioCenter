package com.example.PhysioCenter.domain.dto.message;

import lombok.*;

import java.util.List;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LastMessageListDto {
    List<MessageDto> lastMessages;
}
