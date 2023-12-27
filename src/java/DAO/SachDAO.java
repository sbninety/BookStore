/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import Model.Cart;
import Model.DonHang;
import Model.OrderDetails;
import Model.Sach;
import Model.TheLoai;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vannh
 */
public class SachDAO {
    private String jdbcServer;
    private String jdbcUser;
    private String jdbcPassword;
    private String jdbcDatabase;
    private int jdbcPort;
    private SQLServerDataSource ds = new SQLServerDataSource();
    private Connection conn;
    public SachDAO(String jdbcServer, String jdbcUser, String jdbcPassword, String jdbcDatabase, int jdbcPort) {
        this.jdbcServer = jdbcServer;
        this.jdbcUser = jdbcUser;
        this.jdbcPassword = jdbcPassword;
        this.jdbcDatabase = jdbcDatabase;
        this.jdbcPort = jdbcPort;
    }
    private void OpenDatabase() throws SQLServerException{
        ds.setServerName(jdbcServer);
        ds.setUser(jdbcUser);
        ds.setPassword(jdbcPassword);
        ds.setDatabaseName(jdbcDatabase);
        ds.setPortNumber(jdbcPort);
        conn = ds.getConnection();
    }
    
    public List<Sach> listSach() throws SQLServerException, SQLException{
        List<Sach> listSach = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from Sach order by MaSach DESC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            Sach s = new Sach();
            s.setMaSach(Integer.parseInt(rs.getString("MaSach")));
            s.setTacGia(rs.getString("TacGia"));
            s.setTenSach(rs.getString("TenSach"));
            s.setGiaBan(Double.parseDouble(rs.getString("GiaBan")));
            s.setMoTa(rs.getString("MoTa"));
            s.setHinhAnh(rs.getString("HinhAnh"));
            s.setNamXuatBan(rs.getString("NamXuatBan"));
            listSach.add(s);
        }            
        stmt.close();
        return listSach;
    }
    public List<TheLoai> listTheLoai() throws SQLException{
        List<TheLoai> listTheLoai = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from TheLoai";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            TheLoai tl = new TheLoai();
            tl.setMaTheLoai(Integer.parseInt(rs.getString("MaTheLoai")));
            tl.setTenTheLoai(rs.getString("TenTheLoai"));
            listTheLoai.add(tl);
        }            
        stmt.close();
        return listTheLoai;
    }
    public List<Sach> getSachByTheLoai(String id) throws SQLServerException, SQLException{
        List<Sach> listSach = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from Sach inner join Thuoc on Sach.MaSach = Thuoc.MaSach where Thuoc.MaTheLoai = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Sach s = new Sach();
            s.setMaSach(Integer.parseInt(rs.getString("MaSach")));
            s.setTacGia(rs.getString("TacGia"));
            s.setTenSach(rs.getString("TenSach"));
            s.setGiaBan(Double.parseDouble(rs.getString("GiaBan")));
            s.setMoTa(rs.getString("MoTa"));
            s.setHinhAnh(rs.getString("HinhAnh"));
            s.setNamXuatBan(rs.getString("NamXuatBan"));
            listSach.add(s);
        }            
        stmt.close();
        return listSach;
    }
    public Sach getSachByID(String id) throws SQLServerException, SQLException{
        Sach sach = new Sach();
        OpenDatabase();
        String sql = "select * from Sach where MaSach = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
            sach.setMaSach(Integer.parseInt(rs.getString("MaSach")));
            sach.setTacGia(rs.getString("TacGia"));
            sach.setTenSach(rs.getString("TenSach"));
            sach.setGiaBan(Double.parseDouble(rs.getString("GiaBan")));
            sach.setMoTa(rs.getString("MoTa"));
            sach.setHinhAnh(rs.getString("HinhAnh"));
            sach.setNamXuatBan(rs.getString("NamXuatBan"));
        }
        return sach;
    }
    public List<Sach> searchSach(String name) throws SQLServerException, SQLException{
        List<Sach> listSach = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from Sach where TenSach like ? ";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Sach s = new Sach();
            s.setMaSach(Integer.parseInt(rs.getString("MaSach")));
            s.setTacGia(rs.getString("TacGia"));
            s.setTenSach(rs.getString("TenSach"));
            s.setGiaBan(Double.parseDouble(rs.getString("GiaBan")));
            s.setMoTa(rs.getString("MoTa"));
            s.setHinhAnh(rs.getString("HinhAnh"));
            s.setNamXuatBan(rs.getString("NamXuatBan"));
            listSach.add(s);
        }            
        stmt.close();
        return listSach;
    }
    public Account Login(String TaiKhoan, String MatKhau) throws SQLServerException, SQLException{
        Account acc = new Account();
        OpenDatabase();
        String sql = "select * from NguoiDung where TaiKhoan = ? and MatKhau = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, TaiKhoan);
        stmt.setString(2, MatKhau);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           acc.setMaNguoiDung(Integer.parseInt(rs.getString("MaNguoiDung")));
           acc.setTaiKhoan(rs.getString("TaiKhoan"));
           acc.setMatKhau(rs.getString("MatKhau"));
           acc.setNhanVien(Integer.parseInt(rs.getString("NhanVien")));
           acc.setKhachHang(Integer.parseInt(rs.getString("KhachHang")));
           return acc;
        }
        return null;
    }
    public Account checkAccount(String TaiKhoan) throws SQLException{
        Account acc = new Account();
        OpenDatabase();
        String sql = "select * from NguoiDung where TaiKhoan = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, TaiKhoan);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()){
           acc.setMaNguoiDung(Integer.parseInt(rs.getString("MaNguoiDung")));
           acc.setTaiKhoan(rs.getString("TaiKhoan"));
           acc.setMatKhau(rs.getString("MatKhau"));
           acc.setNhanVien(Integer.parseInt(rs.getString("NhanVien")));
           acc.setKhachHang(Integer.parseInt(rs.getString("KhachHang")));
           return acc;
        }
        return null;
    }
    public void signup(String TaiKhoan, String MatKhau) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "insert into NguoiDung(TaiKhoan,MatKhau,NhanVien,KhachHang) values (?,?,0,1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, TaiKhoan);
        stmt.setString(2, MatKhau);
        stmt.executeUpdate();
    }
    
    public void insertOrder(int MaNguoiDung, String SoDienThoai, String DiaChiGiaoHang, String TenKhachHang, int TrangThai) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "insert into DonHang(MaNguoiDung,SoDienThoai,DiaChiGiaoHang,TenKhachHang,TrangThai) values (?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaNguoiDung);
        stmt.setString(2, SoDienThoai);
        stmt.setString(3, DiaChiGiaoHang);
        stmt.setString(4, TenKhachHang);
        stmt.setInt(5, TrangThai);
        stmt.executeUpdate();
    }
    
    public int getMaDonHang() throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "select MaDonHang from DonHang where TongTien is null";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            return rs.getInt("MaDonHang");
        }            
        stmt.close();
        return 0;
    }
    
    public void insertOrderDetails(int MaDonHang, Cart cart) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "insert into ChiTietDonHang (MaDonHang,MaSach,SoLuong) values (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaDonHang);
        stmt.setInt(2, cart.getSach().getMaSach());
        stmt.setInt(3, cart.getSoLuong());
        stmt.executeUpdate();
    }
    
    public void updateOrder(double Tongtien) throws SQLException{
        OpenDatabase();
        String sql = "update DonHang set Tongtien = ? where TongTien is null";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, Tongtien);
        stmt.executeUpdate();
    }
    
    public List<DonHang> listOrder(String MaNguoiDung) throws SQLServerException, SQLException{
        List<DonHang> listOrder = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from DonHang where MaNguoiDung = ? order by MaDonHang DESC";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(MaNguoiDung));
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            DonHang dh = new DonHang();
            dh.setMaDonHang(Integer.parseInt(rs.getString("MaDonHang")));
            dh.setSoDienThoai(rs.getString("SoDienThoai"));
            dh.setDiaChiGiaoHang(rs.getString("DiaChiGiaoHang"));
            dh.setTenKhachHang(rs.getString("TenKhachHang"));
            dh.setTongTien(rs.getString("TongTien"));
            dh.setTrangThai(Integer.parseInt(rs.getString("TrangThai")));
            listOrder.add(dh);
        }
        stmt.close();
        return listOrder;
    }
    
    public List<OrderDetails> orderDetails(int MaDonHang) throws SQLServerException, SQLException{
        List<OrderDetails> listOrderDetails = new ArrayList<>();
        OpenDatabase();
        String sql = "  select * from ChiTietDonHang inner join Sach on ChiTietDonHang.MaSach = Sach.MaSach where ChiTietDonHang.MaDonHang = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaDonHang);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            OrderDetails odt = new OrderDetails();
            odt.setTenSach(rs.getString("TenSach"));
            odt.setSoLuong(Integer.parseInt(rs.getString("SoLuong")));
            odt.setHinhAnh(rs.getString("HinhAnh"));
            odt.setGiaBan(Double.parseDouble(rs.getString("GiaBan")));
            listOrderDetails.add(odt);
        }
        stmt.close();
        return listOrderDetails;
    }
    
    public boolean deleteOrderDetails(int MaDonHang) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "delete from ChiTietDonHang where MaDonHang = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaDonHang);
        int rowdelete = stmt.executeUpdate();
        stmt.close();
        return rowdelete > 1;
    }
    
    public boolean deleteOrder(int MaDonHang) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "delete from DonHang where MaDonHang = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaDonHang);
        int rowdelete = stmt.executeUpdate();
        stmt.close();
        return rowdelete > 1;
    }
    
    public List<DonHang> listAllOrder() throws SQLServerException, SQLException{
        List<DonHang> listDonHang = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from DonHang order by MaDonHang DESC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            DonHang dh = new DonHang();
            dh.setMaDonHang(Integer.parseInt(rs.getString("MaDonHang")));
            dh.setSoDienThoai(rs.getString("SoDienThoai"));
            dh.setDiaChiGiaoHang(rs.getString("DiaChiGiaoHang"));
            dh.setTenKhachHang(rs.getString("TenKhachHang"));
            dh.setTongTien(rs.getString("TongTien"));
            dh.setTrangThai(Integer.parseInt(rs.getString("TrangThai")));
            listDonHang.add(dh);
        }            
        stmt.close();
        return listDonHang;
    }
    
    public void updateStatus(int MaDonHang) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "update DonHang set TrangThai = 1 where MaDonHang = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, MaDonHang);
        stmt.executeUpdate();
    }
    
    public boolean deleteCBook(int MaSach) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "delete from Thuoc where MaSach = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaSach);
        int rowdelete = stmt.executeUpdate();
        stmt.close();
        return rowdelete > 1;
    }
    
    public boolean deleteBook(int MaSach) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "delete from Sach where MaSach = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaSach);
        int rowdelete = stmt.executeUpdate();
        stmt.close();
        return rowdelete > 1;
    }
    
    public void insertBook(String tenSach, String tacGia, double giaBan, String moTa, String hinhAnh, String namXuatBan) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "insert into Sach (TenSach,TacGia,GiaBan,MoTa,HinhAnh,NamXuatBan) values (?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tenSach);
        stmt.setString(2, tacGia);
        stmt.setDouble(3, giaBan);
        stmt.setString(4, moTa);
        stmt.setString(5, hinhAnh);
        stmt.setString(6,namXuatBan);
        stmt.executeUpdate();
    }
    
    public void editBook(int id, String tenSach, String tacGia, double giaBan, String moTa, String hinhAnh, String namXuatBan) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "update Sach \n" +
