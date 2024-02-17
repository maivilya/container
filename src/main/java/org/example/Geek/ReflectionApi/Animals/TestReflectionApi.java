package org.example.Geek.ReflectionApi.Animals;

public class TestReflectionApi {

    public static void main(String[] args) {
        AbstractAnimal[] animals = new AbstractAnimal[]{
                new Cat(12, "Sema", Color.BLUE),
                new Dog(5, "Bonny", Color.BLACK),
                new Dog(1, "Baby", Color.BROWN),
                new Cat(19, "Bagira", Color.GREEN)
        };
    }

}
