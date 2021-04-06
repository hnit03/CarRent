/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.color;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nhinh.utils.DBHelper;

/**
 *
 * @author PC
 */
public class ColorDAO implements Serializable{
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
    
    private List<ColorDTO> colorList;

    public List<ColorDTO> getColorList() {
        return colorList;
    }
    
    public void getAllColor() throws SQLException, NamingException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select colorID, color "
                        + "from Color";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {                    
                    String colorID = rs.getString("colorID");
                    String color = rs.getString("color");
                    ColorDTO cdto = new ColorDTO(colorID, color);
                    if (this.colorList == null) {
                        this.colorList = new ArrayList<>();
                    }
                    this.colorList.add(cdto);
                }
            }
        } finally {
            closeConnection();
        }
    }
    public ColorDTO getColor(String colorID) throws SQLException, NamingException {
        ColorDTO cdto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select color "
                        + "from Color "
                        + "where colorID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, colorID);
                rs = ps.executeQuery();
                if (rs.next()) {                    
                    String color = rs.getString("color");
                    cdto = new ColorDTO(colorID, color);
                }
            }
        } finally {
            closeConnection();
        }
        return cdto;
    }
}
