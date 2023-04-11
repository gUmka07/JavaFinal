package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.presenter.Presenter;
import lesson7.console_mode.view.consoleUI.ConsoleUI;
import lesson7.console_mode.view.consoleUI.Notifier;
import lesson7.console_mode.view.consoleUI.menu.Menu;

import java.util.Scanner;

/**
 * Базовый класс команды
 */
public abstract class Command {
    protected final Notifier notifier = ConsoleUI.notifier;
    protected final Scanner scanner = ConsoleUI.scanner;
    protected final Presenter presenter = ConsoleUI.presenter;

    public abstract String getDescription();
    public abstract void execute(Menu menu);
}
