/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daoBarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import views.Form;

/**
 *
 * @author Lenovo
 */
public class controllerBarang {
    Form frame;
    List<Barang> listBrg;
    daoBarang daoBrg = new daoBarang();
    Barang brg = new Barang();
    private List<Barang> lisBrg;

    public controllerBarang(Form frame) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         this.frame = frame;
         listBrg = daoBrg.getData();
    }
    
    
    
    public void tampil_tabel() {
        TabelModelBarang tabelBrg = new TabelModelBarang(lisBrg);
    }
    
    public void tambahData() {
        if (frame.getTxtKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode barang belum di isi");
        } else {
            brg.setKode(frame.getTxtKode().getText());
            brg.setNama(frame.getTxtNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerek(frame.getTxtMerek().getText());
            daoBrg.tambah(brg);
            JOptionPane.showMessageDialog(frame, "berhasil menambahkan data baru");
        }
    }
    
    public void ubahData() {
         if (frame.getTxtKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode barang belum di isi");
    }else {
            brg.setKode(frame.getTxtKode().getText());
            brg.setNama(frame.getTxtNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerek(frame.getTxtMerek().getText());
            daoBrg.ubah(brg);
            JOptionPane.showMessageDialog(frame, "berhasil mengubah");
        }
    }
    
    public void hapusData() {
        brg.setKode(frame.getTxtKode().getText());
        daoBrg.hapus(brg);
         JOptionPane.showMessageDialog(frame, "berhasil menghapus");
    }
    
    public void bersih() {
        frame.setTxtKode("");
        frame.setTxtNama("");
        frame.setTxtJumlah(0);
        frame.setTxtHarga(0);
        frame.setTxtMerek("");
    }
    
    public void keluar() {
        frame.dispose();
    }
}
