package lesson7.javafx_mode.model;

import java.util.UUID;

public class Note {
    private String content;
    private final String id;

    public Note(String content) {
        this.content = content;
        this.id = UUID.randomUUID().toString();
    }

    public String getContent() {
        return content;
    }

    public String getId() {
        return this.id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
