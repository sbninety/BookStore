/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author vannh
 */
public class Cart {
    public Sach sach;
    public int SoLuong;

    public Cart(Sach sach, int SoLuong) {
        this.sach = sach;
        this.SoLuong = SoLuong;
    }

    public Cart() {
    }

    public Sach getSach() {
        return sach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
}
