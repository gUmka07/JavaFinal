package lesson7.console_mode;

import lesson7.console_mode.model.Notepad;
import lesson7.console_mode.presenter.Presenter;
import lesson7.console_mode.view.consoleUI.ConsoleUI;
import lesson7.console_mode.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        Notepad notepad = new Notepad();
        new Presenter(view, notepad);

        view.start();
    }
}
