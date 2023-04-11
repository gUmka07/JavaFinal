package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.view.consoleUI.menu.FlipMenu;
import lesson7.console_mode.view.consoleUI.menu.Menu;
/**
 * Команда для перехода на предыдущую страницу в FlipMenu
 */
public class PreviousPage extends Command{
    @Override
    public String getDescription() {
        return "Предыдущая страница";
    }

    @Override
    public void execute(Menu menu) {
        ((FlipMenu) menu).decrementPage();
    }
}
