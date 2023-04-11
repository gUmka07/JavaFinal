package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.view.consoleUI.menu.CreationFileMenu;
import lesson7.console_mode.view.consoleUI.menu.Menu;

/**
 * Команда для создания файла
 */
public class CreateFile extends Command {
    @Override
    public String getDescription() {
        return "Создать файл";
    }

    @Override
    public void execute(Menu menu) {
        menu.stop();
        CreationFileMenu creationFileMenu = new CreationFileMenu("Меню создания файла", false);
        creationFileMenu.run();
    }
}