"set TenSach = ?, TacGia =?, GiaBan = ?, MoTa = ?, HinhAnh = ?, NamXuatBan = ? where MaSach = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, tenSach);
        stmt.setString(2, tacGia);
        stmt.setDouble(3, giaBan);
        stmt.setString(4, moTa);
        stmt.setString(5, hinhAnh);
        stmt.setString(6,namXuatBan);
        stmt.setInt(7,id);
        stmt.executeUpdate();
    }
    
    public int getMaSach() throws SQLServerException, SQLException{
        int maSach = 0;
        OpenDatabase();
        String sql = "select MAX(MaSach) as MaSach from Sach";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            maSach = rs.getInt("MaSach");
        }            
        stmt.close();
        return maSach;
    }
    
    public void insertCBoook(int MaSach, String MaTheLoai) throws SQLServerException, SQLException{
        OpenDatabase();
        String sql = "insert into Thuoc (MaSach,MaTheLoai) values (?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, MaSach);
        stmt.setInt(2, Integer.parseInt(MaTheLoai));
        stmt.executeUpdate();
    }
    
     public List<TheLoai> listTheLoaiByIDSach(String id) throws SQLException{
        List<TheLoai> listTheLoai = new ArrayList<>();
        OpenDatabase();
        String sql = "select * from TheLoai inner join Thuoc on TheLoai.MaTheLoai = Thuoc.MaTheLoai where Thuoc.MaSach = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            TheLoai tl = new TheLoai();
            tl.setMaTheLoai(Integer.parseInt(rs.getString("MaTheLoai")));
            tl.setTenTheLoai(rs.getString("TenTheLoai"));
            listTheLoai.add(tl);
        }            
        stmt.close();
        return listTheLoai;
    }

}
