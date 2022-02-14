package by.epam.tr.task04;

import by.epam.tr.task04.entity.Order;
import by.epam.tr.task04.entity.Role;
import by.epam.tr.task04.entity.User;
import by.epam.tr.task04.service.validator.UserValidator;
import by.epam.tr.task04.service.validator.notEmptyStringValidator;
import org.mindrot.jbcrypt.BCrypt;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        User user = new User();
        System.out.println(user);


    }
}
