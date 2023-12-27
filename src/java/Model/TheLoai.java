/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author vannh
 */
public class TheLoai {
    public int MaTheLoai;
    public String TenTheLoai;

    public int getMaTheLoai() {
        return MaTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setMaTheLoai(int MaTheLoai) {
        this.MaTheLoai = MaTheLoai;
    }

    public void setTenTheLoai(String TenTheLoai) {
        this.TenTheLoai = TenTheLoai;
    }

    public TheLoai(int MaTheLoai, String TenTheLoai) {
        this.MaTheLoai = MaTheLoai;
        this.TenTheLoai = TenTheLoai;
    }

    public TheLoai() {
    }
    
}
