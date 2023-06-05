package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает инициализацию экземпляра класса, работу геттеров и сеттеров для полей
 * экземпляра класса, а так же переопределяет работу методов сравнения и хэш - кода
 * @author STAS KUPRIYANOV
 * @version 1.0
 */
public class User {
    private String passport;
    private String username;

    /**
     *Конструктор принимает поля passport и username и инициализирует ими
     * текущий экземпляр класса
     * @param passport пасспорт текущего экземпляра
     * @param username имя текущего экземпляра
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**\
     * Метод возвращает поле passport текущего экземпляра
     * @return passport пасспорт текущего экземпляра
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает и устанавливает поле passport для текущего экземпляра
     * @param passport пасспорт текущего экземпляра
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод возвращает поле username текущего экземпляра
     * @return username имя текущего экземпляра
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает и устанавливает поле username для текущего экземпляра
     * @param username имя текущего экземпляра
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *Метод принимает другое экземпляр и сравнивает его с текущим
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает хэш - код экземпляра для сравнения
     * @return возвращает хэш - код экземпляра
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
