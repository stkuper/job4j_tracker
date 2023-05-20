package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "one", "1"
        });
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "0"
        });
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(0);
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        String[] numbers = new String[]{
                "0", "1", "2"
        };
        Input in = new StubInput(numbers);
        ValidateInput input = new ValidateInput(out, in);
        for (String num : numbers) {
            int selected = input.askInt("Enter menu: ");
            assertThat(selected).isEqualTo(Integer.parseInt(num));
        }
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "-1"
        });
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected).isEqualTo(-1);
    }
}
