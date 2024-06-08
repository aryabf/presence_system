package pegawai;

public class Manager extends Pegawai {

    // Properti
    private String bidangManager;

    // Constructor
    public Manager(String nama, String id, String email, String bidangManager) {
        setNama(nama);
        setId(id);
        setEmail(email);
        this.bidangManager = bidangManager;
    }

    // Override Getter
    public String getNama() { return super.getNama(); }
    public String getID() { return super.getID(); }

    // Getter
    public String getBidangManager() { return bidangManager; }

}
