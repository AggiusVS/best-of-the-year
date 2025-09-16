package com.example.best_of_the_year.model;

public class Song {

private final int id;
private final String title;
    
    public Song(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
