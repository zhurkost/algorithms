package by.zhurauleu.task4_1_2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int itemsCount = input.nextInt();
        Bag bag = new Bag(input.nextInt());
        List<Item> items = new ArrayList();
        for (int i = 0; i < itemsCount; i++) {
            items.add(new Item(input.nextInt(), input.nextInt()));
        }
        Collections.sort(items);
        if (bag.capacity > 0) {
            for (Item item : items) {
                tryPutItem(bag, item);
                if (bag.capacity == 0) break;

            }
        }
        System.out.println(bag.cost);
    }

    static void tryPutItem(Bag bag, Item item) {
        if (bag.capacity >= item.weight) {
            bag.capacity -= item.weight;
            bag.cost += item.totalCost;
        } else {
            bag.cost += bag.capacity * item.costPerWeight;
            bag.capacity = 0;
        }
    }
}

class Bag {
    int capacity;
    double cost;

    Bag(int bagCapacity) {
        this.capacity = bagCapacity;
    }
}


class Item implements Comparable<Item> {

    int weight;
    int totalCost;
    double costPerWeight;

    Item(int c, int w) {
        this.totalCost = c;
        this.weight = w;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
//        double temp = Math.round((( c * 1000) / w));
//        this.costPerWeight = temp/1000;
        double temp = (double) c / (double) w;
        String cpw = decimalFormat.format(temp);
        this.costPerWeight = Double.parseDouble(cpw.replaceAll(",","."));

    }

    @Override
    public int compareTo(Item o) {
        return (int) (o.costPerWeight - this.costPerWeight);
    }
}
