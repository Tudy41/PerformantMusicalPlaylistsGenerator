package org.example;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * Clasa ce reprezinta artistii.
 */
public class Artist extends Abstracter {

    private Map<Integer, String> name;
    private Map<Integer, String> id;


    private ArtistDAO dao;

    public Artist(String artist) throws SQLException {
        ArtistDAO daoNew = new ArtistDAO();
        id = new HashMap<>();
        name = new HashMap<>();
        counter = 1;
        daoNew.create(new ForHandleAndReturnObj(artist));
        this.dao = daoNew;
        this.id.put(counter, daoNew.findByName(new ForHandleAndReturnObj(artist)).getContains().get(0));
        this.name.put(counter, artist);
        counter++;
    }

    public void addMoreData(String artist) throws SQLException {
        dao.create(new ForHandleAndReturnObj(artist));
        String searchForId = dao.findByName(new ForHandleAndReturnObj(artist)).getContains().get(0);
        this.name.put(counter, dao.findById(new ForHandleAndReturnObj(searchForId)).getContains().get(0));
        this.dao = dao;
        this.id.put(counter, dao.findByName(new ForHandleAndReturnObj(artist)).getContains().get(0));

        counter++;
    }

    public void setDao(Object dao) {
        this.dao = (ArtistDAO) dao;
    }

    public Object getDao() {
        return dao;
    }

    public Map<Integer, String> getName() {
        return name;
    }

    public Map<Integer, String> getId() {
        return id;
    }

    public void setId(Map<Integer, String> id) {
        this.id = id;
    }


    public void setName(Map<Integer, String> name) {
        this.name = name;
    }

    public void findAll() {

        for (int i = 1; i < counter; i++) {

            System.out.println(id.get(i) + " " + name.get(i));
            System.out.println("----------");
        }


    }

    public int getCounter() {
        return counter;
    }
}
