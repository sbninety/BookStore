/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannh
 */
public class OrderDetails {
    public String TenSach;
    public String HinhAnh;
    public int SoLuong;
    public double GiaBan;

    public OrderDetails() {
    }

    public OrderDetails(String TenSach, String HinhAnh, int SoLuong, double GiaBan) {
        this.TenSach = TenSach;
        this.HinhAnh = HinhAnh;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }
    
}
