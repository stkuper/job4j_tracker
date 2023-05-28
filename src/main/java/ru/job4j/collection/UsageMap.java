package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("stklipper@gmail.com", "Куприянов Станислав Юрьевич");
        map.put("divanov@gmail.com", "Иванов Дмитрий Сергеевич");
        map.put("alexgon@gmail.com", "Гончаров Александр Алексеевич");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
