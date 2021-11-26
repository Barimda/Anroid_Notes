package ru.gb.student.anroidnotes.backend.appobjects;

import java.util.Date;

public class Note {

    private String name;
    private String description;
    private String text;
    private Date creationDate;
    private Date lastUpdateDate;

    public Note() {
        this.name = "Пустая заметка";
        this.description = "Описание...";
        this.text = "Введите текст";;
    }

    public Note(String name, String text, Date creationDate) {
        this.name = name;
        this.description = "...";
        this.text = text;
        this.creationDate = creationDate;
        this.lastUpdateDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
