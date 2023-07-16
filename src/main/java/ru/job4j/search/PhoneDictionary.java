package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> namePred = person -> person.getName().contains(key);
        Predicate<Person> surnamePred = person -> person.getSurname().contains(key);
        Predicate<Person> phonePred = person -> person.getPhone().contains(key);
        Predicate<Person> addressPred = person -> person.getAddress().contains(key);
        Predicate<Person> combine = namePred.or(surnamePred).or(phonePred).or(addressPred);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
