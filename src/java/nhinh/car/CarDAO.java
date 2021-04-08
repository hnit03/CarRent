/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.car;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import nhinh.Rating.RatingDAO;
import nhinh.category.CategoryDAO;
import nhinh.category.CategoryDTO;
import nhinh.color.ColorDAO;
import nhinh.color.ColorDTO;
import nhinh.utils.DBHelper;

/**
 *
 * @author PC
 */
public class CarDAO implements Serializable {

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

    private List<CarDTO> carList;

    public List<CarDTO> getCarList() {
        return carList;
    }

    public void getAllCar() throws SQLException, NamingException {
        ColorDAO cdao = new ColorDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        RatingDAO rdao = new RatingDAO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select carID, carName,image,color,year,categoryID,price,quantity,statusID "
                        + "from Car";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String image = rs.getString("image");
                    String color = rs.getString("color");
                    ColorDTO colorDTO = cdao.getColor(color);
                    int year = rs.getInt("year");
                    String categoryID = rs.getString("categoryID");
                    CategoryDTO cateDTO = cateDAO.getCateogory(categoryID);
                    String price = rs.getString("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    float point = rdao.getRatingOfCar(carID);
                    CarDTO cdto = new CarDTO(carID, carName, image, colorDTO, year, cateDTO, price, quantity, statusID, point);
                    if (this.carList == null) {
                        this.carList = new ArrayList<>();
                    }
                    this.carList.add(cdto);
                }
            }
        } finally {
            closeConnection();
        }
    }

    public CarDTO getACar() throws SQLException, NamingException {
        CarDTO dto = null;
        ColorDAO cdao = new ColorDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        RatingDAO rdao = new RatingDAO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select carID, carName,image,color,year,categoryID,price,quantity,statusID "
                        + "from Car";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String image = rs.getString("image");
                    String color = rs.getString("color");
                    ColorDTO colorDTO = cdao.getColor(color);
                    int year = rs.getInt("year");
                    String categoryID = rs.getString("categoryID");
                    CategoryDTO cateDTO = cateDAO.getCateogory(categoryID);
                    String price = rs.getString("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    float point = rdao.getRatingOfCar(carID);
                    dto = new CarDTO(carID, carName, image, colorDTO, year, cateDTO, price, quantity, statusID, point);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public void searchCar(String name, String category) throws SQLException, NamingException {
        ColorDAO cdao = new ColorDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        RatingDAO rdao = new RatingDAO();
        try {
            con = DBHelper.makeConnection();
            if (con != null) {
                String sql = "select carID, carName,image,color,year,categoryID,price,quantity,statusID "
                        + "from Car "
                        + "where carName like ? and categoryID like ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                ps.setString(2, "%" + category + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String carID = rs.getString("carID");
                    String carName = rs.getString("carName");
                    String image = rs.getString("image");
                    String color = rs.getString("color");
                    ColorDTO colorDTO = cdao.getColor(color);
                    int year = rs.getInt("year");
                    String categoryID = rs.getString("categoryID");
                    CategoryDTO cateDTO = cateDAO.getCateogory(categoryID);
                    String price = rs.getString("price");
                    int quantity = rs.getInt("quantity");
                    String statusID = rs.getString("statusID");
                    float point = rdao.getRatingOfCar(carID);
                    CarDTO cdto = new CarDTO(carID, carName, image, colorDTO, year, cateDTO, price, quantity, statusID, point);
                    if (this.carList == null) {
                        this.carList = new ArrayList<>();
                    }
                    this.carList.add(cdto);
                }
            }
        } finally {
            closeConnection();
        }
    }
}
