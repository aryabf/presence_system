import pegawai.*;
import windowpresensi.PresensiGUI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Deklarasi ArrayList
        ArrayList<Direktur> daftarDirektur = new ArrayList<>();
        ArrayList<Manager> daftarManager = new ArrayList<>();
        ArrayList<Staff> daftarStaff = new ArrayList<>();

        // Add data pegawai ke ArrayList
        daftarDirektur.add(new Direktur("Asep", "3270001001", "asep@gmail.com", "Direktur Utama"));
        daftarDirektur.add(new Direktur("Budi", "3270002001", "budi@gmail.com", "Direktur Keuangan"));
        daftarDirektur.add(new Direktur("Mulyo", "3270003001", "mulyo@gmail.com", "Direktur Operasional"));
        daftarDirektur.add(new Direktur("Siti", "3270004001", "siti@gmail.com", "Direktur Pemasaran"));

        daftarManager.add(new Manager("Hendra", "3270101001", "hendra@gmail.com", "Manager Umum"));
        daftarManager.add(new Manager("Dian", "3270102001", "dian@gmail.com", "Manager SDM"));
        daftarManager.add(new Manager("Yono", "3270103001", "yono@gmail.com", "Manager Keuangan"));
        daftarManager.add(new Manager("Yuli", "3270104001", "yuli@gmail.com", "Manager Operasional"));
        daftarManager.add(new Manager("Slamet", "3270105001", "slamet@gmail.com", "Manager Pemasaran"));
        daftarManager.add(new Manager("Ratna", "3270106001", "ratna@gmail.com", "Manager HRD"));

        daftarStaff.add(new Staff("Hari", "3270201001", "hari@gmail.com", "Staff Keuangan"));
        daftarStaff.add(new Staff("Devi", "3270201002", "devi@gmail.com", "Staff Keuangan"));
        daftarStaff.add(new Staff("Agus", "3270202001", "agus@gmail.com", "Staff HRD"));
        daftarStaff.add(new Staff("Sri", "3270202002", "sri@gmail.com", "Staff HRD"));
        daftarStaff.add(new Staff("Dini", "3270202003", "dini@gmail.com", "Staff HRD"));
        daftarStaff.add(new Staff("Rudi", "3270203001", "rudi@gmail.com", "Staff Pemasaran"));
        daftarStaff.add(new Staff("Sintia", "3270203002", "sintia@gmail.com", "Staff Pemasaran"));
        daftarStaff.add(new Staff("Lukman", "3270203003", "lukman@gmail.com", "Staff Pemasaran"));
        daftarStaff.add(new Staff("Yeni", "3270203004", "yeni@gmail.com", "Staff Pemasaran"));
        daftarStaff.add(new Staff("Ade", "3270204001", "ade@gmail.com", "Staff Operasional"));
        daftarStaff.add(new Staff("Sari", "3270204002", "sari@gmail.com", "Staff Operasional"));
        daftarStaff.add(new Staff("Hasan", "3270204003", "hasan@gmail.com", "Staff Operasional"));
        daftarStaff.add(new Staff("Febri", "3270204004", "febri@gmail.com", "Staff Operasional"));
        daftarStaff.add(new Staff("Widya", "3270205001", "widya@gmail.com", "Staff SDM"));
        daftarStaff.add(new Staff("Pras", "3270205002", "pras@gmail.com", "Staff SDM"));
        daftarStaff.add(new Staff("Deden", "3270206001", "deden@gmail.com", "Office Boy"));
        daftarStaff.add(new Staff("Somat", "3270206002", "somat@gmail.com", "Office Boy"));
        daftarStaff.add(new Staff("Putri", "3270206003", "putri@gmail.com", "Office Boy"));
        daftarStaff.add(new Staff("Setyo", "3270206004", "setyo@gmail.com", "Office Boy"));
        daftarStaff.add(new Staff("Hakim", "3270207001", "deden@gmail.com", "Security"));
        daftarStaff.add(new Staff("Suwito", "3270207002", "suwito@gmail.com", "Security"));
        daftarStaff.add(new Staff("Mansur", "3270207003", "mansur@gmail.com", "Security"));
        daftarStaff.add(new Staff("Heru", "3270207004", "heru@gmail.com", "Security"));

        // Membuat GUI
        PresensiGUI gui = new PresensiGUI(daftarDirektur, daftarManager, daftarStaff);

    }
}