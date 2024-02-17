package org.example.Geek.ReflectionApi.Animals;

public class Cat extends AbstractAnimal{


    private final Color eyesColor;

    public Cat(int age, String name, Color eyesColor) {
        super(age, name);
        this.eyesColor = eyesColor;
    }

    private void sleepAllDay() {
        System.out.println(getName() + " go to sleep");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " slept all day");
    }

    @Override
    public void makeSound() {
        System.out.println("meow");
    }

    @Override
    public String toString() {
        return String.format("%s, eyes color: %s",
                super.toString(),
                eyesColor.toString().toLowerCase());
    }
}
