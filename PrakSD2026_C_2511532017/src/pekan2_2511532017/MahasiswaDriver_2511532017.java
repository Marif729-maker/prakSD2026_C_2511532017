package pekan2_2511532017;
import java.util.*;
public class MahasiswaDriver_2511532017 {

		public static void tampilkanMenu_2511532017 () {
			System.out.println("\nMenu:");
			System.out.println("1. tambah Mahasiswa");
			System.out.println("2. tampilkan semua mahasiswa");
			System.out.println("3. hapus mahasiswa berdasarkan NIM ");
			System.out.println("4. cari mahasiswa berdasarkan NIM");
			System.out.println("5. keluar");
		}
		public static void tambahMahasiswa_2511532017(ArrayList<Mahasiswa_2511532017> list, Scanner sc) {
			System.out.print("Masukkan NIM :");
			String nim = sc.nextLine();
			System.out.print("Masukkan Nama :");
			String nama = sc.nextLine();
			System.out.print("Masukkan Prodi :");
			String prodi = sc.nextLine();
			list.add(new Mahasiswa_2511532017(nim, nama, prodi));
			System.out.print("Mahasiswa berhasil ditambahkan");
		}
		public static void tampilkanSemuaMahasiswa_2511532017(ArrayList<Mahasiswa_2511532017>list) {
			if(list.isEmpty()) {
				System.out.println("daftar mahasiswa kosong");
			}else {
				System.out.println("data mahasiswa: ");
				for(Mahasiswa_2511532017 mhs : list) {
					System.out.println(mhs);
				}
			}
		}
		public static void hapusMahasiswa_2511532017(ArrayList<Mahasiswa_2511532017>list, Scanner sc) {
			System.out.println("Masukkan NIM yang akan dihapus : ");
			String nimHapus = sc.nextLine();
			boolean removed = list.removeIf(mhs -> mhs.nim.equals(nimHapus));
			
			if(removed) {
				System.out.println("data dengan NIM " + nimHapus + "berhasil dihapus.");
			}else {
				System.out.println("NIM tidak ditemukan");
			}
		}
		public static void cariMahasiswa_2511532017(ArrayList<Mahasiswa_2511532017>list,Scanner sc) {
			System.out.println("masukkan NIM yang dicari:");
			String nimCari = sc.nextLine();
			boolean ditemukan = false;
			
			for (Mahasiswa_2511532017 mhs : list) {
				if(mhs.nim.equals(nimCari)) {
					System.out.println("Hasil pencarian: " +mhs);
					ditemukan= true;
					break;
				}
			}
			if (!ditemukan) {
				System.out.println("NIM tidak ada.");
			}
		}
		public static void main (String[]args) {
			ArrayList<Mahasiswa_2511532017>mahasiswaList = new ArrayList<>();
			Scanner scanner = new Scanner(System.in);
			int choice;
		do {
			tampilkanMenu_2511532017();
			System.out.println("Pilih menu");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1 :
				tambahMahasiswa_2511532017(mahasiswaList, scanner);
				break;
			case 2 :
				tampilkanSemuaMahasiswa_2511532017(mahasiswaList);
				break;
			case 3 :
				hapusMahasiswa_2511532017(mahasiswaList, scanner);
				break;
			case 4 :
				cariMahasiswa_2511532017(mahasiswaList, scanner);
				break;
			case 5 :
				System.out.println("Keluar dari program");
				break;
			default:
				System.out.println("Pilihan tidak valid");
				
			}
		}while (choice!=5);
		scanner.close();
	}}

