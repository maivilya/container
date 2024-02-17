package org.example.Geek.ReflectionApi.Animals;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectionApi {

    public static void main(String[] args) {
        AbstractAnimal[] animals = new AbstractAnimal[]{
                new Cat(12, "Sema", Color.BLUE),
                new Dog(5, "Bonny", Color.BLACK),
                new Dog(1, "Baby", Color.BROWN),
                new Cat(19, "Bagira", Color.GREEN)
        };

        // #region get info(fields and methods) about object
        for (AbstractAnimal animal : animals) {
            try {
                System.out.println(getObjectFields(animal));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.println(getObjectMethods(animal));
        }
        // #endregion

        // #region do method on object
        String methodName = "sleepAllDay";
        for (AbstractAnimal animal : animals) {
            executeMethodOnObject(animal, methodName);
        }
        // #endregion
    }

    /**
     * С помощью ReflectionApi получаем методы объекта
     * @param object     объект, у которого нужно выполнить метод
     * @param methodName название метода, который нужно выполнить у объекта
     */
    private static void executeMethodOnObject(Object object, String methodName) {
        Method method;
        try {
            method = object.getClass().getDeclaredMethod(methodName);
        } catch (NoSuchMethodException e) {
            return;
        }

        try {
            method.setAccessible(true);
            method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * С помощью ReflectionApi получаем методы объекта
     * @param object объект, у которого нужно получить методы
     * @return       строка, содержащая поля объекта(конечно нужно возвращать Method[], но это для упрощения)
     */
    private static String getObjectMethods(Object object)  {
        StringBuilder sb;
        Method[]      methods;
        sb = new StringBuilder("Methods\n");

        methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            sb.append(method.getName()).append("\n");
        }

        return sb.toString();
    }

    /**
     * С помощью ReflectionApi получаем поля объекта
     * @param object объект, у которого нужно получить поля
     * @return       строка, содержащая поля объекта(конечно нужно возвращать Field[], но это для упрощения)
     * @throws IllegalAccessException Исключение IllegalAccessException выбрасывается,
     * когда приложение пытается рефлексивно создать экземпляр (кроме массива),
     * установить или получить поле или вызвать метод,
     * но выполняющийся в данный момент метод не имеет доступа к определению
     * указанного класса, поля, метода или конструктора
     */
    private static String getObjectFields(Object object) throws IllegalAccessException {
        StringBuilder sb;
        Field[]       fields;
        sb = new StringBuilder(object.getClass().getSimpleName()).append("\n");

        fields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            sb.append(field.getName()).append(": ").append(field.get(object)).append("\n");
        }

        fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            sb.append(field.getName()).append(": ").append(field.get(object)).append("\n");
        }

        return sb.toString();
    }
}
