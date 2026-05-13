package pekan6_2511532017;
import java.util.Scanner;
public class Musik_2511532017 {
	 // Method untuk menampilkan menu
    public static void tampilkanMenu_2511532017() {
        System.out.println("\n=== Playlist Musik NIM: 2511532017 ===");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Hapus Lagu Pertama");
        System.out.println("3. Lihat Playlist (Maju)");
        System.out.println("4. Lihat Playlist (Mundur)");
        System.out.println("5. Cari Lagu");
        System.out.println("6. Keluar");
    }
    
    // Helper method untuk mencari node terakhir (tail) dari head
    // Dibutuhkan karena backwardTraversal membutuhkan parameter tail
    public static Lagu_2511532017 findTail_2017(Lagu_2511532017 head_2017) {
        if (head_2017 == null) return null;
        Lagu_2511532017 curr_2017 = head_2017;
        while (curr_2017.getNext_2017() != null) {
            curr_2017 = curr_2017.getNext_2017();
        }
        return curr_2017;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lagu_2511532017 head_2017 = null;
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
                case 1: // Tambah Lagu
                    System.out.print("Masukkan judul lagu: ");
                    String judul_2017 = sc.nextLine();
                    
                    if (!judul_2017.trim().isEmpty()) {
                        System.out.print("Masukkan nama penyanyi: ");
                        String penyanyi_2017 = sc.nextLine();
                        
                        // Memanggil method insert dari class Lagu
                        head_2017 = Lagu_2511532017.tambahLaguAkhir_2017(head_2017, judul_2017, penyanyi_2017);
                        System.out.println("Lagu berhasil ditambahkan!");
                    } else {
                        System.out.println("Judul lagu tidak boleh kosong");
                    }
                    break;
                    
                case 2: // Hapus Lagu Pertama
                    head_2017 = Lagu_2511532017.delHead_2017(head_2017);
                    break;
                    
                case 3: // Lihat Playlist (Maju)
                    if (head_2017 == null) {
                        System.out.println("Playlist masih kosong.");
                    } else {
                        Lagu_2511532017.forwardTraversal_2017(head_2017);
                    }
                    break;
                    
                case 4: // Lihat Playlist (Mundur)
                    if (head_2017 == null) {
                        System.out.println("Playlist masih kosong.");
                    } else {
                        // Cari tail terlebih dahulu untuk traversing mundur
                        Lagu_2511532017 tail_2017 = findTail_2017(head_2017);
                        Lagu_2511532017.backwardTraversal_2017(tail_2017);
                    }
                    break;
                    
                case 5: // Cari Lagu
                    System.out.print("Masukkan judul lagu yang dicari: ");
                    String cari_2017 = sc.nextLine();
                    Lagu_2511532017.cariJudul_2511532017(head_2017, cari_2017);
                    break;
                    
                case 6: // Keluar
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        sc.close();
    }
}


