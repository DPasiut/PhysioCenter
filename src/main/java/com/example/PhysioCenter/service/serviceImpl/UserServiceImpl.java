package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.exceptions.AuthDataDuplicatedException;
import com.example.PhysioCenter.domain.exceptions.PatientNotCreatedException;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.exceptions.UserNotCreatedException;
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

    private boolean isLoginUnique(String password) {
        for (User user: userRepository.findAll()) {
            System.out.println("COMPARE: " + password + "  ?  " + user.getPassword());
            if (encoder.matches(password, user.getPassword())) {
                return false;
            }
        }

        return true;
    }

    private boolean isPasswordUnique(String login) {
        for (User user: userRepository.findAll()) {
            if (encoder.matches(login, user.getLogin())) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIfLoginAndPasswordAreUnique(String login, String password) {
        return isLoginUnique(login) && isPasswordUnique(password);
    }

    @Override
    public UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreatedException, UserNotCreatedException, AuthDataDuplicatedException {
        // TODO:
        // - TRANSACTIONAL QUERY (add patient + add user)
        boolean isAuthDataUnique = checkIfLoginAndPasswordAreUnique(createPatientUserDto.getLogin(), createPatientUserDto.getPassword());
        if (!isAuthDataUnique) {
            throw new AuthDataDuplicatedException();
        }

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
            throw new PatientNotCreatedException();
        }

        String encodedLogin = encoder.encode(createPatientUserDto.getLogin());
        String encodedPassword = encoder.encode(createPatientUserDto.getPassword());
        Long patientId = createdPatient.getPatientId();
        User createdUser = userRepository.save(
                new User().toBuilder()
                        .login(encodedLogin)
                        .password(encodedPassword)
                        .patientId(patientId)
                        .physioId(null)
                        .build()
        );
        System.out.println("SAVED PASS   : " + encodedPassword);

        if (createdUser == null) {
            throw new UserNotCreatedException();
        }

        return createdUser.dto();
    }
}