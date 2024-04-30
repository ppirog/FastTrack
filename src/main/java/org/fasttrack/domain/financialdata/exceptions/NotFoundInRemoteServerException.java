package org.fasttrack.domain.financialdata.exceptions;

public class NotFoundInRemoteServerException extends RuntimeException {

    public NotFoundInRemoteServerException(final String message) {
        super(message);
    }
}
