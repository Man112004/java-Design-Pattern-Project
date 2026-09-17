package com.example.Session1.Task5;

class PlaylistDAO {

    public void saveSong(String song) {
        System.out.println("Saving song to database " + song);
    }
}

class Controller {

    PlaylistDAO dao = new PlaylistDAO();

    public void addSong(String song) {

        if (song == null || song.isEmpty()) {
            System.out.println("Song name is required");
            return;
        }

        dao.saveSong(song);

        System.out.println("Song added  " + song);
    }
}

public class Task5 {

    public static void main(String[] args) {

        Controller cont = new Controller();

        cont.addSong("Perfect");
    }
}