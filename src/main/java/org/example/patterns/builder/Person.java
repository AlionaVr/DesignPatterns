package org.example.patterns.builder;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String city;

    protected Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }

    protected Person(String name, String surname, int age, String city) {
        this(name, surname, city);
        if (age >= 0)
            this.age = OptionalInt.of(age);
    }

    protected boolean hasAge() {
        return age.isPresent();
    }

    protected boolean hasAddress() {
        return !city.isEmpty();
    }

    protected void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    protected String getName() {
        return name;
    }

    protected String getSurname() {
        return surname;
    }

    protected OptionalInt getAge() {
        return age;
    }

    protected String getCity() {
        return city;
    }

    protected void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        if (hasAge()) {
            return "Person{" + name + '\'' + surname + '\'' + age.getAsInt() + '\'' + city + '\'' + '}';
        }
        return "Person{" + name + '\'' + surname + '\'' + city + '\'' + '}';
    }

    protected PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setCity(this.city);
    }
}
