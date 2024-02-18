package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.EditAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindItemByIdAction;
import ru.job4j.tracker.action.FindItemByNameAction;
import ru.job4j.tracker.action.ShowAllAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "0", "Item name", "1"
        });
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(new String[]{
                "0", String.valueOf(item.getId()), replacedName, "1"
        });
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{
                "0", String.valueOf(item.getId()), "1"
        });
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input input = new StubInput(new String[]{
                "0"
        });
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        assertThat(out.toString()).isEqualTo("Menu:" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item one = memTracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new EditAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit Item" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item1 = memTracker.add(new Item("test1"));
        Item item2 = memTracker.add(new Item("test2"));
        Item item3 = memTracker.add(new Item("test3"));
        Input input = new StubInput(new String[]{
                "0", "1"
        });
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ShowAllAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + item1 + ln
                        + item2 + ln
                        + item3 + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindItemById() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item1 = memTracker.add(new Item("test1"));
        Item item2 = memTracker.add(new Item("test2"));
        Item item3 = memTracker.add(new Item("test3"));
        Input input = new StubInput(new String[]{
                "0", String.valueOf(item2.getId()), "1"
        });
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find Item by Id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + item2 + ln
                        + "Menu:" + ln
                        + "0. Find Item by Id" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindItemByName() {
        Output out = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item1 = memTracker.add(new Item("test1"));
        Item item2 = memTracker.add(new Item("test2"));
        Item item3 = memTracker.add(new Item("test3"));
        Input input = new StubInput(new String[]{
                "0", item3.getName(), "1"
        });
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindItemByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find Item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find items by name ===" + ln
                        + item3 + ln
                        + "Menu:" + ln
                        + "0. Find Item by name" + ln
                        + "1. Exit" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[]{
                        "9", "0"
                });
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(input, memTracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit" + ln
        );
    }
}