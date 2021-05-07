package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.exceptions.PatientNotCreatedException;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.exceptions.UserNotCreatedException;

public interface UserService {
    UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreatedException, UserNotCreatedException;
}
