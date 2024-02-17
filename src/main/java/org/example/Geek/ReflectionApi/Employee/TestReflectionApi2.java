package org.example.Geek.ReflectionApi.Employee;

import java.lang.reflect.Field;

public class TestReflectionApi2 {

    public static void main(String[] args) {
        getEmployeeInfo();
    }

    /**
     * В этом методе получаем все поля у объекта employee
     * и выводим их на экран
     */
    private static void getEmployeeInfo() {
        Employee employee = new Employee();
        Field[] fields = employee.getClass().getFields();
        Field[] declaredFields = employee.getClass().getDeclaredFields();

        System.out.println("Fields: ");
        for (Field field : fields) {
            System.out.println("field: " + field.getName());
        }

        System.out.println("\nDeclaredFields: ");
        for (Field field : declaredFields) {
            System.out.println("field: " + field.getName());
        }
    }
}
