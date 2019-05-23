/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentkuyyoi;

import java.util.ArrayList;

/**
 *
 * @author RIZKY RAMADIKA
 */
public class Aplikasi {

    private ArrayList<Customer> daftarCustomer;
    private ArrayList<Transaksi> daftarTransaksi;
    private ArrayList<Driver> daftarDriver;
    private ArrayList<Mobil> daftarMobil;
//    private PilihSupir pilihSupir;
    private Driver d1;
    private Driver d2;
    private Driver d3;
    private Driver d4;
    private Driver d5;
    
    ConnectDatabase db;

    public Aplikasi() {
        db = new ConnectDatabase();
        db.connect();
        daftarCustomer = new ArrayList();
        daftarTransaksi = new ArrayList();
        daftarDriver = new ArrayList();
        daftarMobil = new ArrayList();
        d1 = new Driver(001, "Adifa", "Tunas kamar atas", "9115");
        d2 = new Driver(002, "Devin", "Tunas kamar bawah", "8116");
        d3 = new Driver(001, "Firhan", "Tunas kamar tengah", "7115");
        d4 = new Driver(001, "Eki", "Tunas kamar tengah", "6114");
//        daftarCustomer = db.loadCustomer();
//        daftarTransaksi = db.loadTransaksi();
//        daftarDriver = db.loadDriver();
//        daftarMobil = db.loadMobil();
    }

    public Transaksi addTransaksi(Mobil mobil, int tanggalPeminjaman, int tanggalPengembalian, String Fasilitas) {
        Transaksi t = new Transaksi(daftarTransaksi.size() + 1, mobil, tanggalPeminjaman, tanggalPengembalian, Fasilitas);
        daftarTransaksi.add(t);
        db.saveTransaksi(t);
        return t;
    }

    public Customer addCustomer(Transaksi Transaksi, String Nama, String Alamat, String noKontak) {
        Customer c = new Customer(daftarCustomer.size() + 1, Transaksi, Nama, Alamat, noKontak);
        daftarCustomer.add(c);
        db.saveCustomer(c);
        return c;
    }
    

    public Driver getDriver(int pilih) {
//        pilih = pilihSupir.getComboboxSupir().getSelectedIndex();
        if (pilih == 1){
            return d1;
        } else if (pilih == 2) {
            return d2;
        } else if (pilih == 3) {
            return d3;
        } else if (pilih == 4) {
            return d4;
        }
        return null;
    }

    public void addMobil(String type) {
        Mobil m = new Mobil(type);
        daftarMobil.add(m);
        db.saveMobil(m);
    }

    public Transaksi getTransaksi(int idTransaksi) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi() == idTransaksi) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
    
    
//    
//    public Customer getCustomer(String id){
//        for (Customer c : daftarCustomer){
//            if (c.GetIdCustomer()==){
//                return c;
//            }
//        }
//        return null;
//    }

    //public Driver getDriver(){
    //for (Driver d : daftarDriver){
    //if (d.GetIdDriver()==id){
    //return d;
    //}
    //}
    //return null;
    //}
    //public Mobil getMobil(){
    //for (Mobil m : daftarMobil){
    //if (d.GetId()==id){
    //return m;
    //}
    //}
    //return null;
    //}
    //public String viewTransaksi() {
    //String s = "";
    //for (Transaksi t : daftarTransaksi) {
    //s += t. + "\n";
    //}
    //return s;
    //}
    public String viewCustomer() {
        String s = "";
        for (Customer c : daftarCustomer) {
            s += c.GetIdCustomer() + "\n";
        }
        return s;
    }

    public String viewDriver() {
        String s = "";
        for (Driver d : daftarDriver) {
            s += d.GetIdDriver() + "\n";
        }
        return s;
    }

    public String viewMobil() {
        String s = "";
        for (Mobil m : daftarMobil) {
            s += m.GetType() + "\n";
        }
        return s;
    }
}
