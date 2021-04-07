/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.role;

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
public class RoleDAO implements Serializable {

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


    public RoleDTO getRoleDTO(String roleID) throws SQLException, NamingException {
        RoleDTO dto = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select roleName "
                        + "from Role "
                        + "where roleID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, roleID);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String roleName = rs.getString("roleName");
                    dto = new RoleDTO(roleID, roleName);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public RoleDTO getRoleCustomer() throws SQLException, NamingException {
        RoleDTO dto = null;
        try {

            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select roleID,roleName "
                        + "from Role "
                        + "where roleName = 'Customer'";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String roleID = rs.getString("roleID");
                    String roleName = rs.getString("roleName");
                    dto = new RoleDTO(roleID, roleName);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
}
