package by.epam.tr.task04.entity;

import java.util.NoSuchElementException;

public enum Role {
    ADMIN(1),
    CLIENT(2);

    private final int id;

    Role(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return id;
    }

    public static Role getRoleById(int id) {
        for (int i = 0; i < Role.values().length; i++) {
                if (Role.values()[i].id == id) {
                    return Role.values()[i];
                }
            } throw new NoSuchElementException();
            }
        }
