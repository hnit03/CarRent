/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.Rating;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import nhinh.utils.DBHelper;

/**
 *
 * @author PC
 */
public class RatingDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public float getRatingOfCar(String carID) throws SQLException, NamingException {
        float point = 0;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select AVG(point) as 'totalPoint' "
                        + "from RatingDetails "
                        + "where carID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, carID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    point = rs.getFloat("totalPoint");
                }
            }
        } finally {
            closeConnection();
        }
        return point;
    }
}
