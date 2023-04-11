package lesson7.console_mode.view.consoleUI.menu;

import lesson7.console_mode.view.consoleUI.ConsoleUI;
import lesson7.console_mode.view.consoleUI.notifications.NoticeType;

/**
 * Класс для создания нового файла-блокнота
 */
public class CreationFileMenu extends Menu {

    public CreationFileMenu(String title, boolean oneTimeLoop) {
        super(title, oneTimeLoop);
    }


    @Override
    public void run() {
        do {
            clearConsole();
            notifier.showNotices();
            printTitle();

            System.out.print("Введите название для нового файла (0 для отмены) >: ");
            String fileName = scanner.nextLine();

            try {
                ConsoleUI.presenter.createFile(fileName);
                ConsoleUI.notifier.add(String.format("Файл \"%s.txt\" успешно создан!\n", fileName), NoticeType.OK);
                ConsoleUI.presenter.openFile(fileName);
                stop();
            } catch (Exception e) {
                ConsoleUI.notifier.add(e.getMessage(), NoticeType.ERROR);
            }
        } while (running);
    }
}
