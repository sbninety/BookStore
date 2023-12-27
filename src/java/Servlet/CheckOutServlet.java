/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.SachDAO;
import Model.Account;
import Model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vannh
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {
    SachDAO sachDAO;
 
    @Override
    public void init() {
        String jdbcServer = "ADMIN\\SERVER_GOC";
        String jdbcUser = "sa";
        String jdbcPassword = "123";
        String jdbcDatabase = "QLSach";
        int jdbcPort = 1433;
 
        sachDAO = new SachDAO(jdbcServer, jdbcUser, jdbcPassword, jdbcDatabase, jdbcPort);
 
    }
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
        try {
            CheckOut(request, response);
        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void CheckOut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        HttpSession session = request.getSession();
        if(session.getAttribute("acc") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
            dispatcher.forward(request, response);
        }
        else{
            Account acc = (Account) session.getAttribute("acc");
            int i = acc.getMaNguoiDung();
            String Ten = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            double TongTien = Float.parseFloat(request.getParameter("TongTien"));
            sachDAO.insertOrder(i, phone, address, Ten, 0);
            int MaDonHang = sachDAO.getMaDonHang();
            List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
            for(Cart c:listCart){
                sachDAO.insertOrderDetails(MaDonHang, c);
            }
            sachDAO.updateOrder(TongTien);
            session.removeAttribute("Cart");
            RequestDispatcher dispatcher = request.getRequestDispatcher("");
            dispatcher.forward(request, response);   
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
