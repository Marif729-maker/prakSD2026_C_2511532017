package pekan2_2511532017;

public class Music_2511532017 {
	//tempat nyimpan variabel
 private String judul_2017; 
 private String penyanyi_2017;
 private int durasi_2017;
 
 //constructor
 public Music_2511532017(String judul_2017, String penyanyi_2017, int durasi_2017){
		this.judul_2017 = judul_2017;
		this.penyanyi_2017 = penyanyi_2017;
		this.durasi_2017 = durasi_2017;
		
		}
 // setter dan getter
 public String getJudul_2017() {return judul_2017;}
 public void setJudul_2017(String judul_2017) {this.judul_2017 = judul_2017;}
 
 public String getPenyanyi_2017() {return penyanyi_2017;}
  public void setPenyanyi_2017(String penyanyi_2017) {this.penyanyi_2017 = penyanyi_2017;}
 
 public int getDurasi_2017() {return durasi_2017;}
 public void setDurasi_2017(int durasi_2017) {
     if (durasi_2017 > 0) {
         this.durasi_2017 = durasi_2017;
     } else {
         System.out.println("Durasi lagu harus lebih dari 0 detik");
         this.durasi_2017 = 0; }}

 @Override 
 public String toString() {
		return "\njudul lagu : " + judul_2017 + 
				"\npenyanyi: " + penyanyi_2017 + 
				"\ndurasi lagu: "+ durasi_2017 + " detik";
}
}