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
public class Driver extends Orang{
    private int idDriver;
    
    public Driver (int idDriver, String Nama, String Alamat,String noKontak){
        super(Nama,Alamat,noKontak);
        this.idDriver=idDriver;
    }
    
    public void SetIdDriver (int idDriver){
        this.idDriver=idDriver;
    }
    
    public int GetIdDriver (){
        return idDriver;
    }
}
