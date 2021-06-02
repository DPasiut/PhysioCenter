package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.message.MessageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "fizjoterapia", name = "wiadomosci")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiadomosci_id")
    private Long messageId;

    @Column(name = "pacjent_id", nullable = false)
    private Long patientId;

    @Column(name = "fizjo_id", nullable = false)
    private Long physioId;

    @Column(name = "do_fizjo", nullable = false)
    private Boolean directionToPhysio;

    @Column(name = "wiadomosc", nullable = false)
    private String message;

    @Column(name = "created_at")
    private Date createdAt;

    public MessageDto dto() {
        return MessageDto.builder()
                .messageId(this.messageId)
                .patientId(this.patientId)
                .physioId(this.physioId)
                .createdAt(this.createdAt)
                .directionToPhysio(this.directionToPhysio)
                .message(this.message.trim())
                .build();
    }

}
