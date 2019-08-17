package ru.job4j.validate;

import org.junit.*;
import ru.job4j.start.StabInput;

import java.io.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Collections;
import java.util.List;


public class ValidateInputTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = System.out;

    @Before
    public void loadOut() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadOutBack() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenPutIncorrectNumber() {
        List<Integer> range = Collections.singletonList(0);
        ValidateInput input = new ValidateInput(
                new StabInput(new String[] {"Неправильный пункт", "0"})
        );
        input.ask("Enter",  range);
        assertThat(
                this.out.toString(),
                is(
                        String.format("Вы ввели строку, а нужно число!%n")
                )
        );
    }

    @Test
    public void whenOutOfRange() {
        List<Integer> range = Collections.singletonList(0);
        ValidateInput input = new ValidateInput(
                new StabInput(new String[] {"123", "0"})
        );
        input.ask("Enter",  range);
        assertThat(
                this.out.toString(),
                is(
                        String.format("Вы вышли за диапазон!%n")
                )
        );
    }
}
