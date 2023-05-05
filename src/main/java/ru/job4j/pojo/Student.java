package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String name;
    private int groupe;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupe() {
        return groupe;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(int year, int month, int dayOfMonth) {
        this.date = LocalDate.of(year, month, dayOfMonth);
    }
}
