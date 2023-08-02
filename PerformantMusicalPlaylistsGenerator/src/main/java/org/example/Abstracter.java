package org.example;

import java.sql.SQLException;
/**
 * Clasa abstracta pentru clasele Album,AlbumGenreAssoc,Artist si Genre.
 *
 *
 *
 */
public abstract class Abstracter {

    protected int counter;
    protected Object dao;

    public abstract void setDao(Object dao);

    public abstract Object getDao();

    public abstract int getCounter();
}
