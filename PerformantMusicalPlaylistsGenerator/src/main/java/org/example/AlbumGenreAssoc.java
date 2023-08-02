package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clasa ce reprezinta asocierile dintre id-urile albumelor si genurilor.
 *
 *
 *
 */
public class AlbumGenreAssoc extends Abstracter {

    private List<String> albumId;
    private List<String> genreId;

    private int counter;

    public AlbumGenreAssoc(Album daoAlbum, Genre daoGenre) throws SQLException {
        counter = 1;
        albumId = new ArrayList<>();
        genreId = new ArrayList<>();
        AlbumGenreAssocDAO dao = new AlbumGenreAssocDAO(((AlbumDAO) (daoAlbum.getDao())), ((GenreDAO) (daoGenre.getDao())));
        int i = 1;
        while (i <= daoAlbum.getCounter()) {
            dao.create(new ForHandleAndReturnObj(daoAlbum.getReleaseYears().get(i), daoAlbum.getTitles().get(i), daoAlbum.getIds().get(i), daoGenre.getName().get(i)));
            i++;
        }
        this.dao = dao;
        ForHandleAndReturnObj[] tableArray = ((AlbumGenreAssocDAO) this.getDao()).getLines();
        int nr = AlbumGenreAssocDAO.nrOfLines;
        while (counter < nr) {
            this.albumId.add(tableArray[counter].getContains().get(0));
            this.genreId.add(tableArray[counter].getContains().get(1));

            counter++;
        }


    }

    public void setDao(Object dao) {
        this.dao = dao;
    }

    public Object getDao() {
        return dao;
    }


    public List<String> getAlbumId() {
        return albumId;
    }

    public List<String> getGenreId() {
        return genreId;
    }

    public void setAlbumId(List<String> albumId) {
        this.albumId = albumId;
    }

    public void setGenreId(List<String> genreId) {
        this.genreId = genreId;
    }

    public void findAll() {

        for (int i = 0; i < counter - 1; i++) {

            System.out.println(albumId.get(i) + " " + genreId.get(i));
            System.out.println("------------------");
        }


    }

    public int getCounter() {
        return counter;
    }
}
