package com.example.PhysioCenter.controller;

import com.example.PhysioCenter.domain.dto.users.UpdatePasswordDto;
import com.example.PhysioCenter.service.PatientService;
import com.example.PhysioCenter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api")
public class UserApiController {
    private final UserService userService;

    public UserApiController(PatientService patientService, UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PutMapping("/user/{id}/password")
    public ResponseEntity<Void> updatePatient(@RequestBody UpdatePasswordDto userPassword, @PathVariable Long id) {
        return userService.updateUserPassword(userPassword, id) ? ResponseEntity.ok().build() : ResponseEntity.badRequest().build();
    }
}
