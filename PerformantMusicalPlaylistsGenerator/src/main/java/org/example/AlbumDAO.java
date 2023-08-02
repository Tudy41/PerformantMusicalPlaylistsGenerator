package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clasa de tip DAO pentru clasa Album.
 *
 *
 *
 */
public class AlbumDAO implements DAOModifiersAndObtainersInterface {
    private static Connection con;
    private Boolean ok1 = false;

    public AlbumDAO() {

    }

    public void create(ForHandleAndReturnObj args) throws SQLException {
        String releaseYear = args.getContains().get(0);
        String title = args.getContains().get(1);
        String artist = args.getContains().get(2);
        String genres = args.getContains().get(3);
        if (ok1 == false) {
            con = Database.getDataSource().getConnection();
            ok1 = true;
        }
        String idArtist = new ArtistDAO().findByName(new ForHandleAndReturnObj(artist)).toString();


        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into albums (release_year,title,artist_id) values (?,?,?)")) {
            pstmt.setString(1, releaseYear);
            pstmt.setString(2, title);
            pstmt.setString(3, idArtist);

            pstmt.executeUpdate();
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

    public ForHandleAndReturnObj findByNameForArtistId(ForHandleAndReturnObj name) throws SQLException {
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
                     "select name from albums where id='" + idForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }

}
