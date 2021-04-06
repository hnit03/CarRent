/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.account;

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
public class AccountDAO implements Serializable {

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

    public boolean checkLogin(String email, String password) throws SQLException, NamingException {

        boolean isCheck = false;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select email,password "
                        + "from Registration  "
                        + "where email = ? and password = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String id = rs.getString("email");
                    String pass = rs.getString("password");
                    if (email.equals(id) && password.equals(pass)) {
                        isCheck = true;
                    }
                }
            }
        } finally {
            closeConnection();
        }
        return isCheck;
    }
    
    public AccountDTO getAccountDTO(String email) throws SQLException, NamingException {

        AccountDTO dTO = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select password,phone,fullname,roleID,statusID,createDate "
                        + "from Registration "
                        + "where email = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String pass = rs.getString("password");
                    String phone = rs.getString("phone");
                    String roleID = rs.getString("roleID");
                    String statusID = rs.getString("statusID");
                    String createDate = rs.getString("createDate");
                    String fullname = rs.getString("fullname");
                    dTO = new AccountDTO(email, pass, fullname, roleID, statusID, phone, createDate);
                }
            }
        } finally {
            closeConnection();
        }
        return dTO;
    }
    public boolean createNewAccount(AccountDTO dto) throws SQLException, NamingException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "insert into Registration(email,password,roleID,fullname,statusID,phone,createDate) "
                        + "values(?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getEmail());
                ps.setString(2, dto.getPassword());
                ps.setString(3, dto.getRoleID());
                ps.setString(4, dto.getFullname());
                ps.setString(5, dto.getStatusID());
                ps.setString(6, dto.getPhone());
                ps.setString(7, dto.getCreateDate());
                int success = ps.executeUpdate();
                if (success == 1) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }

    public boolean checkEmailDup(String email) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select email "
                        + "from Registration "
                        + "where email = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, email);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
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
        return false;
    }
    
    public boolean updateStatusActive(String username) throws SQLException, NamingException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "update Registration "
                        + "set statusID = (select statusID from Status where statusName = 'Active') "
                        + "where email = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, username);
                int success = ps.executeUpdate();
                if (success == 1) {
                    return true;
                }
            }
        } finally {
            closeConnection();
        }
        return false;
    }
    
}
