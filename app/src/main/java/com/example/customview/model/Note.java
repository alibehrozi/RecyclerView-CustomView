package com.example.customview.model;

/**
 * A view model for each note item
 */
public class Note {

    /**
     * A unique id for the note
     */
    public long id;

    /**
     * The title of the note
     */
    public String title;

    /**
     * The content of the note
     */
    public String content;

    /**
     * Default constructor
     *
     * @param id    An unique id for the active chat
     * @param title The display name of this friend
     * @param content   The bio form this chat
     */
    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInitials() {
        return title.substring(0, 1);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
