/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toko;

import controller.koneksi;

/**
 *
 * @author Lenovo
 */
public class Toko {
    public static void main(String[] args) {
        koneksi konek = new koneksi();
        konek.connection();
    }
}
