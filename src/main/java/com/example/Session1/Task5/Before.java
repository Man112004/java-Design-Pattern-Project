package com.example.Session1.Task5;

class Before {

    public void addSong(String song) {

        if (song == null || song.isEmpty()) {
            System.out.println("Song name is required");
            return;
        }

        System.out.println("Saving song to database " + song);

        System.out.println("Song added " + song);
    }
}