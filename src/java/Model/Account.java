/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannh
 */
public class Account {
    public int MaNguoiDung;
    public String TaiKhoan;
    public String MatKhau;
    public int NhanVien;
    public int KhachHang;

    public Account(int MaNguoiDung, String TaiKhoan, String MatKhau, int NhanVien, int KhachHang) {
        this.MaNguoiDung = MaNguoiDung;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.NhanVien = NhanVien;
        this.KhachHang = KhachHang;
    }

    public Account() {
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public int getNhanVien() {
        return NhanVien;
    }

    public int getKhachHang() {
        return KhachHang;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setNhanVien(int NhanVien) {
        this.NhanVien = NhanVien;
    }

    public void setKhachHang(int KhachHang) {
        this.KhachHang = KhachHang;
    }
    
}
