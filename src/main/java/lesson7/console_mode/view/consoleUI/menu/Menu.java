package lesson7.console_mode.view.consoleUI.menu;

import lesson7.console_mode.presenter.Presenter;
import lesson7.console_mode.view.consoleUI.ConsoleUI;
import lesson7.console_mode.view.consoleUI.Notifier;

import java.util.Scanner;

/**
 * Базовый класс меню
 */
public abstract class Menu {
    protected String title;
    protected final Notifier notifier = ConsoleUI.notifier;
    protected final Scanner scanner = ConsoleUI.scanner;
    protected final Presenter presenter = ConsoleUI.presenter;
    protected boolean running = true;

    public Menu(String title, boolean oneTimeLoop) {
        this.title = title;
        if (oneTimeLoop) {
            running = false;
        }
    }

    protected void printTitle() {
        System.out.println("===== " + title + " =====");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected void clearConsole() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void stop() {
        running = false;
    }

    public abstract void run();
}
