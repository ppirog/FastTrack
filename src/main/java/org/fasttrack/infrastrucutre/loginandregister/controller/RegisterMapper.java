package org.fasttrack.infrastrucutre.loginandregister.controller;


import lombok.AllArgsConstructor;
import org.fasttrack.domain.loginandregister.dto.UserRequestDto;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterRequestDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterResponseDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class RegisterMapper {
    private final PasswordEncoder passwordEncoder;

    UserRequestDto fromReqisterRequestDto(final RegisterRequestDto dto) {
        return UserRequestDto.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
    }

    RegisterResponseDto fromUserResponseDto(final UserResponseDto dto) {
        return RegisterResponseDto.builder()
                .username(dto.username())
                .message(dto.message())
                .build();
    }
}
