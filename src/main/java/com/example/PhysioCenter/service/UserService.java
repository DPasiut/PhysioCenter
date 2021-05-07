package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.patient.PatientNotCreated;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.dto.users.UserNotCreated;

public interface UserService {
    UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreated, UserNotCreated;
}
