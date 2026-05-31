package Pekan8_2511532017;

import java.util.Scanner;

public class ShelSort_2511532017 {
	  private static final int MAKS_LAGU = 20;


    public static void shellSortJudul(Lagu_2511532017[] daftarLagu) {
        int n = daftarLagu.length;
        int gap = n / 2;
        
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                Lagu_2511532017 temp = daftarLagu[i];
                int j = i;
                
                // Bandingkan judul 
                while (j >= gap && daftarLagu[j - gap].Judul_2017().compareToIgnoreCase(temp.Judul_2017()) > 0) {
                    daftarLagu[j] = daftarLagu[j - gap];
                    j -= gap;
                }
                daftarLagu[j] = temp;
            }
            gap /= 2;
        }
    }

    // Helper untuk mencetak playlist 
    public static void printPlaylist(Lagu_2511532017[] daftarLagu) {
        for (int i = 0; i < daftarLagu.length; i++) {
            System.out.println((i + 1) + ". " + daftarLagu[i].Judul_2017() + " - " + daftarLagu[i].Durasi_2017() + " detik");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.println("=== Sorting Playlist NIM: 2511532017 === \nmenggunakan ShellSort");
        System.out.print("Pilih Algoritma (1=Shell, 2=Quick, 3=Merge): ");
        String inputPilihan = sc.nextLine().trim();
        
        int pilihan;
        try {
            pilihan = Integer.parseInt(inputPilihan);
        } catch (NumberFormatException e) {
            System.out.println("algoritma tidak tersedia");
            return;
        }

        
        if (pilihan != 1) {
            System.out.println("algoritma tidak tersedia");
            return;
        }

        // Input data lagu dari user
        System.out.print("Masukkan jumlah lagu: ");
        int jumlah = Integer.parseInt(sc.nextLine().trim());
        if( jumlah < 1 || jumlah > MAKS_LAGU) {
        	System.out.print(" jumlah lagu terlalu banyak");
        return;
        }
        else {
        Lagu_2511532017[] daftarLagu = new Lagu_2511532017[jumlah];
        }
        
        Lagu_2511532017[] daftarLagu = new Lagu_2511532017[jumlah];

        for (int i = 0; i < jumlah; i++) {
        	System.out.println("");
            System.out.print("Judul: ");
            String judul = sc.nextLine();
            System.out.print("Penyanyi: ");
            String penyanyi = sc.nextLine();
            System.out.print("Durasi (detik): ");
            int durasi = Integer.parseInt(sc.nextLine().trim());
            System.out.println("");
            daftarLagu[i] = new Lagu_2511532017(judul, penyanyi, durasi);
        }

        // Tampilkan data sebelum sorting
        System.out.println("\nData Sebelum Sorting: ");
        printPlaylist(daftarLagu);

        
        shellSortJudul(daftarLagu);

        // Tampilkan data setelah sorting
        System.out.println("\nData Setelah Shell Sort (Judul Asc): ");
        printPlaylist(daftarLagu);

        sc.close();
    }
}
