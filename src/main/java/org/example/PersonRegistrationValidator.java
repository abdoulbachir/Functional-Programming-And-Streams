package org.example;

import java.util.function.Function;
import org.example.PersonRegistrationValidator.ValidationResult;

import static org.example.PersonRegistrationValidator.ValidationResult.*;

public interface PersonRegistrationValidator extends Function<Person, ValidationResult> {

    static PersonRegistrationValidator isEmailValid(){
        return person -> person.email().contains("@") ? SUCCESS : EMAIL_NOT_VALID_ERROR;
    }

    static PersonRegistrationValidator isPhoneNumberValid(){
        return person -> person.phoneNumber().contains("+1") ? SUCCESS : PHONE_NOT_VALID_ERROR;
    }

    static PersonRegistrationValidator isEmailTaken(){
        return person -> SUCCESS;
    }

    default PersonRegistrationValidator and(PersonRegistrationValidator prv){
        return person -> {
            ValidationResult result = this.apply(person);
            return result.equals(SUCCESS) ? prv.apply(person) : result;
        };
    }

    enum ValidationResult{
        SUCCESS,
        EMAIL_NOT_VALID_ERROR,
        EMAIL_TAKEN_ERROR,
        PHONE_NOT_VALID_ERROR,
        NOT_ADULT_ERROR
    }
}
