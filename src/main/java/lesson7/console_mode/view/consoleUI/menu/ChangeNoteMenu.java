package lesson7.console_mode.view.consoleUI.menu;

import lesson7.console_mode.model.Note;
import lesson7.console_mode.view.consoleUI.ConsoleUI;
import lesson7.console_mode.view.consoleUI.notifications.NoticeType;

/**
 * Класс меню для изменения текста записи
 */
public class ChangeNoteMenu extends Menu {
    private final Note note;

    public ChangeNoteMenu(String title, boolean oneTimeLoop, Note note) {
        super(title, oneTimeLoop);
        this.note = note;
    }

    @Override
    public void run() {
        do {
            System.out.print("Введите текст записи (для отмены введите 0) >: ");
            String content = scanner.nextLine();

            if (content.equals("0")) {
                stop();
            } else {
                try {
                    note.setContent(content);
                    stop();
                } catch (Exception e) {
                    ConsoleUI.notifier.add(e.getMessage(), NoticeType.ERROR);
                }
            }
        } while (running);
    }
}
