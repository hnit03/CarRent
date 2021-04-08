/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.category;

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
public class CategoryDAO implements Serializable {

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
    
    private List<CategoryDTO> categoryList;

    public List<CategoryDTO> getCategoryList() {
        return categoryList;
    }
    
    public void getAllCateogory() throws SQLException, NamingException {
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select categoryID, category "
                        + "from Category";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {                    
                    String cateID = rs.getString("categoryID");
                    String cateName = rs.getString("category");
                    CategoryDTO cdto = new CategoryDTO(cateID, cateName);
                    if (this.categoryList == null) {
                        this.categoryList = new ArrayList<>();
                    }
                    this.categoryList.add(cdto);
                }
            }
        } finally {
            closeConnection();
        }
    }
    
    public CategoryDTO getCateogory(String categoryID) throws SQLException, NamingException {
        CategoryDTO cdto = null;
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select category "
                        + "from Category "
                        + "where categoryID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, categoryID);
                rs = ps.executeQuery();
                if (rs.next()) {                    
                    String cateName = rs.getString("category");
                    cdto = new CategoryDTO(categoryID, cateName);
                }
            }
        } finally {
            closeConnection();
        }
        return cdto;
    }
}
