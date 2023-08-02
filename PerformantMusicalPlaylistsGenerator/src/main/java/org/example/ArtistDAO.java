package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clasa de tip DAO pentru clasa Artist.
 *
 *
 *
 */
public class ArtistDAO implements DAOModifiersAndObtainersInterface {
    private static Connection con;
    private Boolean ok1 = false;


    public ArtistDAO() {


    }


    public void create(ForHandleAndReturnObj args) throws SQLException {

        String name = args.getContains().get(0);
        if (ok1 == false) {
            con = Database.getDataSource().getConnection();
            ok1 = true;
        }

        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    public ForHandleAndReturnObj findByName(ForHandleAndReturnObj name) throws SQLException {
        String nameForQuery = name.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + nameForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }

    public ForHandleAndReturnObj findById(ForHandleAndReturnObj id) throws SQLException {
        String idForQuery = id.getContains().get(0);

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + idForQuery + "'")) {
            return new ForHandleAndReturnObj(rs.next() ? rs.getString(1) : null);
        }
    }


}
