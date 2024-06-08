package windowpresensi;

import pegawai.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class PresensiGUI extends JFrame implements ActionListener {

    private Container container;
    private JLabel header;
    private JLabel subheader;
    private ArrayList<Direktur> daftarDirektur;
    private ArrayList<Manager> daftarManager;
    private ArrayList<Staff> daftarStaff;
    private int jabatanYangDibuka;
    private boolean apakahAda;
    private Direktur direkturTampil;
    private Manager managerTampil;
    private Staff staffTampil;
    private int geserKanan;
    private int loopCounter = -1;
    private ArrayList<ArrayList<String>> pegawaiHadir = new ArrayList<>();
    private static final int DIREKTUR = 0;
    private static final int MANAGER = 1;
    private static final int STAFF = 2;
    private static final String PW = "4DM1N";

    // Constructor
    public PresensiGUI(ArrayList<Direktur> daftarDirektur,
                       ArrayList<Manager> daftarManager,
                       ArrayList<Staff> daftarStaff) {
        this.daftarDirektur = daftarDirektur;
        this.daftarManager = daftarManager;
        this.daftarStaff = daftarStaff;
        pilihJabatan();
    }

    // Halaman Daftar Kehadiran Pegawai
    void daftarHadir() {

        setTitle("Daftar Hadir Pegawai");
        setBounds(280, 100, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        container = getContentPane();
        container.setLayout(null);

        JButton tombolKembali = new JButton("Kembali");
        tombolKembali.setFont(new Font("Arial", Font.BOLD, 10));
        tombolKembali.setSize(75, 20);
        tombolKembali.setLocation(5, 5);
        tombolKembali.addActionListener(e -> {
            container.removeAll();
            pilihJabatan();
        });
        container.add(tombolKembali);

        header = new JLabel("Daftar Hadir Pegawai");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setSize(500, 40);
        header.setLocation(245, 43);
        container.add(header);

        String[] kolom = {"ID Pegawai", "Nama Pegawai", "Email Pegawai", "Jabatan"};
        String[][] dataPegawai = new String[pegawaiHadir.size()][4];
        for (int i=0; i < pegawaiHadir.size(); i++){
            for (int j=0; j < 4; j++) {
                dataPegawai[i][j] = pegawaiHadir.get(i).get(j);
            }
        }
        JTable tabelPresensi = new JTable(dataPegawai, kolom);
        tabelPresensi.setSize(700, 300);
        tabelPresensi.setLocation(40, 125);

        container.add(tabelPresensi);

        setVisible(true);

        JOptionPane.showMessageDialog(null,
                "Selamat Datang, Admin!",
                "Selamat Datang!",
                JOptionPane.INFORMATION_MESSAGE);

    }

    // Homepage
    void pilihJabatan() {

        setTitle("Presensi Kehadiran Pegawai");
        setBounds(225, 200, 900, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        header = new JLabel("Presensi Kehadiran Pegawai");
        header.setFont(new Font("Arial", Font.BOLD, 30));
        header.setSize(500, 30);
        header.setLocation(245, 55);
        container.add(header);

        JButton tombolDirektur = new JButton("Direktur");
        JButton tombolManager = new JButton("Manager");
        JButton tombolStaff = new JButton("Staff");

        tombolDirektur.setFont(new Font("Arial", Font.BOLD, 15));
        tombolDirektur.setSize(100, 35);
        tombolDirektur.setLocation(250, 155);
        tombolDirektur.addActionListener(e -> {
            container.removeAll();
            presensi(DIREKTUR);
        });
        container.add(tombolDirektur);

        tombolManager.setFont(new Font("Arial", Font.BOLD, 15));
        tombolManager.setSize(100, 35);
        tombolManager.setLocation(400, 155);
        tombolManager.addActionListener(e -> {
            container.removeAll();
            presensi(MANAGER);
        });
        container.add(tombolManager);

        tombolStaff.setFont(new Font("Arial", Font.BOLD, 15));
        tombolStaff.setSize(100, 35);
        tombolStaff.setLocation(550, 155);
        tombolStaff.addActionListener(e -> {
            container.removeAll();
            presensi(STAFF);
        });
        container.add(tombolStaff);

        JButton tombolDaftarHadir = new JButton("Daftar Hadir");
        tombolDaftarHadir.setFont(new Font("Arial", Font.PLAIN, 10));
        tombolDaftarHadir.setSize(90, 20);
        tombolDaftarHadir.setLocation(790, 235);
        tombolDaftarHadir.addActionListener(e -> {
            String cekPassword = JOptionPane.showInputDialog(null,
                    "Masukkan Password!",
                    "Masukkan Password!",
                    JOptionPane.INFORMATION_MESSAGE);
            if (Objects.equals(cekPassword, PW)) {
                container.removeAll();
                daftarHadir();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Mohon Maaf, Anda tidak diizinkan masuk!",
                        "Password Salah!",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        container.add(tombolDaftarHadir);

        setVisible(true);

    }

    // Halaman Presensi
    void presensi(int jabatan) {

        String jabatanStr = "";

        switch (jabatan) {
            case DIREKTUR -> {
                jabatanStr = "Direktur";
                jabatanYangDibuka = DIREKTUR;
                geserKanan = 0;
            }
            case MANAGER -> {
                jabatanStr = "Manager";
                jabatanYangDibuka = MANAGER;
                geserKanan = -5;
            }
            case STAFF -> {
                jabatanStr = "Staff";
                jabatanYangDibuka = STAFF;
                geserKanan = 10;
            }
        }

        setTitle("Presensi Kehadiran " + jabatanStr);
        setBounds(485, 175, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        container = getContentPane();
        container.setLayout(null);

        JTextField idField = new JTextField();
        idField.setSize(250, 25);
        idField.setLocation(68, 200);
        container.add(idField);

        header = new JLabel("Presensi Kehadiran " + jabatanStr);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setSize(300, 30);
        header.setLocation(63 + geserKanan, 85);
        container.add(header);

        subheader = new JLabel("Masukkan ID Anda");
        subheader.setFont(new Font("Arial", Font.PLAIN, 14));
        subheader.setSize(300, 30);
        subheader.setLocation(130, 120);
        container.add(subheader);

        JButton tombolPresensi = new JButton("Hadir");
        tombolPresensi.setFont(new Font("Arial", Font.BOLD, 15));
        tombolPresensi.setSize(100, 30);
        tombolPresensi.setLocation(147, 250);
        tombolPresensi.addActionListener(e -> {

            String isiField = idField.getText();

            switch (jabatanYangDibuka) {
                case DIREKTUR -> {
                    for (Direktur direktur : daftarDirektur) {
                        loopCounter++;
                        if (Objects.equals(isiField, direktur.getID())) {
                            apakahAda = true;
                            if (daftarDirektur.get(loopCounter).apakahHadir()) {
                                JOptionPane.showMessageDialog(null,
                                        direkturTampil.getNama() + " sudah hadir!",
                                        "Sudah hadir!",
                                        JOptionPane.ERROR_MESSAGE);

                            } else {
                                daftarDirektur.get(loopCounter).presensi();
                                tambahDataDirektur(direktur);
                                direkturTampil = direktur;
                                JOptionPane.showMessageDialog(null,
                                        "Selamat Datang, " + direkturTampil.getNama() + "!",
                                        "Selamat Datang!",
                                        JOptionPane.INFORMATION_MESSAGE);
                                }
                        }
                    }
                }
                case MANAGER -> {
                    for (Manager manager : daftarManager) {
                        loopCounter++;
                        if (Objects.equals(isiField, manager.getID())) {
                            apakahAda = true;
                            if (daftarManager.get(loopCounter).apakahHadir()) {
                                JOptionPane.showMessageDialog(null,
                                        managerTampil.getNama() + " sudah hadir!",
                                        "Sudah hadir!",
                                        JOptionPane.ERROR_MESSAGE);

                            } else {
                                managerTampil = manager;
                                tambahDataManager(manager);
                                manager.presensi();
                                JOptionPane.showMessageDialog(null,
                                        "Selamat Datang, " + managerTampil.getNama(),
                                        "Selamat Datang!",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
                case STAFF -> {
                    for (Staff staff : daftarStaff) {
                        loopCounter++;
                        if (Objects.equals(isiField, staff.getID())) {
                            apakahAda = true;
                            if (daftarStaff.get(loopCounter).apakahHadir()){
                                JOptionPane.showMessageDialog(null,
                                        staffTampil.getNama() + " sudah hadir!",
                                        "Sudah hadir!",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                staffTampil = staff;
                                staff.presensi();
                                tambahDataStaff(staff);
                                JOptionPane.showMessageDialog(null,
                                        "Selamat Datang, " + staffTampil.getNama(),
                                        "Selamat Datang!",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
            }
            loopCounter = -1;
            if (apakahAda) {
                container.removeAll();
                apakahAda = false;
                pilihJabatan();
            } else {
                JOptionPane.showMessageDialog(null,
                        "Mohon maaf, ID tidak ditemukan!",
                        "ID Tidak Ditemukan!",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        container.add(tombolPresensi);

        JButton tombolKembali = new JButton("Kembali");
        tombolKembali.setFont(new Font("Arial", Font.BOLD, 10));
        tombolKembali.setSize(75, 20);
        tombolKembali.setLocation(5, 5);
        tombolKembali.addActionListener(e -> {
            container.removeAll();
            pilihJabatan();
        });
        container.add(tombolKembali);

        setVisible(true);

    }

    // Menambahkan Direktur Hadir ke Tabel
    void tambahDataDirektur(Direktur direktur) {
        ArrayList<String> dataDirektur = new ArrayList<>();
        dataDirektur.add(direktur.getID());
        dataDirektur.add(direktur.getNama());
        dataDirektur.add(direktur.getEmail());
        dataDirektur.add(direktur.getBidangDirektur());
        pegawaiHadir.add(dataDirektur);
    }

    // Menambahkan Manager Hadir ke Tabel
    void tambahDataManager(Manager manager) {
        ArrayList<String> dataManager = new ArrayList<>();
        dataManager.add(manager.getID());
        dataManager.add(manager.getNama());
        dataManager.add(manager.getEmail());
        dataManager.add(manager.getBidangManager());
        pegawaiHadir.add(dataManager);
    }

    // Menambahkan Staff Hadir ke Tabel
    void tambahDataStaff(Staff staff) {
        ArrayList<String> dataStaff = new ArrayList<>();
        dataStaff.add(staff.getID());
        dataStaff.add(staff.getNama());
        dataStaff.add(staff.getEmail());
        dataStaff.add(staff.getBidangStaff());
        pegawaiHadir.add(dataStaff);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
