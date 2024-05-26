package org.fasttrack.infrastrucutre.errorvalidation;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.infrastrucutre.errorvalidation.dto.DuplicateKeyExceptionDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ApiValidationErrorHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiValidationErrorResponseDto handleException(MethodArgumentNotValidException exception) {
        log.warn("Validation error");
        return ApiValidationErrorResponseDto.builder()
                .errors(exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public DuplicateKeyExceptionDto handleDataIntegrityViolationException() {
        final String loginAlreadyExists = "Login already exists";
        log.warn(loginAlreadyExists);
        return DuplicateKeyExceptionDto .builder()
                .message(loginAlreadyExists)
                .build();
    }
}
