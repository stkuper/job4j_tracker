package ru.job4j.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] prods = new Product[5];
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;
        for (int index = 0; index < prods.length; index++) {
            Product prod = prods[index];
            if (prod != null) {
                System.out.println(prod.getName() + " - " + prod.getCount());
            }
        }
        System.out.println("Replace milk to oil");
        Product oil = new Product("Oil", 11);
        prods[0] = oil;
        for (int i = 0; i < prods.length; i++) {
            Product prod = prods[i];
            if (prod != null) {
                System.out.println(prod.getName() + " - " + prod.getCount());
            }
        }
        System.out.println("Shown only product.count > 10");
        for (int i = 0; i < prods.length; i++) {
            Product prod = prods[i];
            if (prod != null && prod.getCount() > 10) {
                System.out.println(prod.getName() + " - " + prod.getCount());
            }
        }
    }
}
