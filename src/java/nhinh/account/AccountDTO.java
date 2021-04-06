/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.account;

import java.io.Serializable;

/**
 *
 * @author PC
 */
public class AccountDTO implements Serializable {

    private String email;
    private String password;
    private String fullname;
    private String roleID;
    private String statusID;
    private String phone;
    private String createDate;

    public AccountDTO() {
    }

    public AccountDTO(String email, String password, String fullname, String roleID, String statusID, String phone, String createDate) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.roleID = roleID;
        this.statusID = statusID;
        this.phone = phone;
        this.createDate = createDate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the roleID
     */
    public String getRoleID() {
        return roleID;
    }

    /**
     * @param roleID the roleID to set
     */
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    /**
     * @return the statusID
     */
    public String getStatusID() {
        return statusID;
    }

    /**
     * @param statusID the statusID to set
     */
    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }
}
