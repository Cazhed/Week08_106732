package week08.zachary.id.ac.umn;

public abstract class Payment2 {
    protected Item item;
    protected int sisaPembayaran;

    public Payment2(Item item) {
        this.item = item;
        this.sisaPembayaran = item.getPrice();
    }

    public Item getItem() {
        return item;
    }

    public String getItemName() {
        return item.getName();
    }

    public String getStatus() {
        if (sisaPembayaran == 0) {
            return "FINISHED";
        }
        return "ON PROGRESS";
    }

    public int getRemainingAmount() {
        return sisaPembayaran;
    }

    public abstract void bayar(int amount);

    public abstract String getPaymentType();
}
