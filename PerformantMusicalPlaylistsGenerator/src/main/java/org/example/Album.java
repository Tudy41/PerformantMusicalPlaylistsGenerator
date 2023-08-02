package org.example;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * Clasa ce reprezinta albumele.
 */
public class Album extends Abstracter {

    private Map<Integer, String> year;

    private Map<Integer, String> id;

    private Map<Integer, String> titles;

    private Map<Integer, String> artistId;


    public Album(String releaseYear, String title, String artist, String genres) throws SQLException {
        AlbumDAO daoNew = new AlbumDAO();
        artistId = new HashMap<>();
        titles = new HashMap<>();
        year = new HashMap<>();

        artistId = new HashMap<>();
        id = new HashMap<>();

        counter = 1;

        daoNew.create(new ForHandleAndReturnObj(releaseYear, title, artist, genres));
        this.year.put(counter, releaseYear);
        this.titles.put(counter, title);
        this.dao = daoNew;
        this.id.put(counter, daoNew.findByName(new ForHandleAndReturnObj(title)).getContains().get(0));
        this.artistId.put(counter, daoNew.findByNameForArtistId(new ForHandleAndReturnObj(title)).getContains().get(0));
        counter++;

    }

    public void addMoreData(String releaseYear, String title, String artist, String genres) throws SQLException {


        ((AlbumDAO) dao).create(new ForHandleAndReturnObj(releaseYear, title, artist, genres));


        this.year.put(counter, releaseYear);
        this.titles.put(counter, title);

        this.id.put(counter, ((AlbumDAO) dao).findByName(new ForHandleAndReturnObj(title)).getContains().get(0));
        this.artistId.put(counter, ((AlbumDAO) dao).findByNameForArtistId(new ForHandleAndReturnObj(title)).getContains().get(0));
        counter++;
    }

    public Map<Integer, String> getArtistIds() {
        return artistId;
    }

    public Map<Integer, String> getReleaseYears() {
        return year;
    }

    public Map<Integer, String> getIds() {
        return id;
    }

    public Map<Integer, String> getTitles() {
        return titles;
    }

    public void setDao(Object dao) {
        this.dao = dao;
    }

    public Object getDao() {
        return dao;
    }


    public void setIds(Map<Integer, String> id) {
        this.id = id;
    }

    public void setArtistIds(Map<Integer, String> artistId) {
        this.artistId = artistId;
    }

    public void setReleaseYears(Map<Integer, String> releaseYear) {
        this.year = releaseYear;
    }

    public void setTitles(Map<Integer, String> title) {
        this.titles = title;
    }

    public void findAll() {

        for (int i = 1; i < counter; i++) {

            System.out.println(id.get(i) + " " + year.get(i) + " " + titles.get(i) + " " + artistId.get(i));
            System.out.println("----------------------------------------");
        }


    }

    public int getCounter() {
        return counter;
    }
}
