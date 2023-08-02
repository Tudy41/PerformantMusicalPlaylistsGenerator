package org.example;

import java.sql.*;
/**
 * Clasa de tip DAO pentru clasa AlbumGenreAssoc.
 *
 *
 *
 */
public class AlbumGenreAssocDAO implements DAOModifiersAndObtainersInterface {
    public static int nrOfLines;
    private AlbumDAO album;

    private GenreDAO genre;
    private static Connection con;
    private Boolean ok1 = false;

    public AlbumGenreAssocDAO(AlbumDAO album, GenreDAO genre) {
        nrOfLines = 0;
        this.setAlbum(album);
        this.setGenre(genre);

    }

    public void setAlbum(AlbumDAO album) {
        this.album = album;
    }

    public AlbumDAO getAlbum() {
        return album;
    }

    public GenreDAO getGenre() {
        return genre;
    }

    public void setGenre(GenreDAO genre) {
        this.genre = genre;
    }

    public void create(ForHandleAndReturnObj args) throws SQLException {

        String releaseYear = args.getContains().get(0);
        String title = args.getContains().get(1);
        String artist = args.getContains().get(2);
        String genres = args.getContains().get(3);

        String idAlbum = new AlbumDAO().findByName(new ForHandleAndReturnObj(title)).toString();
        if (ok1 == false) {
            con = Database.getDataSource().getConnection();
            ok1 = true;
        }
        if (genres != null) {
            String[] genresVec = genres.split(",");
            for (String g : genresVec) {
                String idGenres = new GenreDAO().findByName(new ForHandleAndReturnObj(g)).toString();
                try (PreparedStatement pstmt = con.prepareStatement(
                        "insert into album_genre (album_id,genre_id) values (?,?)")) {
                    pstmt.setString(1, idAlbum);
                    pstmt.setString(2, idGenres);
                    pstmt.executeUpdate();
                }
            }
        }


    }


    public ForHandleAndReturnObj findByName(ForHandleAndReturnObj name) throws SQLException {
        String nameForQuery = name.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title='" + nameForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getInt(1) : null);
        }
    }


    public ForHandleAndReturnObj findById(ForHandleAndReturnObj id) throws SQLException {
        String idForQuery = id.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from album_genre where album_id='" + idForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }

    public ForHandleAndReturnObj findByIdForGenres(ForHandleAndReturnObj id) throws SQLException {
        String idForQuery = id.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from album_genre where genre_id='" + idForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }

    public ForHandleAndReturnObj[] getLines() throws SQLException {

        ForHandleAndReturnObj[] arraySol = new ForHandleAndReturnObj[10000];
        int i = 1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from album_genre")) {
            while (rs.next()) {
                nrOfLines++;
                arraySol[i] = new ForHandleAndReturnObj(rs.getString(1), rs.getString(2));
                i++;
            }
        }
        return arraySol;
    }


}
