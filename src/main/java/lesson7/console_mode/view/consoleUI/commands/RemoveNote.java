package lesson7.console_mode.view.consoleUI.commands;

import lesson7.console_mode.model.Note;
import lesson7.console_mode.view.consoleUI.menu.Menu;
import lesson7.console_mode.view.consoleUI.notifications.NoticeType;

import java.io.IOException;

public class RemoveNote extends Command {
    Note note;

    public RemoveNote(Note note) {
        this.note = note;
    }

    @Override
    public String getDescription() {
        return "Удалить запись";
    }

    @Override
    public void execute(Menu menu) {
        try {
            presenter.removeNote(note);
            notifier.add("Запись успешно удалена!", NoticeType.OK);
            menu.stop();
        } catch (IOException e) {
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}
