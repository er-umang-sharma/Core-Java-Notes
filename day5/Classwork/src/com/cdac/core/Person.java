package com.cdac.core;

public abstract class Person {

    protected String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public abstract void introduce();

    @Override
    public String toString() {
        return "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        return this.firstName.equals(((Person) o).firstName) && this.lastName.equals(((Person) o).lastName);
    }
}
