package org.example.Geek.ReflectionApi.Animals;

public class Dog extends AbstractAnimal {

    private final Color hairColor;

    public Dog (int age, String name, Color hairColor) {
        super(age, name);
        this.hairColor = hairColor;
    }

    private void runForever() {
        System.out.println(getName() + " run run run run run");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    @Override
    public void makeSound() {
        System.out.println("woof");
    }

    @Override
    public String toString() {
        return String.format("%s, hair color: %s",
                super.toString(),
                hairColor.toString().toLowerCase());
    }
}
