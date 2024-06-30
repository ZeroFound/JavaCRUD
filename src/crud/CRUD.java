/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.util.Scanner;

public class CRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = new String[10]; // Array untuk menyimpan data sederhana

        int choice;

        do {
            System.out.println("\nMenu CRUD");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Lihat Data Mahasiswa");
            System.out.println("3. Ubah Data Mahasiswa");
            System.out.println("4. Hapus Data Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan data Mahasiswa baru: ");
                    scanner.nextLine(); //membuat baris baru 
                    String newData = scanner.nextLine();
                    addData(data, newData);
                    break;
                case 2:
                    displayData(data);
                    break;
                case 3:
                    System.out.print("Masukkan indeks data yang ingin diubah: ");
                    int indexToUpdate = scanner.nextInt();
                    System.out.print("Masukkan data Mahasiswa baru: ");
                    scanner.nextLine(); //membuat baris baru
                    String updatedData = scanner.nextLine();
                    updateData(data, indexToUpdate, updatedData);
                    break;
                case 4:
                    System.out.print("Masukkan indeks data yang ingin dihapus: ");
                    int indexToDelete = scanner.nextInt();
                    deleteData(data, indexToDelete);
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        } while (choice != 0);
        
        scanner.close();
    }

    private static void addData(String[] data, String newData) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = newData;
                System.out.println("Data berhasil ditambahkan.");
                return;
            }
        }
        System.out.println("Array penuh. Data tidak dapat ditambahkan.");
    }

    private static void displayData(String[] data) {
        System.out.println("\nData:");
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(i + ". " + data[i]);
            }
        }
    }

    private static void updateData(String[] data, int index, String updatedData) {
        if (index >= 0 && index < data.length && data[index] != null) {
            data[index] = updatedData;
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("Indeks tidak valid atau data tidak ada.");
        }
    }

    private static void deleteData(String[] data, int index) {
        if (index >= 0 && index < data.length && data[index] != null) {
            data[index] = null;
            System.out.println("Data berhasil dihapus.");
        } else {
            System.out.println("Indeks tidak valid atau data tidak ada.");
        }
    }
}