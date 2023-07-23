package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает инициализацию экземпляра класса, работу геттеров и сеттеров для полей
 * экземпляра класса, а так же переопределяет работу для методов сравнения и хэш - кода
 *
 * @author STAS KUPRIYANOV
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * Конструктор принимает поля requisite и balance и инициализирует ими
     * текущий экземпляр класса
     *
     * @param requisite реквизит текущего экземпляра
     * @param balance   баланс текущего экземпляра
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод возвращает поле requisite текущего экземпляра
     *
     * @return requisite реквизит текущего экземпляра
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает и устанавливает поле requisite для текущего экземпляра
     *
     * @param requisite реквизит текущего экземпляра
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод возвращает поле balance текущего экземпляра
     *
     * @return balance баланс текущего экземпляра
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает и устанавливает поле balance для текущего экземпляра
     *
     * @param balance баланс текущего экземпляра
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод принимает другой экземпляр и сравнивает его с текущим по полю requisite
     *
     * @param o другой экземпляр для сравнения
     * @return возвращает true если равны, false если нет
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хэш - код экземпляра для сравнения
     *
     * @return возвращает хэш - код экземпляра
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
