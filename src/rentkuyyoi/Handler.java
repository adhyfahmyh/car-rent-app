/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentkuyyoi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RIZKY RAMADIKA
 */
public class Handler extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private PanelContainer view;
    public Mobil mobils;

    private String currentView;
    private JPanel mainPanel;

    private Home home;
    private PilihTransaksi pilihTransaksi;
    private PilihSupir pilihSupir;
    private IsiCustomer1 Customer;
    private ShowTransaksi showTransaksi;
    private Pengembalian pengembalian;
    private AllTransaksi allTransaksi;
    private menupilihan menupilihan;
    private Transaksi t;
    private Customer c;
    private int pilih;
    private Mobil tipe;
    private Driver d;

    public Handler(Aplikasi model) {
        this.model = model;
        this.view = new PanelContainer();

        home = new Home();
        pilihTransaksi = new PilihTransaksi();
        pilihSupir = new PilihSupir();
        Customer = new IsiCustomer1();
        showTransaksi = new ShowTransaksi();
        pengembalian = new Pengembalian();
        allTransaksi = new AllTransaksi();
        menupilihan = new menupilihan();

        home.addListener(this);
        pilihTransaksi.addListener(this);
        pilihSupir.addListener(this);
        showTransaksi.addListener(this);
        pengembalian.addListener(this);
        allTransaksi.addListener(this);
        Customer.addListener(this);
        menupilihan.addListener(this);

        mainPanel = view.getMainPanel();
        mainPanel.add(home, "0");
        mainPanel.add(menupilihan, "1");
        mainPanel.add(pilihTransaksi, "2");
        mainPanel.add(pengembalian, "3");
        mainPanel.add(allTransaksi, "4");
        mainPanel.add(pilihSupir, "5");
        mainPanel.add(Customer, "6");
        mainPanel.add(showTransaksi, "7");
        currentView = "0";

        view.getCardLayout().show(mainPanel, currentView);
        view.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (currentView.equals("0")) {
            //current view = Home
            if (source.equals(home.getStartButton())) {
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("1")) {
            //current view = menupilihan
            if (source.equals(menupilihan.getBTNpenyewaan())) {
                currentView = "2";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(menupilihan.getBTNpengembalian())) {
                currentView = "3";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(menupilihan.getBTNlihatdata())) {
                currentView = "4";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("2")) {
            //current view = PilihTransaksi

            //proses
//            Transaksi t = model.addTransaksi(pilihTransaksi.getComboboxMobil().setSelectedIndex(), pilihTransaksi.getDatePeminjaman().getDay(), pilihTransaksi.getDatePengembalian().getDay(), null);
            if (source.equals(pilihTransaksi.getBTNlanjut1())) {
                pilih = pilihTransaksi.getComboboxMobil().getSelectedIndex();
                tipe = new Mobil();
                if (pilih == 1) {
                    tipe = new Mobil("SUV");
                } else if (pilih == 2) {
                    tipe = new Mobil("MPV");
                } else if (pilih == 3) {
                    tipe = new Mobil("City car");
                }
                int haripeminjaman = pilihTransaksi.getPinjamTanggal();
                int bulanpeminjaman = pilihTransaksi.getPinjamBulan();
                int haripengembalian = pilihTransaksi.getKembaliTanggal();
                int bulanpengembalian = pilihTransaksi.getKembaliBulan();
                String fasilitas;
                if (pilihTransaksi.getRdBTNAll().isSelected()) {
                    fasilitas = "Sopir&BBM";
                } else if (pilihTransaksi.getRdBTNFasilitas().isSelected()) {
                    fasilitas = "Tanpa Fasilitas";
                } else if (pilihTransaksi.getRdBTNSopir().isSelected()) {
                    fasilitas = "Sopir";
                }
                t = model.addTransaksi(tipe, haripeminjaman, haripengembalian, "");
                if (pilihTransaksi.getRdBTNSopir().isSelected() == true) {
                    currentView = "5";
                    view.getCardLayout().show(mainPanel, currentView);
                } else if (pilihTransaksi.getRdBTNAll().isSelected() == true) {
                    currentView = "5";
                    view.getCardLayout().show(mainPanel, currentView);
                } else if (pilihTransaksi.getRdBTNFasilitas().isSelected() == true) {
                    currentView = "6";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            } else if (source.equals(pilihTransaksi.getBTNkembali())) {
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("3")) {
            //current view = pengembalian
            pengembalian.reset();
            pengembalian.getTXTidTransaksi().getText();
            int haripeminjaman = pengembalian.getPinjamTanggal();
            int bulanpeminjaman = pengembalian.getPinjamBulan();
            int haripengembalian = pengembalian.getKembaliTanggal();
            int bulanpengembalian = pengembalian.getKembaliBulan();
            if (source.equals(pengembalian.getBTNok())) {
                pengembalian.getBTNok().getText();
                Transaksi tr = model.getTransaksi(t.getIdTransaksi());
                tr.HitungDenda();
                pengembalian.setTXTdenda(tr.getDenda());
            }
            if (source.equals(pengembalian.getBTNkembali1())) {
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
            } else if (source.equals(pengembalian.getBTNkonfirmasi())) {
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("4")) {
            //current view = all transaksi
            DefaultTableModel transaksi = (DefaultTableModel) allTransaksi.getTableTransaksi().getModel();
            for (Transaksi t : model.getDaftarTransaksi()){
                transaksi.addRow(new Object[]{t.getIdTransaksi(),t.GetMobil().GetType(),t.getTanggalPeminjaman(),t.getTanggalPengembalian()});
            }
            if (source.equals(allTransaksi.getBTNkembali())) {
                currentView = "1";
                view.getCardLayout().show(mainPanel, currentView);
            }
        } else if (currentView.equals("5")) {
            //current view = PilihSupir
            if (source.equals(pilihSupir.getBTNOK2())) {
//                pilih = pilihSupir.getComboboxSupir().getSelectedIndex();
                Driver supir;
                supir = model.getDriver(pilih);
                pilihSupir.setTXTidSupir(supir.GetIdDriver());
                pilihSupir.setTXTAlamat(supir.GetAlamat());
                pilihSupir.setTXTKontak(supir.getNoKontak());

            }else if (source.equals(pilihSupir.getBTNlanjut2())) {
                    currentView = "6";
                    view.getCardLayout().show(mainPanel, currentView);
                }
        } else if (currentView.equals("6")) {
//            current view = dataCustomer

            if (source.equals(Customer.getBTNlanjut5())) {
                String namaCus = Customer.getTXTnamacus().getText();
                String Alamat = Customer.getTXTalamat().getText();
                String no = Customer.getTXTnomorkntk().getText();
                System.out.println(namaCus+Alamat+no);
                c = model.addCustomer(t, namaCus, Alamat, no);
                Customer.reset();
                currentView = "7";
                view.getCardLayout().show(mainPanel, currentView);
            }
            } else if (currentView.equals("7")) {
            //current view = show transaksi

                //proses show
//                model.getDaftarTransaksi();
                showTransaksi.setTXTidTransaksi(t.getIdTransaksi());
                showTransaksi.setTXTidCustomer(c.GetIdCustomer());
                showTransaksi.setTXTtipeMobil(t.GetMobil().GetType());
                showTransaksi.setTXTtanggalpeminjaman(t.getTanggalPeminjaman());
                showTransaksi.setTXTtanggalpengembalian(t.getTanggalPengembalian());
                showTransaksi.setTXTtotalharga(t.GetHarga());

                if (source.equals(showTransaksi.getBTNmenu1())) {
                    currentView = "1";
                    view.getCardLayout().show(mainPanel, currentView);
                }
            }
        }
    }
