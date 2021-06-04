package com.example.PhysioCenter.domain.dto.dateRoom;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AddDateRoomDto {
    private Long roomId;
    private Long dateId;
}
