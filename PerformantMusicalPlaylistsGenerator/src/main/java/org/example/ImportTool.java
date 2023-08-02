package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Clasa ce realizeaza extragerea datelor si transmiterea acestora catre baza de date.
 *
 *
 *
 */
public class ImportTool {
    private static List<RecordsFromCSV> listOfRecords;

    public static void collectData(String path) throws IOException {
        List<RecordsFromCSV> books = null;

        books = readBooksFromCSV(path);

        listOfRecords = books;

        for (RecordsFromCSV b : books) {
            System.out.println(b);
        }

    }

    private static List<RecordsFromCSV> readBooksFromCSV(String fileName) throws IOException {
        List<RecordsFromCSV> books = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        FileReader f = new FileReader(fileName);
        try (BufferedReader br = new BufferedReader(f)) {
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                RecordsFromCSV book = createBook(attributes);
                books.add(book);
                line = br.readLine();
            }
        }
        return books;
    }


    private static RecordsFromCSV createBook(String[] metadata) {
        String number = metadata[0];
        String year = metadata[1];
        String album = metadata[2];
        String artist = metadata[3];
        String genre = metadata[4];
        String subgenres = metadata[5];

        return new RecordsFromCSV(number, year, album, artist, genre, subgenres);
    }

    public static void importDataCollected() throws SQLException {
        Artist artist = null;
        Genre genres;
        Album albums;
        Boolean firstTime = true;
        AlbumGenreAssoc association;

        for (RecordsFromCSV s : listOfRecords) {
            if (firstTime) {
                artist = new Artist(s.getArtist());

                firstTime = false;
            } else {

                artist.addMoreData(s.getArtist());
            }
        }
        genres = null;
        firstTime = true;
        for (RecordsFromCSV s : listOfRecords) {
            if (firstTime) {
                genres = new Genre(s.getGenre());
                firstTime = false;
            } else {
                genres.addMoreData(s.getGenre());
            }
        }
        albums = null;
        firstTime = true;
        for (RecordsFromCSV s : listOfRecords) {
            if (firstTime) {
                albums = new Album(s.getYear(), s.getAlbum(), s.getArtist(), s.getGenre());
                firstTime = false;
            } else {

                albums.addMoreData(s.getYear(), s.getAlbum(), s.getArtist(), s.getGenre());
            }
        }


        association = new AlbumGenreAssoc(albums, genres);


    }

    public static List<RecordsFromCSV> getListOfRecords() {
        return listOfRecords;
    }

    public static void setListOfRecords(List<RecordsFromCSV> listOfRecords) {
        ImportTool.listOfRecords = listOfRecords;
    }

}





