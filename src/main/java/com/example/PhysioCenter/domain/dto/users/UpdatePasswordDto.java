package com.example.PhysioCenter.domain.dto.users;

import lombok.*;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UpdatePasswordDto {
    private String password;
}
