/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class NextId {

    public int next(Connection conn, String nTabla) throws SQLException {
        String sql = "SELECT SQ_ID_"+nTabla+".NEXTVAL FROM DUAL";
        PreparedStatement stmt = null;
        ResultSet result = null;
        int id = 0;
        try {
            stmt = conn.prepareStatement(sql);
            result = stmt.executeQuery();
            if (result.next()) {
                id = result.getInt(1);
            }
        } finally {
            if (result != null) {
                result.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return id;
    }

}
