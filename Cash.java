package week08.zachary.id.ac.umn;

public class Cash extends Payment2 {

    public Cash(Item item) {
        super(item);
    }

    public void bayar(int amount) {
        if (amount >= this.sisaPembayaran) {
            this.sisaPembayaran = 0;
            System.out.println("Transaksi telah dibayar lunas");
        } else if (amount > 0) {
            this.sisaPembayaran -= amount;
            System.out.println("Transaksi telah dibayar");
        } else {
            System.out.println("Transaksi telah disimpan");
        }
    }

    public String getPaymentType() {
        return "CASH";
    }
}