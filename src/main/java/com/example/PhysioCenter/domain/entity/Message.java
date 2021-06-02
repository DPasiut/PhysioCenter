package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.message.MessageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "pacjent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wiadomosci_id")
    private Long messageId;

    @Column(name = "pacjent_id")
    private Long patientId;

    @Column(name = "fizjo_id")
    private Long physioId;

    @Column(name = "do_fizjo")
    private Boolean directionToPhysio;

    @Column(name = "wiadomosc")
    private String message;

    public MessageDto dto() {
        return MessageDto.builder()
                .messageId(this.messageId)
                .patientId(this.patientId)
                .physioId(this.physioId)
                .directionToPhysio(this.directionToPhysio)
                .message(this.message.trim())
                .build();
    }

}
