package week08.zachary.id.ac.umn;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment {
    static ArrayList<Item> ListOfItems = new ArrayList<Item>();
    static ArrayList<Payment2> ListOfTransactions = new ArrayList<Payment2>();
    static Scanner s = new Scanner(System.in);

    public static void seedData() {
        ListOfItems.add(new Item("Kulkas", "Elektronik", 4800000));
        ListOfItems.add(new Item("TV", "Elektronik", 1280000));
        ListOfItems.add(new Item("Laptop", "Komputer", 6000000));
        ListOfItems.add(new Item("PC", "Komputer", 1200000));
    }

    public static void printItem(Item item) {
        System.out.println("Nama  : " + item.getName());
        System.out.println("Tipe  : " + item.getType());
        System.out.println("Harga : " + item.getPrice());
    }

    public static void main(String[] args) {
        int opt = 0;
        seedData();
        
        do {
            System.out.println("----Program Toko Elektronik----");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            opt = s.nextInt();
            s.nextLine();

            if (opt == 1) {
                System.out.println("----Daftar Barang----");
                for (int i = 0; i < ListOfItems.size(); i++) {
                    System.out.println("No    : " + (i + 1));
                    printItem(ListOfItems.get(i));
                    System.out.println("--------------------------------");
                }
                
                int itemChoice = 0;
                do {
                    System.out.print("Pilih : ");
                    itemChoice = s.nextInt();
                } while (itemChoice <= 0 || itemChoice > ListOfItems.size());
                
                Item selectedItem = ListOfItems.get(itemChoice - 1);
                System.out.println("---Tipe Pembayaran---");
                System.out.println("1. Cash");
                System.out.println("2. Credit");
                System.out.print("Pilih : ");
                int paymentOpt = s.nextInt();
                s.nextLine();

                if (paymentOpt == 1) {
                    Cash transaction = new Cash(selectedItem);
                    System.out.print("Bayar (Y/N): ");
                    String confirm = s.nextLine();
                    
                    if (confirm.equalsIgnoreCase("Y")) {
                        transaction.bayar(selectedItem.getPrice());
                    } else {
                        transaction.bayar(0);
                    }
                    ListOfTransactions.add(transaction);

                } else if (paymentOpt == 2) {
                    int lamaCicilan = 0;
                    do {
                        System.out.print("Lama Cicilan (3/6/9/12): ");
                        lamaCicilan = s.nextInt();
                    } while (lamaCicilan != 3 && lamaCicilan != 6 && lamaCicilan != 9 && lamaCicilan != 12);
                    
                    Credit transaction = new Credit(selectedItem, lamaCicilan);
                    System.out.println("Harga Pembayaran : " + transaction.getBayarPerBulan());
                    System.out.print("Bayar : ");
                    int bayarAmount = s.nextInt();
                    s.nextLine();
                    
                    transaction.bayar(bayarAmount);
                    ListOfTransactions.add(transaction);
                }

            } else if (opt == 2) {
                if (ListOfTransactions.isEmpty()) {
                    System.out.println("Belum ada transaksi.");
                    System.out.println();
                    continue;
                }

                for (int i = 0; i < ListOfTransactions.size(); i++) {
                    Payment2 t = ListOfTransactions.get(i);
                    System.out.println("No               : " + (i + 1));
                    System.out.println("Nama             : " + t.getItemName());
                    System.out.println("Tipe             : " + t.getItem().getType());
                    System.out.println("Status           : " + t.getStatus());
                    System.out.println("Sisa Pembayaran  : " + t.getRemainingAmount());
                    System.out.println("--------------------------------");
                }
                
                int transChoice = 0;
                do {
                    System.out.print("Pilih No Transaksi (0 untuk kembali) : ");
                    transChoice = s.nextInt();
                    s.nextLine();

                    if (transChoice > 0 && transChoice <= ListOfTransactions.size()) {
                        Payment2 t = ListOfTransactions.get(transChoice - 1);
                        
                        if (t.getStatus().equals("FINISHED")) {
                            System.out.println("Transaksi telah lunas");
                            System.out.println("--------------------------------");
                        } else {
                            System.out.println("Nama             : " + t.getItemName());
                            System.out.println("Tipe             : " + t.getItem().getType());
                            System.out.println("Status           : " + t.getStatus());
                            System.out.println("Sisa Pembayaran  : " + t.getRemainingAmount());
                            
                            int hargaBayar = 0;
                            if (t instanceof Credit) {
                                hargaBayar = ((Credit) t).getBayarPerBulan();
                                System.out.println("Harga Pembayaran : " + hargaBayar);
                            } else {
                                hargaBayar = t.getRemainingAmount();
                                System.out.println("Harga Pembayaran : " + hargaBayar);
                            }
                            
                            System.out.print("Bayar : ");
                            int bayarAmount = s.nextInt();
                            s.nextLine();
                            t.bayar(bayarAmount);
                        }
                    } else if (transChoice != 0) {
                        System.out.println("Pilihan tidak valid.");
                    }
                } while (transChoice != 0);

            } else if (opt == 0) {
                System.out.println("Terima Kasih");
            } else {
                System.out.println("Salah Input");
            }
            System.out.println();
        } while (opt != 0);
    }
}