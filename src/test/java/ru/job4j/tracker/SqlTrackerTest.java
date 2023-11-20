package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("first");
        tracker.add(item);
        List<Item> expected = List.of(item);
        assertThat(tracker.findByName(item.getName())).isEqualTo(expected);
    }

    @Test
    public void whenSaveItemsAndFindAllThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        Item item3 = new Item("third");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expected = List.of(item1, item2, item3);
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenDeleteItemThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item1.getId())).isNull();
        assertThat(tracker.findById(item2.getId())).isEqualTo(item2);
    }

    @Test
    public void whenReplaceItem1OnItem2ThenMustBeTrue() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("first");
        Item item2 = new Item("second");
        tracker.add(item1);
        assertThat(tracker.replace(item1.getId(), item2)).isTrue();
        assertThat(tracker.findById(item1.getId()).getName()).isEqualTo(item2.getName());
    }
}