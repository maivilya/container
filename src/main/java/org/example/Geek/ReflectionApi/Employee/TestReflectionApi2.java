package org.example.Geek.ReflectionApi.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflectionApi2 {

    public static void main(String[] args) {
        getEmployeeInfo();
        getEmployeeMethodInfo();
    }

    /**
     * В этом методе получаем все методы у объекта employee
     * и выводим их на экран
     */
    private static void getEmployeeMethodInfo() {
        Employee employee = new Employee();
        Method[] methods = employee.getClass().getMethods();
        Method[] declaredMethods = employee.getClass().getDeclaredMethods();

        System.out.println("Methods: ");
        for (Method method : methods) {
            System.out.println("method: " + method.getName());
        }

        System.out.println("\nDeclaredMethod: ");
        for (Method method : declaredMethods) {
            System.out.println("method: " + method.getName());
        }
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
