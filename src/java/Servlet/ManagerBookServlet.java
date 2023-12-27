/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.SachDAO;
import Model.Sach;
import Model.TheLoai;
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

/**
 *
 * @author vannh
 */
@WebServlet(name = "ManagerBookServlet", urlPatterns = {"/ManagerBook"})
public class ManagerBookServlet extends HttpServlet {
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
                listAllBook(request, response);            
            }
            else{
                switch (action) {
                case "Addform":
                    Addform(request, response);
                    break;
                case "Delete":
                    Delete(request, response);
                    break;
                case "Add":
                    Add(request, response);
                    break;
                case "Edit" :
                    Edit(request, response);
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
    private void listAllBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Sach> listSach = sachDAO.listSach();
        request.setAttribute("listSach", listSach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerBook.jsp");
        dispatcher.forward(request, response);
    }

    private void Addform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Form.jsp");
        dispatcher.forward(request, response);
    }

    private void Delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        sachDAO.deleteCBook(Integer.parseInt(id));
        sachDAO.deleteBook(Integer.parseInt(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerBook.jsp");
        dispatcher.forward(request, response);
    }

    private void Add(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String[] theLoai = request.getParameterValues("theloai");
        String tenSach = request.getParameter("tenSach");
        Double giaBan = Double.valueOf(request.getParameter("giaBan"));
        String tacGia = request.getParameter("tacGia");
        String moTa = request.getParameter("moTa");
        String hinhAnh = request.getParameter("hinhAnh");
        String namXuatBan = request.getParameter("namXuatBan");
        sachDAO.insertBook(tenSach, tacGia, giaBan, moTa, hinhAnh, namXuatBan);
        int maSach = sachDAO.getMaSach();
        for(String tl:theLoai){
            sachDAO.insertCBoook(maSach,tl);
        }
        List<Sach> listSach = sachDAO.listSach();
        request.setAttribute("listSach", listSach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerBook.jsp");
        dispatcher.forward(request, response);
    }
    
     private void Edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String[] theLoai = request.getParameterValues("theloai");
        int id = Integer.parseInt(request.getParameter("ID"));
        String tenSach = request.getParameter("tenSach");
        Double giaBan = Double.valueOf(request.getParameter("giaBan"));
        String tacGia = request.getParameter("tacGia");
        String moTa = request.getParameter("moTa");
        String hinhAnh = request.getParameter("hinhAnh");
        String namXuatBan = request.getParameter("namXuatBan");
        sachDAO.deleteCBook(id);
        sachDAO.editBook(id, tenSach, tacGia, giaBan, moTa, hinhAnh, namXuatBan);
        for(String tl:theLoai){
            sachDAO.insertCBoook(id,tl);
        }
        List<Sach> listSach = sachDAO.listSach();
        request.setAttribute("listSach", listSach);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ManagerBook.jsp");
        dispatcher.forward(request, response);
     }
}
