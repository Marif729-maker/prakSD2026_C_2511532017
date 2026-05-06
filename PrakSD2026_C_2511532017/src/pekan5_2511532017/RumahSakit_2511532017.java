package pekan5_2511532017;

import java.util.Scanner;

public class RumahSakit_2511532017 {
	//method menu
	public static void tampilkanMenu_2511532017 () {
		System.out.println("\n=== Program Antrian Rumah Sakit NIM: 2511532017 ===");
		System.out.println("1. Daftarkan Pasien");
		System.out.println("2. Panggil Pasien");
		System.out.println("3. Tampilkan Antrian");
		System.out.println("4. Cari Pasien");
		System.out.println("5. Cek Status Antrian");
		System.out.println("6. Keluar");
	}

	  public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Pasien_2511532017 head_2017 = null;
	        int pilihan;

	        do {
	            tampilkanMenu_2511532017();
	            System.out.print("Pilih menu (1-6): ");
	            try {
	                pilihan = Integer.parseInt(sc.nextLine().trim());
	            } catch (NumberFormatException e) {
	                pilihan = -1;
	                System.out.println("Input harus angka 1-6!");
	                continue;
	            }

	            switch (pilihan) {
	                case 1:
	                    System.out.print("Masukkan nama pasien: ");
	                    String nama_2017 = sc.nextLine();
	                    if (!nama_2017.trim().isEmpty()) {
	                        System.out.print("Masukkan penyakit/keluhan: ");
	                        String penyakit_2017 = sc.nextLine();
	                        System.out.print("Masukkan nomor antrian: ");
	                        int antrian_2017 = Integer.parseInt(sc.nextLine().trim());
	                        head_2017 = Pasien_2511532017.insertAtEnd_2511532017(head_2017, nama_2017, penyakit_2017, antrian_2017);
	                    } else {
	                        System.out.println("Nama tidak boleh kosong");
	                    }
	                    break;
	                case 2:
	                    head_2017 = Pasien_2511532017.deleteHead_2511532017(head_2017);
	                    break;
	                case 3:
	                    Pasien_2511532017.printList_2511532017(head_2017);
	                    break;
	                case 4:
	                    System.out.print("Masukkan nama pasien yang dicari: ");
	                    String cari_2017 = sc.nextLine();
	                    Pasien_2511532017.searchKey_2511532017(head_2017, cari_2017);
	                    break;
	                case 5:
	                    Pasien_2511532017.jumlahPasien_2511532017(head_2017);
	                    break;
	                case 6:
	                    System.out.println("Terima kasih telah menggunakan program ini.");
	                    break;
	                default:
	                    System.out.println("Pilihan tidak valid.");
	            }
	        } while (pilihan != 6);

	        sc.close();
	    }
}
