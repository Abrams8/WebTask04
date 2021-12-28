package by.epam.tr.task04.entity;

import java.util.NoSuchElementException;

public enum BodyType {
    CATCHBACK(1),
    WAGON(2),
    SEDAN(3),
    COUPE(4),
    ROADSTER(5),
    CROSSOVER(6);

    private final int id;

    BodyType(int id) {
        this.id = id;
    }

    public int getBodyTypeId() {
        return id;
    }

    public static BodyType getBodyTypeById(int id) {
        for (int i = 0; i < BodyType.values().length; i++) {
            if (BodyType.values()[i].id == id) {
                return BodyType.values()[i];
            }
        } throw new NoSuchElementException();
    }
}
