package org.example.Geek.ReflectionApi.Employee;

public class Employee {
    private int number;
    private String name = "default";
    public  String email;
    protected final boolean isHuman = true;

    public Employee(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Employee () {

    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number, String secondNumber) {
        this.number = number + Integer.parseInt(secondNumber);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d %s", number, name);
    }
}
