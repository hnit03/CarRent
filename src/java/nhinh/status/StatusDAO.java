/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.status;

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
public class StatusDAO implements Serializable{

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
    
    public StatusDTO getStatusDTO(String statusID) throws SQLException, NamingException {
        StatusDTO dto = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select statusName "
                        + "from Status "
                        + "where statusID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, statusID);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    String statusName = rs.getString("statusName");
                    dto = new StatusDTO(statusID, statusName);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public StatusDTO getStatusVerify() throws SQLException, NamingException {
        StatusDTO dto = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select statusID,statusName "
                        + "from Status "
                        + "where statusName = 'Verifying'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String statusID = rs.getString("statusID");
                    String statusName = rs.getString("statusName");
                    dto = new StatusDTO(statusID, statusName);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
}
