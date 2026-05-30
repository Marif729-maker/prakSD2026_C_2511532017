package Pekan8_2511532017;

public class Lagu_2511532017 {
		private String judul_2017;
		private String penyanyi_2017;
		private int durasi_2017;
		Lagu_2511532017(String judul_2017, String penyanyi_2017, int durasi_2017){
			this.judul_2017 = judul_2017;
			this.penyanyi_2017 = penyanyi_2017;
			this.durasi_2017 = durasi_2017;
		}
		 public String Judul_2017() {return judul_2017;}
		 public void Judul_2017(String judul_2017) {this.judul_2017 = judul_2017;}
		 
		 public String Penyanyi_2017() {return penyanyi_2017;}
		 public void Penyanyi_2017(String penyanyi_2017) {this.penyanyi_2017 = penyanyi_2017;}
		 
		 public int Durasi_2017() {return durasi_2017;}
		 public void Durasi_2017(int durasi_2017) {this.durasi_2017 = durasi_2017;}
		
		
		public String toString() {
			return "\nJudul : " + judul_2017 + 
					"\nPenyanyi : " + penyanyi_2017 + 
					"\nDurasi: "+ durasi_2017;
					}
	}



