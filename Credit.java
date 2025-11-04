package week08.zachary.id.ac.umn;

public class Credit extends Payment2 {
    private int lamaCicilan;
    private int bayarPerBulan;

    public Credit(Item item, int lamaCicilan) {
        super(item);
        this.lamaCicilan = lamaCicilan;
        this.bayarPerBulan = item.getPrice() / lamaCicilan;
    }

    public int getBayarPerBulan() {
        return bayarPerBulan;
    }

    public void bayar(int amount) {
        if (amount < this.bayarPerBulan && (this.sisaPembayaran - amount) > 0) {
            System.out.println("Pembayaran kurang dari tagihan minimum per bulan (" + this.bayarPerBulan + ")!");
            System.out.println("Transaksi gagal dibayar");
            return;
        }
        
        if (amount >= this.sisaPembayaran) {
            this.sisaPembayaran = 0;
            System.out.println("Transaksi telah dibayar lunas");
        } else {
            this.sisaPembayaran -= amount;
            System.out.println("Transaksi telah dibayar");
        }
    }

    public String getPaymentType() {
        return "CREDIT";
    }
}