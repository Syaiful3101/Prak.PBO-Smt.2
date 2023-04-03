/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.koneksi;
import model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class daoBarang {
    Connection connection;
    final String insert = "INSERT INTO barang (kode, nama, jumlah, harga, merek) VALUES (?,?,?,?,?);";
    final String update = "UPDATE barang SET nama=?,jumlah=?, harga=?, merek=? WHERE kode=?;";
    final String delete = "DELETE FROM barang WHERE kode=?;";
    final String select = "SELECT * FROM barang ORDER BY kode ABC;";
    final String selectData = "SELECT * FROM barang WHERE KODE=?;";
    private String Kode;
    
    public daoBarang() {
    connection = koneksi.connection();
}
     public void tambah(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, brg.getKode());
            statement.setString(2, brg.getNama());
            statement.setInt(3, brg.getJumlah());
            statement.setInt(4, brg.getHarga());
            statement.setString(5, brg.getMerek());
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
            
    }
     public void ubah(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, brg.getKode());
            statement.setString(2, brg.getNama());
            statement.setInt(3, brg.getJumlah());
            statement.setInt(4, brg.getHarga());
            statement.setString(5, brg.getMerek());
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
     public void hapus(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            
        }

    }
     public void tampil(Barang brg) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
     public List<Barang> getData() {
        List<Barang> listBrg = null;
        try {
            listBrg = new ArrayList<>();
            Statement st = connection.createStatement();
            Resultset rs = (Resultset) st.executeQuery(select);
            while (rs.next()) {
                Barang brg = new Barang();
                brg.setKode(rs.getString("kode"));
                brg.setNama(rs.getString("nama"));
                brg.setJumlah(rs.getInt("jumlah"));
                brg.setHarga(rs.getInt("harga"));
                brg.setMerek(rs.getString("merek"));
                listBrg.add(brg);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listBrg;
    } 

}
