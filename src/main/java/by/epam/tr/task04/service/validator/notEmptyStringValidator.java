package by.epam.tr.task04.service.validator;

public class notEmptyStringValidator {

    public static boolean isNotEmpty(String string) {

        if (!string.isEmpty() && string != null) {
            return true;
        } else {
            return false;
        }
    }
}