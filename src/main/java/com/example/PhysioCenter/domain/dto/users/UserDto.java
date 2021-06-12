package com.example.PhysioCenter.domain.dto.users;

import com.example.PhysioCenter.domain.enums.UserType;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDto {
    private Long userId;
    private String login;
    private String password;
    private Long physioId;
    private Long patientId;
    private UserType userType;
}
