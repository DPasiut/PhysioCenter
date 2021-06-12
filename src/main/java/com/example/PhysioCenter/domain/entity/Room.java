package com.example.PhysioCenter.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "gabinet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_gabinetu")
    private Long roomId;

    @Column(name = "numer")
    private String roomNumber;

    public Room dto() {
        return Room.builder()
                .roomId(this.roomId)
                .roomNumber(this.roomNumber)
                .build();
    }
}
