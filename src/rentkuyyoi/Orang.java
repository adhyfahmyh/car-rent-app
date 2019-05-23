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
public abstract class Orang {
    private String Nama;
    private String Alamat;
    private String noKontak;
    
    public Orang (String Nama, String Alamat, String noKontak){
        this.Nama=Nama;
        this.Alamat=Alamat;
        this.noKontak=noKontak;
    }

    public void SetNama (String Nama){
        this.Nama=Nama;
    }
    
    public String GetNama (){
        return Nama;
    }
    
    public void SetAlamat (String Alamat){
        this.Alamat=Alamat;
    }
    
    public String GetAlamat (){
        return Alamat;
    }

    public String getNoKontak() {
        return noKontak;
    }

    public void setNoKontak(String noKontak) {
        this.noKontak = noKontak;
    }
    
    
}
