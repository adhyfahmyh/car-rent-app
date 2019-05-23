/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentkuyyoi;

import java.util.ArrayList;

/**
 *
 * @author Firhan
 */
public class Customer extends Orang {
    private int idCustomer;
    private ArrayList<Transaksi> Transaksi = new  ArrayList<>();
    
    public Customer (int idCustomer,Transaksi Transaksi, String Nama, String Alamat, String noKontak){
        super(Nama, Alamat,noKontak);
        this.idCustomer=idCustomer;
    }
    
    public void SetIdCustomer (int idCustomer){
        this.idCustomer=idCustomer;
    }
    
    public int GetIdCustomer (){
        return idCustomer;
    }
    
    public void setTransaksi(Transaksi Transaksi){
        this.Transaksi.add(Transaksi);
    }
    
    public ArrayList<Transaksi> getTransaksi(){
        return Transaksi;
    }
    
    public void tambahTransaksi(int idTransaksi,Mobil mobil, int tanggalPeminjaman, int tanggalPengembalian,String Fasilitas) {
        //Transaksi t = new Transaksi(mobil,tanggalPeminjaman,tanggalPengembalian,Fasilitas);
        Transaksi t = new Transaksi(idTransaksi,mobil, tanggalPeminjaman, tanggalPengembalian, Fasilitas);
    }
    
    public void pengembalian(Transaksi t, int tanggal){
        for (Transaksi tr : Transaksi){
            if (tr == t ){
                tr.setSelisih(tanggal-tr.getTanggalPengembalian());
                break;
            }    
        }
    }
    
}
