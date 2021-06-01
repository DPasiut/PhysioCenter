package com.example.PhysioCenter.service;

import com.example.PhysioCenter.domain.dto.users.LoginRequestDto;
import com.example.PhysioCenter.domain.dto.users.UpdatePasswordDto;
import com.example.PhysioCenter.domain.exceptions.LoginDuplicatedException;
import com.example.PhysioCenter.domain.exceptions.PatientNotCreatedException;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.exceptions.UserNotCreatedException;
import com.example.PhysioCenter.domain.exceptions.WrongLoginDataException;

public interface UserService {
    UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreatedException, UserNotCreatedException, LoginDuplicatedException;
    UserDto loginPatient(LoginRequestDto loginRequestDto) throws WrongLoginDataException;
    UserDto loginPhysio(LoginRequestDto loginRequestDto) throws WrongLoginDataException;
    boolean updateUserPassword(UpdatePasswordDto userPassword, Long id);
}
