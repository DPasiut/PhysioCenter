package com.example.PhysioCenter.domain.entity;

import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "fizjoterapia", name = "uzytkownik")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_uzytkownika")
    private Long userId;

    @Column(name = "login")
    private String login;

    @Column(name = "haslo")
    private String password;

    @Column(name = "id_pacjenta")
    private Long patientId;

    @Column(name = "id_fizjoterapeuty")
    private Long physioId;


    public UserDto dto(){
        return UserDto.builder()
                .userId(this.userId)
                .login(this.login)
                .password(this.password)
                .patientId(this.patientId)
                .physioId(this.physioId)
                .userType(this.physioId != null ? UserType.PHYSIO : UserType.PATIENT)
                .build();
    }
}
