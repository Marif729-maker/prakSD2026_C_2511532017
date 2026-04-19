package pekan3_2511532017;

import java.util.ArrayList;
import java.util.Scanner;



public class Browser_2511532017 {
	private ArrayList<Website_2511532017>stack;
	public Browser_2511532017 () {
		stack = new ArrayList<>();
	}
	//method menu
	public static void tampilkanMenu_2511532017 () {
		System.out.println("\n=== Browser History NIM: 2511532017 ===");
		System.out.println("1. Kunjungi Website (Push)");
		System.out.println("2. Tombol Back (Pop)");
		System.out.println("3. Lihat Halaman Aktif (Peek)");
		System.out.println("4. Cek Status History");
		System.out.println("5. keluar");
	}
	//memasukkan website baru
	public void tambahWebsite_2511532017(Scanner sc) {
        System.out.print("Masukkan Judul Website : ");
        String judul = sc.nextLine();
        
        String url;
        while (true) {
            System.out.print("Masukkan URL: ");
            url = sc.nextLine();
            if (!url.trim().isEmpty()) {
                break; 
            }
            System.out.println("Error: URL tidak boleh kosong! Silakan ulangi.");
        }
        Website_2511532017 webBaru = new Website_2511532017(judul, url);
        this.push(webBaru);		//push ke stack
        System.out.println(" Website berhasil ditambahkan ke history");
	}
	public void push (Website_2511532017 wbst) {
		stack.add(wbst);
	}
	//mengeluarkan website
	 public Website_2511532017 pop() {
	        if (!stack.isEmpty()) {				//cek stack kosong atau tidak
	            return stack.remove(stack.size() - 1);}
	        return null;}
	  
	 //melihat website tanpa menghapus
		public Website_2511532017 peek() {
			if(!isEmpty()) {
				return stack.get(stack.size()-1);}
			return null;}
		
		public boolean isEmpty() {
			return stack.isEmpty();}
		
		//method cek status history
		public void cekStatusHistory_2511532017() {
		    int total = stack.size();
		    System.out.println("\nJumlah riwayat history : " + total);
		    
		    if (total == 0) {
		        System.out.println("(History masih kosong)");
		    } else {
		        System.out.println("=== Daftar Riwayat ===");
		        for (int i = total - 1; i >= 0; i--) {
		            System.out.println((i == total - 1 ? " Aktif " : "   ") + stack.get(i));
		        }
		    }
		}

	public static void main(String[] args) {
		  Browser_2511532017 browser = new Browser_2511532017();
		    Scanner sc = new Scanner(System.in);
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
		                browser.tambahWebsite_2511532017(sc);
		                break;
		            case 2:
		                Website_2511532017 webBack = browser.pop();
		                if (webBack != null) {
		                    System.out.println("Berhasil dihapus: " + webBack.getJudul_2017());
		                } else {
		                    System.out.println("History kosong, Tidak bisa Back.");
		                }
		                break;
		            case 3:
		                Website_2511532017 webActive = browser.peek();
		                if (webActive != null) {
		                    System.out.println("Halaman Aktif:\n" + webActive);
		                } else {
		                    System.out.println("Tidak ada halaman yang dibuka.");
		                }
		                break;
		            case 4:
		                browser.cekStatusHistory_2511532017();
		                break;
		            case 5:
		                break;
		            default:
		                System.out.println(" Pilihan tidak valid.");
		        }
		    } while (pilihan != 5);
		    
		    sc.close();
		}

	}


