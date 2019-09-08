package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.storage.Tracker;

import java.util.function.Consumer;

public class ExitProgramm extends BaseAction {
    private StartUI stop;

    public ExitProgramm(int key, String name, StartUI stop) {
        super(key, name);
        this.stop = stop;
    }


    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        this.stop.exit();
    }
}
