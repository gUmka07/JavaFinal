package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.view.consoleUI.menu.Menu;

/**
 * Команда Выход из программы
 */
public class Exit extends Command{
    @Override
    public void execute(Menu menu) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Выход";
    }
}
