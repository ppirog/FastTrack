package org.fasttrack.infrastrucutre.loginandregister.controller;


import org.fasttrack.domain.loginandregister.dto.UserRequestDto;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterRequestDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterResponseDto;
import org.springframework.stereotype.Service;

@Service
class RegisterMapper {
    UserRequestDto fromReqisterRequestDto(final RegisterRequestDto dto) {
        return UserRequestDto.builder()
                .username(dto.username())
                .password(dto.password())
                .build();
    }

    RegisterResponseDto fromUserResponseDto(final UserResponseDto dto) {
        return RegisterResponseDto.builder()
                .username(dto.username())
                .message(dto.message())
                .build();
    }
}
