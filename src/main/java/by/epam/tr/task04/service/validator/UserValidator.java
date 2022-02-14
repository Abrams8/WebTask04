package by.epam.tr.task04.service.validator;

import by.epam.tr.task04.service.ServiceFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {

    private static final String PHONE_NUMBER_VALIDATOR = "\\+?\\d{9,12}";
    private static final String PASSWORD_VALIDATOR = "^(?=.*[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{6,}+$";
    private static final String MAIL_VALIDATOR = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private static final String LOGIN_VALIDATOR = "^[A-Za-z0-9]{3,15}$";
    private static final String PASSPORT_NUMBER_VALIDATOR = "^[a-zA-Z]{2}+[0-9]{7}+$";
    private static final String NAME_OR_SURNAME_VALIDATOR = "^[a-zA-Z]{2,}";
    private static final String AGE_VALIDATOR = "^[0-9]{2,3}+$";


    public boolean validatePhoneNumber(String phone) {
        if (!notEmptyStringValidator.isNotEmpty(phone)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PHONE_NUMBER_VALIDATOR);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        if (!notEmptyStringValidator.isNotEmpty(password)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PASSWORD_VALIDATOR);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean validateMail(String mail) {
        if (!notEmptyStringValidator.isNotEmpty(mail)) {
            return false;
        }
        Pattern pattern = Pattern.compile(MAIL_VALIDATOR);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public boolean validateLogin(String login) {
        if (!notEmptyStringValidator.isNotEmpty(login)) {
            return false;
        }
        Pattern pattern = Pattern.compile(LOGIN_VALIDATOR);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    public boolean validatePassportNumber(String passportNumber) {
        if (!notEmptyStringValidator.isNotEmpty(passportNumber)) {
            return false;
        }
        Pattern pattern = Pattern.compile(PASSPORT_NUMBER_VALIDATOR);
        Matcher matcher = pattern.matcher(passportNumber);
        return matcher.matches();
    }

    public boolean validateNameAndSurname(String nameOrSurname) {
        if (!notEmptyStringValidator.isNotEmpty(nameOrSurname)) {
            return false;
        }
        Pattern pattern = Pattern.compile(NAME_OR_SURNAME_VALIDATOR);
        Matcher matcher = pattern.matcher(nameOrSurname);
        return matcher.matches();
    }

    public boolean validateAge(String age) {
        if (!notEmptyStringValidator.isNotEmpty(age)) {
            return false;
        }
        Pattern pattern = Pattern.compile(AGE_VALIDATOR);
        Matcher matcher = pattern.matcher(age);
        return matcher.matches();
    }

    public boolean registrationUserValidator(String login, String password, String name, String surname, String phoneNumber, String mail, String passportNumber, String age) {
        if (validateLogin(login) &&
                validateMail(mail) &&
                validatePassword(password) &&
                validatePassportNumber(passportNumber) &&
                validateNameAndSurname(name) &&
                validateNameAndSurname(surname) &&
                validateAge(age) &&
                validatePhoneNumber(phoneNumber)) {
            return true;
        } else return false;
    }

    public boolean loginationUserValidator(String login, String password) {
        if (validateLogin(login) && validatePassword(password)) {
            return true;
        } else return false;
    }
}

