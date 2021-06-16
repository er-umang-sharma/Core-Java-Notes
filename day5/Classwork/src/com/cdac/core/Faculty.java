package com.cdac.core;

public class Faculty extends Person {

    private int yearsOfExp;
    private String workingDomain;

    public Faculty(String firstName, String lastName, int yearsOfExp, String workingDomain) {
        super(firstName, lastName);
        this.yearsOfExp = yearsOfExp;
        this.workingDomain = workingDomain;
    }

    @Override
    public void introduce() {
        System.out.println("Hi! I'm " + super.firstName + " and I have " + this.yearsOfExp + " years of experience.");
    }

    public void evaluate() {
        System.out.println("Students evaluated.");
    }

    @Override
    public String toString() {
        return super.toString() + " yearsOfExp=" + yearsOfExp +
                ", workingDomain='" + workingDomain + '\'';
    }
}
