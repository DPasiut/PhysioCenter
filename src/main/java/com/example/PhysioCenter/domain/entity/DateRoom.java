package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.dateRoom.DateRoomDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@IdClass(DateRoomId.class)
@Table(schema = "fizjoterapia", name = "termin_gabinet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class DateRoom {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @Column(name = "id_terminu")
    private Long dateId;

    @Id
    @Column(name = "id_gabinetu")
    private Long roomId;

    @Column(name = "wolny")
    private Boolean isAvailable;

    public DateRoomDto dto(){
        return DateRoomDto.builder()
                .dateId(this.dateId)
                .roomId(this.roomId)
                .isAvailable(this.isAvailable)
                .build();
    }
}
