package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                return i;
            }
        }
        throw new ElementNotFoundException("Element not found");
    }

    public static void main(String[] args) {
        String[] words = {"Valya", "Sasha", "Alex", "Sveta", "Dasha"};
        String name = "Stas";
        try {
            indexOf(words, name);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
