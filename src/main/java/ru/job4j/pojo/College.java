package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Petr Sidorovich");
        student.setGroupe(3);
        student.setDate(2023, 4, 7);
        System.out.println("The student " + student.getName() + " entered "
                           + student.getGroupe() + " groupe " + student.getDate());
    }
}
