package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, String> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen.getUsername());
            return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        String value = citizens.get(passport);
        return new Citizen(passport, value);
    }
}
