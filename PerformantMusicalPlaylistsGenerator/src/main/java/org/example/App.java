package org.example;


import org.example.AlbumDAO;
import org.example.ArtistDAO;
import org.example.Database;
import org.example.GenreDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * Clasa principala ce contine metoda main.
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        try {

            ImportTool.collectData("C:\\Users\\User\\IdeaProjects\\PerformantMusicalPlaylistsGenerator\\src\\main\\java\\org\\example\\albumList.csv");
            ImportTool.importDataCollected();

            Playlists p = new Playlists();
            p.generateUnrelatedPlaylists();


            Database.getDataSource().getConnection().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}