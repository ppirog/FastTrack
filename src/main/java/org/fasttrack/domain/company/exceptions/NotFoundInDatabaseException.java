package org.fasttrack.domain.company.exceptions;

public class NotFoundInDatabaseException extends RuntimeException{
    public NotFoundInDatabaseException(final String message) {
        super(message);
    }
}
