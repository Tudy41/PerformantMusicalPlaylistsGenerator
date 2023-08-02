package org.example;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * Clasa ce reprezinta genurile.
 */
public class Genre extends Abstracter {
    private Map<Integer, String> name;
    private Map<Integer, String> id;

    private GenreDAO dao;

    public Genre(String genres) throws SQLException {
        counter = 1;
        name = new HashMap<>();
        id = new HashMap<>();
        GenreDAO dao = new GenreDAO();
        dao.create(new ForHandleAndReturnObj(genres));
        this.name.put(counter, genres);
        this.dao = dao;
        this.id.put(counter, dao.findByName(new ForHandleAndReturnObj(genres)).getContains().get(0));
        counter++;

    }

    public void addMoreData(String genres) throws SQLException {
        dao.create(new ForHandleAndReturnObj(genres));
        String idToSearch = dao.findByName(new ForHandleAndReturnObj(genres)).getContains().get(0);
        this.name.put(counter, dao.findById(new ForHandleAndReturnObj(idToSearch)).getContains().get(0));
        this.dao = dao;
        this.id.put(counter, dao.findByName(new ForHandleAndReturnObj(genres)).getContains().get(0));

        counter++;
    }

    public void setDao(Object dao) {
        this.dao = (GenreDAO) dao;
    }

    public Object getDao() {
        return dao;
    }

    public Map<Integer, String> getId() {
        return id;
    }

    public Map<Integer, String> getName() {
        return name;
    }


    public void setName(Map<Integer, String> name) {
        this.name = name;
    }

    public void setId(Map<Integer, String> id) {
        this.id = id;
    }

    public void findAll() {

        for (int i = 1; i < counter; i++) {

            System.out.println(id.get(i) + " " + name.get(i));
            System.out.println("----------------------------------------");
        }


    }

    public int getCounter() {
        return counter;
    }
}
