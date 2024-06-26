package org.fasttrack.infrastrucutre.company.error;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.company.exceptions.NotFoundInDatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Log4j2
class CompanyFacadeErrorHandler {

    @ExceptionHandler(NotFoundInDatabaseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundInDatabaseResponseDto handleException(NotFoundInDatabaseException exception) {
        log.warn("NotFoundInDatabaseException - error while accesing offer");
        return NotFoundInDatabaseResponseDto.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
    }

    //    ResponseStatusException
    @ExceptionHandler(ResponseStatusException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundInRemoteRestServerException handleException(ResponseStatusException exception) {
        log.warn("ResponseStatusException - error while accesing company in KRS");
        return NotFoundInRemoteRestServerException.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
    }
}
