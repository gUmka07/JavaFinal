package lesson7.console_mode.view.consoleUI;

import lesson7.console_mode.view.consoleUI.notifications.Notice;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, работающий с уведомлениями (Notice) для пользователя
 */
public class Notifier {
    private final List<Notice> noticeList;

    public Notifier() {
        this.noticeList = new ArrayList<>();
    }

    public void add(String text, int type){
        noticeList.add(new Notice(text, type));
    }

    public void showNotices(){
        if (!this.noticeList.isEmpty()) {
            for (Notice notice : noticeList) {
                System.out.println((notice));
            }
            noticeList.clear();
        }
    }
}
