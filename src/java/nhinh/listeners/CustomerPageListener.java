/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.listeners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author PC
 */
public class CustomerPageListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String filename = "customerPage.txt";
        Map<String, String> indexPage = new HashMap<>();
        String path = sce.getServletContext().getRealPath("/");
        File f = new File(path + "WEB-INF\\" + filename);
        FileReader fr;
        try {
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            StringTokenizer stk = null;
            while ((line = br.readLine()) != null) {
                stk = new StringTokenizer(line, "=");
                String key = stk.nextToken();
                String value = stk.nextToken();
                indexPage.put(key.trim(), value.trim());
            }
            sce.getServletContext().setAttribute("CUSTOMER", indexPage);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerPageListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerPageListener.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
