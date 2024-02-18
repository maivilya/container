package org.example.Geek.Patterns.Builder;

public class TestBuilder {

    public static void main(String[] args) {
        Employee.Builder emp1 = new Employee.Builder();
        emp1
                .firstname("Илья")
                .lastname("Мамаев")
                .middlename("Евгеньевич")
                .age(19)
                .department("Backend")
                .email("mamaevila2004@mail.ru")
                .phoneNumber("+79935221012")
                .build();
        System.out.println(emp1);
    }
}
