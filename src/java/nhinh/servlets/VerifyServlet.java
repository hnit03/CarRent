/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhinh.account.AccountDAO;

/**
 *
 * @author PC
 */
@WebServlet(name = "VerifyServlet", urlPatterns = {"/VerifyServlet"})
public class VerifyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = "verify";

        try {
            /* TODO output your page here. You may use following sample code. */
            String code = request.getParameter("verify");
            HttpSession session = request.getSession(false);
            if (session != null) {
                long currentTime = System.currentTimeMillis() / 1000;
                System.out.println("1111 " + currentTime);
                long lastSessionAccessedTime = session.getLastAccessedTime() / 1000;
                System.out.println("2222 " + lastSessionAccessedTime);
                int inactiveInterval = (int) (currentTime - lastSessionAccessedTime);
                String codeVerify = (String) session.getAttribute("CODE_VERIFY");
                String email = (String) session.getAttribute("EMAIL");

                if (codeVerify.equals(code) && email != null) {
                    if (inactiveInterval > session.getMaxInactiveInterval()) {
                        request.setAttribute("EXPIRED", "Verify code is expired. Please send again.");
                        RequestDispatcher rd = request.getRequestDispatcher(url);
                        rd.forward(request, response);
                    } else {
                        url = "signin";
                        AccountDAO rdao = new AccountDAO();
                        rdao.updateStatusActive(email);
                        session.removeAttribute("EMAIL");
                        response.sendRedirect(url);
                    }

                }
            } else {
                request.setAttribute("EXPIRED", "Verify code is expired. Please send again.");
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
        } catch (SQLException ex) {
            log(ex.getMessage());
        } catch (NamingException ex) {
            log(ex.getMessage());
        } finally {

            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
