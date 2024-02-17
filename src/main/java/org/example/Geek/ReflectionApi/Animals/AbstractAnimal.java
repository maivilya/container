package org.example.Geek.ReflectionApi.Animals;

public abstract class AbstractAnimal {

    private int age;
    private String name;

    public AbstractAnimal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    abstract void makeSound();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return String.format("%s %s, age: %d",
                getClass().getSimpleName(),
                name,
                age);
    }
}
