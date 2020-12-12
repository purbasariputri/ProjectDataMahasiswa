/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Mahasiswa {
    ArrayList<String> nim = new ArrayList<>();
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<Date> date = new ArrayList<>();
    ArrayList<Integer> gender = new ArrayList<>();
    void inputMenu(){
        int menu;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("------------------");
            System.out.println("Data Mahasiswa");
            System.out.println("------------------");
            System.out.println("Menu");
            System.out.println("1. Tambah Data");
            System.out.println("2. Hapus Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Tampil Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih nomor menu : ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    hapusData();
                    break;
                case 3:
                    cariData();
                    break;
                case 4:
                    tampilData();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while(menu != 5);
    }
    void tambahData(){
        Scanner input = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Tambah Data Mahasiswa");
        System.out.println("------------------");
        while(true){
            System.out.print("NIM : ");
            this.nim.add(input.nextLine());
            System.out.print("Nama : ");
            this.nama.add(input.nextLine());
            inputTanggal();
            System.out.print("Jenis kelamin (0 = Laki-laki, 1 = Perempuan): ");
            this.gender.add(input.nextInt());
            System.out.print("Tambah data lagi? (y/n) : ");
            input.nextLine();
            char lagi = input.nextLine().charAt(0);
            if (lagi == 'n') {
                inputMenu();
                break;
            }
        }
    }
    void inputTanggal(){
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan tanggal lahir (dd/MM/yyyy)");
        System.out.print("Tanggal : ");
        int d = input.nextInt();
        System.out.print("Bulan : ");
        int m = input.nextInt();
        System.out.print("Tahun : ");
        int y = input.nextInt();
        Date tanggal = new GregorianCalendar(y, m-1, d).getTime();
        SimpleDateFormat formatTgl = new SimpleDateFormat("dd/MM/yyyy");
        this.date.add(tanggal);
    }
    void hapusData(){
        Scanner input = new Scanner(System.in);
        String hapus;
        while(true){
            System.out.println("------------------");
            System.out.println("Hapus Data Mahasiswa");
            System.out.println("------------------");
            System.out.print("Masukkan NIM mahasiswa yang akan dihapus : ");
            hapus = input.nextLine();
            int index = Collections.binarySearch(nim, hapus);
            boolean cek = this.nim.contains(hapus);
            if (cek == true){
                System.out.println("------------------");
                System.out.println("Menghapus data");
                System.out.println("NIM : " + this.nim.get(index));
                System.out.println("Nama : " + this.nama.get(index));
                System.out.println("Tanggal lahir : " + this.date.get(index));
                this.nim.remove(index);
                this.nama.remove(index);
                this.gender.remove(index);
                System.out.println("--- Berhasil! ---");
            } else {
                System.out.println("Data tidak ditemukan");
            }
            System.out.print("Hapus data lagi? (y/n) : ");
            char lagi = input.nextLine().charAt(0);
            if (lagi == 'n') {
                inputMenu();
                break;
            }
        }
    }
    void cariData(){
        Scanner input = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Cari Data Mahasiswa");
        System.out.println("------------------");
        System.out.println("Cari data berdasarkan");
        System.out.println("1. Jenis kelamin");
        System.out.println("2. NIM");
        System.out.print("Masukkan pilihan : ");
        int pilih = input.nextInt();
        if (pilih == 1) {
            System.out.print("Masukkan jenis kelamin (0 = Laki-laki, 1 = Perempuan) : ");
            input.nextLine();
            int cariGender = input.nextInt();
            System.out.println("------------------");
            switch (cariGender) {
                case 0:
                    System.out.println("Data Mahasiswa Laki-laki");
                    break;
                case 1:
                    System.out.println("Data Mahasiswi Perempuan");
                    break;
                default:
                    System.out.println("Inputan salah");
                    break;
            }
            boolean cekGender = this.gender.contains(cariGender);
            if (cekGender == true) {
                for (int i=0; i<this.gender.size(); i++) {
                    if (this.gender.get(i) == cariGender) {
                        System.out.println("NIM : " + this.nim.get(i));
                        System.out.println("Nama : " + this.nama.get(i));
                        System.out.println("Tanggal lahir : " + this.date.get(i));
                    }
                }
            } else {
                System.out.println("Data tidak ditemukan");
            }
        } else if (pilih == 2) {
            System.out.print("Masukkan NIM : ");
            input.nextLine();
            String cariNim = input.nextLine();
            int index = Collections.binarySearch(nim, cariNim);
            boolean cekNim = this.nim.contains(cariNim);
            if (cekNim == true) {
                System.out.println("NIM : " + this.nim.get(index));
                System.out.println("Nama : " + this.nama.get(index));
                System.out.println("Tanggal lahir : " + this.date.get(index));
                if (this.gender.get(index) == 0) {
                    System.out.println("Jenis kelamin : Laki-laki");
                } else if (this.gender.get(index) == 1) {
                    System.out.println("Jenis kelamin : Perempuan");
                }
            } else {
                System.out.println("Data tidak ditemukan");
            }
        }
    }
    void tampilData(){
        System.out.println("------------------");
        System.out.println("Tampil Data Mahasiswa");
        System.out.println("------------------");
        boolean cek = this.nim.isEmpty();
        if (cek == true) {
            System.out.println("Data tidak ditemukan");
        } else {
            for (int i=0; i<this.nim.size(); i++) {
                System.out.println("NIM : " + this.nim.get(i));
                System.out.println("Nama : " + this.nama.get(i));
                System.out.println("Tanggal lahir : " + this.date.get(i));
                if (this.gender.get(i) == 0) {
                    System.out.println("Jenis kelamin : Laki-laki");
                } else if(this.gender.get(i) == 1) {
                    System.out.println("Jenis kelamin : Perempuan");
                }
            }
        }
    }    
}