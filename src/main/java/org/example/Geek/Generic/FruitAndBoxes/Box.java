package org.example.Geek.Generic.FruitAndBoxes;

import org.example.Geek.Generic.FruitAndBoxes.Fruits.Fruit;
import java.util.List;
import java.util.ArrayList;

public class Box<T extends Fruit> {

    private final List<T> fruitContainer;

    public Box() {
        this.fruitContainer = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruitContainer.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : fruitContainer) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public int getSize() {
        return fruitContainer.size();
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public void pourTo(Box<? super T> boxTo) {
        for (T fruit : fruitContainer) {
            boxTo.addFruit(fruit);
        }
        fruitContainer.clear();
    }
}
