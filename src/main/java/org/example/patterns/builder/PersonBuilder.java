package org.example.patterns.builder;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city = "unknown";

    protected PersonBuilder setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        return this;
    }

    protected PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname;
        return this;
    }

    protected PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = OptionalInt.of(age);
        return this;
    }

    protected PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    protected Person build() {
        if (name == null) {
            throw new IllegalStateException("Не указано имя");
        }
        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия");
        }
        if (age.isEmpty()) {
            return new Person(name, surname, city);
        }
        return new Person(name, surname, age.getAsInt(), city);
    }
}

