import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Kelas untuk menyimpan data mahasiswa
class Mahasiswa {
    private String nama;
    private String nim;

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama;
    }
}

// Kelas utama untuk pengelolaan mahasiswa
public class ManajemenMahasiswa {
    private Map<String, Mahasiswa> dataMahasiswa = new HashMap<>();
    private Scanner input = new Scanner(System.in);

    public void tampilkanMenu() {
        int pilihan;
        while (true) {
            System.out.println("\n====== Menu Utama ======");
            System.out.println("1. Input Data Mahasiswa");
            System.out.println("2. Lihat Data Mahasiswa");
            System.out.println("3. Edit Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("0. Keluar Program");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // Bersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    ubahMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 0:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private void tambahMahasiswa() {
        System.out.println("\n=== Tambah Data Mahasiswa ===");
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        if (dataMahasiswa.containsKey(nim)) {
            System.out.println("NIM sudah ada dalam sistem! Coba dengan NIM lain.");
            return;
        }
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        dataMahasiswa.put(nim, new Mahasiswa(nama, nim));
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    private void tampilkanData() {
        System.out.println("\n=== Data Mahasiswa ===");
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data yang tersedia.");
            return;
        }
        for (Map.Entry<String, Mahasiswa> entry : dataMahasiswa.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private void ubahMahasiswa() {
        System.out.println("\n=== Ubah Data Mahasiswa ===");
        System.out.print("Masukkan NIM yang akan diubah: ");
        String nim = input.nextLine();
        if (!dataMahasiswa.containsKey(nim)) {
            System.out.println("NIM tidak ditemukan.");
            return;
        }
        System.out.print("Masukkan Nama baru: ");
        String namaBaru = input.nextLine();
        dataMahasiswa.put(nim, new Mahasiswa(namaBaru, nim));
        System.out.println("Data mahasiswa berhasil diperbarui.");
    }

    private void hapusMahasiswa() {
        System.out.println("\n=== Hapus Data Mahasiswa ===");
        System.out.print("Masukkan NIM yang akan dihapus: ");
        String nim = input.nextLine();
        if (!dataMahasiswa.containsKey(nim)) {
            System.out.println("NIM tidak ditemukan.");
            return;
        }
        dataMahasiswa.remove(nim);
        System.out.println("Data mahasiswa berhasil dihapus.");
    }

    public static void main(String[] args) {
        ManajemenMahasiswa aplikasi = new ManajemenMahasiswa();
        aplikasi.tampilkanMenu();
    }
}
