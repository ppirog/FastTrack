package org.fasttrack.infrastrucutre.loginandregister.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.loginandregister.LoginAndRegisterFacade;
import org.fasttrack.domain.loginandregister.dto.UserResponseDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterRequestDto;
import org.fasttrack.infrastrucutre.loginandregister.controller.dto.RegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@AllArgsConstructor
public class RegisterRestController {

    private final LoginAndRegisterFacade loginAndRegisterFacade;
    private final RegisterMapper mapper;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RegisterResponseDto> registerUser(@RequestBody RegisterRequestDto registerRequestDto) {
        final UserResponseDto userResponseDto = loginAndRegisterFacade.register(mapper.fromReqisterRequestDto(registerRequestDto));
        final RegisterResponseDto registered = mapper.fromUserResponseDto(userResponseDto);
        log.info("User registered: {}", registered);
        return ResponseEntity.status(HttpStatus.CREATED).body(registered);
    }
}