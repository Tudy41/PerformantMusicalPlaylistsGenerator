package org.example;
import java.sql.SQLException;
/**
 * Interfata pentru DAO-urile din modelul POO.
 *
 *
 *
 *
 */
public interface DAOModifiersAndObtainersInterface {

    void create(ForHandleAndReturnObj args) throws SQLException;

    ForHandleAndReturnObj findByName(ForHandleAndReturnObj name) throws SQLException;

    ForHandleAndReturnObj findById(ForHandleAndReturnObj id) throws SQLException;

}
