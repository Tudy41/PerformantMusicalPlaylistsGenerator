package org.example;
/**
 * Clasa ce reprezinta continutul unei inregistrari dintr-un set de date.
 *
 *
 *
 */
public class RecordsFromCSV {
    private String number;

    private String year;
    private String album;

    private String artist;

    private String genre;
    private String subgenre;

    public RecordsFromCSV(String number, String year, String album, String artist, String genre, String subgenre) {
        this.number = number;
        this.year = year;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.subgenre = subgenre;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public String getNumber() {
        return number;
    }

    public String getSubgenre() {
        return subgenre;
    }

    public String getYear() {
        return year;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setSubgenre(String subgenre) {
        this.subgenre = subgenre;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    @Override
    public String toString() {
        return "record [number=" + number + ", year=" + year + ", album=" + album + ", artist=" + artist + ", genre=" + genre + ", subgenres=" + subgenre + "]";
    }


    public Boolean compareTo(RecordsFromCSV o) {
        if (this.getNumber().equals(o.getNumber())) {
            return true;
        }
        return false;
    }
}