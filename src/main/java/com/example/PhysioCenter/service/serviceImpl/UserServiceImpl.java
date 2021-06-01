package com.example.PhysioCenter.service.serviceImpl;

import com.example.PhysioCenter.domain.dto.users.LoginRequestDto;
import com.example.PhysioCenter.domain.dto.users.UpdatePasswordDto;
import com.example.PhysioCenter.domain.exceptions.LoginDuplicatedException;
import com.example.PhysioCenter.domain.exceptions.PatientNotCreatedException;
import com.example.PhysioCenter.domain.dto.users.CreatePatientUserDto;
import com.example.PhysioCenter.domain.dto.users.UserDto;
import com.example.PhysioCenter.domain.exceptions.UserNotCreatedException;
import com.example.PhysioCenter.domain.entity.Patient;
import com.example.PhysioCenter.domain.entity.User;
import com.example.PhysioCenter.domain.exceptions.WrongLoginDataException;
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

    private boolean isLoginUnique(String login) {
        for (User user: userRepository.findAll()) {
            if (encoder.matches(login, user.getLogin())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public UserDto createPatientUser(CreatePatientUserDto createPatientUserDto) throws PatientNotCreatedException, UserNotCreatedException, LoginDuplicatedException {
        boolean isAuthDataUnique = isLoginUnique(createPatientUserDto.getLogin());
        if (!isAuthDataUnique) {
            throw new LoginDuplicatedException();
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

        if (createdUser == null) {
            throw new UserNotCreatedException();
        }

        return createdUser.dto();
    }

    @Override
    public UserDto loginPatient(LoginRequestDto loginRequestDto) throws WrongLoginDataException {
        for (User user: userRepository.findAll()) {
            if (encoder.matches(loginRequestDto.getLogin(), user.getLogin())) {
               if (encoder.matches(loginRequestDto.getPassword(), user.getPassword()) && user.getPatientId() != null) {
                   return user.dto();
               }
               break;
            }
        }

       throw new WrongLoginDataException();
    }

    @Override
    public UserDto loginPhysio(LoginRequestDto loginRequestDto) throws WrongLoginDataException {
        for (User user: userRepository.findAll()) {
            if (encoder.matches(loginRequestDto.getLogin(), user.getLogin())) {
                if (encoder.matches(loginRequestDto.getPassword(), user.getPassword()) && user.getPhysioId() != null) {
                    return user.dto();
                }
                break;
            }
        }

        throw new WrongLoginDataException();
    }

    @Override
    public boolean updateUserPassword(UpdatePasswordDto userPasswordDto, Long id) {
        User user = userRepository.getOne(id);

        if (user != null) {
            String encodedPassword = encoder.encode(userPasswordDto.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);

            return true;
        }

        return false;
    }
}
