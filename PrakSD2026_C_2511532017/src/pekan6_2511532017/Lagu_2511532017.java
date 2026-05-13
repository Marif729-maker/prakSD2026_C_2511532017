package pekan6_2511532017;

import pekan5_2511532017.Pasien_2511532017;

public class Lagu_2511532017 {
	private String judul_2017;
	private String penyanyi_2017;
	private Lagu_2511532017 next_2017;
	private Lagu_2511532017 prev_2017;
	
	//constructor
	public Lagu_2511532017 (String judul_2017, String penyanyi_2017) {
		this.judul_2017 = judul_2017;
		this.penyanyi_2017 = penyanyi_2017;
		
		}
	
	//setter getter
	 public String getJudul_2017() {return judul_2017;}
	 public void setJudul_2017(String judul_2017) {this.judul_2017= judul_2017;}
	 
	 public String getPenyanyi_2017 () { return penyanyi_2017;}
	 public void setPenyanyi_2017 (String penyanyi_2017) {this.penyanyi_2017 = penyanyi_2017;}
	 
	 public Lagu_2511532017 getNext_2017 () {return next_2017;}
	 public void setNext_2017 (Lagu_2511532017 next_2017) {this.next_2017 = next_2017;}
	 
	 public Lagu_2511532017 getPrev_2017 () {return prev_2017;}
	 public void setPrev_2017 (Lagu_2511532017 prev_2017) {this.prev_2017 = prev_2017;}
	 
	 
	 public static Lagu_2511532017 findTail_2017(Lagu_2511532017 head_2017) {
	        if (head_2017 == null) return null;
	        Lagu_2511532017 curr_2017 = head_2017;
	        while (curr_2017.getNext_2017() != null) {
	            curr_2017 = curr_2017.getNext_2017();
	        }
	        return curr_2017;
	    }


	 public static Lagu_2511532017 tambahLaguAkhir_2017 (Lagu_2511532017 head_2017, String lagu_2017, String penyanyi_2017) {
			//buat node baru
			Lagu_2511532017 newNode_2017 = new Lagu_2511532017 (lagu_2017, penyanyi_2017);
			//jika dll null jadikan head
			if (head_2017 == null) {
				head_2017 = newNode_2017;
			}
			else {
				Lagu_2511532017 curr_2017 = head_2017;
				while (curr_2017.next_2017 != null ) {
					curr_2017 = curr_2017.next_2017;
				}
				curr_2017.next_2017 = newNode_2017;
				newNode_2017.prev_2017 = curr_2017; 
			}
			return head_2017;
		}
	 
	 public static Lagu_2511532017 delHead_2017 (Lagu_2511532017 head_2017) {
			if (head_2017 == null) {
				System.out.println("playlist masih kosong");
				return null;
			}
			Lagu_2511532017 temp_2017 = head_2017;
			head_2017 = head_2017.next_2017;
			if(head_2017 != null) {
				head_2017.prev_2017 = null;
				System.out.println("Lagu berhasil dihapus");
			}
			return head_2017;
		}
	 
	 static void forwardTraversal_2017 (Lagu_2511532017 head_2017) {
			Lagu_2511532017 curr_2017 = head_2017;
			while (curr_2017 != null) {
				System.out.print(curr_2017.toString());
				System.out.println();
				curr_2017 = curr_2017.next_2017;
			}
			
			System.out.println();
		}
	 
		
		static void backwardTraversal_2017 (Lagu_2511532017 tail_2017) {
			
			Lagu_2511532017 curr_2017 = tail_2017;
			while (curr_2017 != null) {
				System.out.print(curr_2017.toString());
				System.out.println();
				curr_2017 = curr_2017.prev_2017;
			}
			System.out.println();
		}
		
		 static boolean cariJudul_2511532017 (Lagu_2511532017 head_2017, String key_2017) {
				Lagu_2511532017 curr_2017 = head_2017;
				while (curr_2017 != null) {
					if (curr_2017.judul_2017.equalsIgnoreCase(key_2017)) {
						System.out.println();
						System.out.println("judul lagu ditemukan");
						System.out.println(curr_2017.toString());
						return true;
					}
					curr_2017 = curr_2017.next_2017;}
				System.out.println();
				System.out.println("Judul Lagu "+ key_2017 + "tidak ditemukan"); 
				return false;	
				}
		 
			@Override
			  public String toString() {
					 return "\nJudul Lagu: " + judul_2017 +
							 "\nPenyanyi: "+ penyanyi_2017;
			}

}
