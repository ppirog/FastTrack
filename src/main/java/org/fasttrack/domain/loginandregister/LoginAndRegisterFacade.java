package org.fasttrack.domain.loginandregister;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.loginandregister.dto.UserRequestDto;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Log4j2
@AllArgsConstructor
@Component
public class LoginAndRegisterFacade {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserResponseDto register(UserRequestDto requestDto) {
        final User user = userMapper.mapToUser(requestDto);
        final User saved = userRepository.save(user);
        return userMapper.mapToUserResponseDto(user);
    }
}
