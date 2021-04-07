/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhinh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhinh.account.AccountDAO;
import nhinh.account.AccountDTO;
import nhinh.account.AccountError;
import nhinh.role.RoleDAO;
import nhinh.role.RoleDTO;
import nhinh.status.StatusDAO;
import nhinh.status.StatusDTO;
import nhinh.utils.SHA256;
import nhinh.utils.Utils;
import nhinh.utils.VerifyGmail;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

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
        String url = "signup";
        //        BasicConfigurator.configure();
        try {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            AccountError errors = new AccountError();
            AccountDAO dao = new AccountDAO();
            if (!email.trim().isEmpty() && !password.trim().isEmpty() && !confirmPassword.trim().isEmpty()
                    && !fullname.trim().isEmpty()) {
                boolean err = false;
                if (dao.checkEmailDup(email)) {
                    errors.setEmailIsExist(email + "is existed!!!");
                    err = true;
                }
                if (!confirmPassword.equals(password)) {
                    errors.setComfirmNotMatch("Confirm must match password");
                    err = true;
                }
                if (err) {
                    request.setAttribute("ERROR", errors);
                } else if (!err) {
                    Date date = new Date();
                    Utils u = new Utils();
                    String createDate = u.formatDateToString(date);
                    SHA256 sha = new SHA256();
                    String pass = sha.bytesToHex(password);
                    RoleDAO rdao = new RoleDAO();
                    RoleDTO rdto = rdao.getRoleCustomer();
                    StatusDAO sdao = new StatusDAO();
                    StatusDTO sdto = sdao.getStatusVerify();
                    AccountDTO dto = new AccountDTO(email, pass, fullname, rdto, sdto, phone, createDate);
                    VerifyGmail vg = new VerifyGmail();
                    String code = vg.sendEmail(email);

                    boolean success = dao.createNewAccount(dto);
                    if (success) {
                        HttpSession codeSession = request.getSession(true);
                        codeSession.setMaxInactiveInterval(5*60);
                        codeSession.setAttribute("CODE_VERIFY", code);
                        codeSession.setAttribute("EMAIL", email);
                        url = "verify";
                    }

                }
            }
        } catch (SQLException ex) {
            //        log.error("RegisterServlet_SQL:" + ex.getMessage());
            ex.printStackTrace();
        } catch (NamingException ex) {
            //       log.error("RegisterServlet_Naming:" + ex.getMessage());
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
