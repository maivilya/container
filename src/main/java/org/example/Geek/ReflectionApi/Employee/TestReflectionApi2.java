package org.example.Geek.ReflectionApi.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflectionApi2 {

    public static void main(String[] args) {
        getEmployeeInfo();
        getEmployeeMethodInfo();
        changePrivateField();
        executeMethodOnObject();
        getMethodsReturnType();
    }

    /**
     * В этом методе с помощью ReflectionApi мы пытаемся получить типы
     * возвращаемых значений у методов на объекте employee,
     * а конкретно getNumber() и setNumber(int, String)
     */
    private static void getMethodsReturnType() {
        final Employee employee = new Employee();
        try {
            System.out.println("getReturnType() = "
                    + employee.getClass()
                    .getDeclaredMethod("getNumber")
                    .getReturnType());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Class<?>[] types;
        try {
            types = employee.getClass()
                    .getDeclaredMethod("setNumber", int.class, String.class)
                    .getParameterTypes();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(types));
    }

    /**
     * В этом методе с помощью ReflectionApi мы пытаемся выполнить метод
     * у объекта employee, а конкретно setNumber(int, String)
     */
    private static void executeMethodOnObject() {
        Employee employee = new Employee();
        System.out.println("employee = " + employee);
        try {
            Method method = employee.getClass().getDeclaredMethod("setNumber", int.class, String.class);
            method.setAccessible(true);
            method.invoke(employee, 20, "20");
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
        System.out.println("employee = " + employee);
    }

    /**
     * В этом методе с помощью ReflectionApi мы пытаемся изменить ПРИВАТНОЕ
     * поле у объекта employee
     */
    private static void changePrivateField() {
        Employee employee = new Employee();
        int number = employee.getNumber();
        String name = null;
        System.out.println("employee = " + employee);
        System.out.println("number + name = " + number + name);

        try {
            Field fieldName = employee.getClass().getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(employee, "new name from fieldName");
            name = (String) fieldName.get(employee);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("\nemployee = " + employee);
        System.out.println("number + name = " + number + name);
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
