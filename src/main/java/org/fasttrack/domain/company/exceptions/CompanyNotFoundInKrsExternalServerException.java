package org.fasttrack.domain.company.exceptions;

public class CompanyNotFoundInKrsExternalServerException extends Exception {
    public CompanyNotFoundInKrsExternalServerException(String message) {
        super(message);
    }

    public CompanyNotFoundInKrsExternalServerException(final Throwable cause) {
        super(cause);
    }
}
