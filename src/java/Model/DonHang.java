/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannh
 */
public class DonHang {
    private int MaDonHang;
    private String SoDienThoai;
    private String DiaChiGiaoHang;
    private String TenKhachHang;
    private String TongTien;
    private int TrangThai;



    public DonHang(int MaDonHang, String SoDienThoai, String DiaChiGiaoHang, String TenKhachHang, String TongTien, int TrangThai) {
        this.MaDonHang = MaDonHang;
        this.SoDienThoai = SoDienThoai;
        this.DiaChiGiaoHang = DiaChiGiaoHang;
        this.TenKhachHang = TenKhachHang;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
    }

    public DonHang() {
    }

    public DonHang(int MaDonHang, String SoDienThoai, String DiaChiGiaoHang, String TenKhachHang, String TongTien) {
        this.MaDonHang = MaDonHang;
        this.SoDienThoai = SoDienThoai;
        this.DiaChiGiaoHang = DiaChiGiaoHang;
        this.TenKhachHang = TenKhachHang;
        this.TongTien = TongTien;
    }

    public int getMaDonHang() {
        return MaDonHang;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public String getDiaChiGiaoHang() {
        return DiaChiGiaoHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public String getTongTien() {
        return TongTien;
    }

     public int getTrangThai() {
        return TrangThai;
    }
    public void setMaDonHang(int MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public void setDiaChiGiaoHang(String DiaChiGiaoHang) {
        this.DiaChiGiaoHang = DiaChiGiaoHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public void setTongTien(String TongTien) {
        this.TongTien = TongTien;
    }
public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
   
    
}
