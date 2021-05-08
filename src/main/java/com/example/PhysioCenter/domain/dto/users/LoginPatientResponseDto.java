package com.example.PhysioCenter.domain.dto.users;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginPatientResponseDto {
    private String message;
    private UserDto user;
}
