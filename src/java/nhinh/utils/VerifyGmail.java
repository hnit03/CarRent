/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author PC
 */
public class VerifyGmail implements Serializable {

    public String getRandom() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    //send email to the user email
    public String sendEmail(String username) throws AddressException, MessagingException {
        String code = getRandom();
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        final String login = "duongduong3320@gmail.com";
        final String pwd = "0385306264";
        Authenticator pa = null;

        if (login != null && pwd != null) { 
            props.put("mail.smtp.auth", "true");
            pa = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(login, pwd);
                }
            };
        }//else: no authentication
        Session session = Session.getInstance(props, pa);
        // — Create a new message –
        Message msg = new MimeMessage(session);
        // — Set the FROM and TO fields –
        msg.setFrom(new InternetAddress(login));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username, false));

        // — Set the subject and body text –
        msg.setSubject("Verify user");
        msg.setText("Code verify: " + code);
        // — Set some other header information –
        msg.setHeader("X - Mailer", "LOTONtechEmail");
        msg.setSentDate(new Date());
        msg.saveChanges();
        // — Send the message –
        Transport.send(msg);
        return code;
    }
}
