package com.example.PhysioCenter.domain.dto.users;
import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterPatientUserResponseDto {
    private String message;
    private UserDto userDto;
}
