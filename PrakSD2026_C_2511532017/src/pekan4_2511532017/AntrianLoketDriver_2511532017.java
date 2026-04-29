package pekan4_2511532017;
import java.util.Scanner;

public class AntrianLoketDriver_2511532017 {


			//method menu
			public static void tampilkanMenu_2511532017 () {
				System.out.println("\n=== Program Antrian Loket NIM: 2511532017 ===");
				System.out.println("1. Tambah Antrian");
				System.out.println("2. Hapus Antrian");
				System.out.println("3. Tampilkan Antrian");
				System.out.println("4. Reverse");
				System.out.println("5. keluar");
			}
			
			 public static void main(String[] args) {
			        Scanner sc = new Scanner(System.in);
			 
			        AntrianLoket_2511532017 queue = new AntrianLoket_2511532017(5);
			        int pilihan;

				    do {
				        tampilkanMenu_2511532017();
				        System.out.print("Pilih menu (1-5): ");
				        try {
				            pilihan = Integer.parseInt(sc.nextLine().trim());
				        } catch (NumberFormatException e) {
				            pilihan = -1;
				            System.out.println("Input harus angka 1-5!");
				            continue;
				        }

				        switch (pilihan) {
				            case 1:
				            	System.out.println("Masukkan nama pelanggan: ");
				            	String namaPelanggan_2017 = sc.nextLine();
				            	if(!namaPelanggan_2017.trim().isEmpty()) {
				            	queue.enqueue_2511532017(namaPelanggan_2017);
				            	}else {System.out.println("nama tidak boleh kosong");}
				            	
				                break;
				            case 2:
				            	String selesai_2017 = queue.dequeue_2511532017();
				            	if (selesai_2017 != null) {
				            	System.out.println(selesai_2017 + " telah dilayani ");
				            	}
				                break;
				            case 3:
				               queue.display_2511532017();
				                break;
				            case 4:
				            	 System.out.println("isi antrian");
				            	queue.reverseQueue_2511532017();
				               queue.display_2511532017();
				                break;
				            default:
				                System.out.println(" Pilihan tidak valid.");
				        }
				    } while (pilihan != 5);
				    
				    sc.close();
				}
			        
		        
	        
	
	

}
