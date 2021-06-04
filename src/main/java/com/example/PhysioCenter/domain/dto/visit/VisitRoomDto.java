package com.example.PhysioCenter.domain.dto.visit;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class VisitRoomDto {
    String roomNumber;
}
