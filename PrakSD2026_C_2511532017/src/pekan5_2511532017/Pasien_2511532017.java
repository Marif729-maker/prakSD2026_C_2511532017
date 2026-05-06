package pekan5_2511532017;

public class Pasien_2511532017 {
	private String namaPasien_2017;
	private String penyakit_2017;
	private int antrian_2017;
	private Pasien_2511532017 next_2017;
	
	//constructor
	public Pasien_2511532017 (String namaPasien_2017, String penyakit_2017, int antrian_2017) {
		this.namaPasien_2017 = namaPasien_2017;
		this.penyakit_2017 = penyakit_2017;
		this.antrian_2017 = antrian_2017;
		}
	
	//setter getter
	 public String getNamaPasien_2017() {return namaPasien_2017;}
	 public void setNamaPasien_2017(String namaPasien_2017) {this.namaPasien_2017= namaPasien_2017;}
	 
	 public String getPenyakit_2017 () { return penyakit_2017;}
	 public void setPenyakit_2017 (String penyakit_2017) {this.penyakit_2017 = penyakit_2017;}
	 
	 public int getAntrian_2017 () { return antrian_2017;}
	 public void setAntrian_2017 (int antrian_2017) {this.antrian_2017 = antrian_2017;}
	 
	 public Pasien_2511532017 getNext_2017 () {return next_2017;}
	 public void setNext_2017 (Pasien_2511532017 next_2017) {this.next_2017 = next_2017;}
	 
	 //tambah pasien
	 public static Pasien_2511532017 insertAtEnd_2511532017 (Pasien_2511532017 head_2017, String namaPasien_2017, String penyakit_2017, int antrian_2017) {
			//buat sebuah node dengan sebuah nilai
		 Pasien_2511532017 newNode_2017 = new Pasien_2511532017 (namaPasien_2017, penyakit_2017, antrian_2017);
			//jika list kosong maka node jadi head
			if (head_2017 == null) {
				return newNode_2017;
			}
			//simpan head ke variabel sementara
			Pasien_2511532017 last_2017 = head_2017;
			//telusuri ke node akhir
			while (last_2017.next_2017 != null) {
				last_2017 = last_2017.next_2017; 
			}
			//ubah pointer
			last_2017.next_2017 = newNode_2017;
			return head_2017;
	 }
	 


	 //delete head (panggil pasien dari antrian)
	 public static Pasien_2511532017 deleteHead_2511532017 (Pasien_2511532017 head_2017) {
			//jika SLL kosong
			if (head_2017 == null) 
			return null;
			System.out.println("pasien berhasil dipanggil");
			System.out.println(head_2017.toString());
			//pindahkan head ke node berikutnya
			head_2017 = head_2017.next_2017;
			//return head baru
			return head_2017;	
			}
	 
	 //tampilkan antrian
	 public static void printList_2511532017 (Pasien_2511532017 head_2017) {
			Pasien_2511532017 curr_2017 = head_2017;
			while (curr_2017.next_2017 != null) {
				System.out.print(curr_2017.namaPasien_2017+" --> ");
				curr_2017 = curr_2017.next_2017;
		}
			if (curr_2017.next_2017 == null) {
				System.out.println(curr_2017.namaPasien_2017);
			} System.out.println();
	}
	 
	 //cari nama pasien
	 static boolean searchKey_2511532017 (Pasien_2511532017 head_2017, String key_2017) {
			Pasien_2511532017 curr_2017 = head_2017;
			while (curr_2017 != null) {
				if (curr_2017.namaPasien_2017.equalsIgnoreCase(key_2017)) {
					System.out.println("pasien ditemukan");
					System.out.println(curr_2017.toString());
					return true;
				}
				curr_2017 = curr_2017.next_2017;}
			System.out.println("passien dengan nama "+ key_2017 + "tidak ditemukan"); 
			return false;	}
	 
		public static void traversal (Pasien_2511532017 head_2017) {
			//mulai dari head
			Pasien_2511532017 curr_2017 = head_2017;
			
			 if (curr_2017 == null) {
				 System.out.println("list kosong");
				 return;
			 }
			//telusuri sampai pointer null
			while (curr_2017 != null) {
				System.out.print(" "+ curr_2017.namaPasien_2017);
				curr_2017 = curr_2017.next_2017;	}
			System.out.println();
			}
		
		
		//menampilkan jumlah antrian
		public static void jumlahPasien_2511532017 (Pasien_2511532017 head_2017) {
			int count_2017 = 0;
			Pasien_2511532017 curr_2017 = head_2017;
			
			while (curr_2017 != null) {
				count_2017++;
				curr_2017 =curr_2017.next_2017;
			}
			
			if (count_2017 == 0 ) {
				System.out.println("antrian kosong");
			} else {
				System.out.println("total pasien dalam antrian: " + count_2017);
			}
			// Tampilkan status lengkap
		    System.out.println("STATUS ANTRIAN:");
		    System.out.println("Total pasien: " + count_2017);
		    System.out.println("Pasien terdepan:" + head_2017); 
		}
	 
		@Override
		  public String toString() {
				 return "\n Nama Pasien: " + namaPasien_2017 +
						 "\nPenyakit/keluhan: "+ penyakit_2017+
						 "\nAntrian: "+ antrian_2017;
		}
}
