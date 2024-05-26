package org.fasttrack.domain.loginandregister;

import org.fasttrack.domain.loginandregister.dto.UserRequestDto;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
class UserMapper {
    User mapToUser(final UserRequestDto requestDto) {
        return User.builder()
                .username(requestDto.username())
                .password(requestDto.password())
                .build();
    }

    UserResponseDto mapToUserResponseDto(User user){
        return UserResponseDto.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}