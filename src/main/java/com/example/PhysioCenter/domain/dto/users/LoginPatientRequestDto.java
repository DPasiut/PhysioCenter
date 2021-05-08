package com.example.PhysioCenter.domain.dto.users;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginPatientRequestDto {
    private String login;
    private String password;
}
