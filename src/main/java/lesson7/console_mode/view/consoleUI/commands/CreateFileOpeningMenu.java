package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.model.Notepad;
import lesson7.console_mode.view.consoleUI.menu.FlipMenu;
import lesson7.console_mode.view.consoleUI.menu.Menu;
import lesson7.console_mode.view.consoleUI.notifications.NoticeType;

import java.util.List;

/**
 * Команда для создания и запуска меню открытия файла
 */
public class CreateFileOpeningMenu extends Command {
    @Override
    public String getDescription() {
        return "Открыть файл";
    }

    @Override
    public void execute(Menu menu) {
        try {
            FlipMenu flipMenu = new FlipMenu("Меню открытия файла", false) {
                @Override
                protected void fillCommands() {
                    List<String> list = presenter.getAllFilesNames();
                    for (String string : list) {
                        this.addCommand(new OpenFile(Notepad.FOLDER_PATH, string));
                    }
                }
            };

            flipMenu.run();

        } catch (Exception e) {
            notifier.add("Что-то пошло не так", NoticeType.ERROR);
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}
