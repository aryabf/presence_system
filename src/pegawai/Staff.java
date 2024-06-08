package pegawai;

public class Staff extends Pegawai {

    // Properti
    private String bidangStaff;

    // Constructor
    public Staff(String nama, String id, String email, String bidangStaff) {
        setNama(nama);
        setId(id);
        setEmail(email);
        this.bidangStaff = bidangStaff;
    }

    // Override Getter
    public String getNama() { return super.getNama(); }
    public String getID() { return super.getID(); }

    // Getter
    public String getBidangStaff() { return bidangStaff; }

}
