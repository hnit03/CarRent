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
public class AccountError implements Serializable {

    private String comfirmNotMatch;
    private String emailIsExist;

    public AccountError() {
    }

    public AccountError(String comfirmNotMatch, String emailIsExist) {
        this.comfirmNotMatch = comfirmNotMatch;
        this.emailIsExist = emailIsExist;
    }

    /**
     * @return the comfirmNotMatch
     */
    public String getComfirmNotMatch() {
        return comfirmNotMatch;
    }

    /**
     * @param comfirmNotMatch the comfirmNotMatch to set
     */
    public void setComfirmNotMatch(String comfirmNotMatch) {
        this.comfirmNotMatch = comfirmNotMatch;
    }

    /**
     * @return the emailIsExist
     */
    public String getEmailIsExist() {
        return emailIsExist;
    }

    /**
     * @param emailIsExist the emailIsExist to set
     */
    public void setEmailIsExist(String emailIsExist) {
        this.emailIsExist = emailIsExist;
    }

}
