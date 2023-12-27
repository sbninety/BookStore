/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.SachDAO;
import Model.Cart;
import Model.Sach;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "CartServlet", urlPatterns = {"/Cart"})
public class CartServlet extends HttpServlet {
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
        String action = request.getParameter("action");
        try {
            if (action == null) {
                listCart(request, response);            
            }
            else{
                switch (action) {
                case "Add":
                    Add(request, response);
                    break;
                case "Increase":
                    Increase(request, response);
                    break;
                case "Reduce":
                    Reduce(request, response);
                    break;
                case "Delete":
                    Delete(request, response);
                    break;
                }
            }
        }
        catch (SQLException ex) {
            throw new ServletException(ex);
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

    private void listCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("acc") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        HttpSession session = request.getSession();
        if(session.getAttribute("acc") == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login");
            dispatcher.forward(request, response);
        }
        else{
            int soluong = 1;
            int id = Integer.parseInt(request.getParameter("id"));
            Sach sach = sachDAO.getSachByID(String.valueOf(id));
            if(session.getAttribute("Cart")==null){
                List<Cart> listCart = new ArrayList<Cart>();
                Cart cart = new Cart();
                cart.setSoLuong(soluong);
                cart.setSach(sach);
                listCart.add(cart);
                session.setAttribute("Cart", listCart);
            }else{
                List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
                boolean check = false;
                for(Cart cart:listCart){
                    if(cart.getSach().getMaSach() == sach.getMaSach()){
                        cart.setSoLuong(cart.getSoLuong()+soluong);
                        check = true;
                    }
                }
                if(check==false){
                    Cart cart = new Cart();
                    cart.setSoLuong(soluong);
                    cart.setSach(sach);
                    listCart.add(cart);
                }
                session.setAttribute("Cart", listCart);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("");
            dispatcher.forward(request, response);
        }
    }

    private void Increase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("Cart")!=null){
            List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
            int id = Integer.parseInt(request.getParameter("id"));
            for(Cart cart:listCart){
                if(id == cart.getSach().getMaSach()){
                    cart.setSoLuong(cart.getSoLuong() + 1);
                }
            }
            session.setAttribute("Cart", listCart);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
        dispatcher.forward(request, response);
    }

    private void Reduce(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if(session.getAttribute("Cart")!=null){
            List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
            int id = Integer.parseInt(request.getParameter("id"));
            for(Cart cart:listCart){
                if(id == cart.getSach().getMaSach()){
                    cart.setSoLuong(cart.getSoLuong() - 1);
                    if(cart.getSoLuong()==0){
                        listCart.remove(cart);
                        session.setAttribute("Cart", listCart);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
                        dispatcher.forward(request, response);
                    }
                }
            }
            session.setAttribute("Cart", listCart);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
        dispatcher.forward(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("Cart")!=null){
            List<Cart> listCart = (List<Cart>)session.getAttribute("Cart");
            int id = Integer.parseInt(request.getParameter("id"));
            for(Cart cart:listCart){
                if(id == cart.getSach().getMaSach()){
                    listCart.remove(cart);
                    session.setAttribute("Cart", listCart);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
                    dispatcher.forward(request, response);
                }
            }
            session.setAttribute("Cart", listCart);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Cart.jsp");
        dispatcher.forward(request, response);
    }
}
