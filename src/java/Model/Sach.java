/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannh
 */
public class Sach {
    public int MaSach;
    public String TenSach;
    public String TacGia;
    public double GiaBan;
    public String MoTa;
    public String HinhAnh;
    public String NamXuatBan;

    public int getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public String getNamXuatBan() {
        return NamXuatBan;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setNamXuatBan(String NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

    public Sach(int MaSach, String TenSach, String TacGia, double GiaBan, String MoTa, String HinhAnh, String NamXuatBan) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.HinhAnh = HinhAnh;
        this.NamXuatBan = NamXuatBan;
    }

    public Sach() {
    }
    
}
