package pegawai;

public abstract class Pegawai implements InterfacePegawai {

    // Deklarasi Properti
    private String nama = "";
    private String id = "";
    private String email = "";
    boolean kehadiran = false;

    // Deklarasi Method Getter dan Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getID() {
        return id;
    }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Dynamic Polymorphism
    @Override
    public void presensi() {
        kehadiran = true;
    }
    @Override
    public boolean apakahHadir() {
        return kehadiran;
    }

}

