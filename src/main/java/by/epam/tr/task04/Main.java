package by.epam.tr.task04;

import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.service.validator.notEmptyStringValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        String name = "Dima";
        String surname = "Tutur";
        String login = "robikl";
        String passportNumber = "FG8596895";
        String age = "33";
        String mail = "dsfsf@gmail.com";
        String phoneNumber = "+375298005868";
        String password = "asdrtgf5248";

        UserValidator userValidator = new UserValidator();
        if (userValidator.registrationUserValidator(login, password, name, surname, phoneNumber, mail, passportNumber, age)) {
            User user = new User();

            user.setName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setPasportNumber(passportNumber);
            user.setAge(Integer.parseInt(age));
            user.setPhoneNumber(phoneNumber);
            user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
            user.setRole(Role.Client);
            user.setMail(mail);
        }else System.out.println("false");
        System.out.println("___________");
        System.out.println(userValidator.validateAge(age));
        System.out.println(userValidator.validateNameAndSurname(name));
        System.out.println(userValidator.validateNameAndSurname(surname));
        System.out.println(userValidator.validatePassword(password));
        System.out.println(userValidator.validatePassportNumber(passportNumber));
        System.out.println(userValidator.validateMail(mail));
        System.out.println(userValidator.validateLogin(login));
        System.out.println(userValidator.validatePhoneNumber(phoneNumber));
    }
}
