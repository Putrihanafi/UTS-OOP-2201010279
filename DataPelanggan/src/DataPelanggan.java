import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for the customer management application
 */
public class DataPelanggan {

    private static final ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;
            
            do {
                // Display Menu
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Pelanggan");
                System.out.println("2. Tampilkan Pelanggan");
                System.out.println("3. Hapus Pelanggan");
                System.out.println("4. Ubah Data Pelanggan");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                
                // Validate Menu Choice Input
                while (!scanner.hasNextInt()) {
                    System.out.print("Pilihan tidak valid. Pilih menu: ");
                    scanner.next();
                }
                pilihan = scanner.nextInt();
                scanner.nextLine();  // Clear the newline
                
                // Handle Menu Choices
                switch (pilihan) {
                    case 1 -> tambahPelanggan(scanner);
                    case 2 -> tampilkanPelanggan();
                    case 3 -> hapusPelanggan(scanner);
                    case 4 -> ubahDataPelanggan(scanner);
                    case 5 -> System.out.println("Keluar dari program.");
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } while (pilihan != 5);
        }
    }

    private static void tambahPelanggan(Scanner scanner) {
        // Input Pelanggan Details
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Nomor Pelanggan: ");
        String nomorPelanggan = scanner.nextLine();
        System.out.print("Masukkan jenis kelamin: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan agama: ");
        String agama = scanner.nextLine();
        System.out.print("Masukkan tempat tinggal: ");
        String tempatTinggal = scanner.nextLine();
        System.out.print("Masukkan Nomor HP: ");
        String noHP = scanner.nextLine();
        System.out.print("Masukkan kewarganegaraan: ");
        String kewarganegaraan = scanner.nextLine();
        System.out.print("Masukkan status: ");
        String status = scanner.nextLine();

        // Create and Add New Pelanggan
        Pelanggan pelangganBaru = new Pelanggan(nama, nomorPelanggan, jenisKelamin, agama, tempatTinggal, noHP, kewarganegaraan, status);
        daftarPelanggan.add(pelangganBaru);
        System.out.println("Pelanggan berhasil ditambahkan.");
    }

    private static void tampilkanPelanggan() {
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan yang ditambahkan.");
        } else {
            // Display Pelanggan List
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                Pelanggan pelanggan = daftarPelanggan.get(i);
                System.out.println(", Jenis Kelamin: " +
                        (i + 1) + ". Nama: " + pelanggan.getNama() +
                        ", Nomor Pelanggan: " + pelanggan.getNomorPelanggan() + pelanggan.getJenisKelamin() +
                        ", Agama: " + pelanggan.getAgama() +
                        ", Tempat Tinggal: " + pelanggan.getTempatTinggal() +
                        ", Nomor HP: " + pelanggan.getNoHP() +
                        ", Kewarganegaraan: " + pelanggan.getKewarganegaraan() +
                        ", Status: " + pelanggan.getStatus());
            }
        }
    }

    private static void hapusPelanggan(Scanner scanner) {
        System.out.print("Masukkan Nomor Pelanggan yang akan dihapus: ");
        String nomorPelangganDicari = scanner.nextLine();
        boolean ditemukan = false;

        // Search and Remove Pelanggan by Nomor Pelanggan
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getNomorPelanggan().equals(nomorPelangganDicari)) {
                daftarPelanggan.remove(i);
                System.out.println("Pelanggan berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pelanggan dengan Nomor Pelanggan " + nomorPelangganDicari + " tidak ditemukan.");
        }
    }

    private static void ubahDataPelanggan(Scanner scanner) {
        System.out.print("Masukkan Nomor Pelanggan yang akan diubah: ");
        String nomorPelangganDicari = scanner.nextLine();
        boolean ditemukan = false;

        // Search for Pelanggan by Nomor Pelanggan
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            if (daftarPelanggan.get(i).getNomorPelanggan().equals(nomorPelangganDicari)) {
                // Prompt for New Pelanggan Details
                System.out.println("Masukkan data baru untuk pelanggan dengan Nomor Pelanggan " + nomorPelangganDicari + ":");

                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Jenis Kelamin: ");
                String jenisKelamin = scanner.nextLine();
                System.out.print("Agama: ");
                String agama = scanner.nextLine();
                System.out.print("Tempat Tinggal: ");
                String tempatTinggal = scanner.nextLine();
                System.out.print("Nomor HP: ");
                String noHP = scanner.nextLine();
                System.out.print("Kewarganegaraan: ");
                String kewarganegaraan = scanner.nextLine();
                System.out.print("Status: ");
                String status = scanner.nextLine();

                // Update Pelanggan Details
                Pelanggan pelanggan = daftarPelanggan.get(i);
                pelanggan.setNama(nama);
                pelanggan.setJenisKelamin(jenisKelamin);
                pelanggan.setAgama(agama);
                pelanggan.setTempatTinggal(tempatTinggal);
                pelanggan.setNoHP(noHP);
                pelanggan.setKewarganegaraan(kewarganegaraan);
                pelanggan.setStatus(status);

                System.out.println("Data pelanggan berhasil diubah.");
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Pelanggan dengan Nomor Pelanggan " + nomorPelangganDicari + " tidak ditemukan.");
                /*   }
                }*/
}