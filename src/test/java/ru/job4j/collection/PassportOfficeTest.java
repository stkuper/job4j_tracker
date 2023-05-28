package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenDublicate() {
        PassportOffice office = new PassportOffice();
        office.add(new Citizen("12345", "Stas Kupriyanov"));
        office.add(new Citizen("56789", "Aleksandr Goncharov"));
        office.add(new Citizen("02468", "Kirill Klein"));
        assertThat(office.add(new Citizen("12345", "Stas Kupriyanov"))).isFalse();
    }

}