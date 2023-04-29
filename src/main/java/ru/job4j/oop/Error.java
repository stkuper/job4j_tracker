package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
        System.out.println();
    }

    public static void main(String[] args) {
        Error def = new Error();
        Error param1 = new Error(true, 5, "Ошибка 5");
        Error param2 = new Error(false, 3, "Ошибка 3");
        Error param3 = new Error(false, 0, "Ошибка 0");
        def.printInfo();
        param1.printInfo();
        param2.printInfo();
        param3.printInfo();
    }
}
