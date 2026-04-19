package pekan2_2511532017;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist_2511532017 {
	
//method menu
		public static void tampilkanMenu_2511532017 () {
			System.out.println("\n=== Playlist Musik NIM: 2511532017 ===");
			System.out.println("1. tambah Lagu");
			System.out.println("2. tampilkan Playlist");
			System.out.println("3. hapus Lagu");
			System.out.println("4. keluar");
		}
		
		//method untuk tambah lagu
		 public static void tambahLagu_2511532017(ArrayList<Music_2511532017> list, Scanner sc) {
		        System.out.print("Masukkan Judul Lagu : ");
		        String judul = sc.nextLine();
		        System.out.print("Masukkan Nama Penyanyi : ");
		        String penyanyi = sc.nextLine();
		        System.out.print("Masukkan Durasi (dalam detik) : ");
		        int durasi= Integer.parseInt(sc.nextLine());
		        
		       
		        list.add(new Music_2511532017(judul, penyanyi, durasi));
		        System.out.println("Lagu berhasil ditambahkan.");
		    }
		 
		 //method nampilin semua lagu
		public static void lihatPlaylist_2511532017(ArrayList<Music_2511532017>list) {
			if(list.isEmpty()) {
				System.out.println("daftar Playlist kosong");	//cek kosong atau ngga
			}else {
				System.out.println("daftar Playlist: ");
				for(Music_2511532017 msc : list) {
					System.out.println(msc);
				}
			}
		}
		
		//method hapus lagu
		  public static void hapusLagu_2511532017(ArrayList<Music_2511532017> list, Scanner sc) {
		        lihatPlaylist_2511532017(list);
		        System.out.print("Masukkan nomor lagu yang ingin dihapus: ");
		        try {
		            int nomor = Integer.parseInt(sc.nextLine());
		            int index = nomor - 1; 						//karena array mulai dari nol
		            if (index >= 0 && index < list.size()) {
		                list.remove(index);
		                System.out.println("Lagu berhasil dihapus.");
		            } else {
		                System.out.println("Nomor tidak valid.");
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Input harus berupa angka.");
		        }
		    }
		  
		  //main code
		public static void main (String[]args) {
			ArrayList<Music_2511532017>musicList = new ArrayList<>();
			Scanner scanner = new Scanner(System.in);
			int choice;			//nyimpan pilihan
		do {							//nampilin minimal sekali
			tampilkanMenu_2511532017();
			System.out.print("Pilih menu :");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1 :
				tambahLagu_2511532017(musicList, scanner);
				break;
			case 2 :
				lihatPlaylist_2511532017(musicList);
				break;
			case 3 :
				hapusLagu_2511532017(musicList,scanner);
				break;
			case 4 :
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid");

	}
		}while (choice!=4); 				//selama ngga sama dengan 4 ulangi terus
		scanner.close();
		}
}

