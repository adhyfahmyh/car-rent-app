/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentkuyyoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author RIZKY RAMADIKA
 */
public class ConnectDatabase {
    
    private String server = "jdbc:mysql://localhost:3306/RentalMobil";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;
    public void connect(){
        try{
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        }catch(Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan pada koneksi database");
        }
    }
        
    public void saveCustomer(Customer c){
        try {
            String query = "insert into customer values"
                + "(" + c.GetIdCustomer() + ", "
                + "'" + c.GetNama()+ "'"
                + ", '" + c.GetAlamat() + "', "
                + "'" + c.getNoKontak()+ "')";
        statement.execute(query);
        } catch (Exception e) {
//            throw new IllegalArgumentException("Terjadi kesalahan pada save Customer");
            System.out.println(e);
        }
    }
    
    public void saveDriver(Driver d){
        try {
            String query = "insert into driver(idDriver, Nama, Alamat, noKontak) values"
                + "('" + d.GetIdDriver()+ "', "
                + "'" + d.GetNama() + "')"
                + "'" + d.GetAlamat()+ "')"
                + "'" + d.getNoKontak() + "')";
        statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan pada save Customer");
        }
    }
    
    public void saveMobil(Mobil m){
        try {
            String query = "insert into mobil(type) values"
                + "('" + m.GetType()+ "')";
        statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan pada save Customer");
        }
    }
    
    public void saveTransaksi(Transaksi t){
        try {
            String query = "insert into Transaksi(idTransaksi,harga,type,tanggalPeminjaman,tanggalPengembalian,Fasilitas) values ("
                + "'" + t.getIdTransaksi()+ "', "
                + "'" + t.GetHarga()+ "', "
                + "'" + t.GetMobil().GetType() + "', "
                + "'" + t.getTanggalPeminjaman()+ "', "
                + "'" + t.getTanggalPengembalian()+ "', "
                + "'" + t.getFasilitas()+ "')";
        statement.execute(query);
        } catch (Exception e) {
            System.out.println(e);
//            throw new IllegalArgumentException("Terjadi kesalahan pada save Transaksi");
        }
    }
    
    public ArrayList<Customer> loadCustomer(){
        try{
            ArrayList<Customer> daftarCustomer = new ArrayList<>();
            String query = "select * from Customer";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                //Customer cst = new Customer(rs.getString(1),rs,rs.getString(3),rs.getString(4));
                //daftarCustomer.add(cst);
            }
            return daftarCustomer;
        }catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan pada load transaksi");
        }
    }
   
    public ArrayList<Transaksi> loadTransaksi(){
        try{
            ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
            String query = "select * from Transaksi";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Transaksi trn = new Transaksi(rs.getInt(7), new Mobil(rs.getString(1)),rs.getInt(2),rs.getInt(3),rs.getString(6)); 
                daftarTransaksi.add(trn);
            }
            return daftarTransaksi;
        }catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan pada load transaksi");
        }
    }
    
    public ArrayList<Driver> loadDriver(){
        try{
            ArrayList<Driver> daftarDriver  = new ArrayList<>();
            String query = "select * from Driver";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
//                Driver drv = new Driver(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
//                daftarDriver.add(drv);
            }
            return daftarDriver;
        }catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan pada load transaksi");
        }
    }
    
    public ArrayList<Mobil> loadMobil(){
        try{
            ArrayList<Mobil> daftarMobil = new ArrayList<>();
            String query = "select * from Mobil";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Mobil mbl = new Mobil(rs.getString(1));
                daftarMobil.add(mbl);
            }
            return daftarMobil;
        }catch (Exception e){
            throw new IllegalArgumentException("Terjadi kesalahan pada load transaksi");
        }
    }
    
    //public void updateTransaksi(Transaksi t){
        //try{
            //String query;
            //if 
        //}
    //}
    
}
