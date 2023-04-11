package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.view.consoleUI.menu.FlipMenu;
import lesson7.console_mode.view.consoleUI.menu.Menu;

/**
 * Команда для перехода на следующую страницу в FlipMenu
 */
public class NextPage extends Command{
    @Override
    public String getDescription() {
        return "Следующая страница";
    }
    @Override
    public void execute(Menu menu) {
        ((FlipMenu) menu).incrementPage();
    }
}
