/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.ArrayList;
import java.util.Scanner;

class Mhs {
    String nim;
    String nama;

    public Mhs(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama;
    }
}

public class ContohCrudSederhana {

    private static ArrayList<Mhs> daftarMahasiswa = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");

            System.out.print("Pilih operasi (1-5): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    tampilkanMahasiswa();
                    break;
                case 3:
                    updateMahasiswa();
                    break;
                case 4:
                    hapusMahasiswa();
                    break;
                case 5:
                    System.out.println("Terima kasih! Keluar dari program.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }

    private static void tambahMahasiswa() {
        System.out.print("Masukkan NIM: ");
        String nim = scanner.next();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.next();

        Mhs mahasiswa = new Mhs(nim, nama);
        daftarMahasiswa.add(mahasiswa);

        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private static void tampilkanMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
        } else {
            System.out.println("Daftar Mahasiswa:");
            for (Mhs mahasiswa : daftarMahasiswa) {
                System.out.println(mahasiswa);
            }
        }
    }

    private static void updateMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa untuk diupdate.");
        } else {
            tampilkanMahasiswa();
            System.out.print("Masukkan NIM mahasiswa yang akan diupdate: ");
            String nimToUpdate = scanner.next();

            boolean ditemukan = false;
            for (Mhs mahasiswa : daftarMahasiswa) {
                if (mahasiswa.nim.equals(nimToUpdate)) {
                    System.out.print("Masukkan Nama baru: ");
                    String namaBaru = scanner.next();
                    mahasiswa.nama = namaBaru;
                    ditemukan = true;
                    System.out.println("Data mahasiswa berhasil diupdate!");
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Mahasiswa dengan NIM " + nimToUpdate + " tidak ditemukan.");
            }
        }
    }

    private static void hapusMahasiswa() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa untuk dihapus.");
        } else {
            tampilkanMahasiswa();
            System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
            String nimToDelete = scanner.next();

            boolean dihapus = daftarMahasiswa.removeIf(mahasiswa -> mahasiswa.nim.equals(nimToDelete));

            if (dihapus) {
                System.out.println("Data mahasiswa berhasil dihapus!");
            } else {
                System.out.println("Mahasiswa dengan NIM " + nimToDelete + " tidak ditemukan.");
            }
        }
    }
}
