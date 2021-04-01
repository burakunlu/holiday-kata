package com.burak.holiday.kata.util;

import com.burak.holiday.kata.exception.ValidationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constraints {


    /**
     * Validates if the given object is not null, throws {@link ValidationException} with {@code exceptionMessage} if {@code givenObject} is null
     *
     * @param givenObject
     * @param exceptionMessage
     */
    public static void requireNonNull(Object givenObject, String exceptionMessage) throws ValidationException {
        if (givenObject == null) {
            throw new ValidationException(exceptionMessage);
        }
    }

    /**
     * Validates if the state is true or else throws {@link ValidationException}.
     */
    public static void checkThrows(boolean state, String message) throws ValidationException {
        if (!state) {
            throw new ValidationException(message);
        }
    }
}
