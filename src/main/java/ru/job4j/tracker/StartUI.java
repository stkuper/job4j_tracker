package ru.job4j.tracker;

import ru.job4j.tracker.action.CreateAction;
import ru.job4j.tracker.action.CreateManyItems;
import ru.job4j.tracker.action.DeleteAction;
import ru.job4j.tracker.action.DeleteAllItems;
import ru.job4j.tracker.action.EditAction;
import ru.job4j.tracker.action.ExitAction;
import ru.job4j.tracker.action.FindItemByIdAction;
import ru.job4j.tracker.action.FindItemByNameAction;
import ru.job4j.tracker.action.ShowAllAction;
import ru.job4j.tracker.action.UserAction;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store tracker = new SqlTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ShowAllAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindItemByIdAction(output),
                new FindItemByNameAction(output),
                new ExitAction(),
                new CreateManyItems(output),
                new DeleteAllItems(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}
