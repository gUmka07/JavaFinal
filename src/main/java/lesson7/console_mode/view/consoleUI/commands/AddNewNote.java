package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.model.Note;
import lesson7.console_mode.view.consoleUI.menu.ChangeNoteMenu;
import lesson7.console_mode.view.consoleUI.menu.Menu;
import lesson7.console_mode.view.consoleUI.notifications.NoticeType;

public class AddNewNote extends Command {
    @Override
    public String getDescription() {
        return "Добавить запись";
    }

    @Override
    public void execute(Menu menu) {
        Note note = new Note();
        try {
            new ChangeNoteMenu("Меню создания записи", false, note).run();
            presenter.addNote(note);
            notifier.add("Запись успешно добавлена!", NoticeType.OK);
        } catch (Exception e) {
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}
