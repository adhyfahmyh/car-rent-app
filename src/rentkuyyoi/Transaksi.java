/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentkuyyoi;

/**
 *
 * @author Firhan
 */
public class Transaksi implements Denda {
    private int harga;
    private Driver driver;
    private Mobil mobil;
    private int tanggalPeminjaman;
    private int tanggalPengembalian;
    private int selisih;
    private int Denda;
    private String Fasilitas;
    private int idTransaksi;

    public Transaksi(int idTransaksi,Mobil mobil, int tanggalPeminjaman, int tanggalPengembalian,String Fasilitas) {
        switch (mobil.GetType()) {
            case "SUV":
                this.harga = (tanggalPengembalian-tanggalPeminjaman)* 250000;
                break;
            case "MPV":
                this.harga = (tanggalPengembalian-tanggalPeminjaman)* 350000;
                break;
            case "Car city":
                this.harga = (tanggalPengembalian-tanggalPeminjaman)* 150000;
                break;
        }
        this.idTransaksi = idTransaksi;
        if (Fasilitas == "Sopir"){
            this.harga = harga+50000;
        }else if(Fasilitas == "Sopir&BBM"){
            this.harga = harga+150000;
        }else if (Fasilitas == "Tanpa Fasilitas"){
            this.harga = harga;
        }
        this.mobil = mobil;
        this.tanggalPeminjaman = tanggalPeminjaman;
        this.tanggalPengembalian = tanggalPengembalian;
        this.Fasilitas = Fasilitas;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    
    public void SetHarga (int harga){
        this.harga=harga;
    }
    
    public int GetHarga (){
        return harga;
    }
    
    public void SetDriver (Driver driver){
        this.driver=driver;
    }
    
    public Driver GetDriver (){
        return driver;
    }
    
    public void SetMObil (Mobil mobil){
        this.mobil=mobil;
    }
    
    public Mobil GetMobil (){
        return mobil;
    }
    
    public void setTanggalPeminjaman (int tanggalPeminjaman){
        this.tanggalPeminjaman = tanggalPeminjaman;
    }
    
    public int getTanggalPeminjaman(){
        return tanggalPeminjaman;
    }
    
    public void setTanggalPengembalian(int tanggalPengembalian){
        this.tanggalPengembalian=tanggalPengembalian;
    }
    
    public int getTanggalPengembalian(){
        return tanggalPengembalian;
    }
    
    public void setSelisih(int selisih){
        this.selisih= selisih;
    }
    
    public int getSelisih(){
        return selisih;
    }
    
    public void setDenda (int Denda){
        this.Denda=Denda;
    }
    
    public int getDenda(){
        return Denda;
    }
    
    public void setFasilitas (String Fasilitas){
        this.Fasilitas=Fasilitas;
    }
    
    public String getFasilitas(){
        return Fasilitas;
    }
    @Override
    public void HitungDenda(){
        Denda = selisih*500000;
    }
   
    
    
}
