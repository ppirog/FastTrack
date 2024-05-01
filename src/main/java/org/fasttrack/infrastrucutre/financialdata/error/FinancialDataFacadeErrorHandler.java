package org.fasttrack.infrastrucutre.financialdata.error;

import lombok.extern.log4j.Log4j2;
import org.fasttrack.domain.financialdata.exceptions.NotFoundInRemoteServerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
class FinancialDataFacadeErrorHandler {


    @ExceptionHandler(NotFoundInRemoteServerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundInternetPageException handleException(NotFoundInRemoteServerException exception) {
        log.warn("NotFoundInternetPageException - error while accesing offer by id");
        return NotFoundInternetPageException.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
    }
}
