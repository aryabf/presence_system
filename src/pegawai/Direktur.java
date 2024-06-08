package pegawai;

public class Direktur extends Pegawai {

    // Properti
    private String bidangDirektur;

    // Constructor
    public Direktur(String nama, String id, String email, String bidangDirektur) {
        setNama(nama);
        setId(id);
        setEmail(email);
        this.bidangDirektur = bidangDirektur;
    }

    // Override Getter
    public String getNama() { return super.getNama(); }
    public String getID() { return super.getID(); }

    // Getter
    public String getBidangDirektur() { return bidangDirektur; }
}
