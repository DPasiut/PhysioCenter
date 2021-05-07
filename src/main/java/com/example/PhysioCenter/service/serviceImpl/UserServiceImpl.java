package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.patient.PatientNotCreated;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.dto.users.UserNotCreated;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.entity.User;
import com.example.PhysioCenter.domain.repository.PatientRepository;
import com.example.PhysioCenter.domain.repository.UserRepository;
import com.example.PhysioCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private PatientRepository patientRepository;
    private UserRepository userRepository;
    private PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(PatientRepository patientRepository, UserRepository userRepository) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreated, UserNotCreated {
        // TODO:
        // - TRANSACTIONAL QUERY (add patient + add user)
        // - COMPARE IF LOGIN AND PASSWORD DOESN'T EXISTS

        Patient createdPatient = patientRepository.save(
                new Patient().toBuilder()
                        .name(createPatientUserDto.getName())
                        .email(createPatientUserDto.getEmail())
                        .peselNo(createPatientUserDto.getPeselNo())
                        .phoneNumber(createPatientUserDto.getPhoneNumber())
                        .surname(createPatientUserDto.getSurname())
                        .build()
        );

        if (createdPatient == null) {
            throw new PatientNotCreated();
        }

        String encodedLogin = encoder.encode(createPatientUserDto.getLogin());
        String encodedPassword = encoder.encode(createPatientUserDto.getPassword());
        System.out.println("HASHED DATA: " + encodedLogin + "     " + encodedPassword);
        Long patientId = createdPatient.getPatientId();
        User createdUser = userRepository.save(
                new User().toBuilder()
                        .login(encodedLogin)
                        .password(encodedPassword)
                        .patientId(patientId)
                        .physioId(null)
                        .build()
        );

        if (createdUser == null) {
            throw new UserNotCreated();
        }

        return createdUser.dto();
    }
}
