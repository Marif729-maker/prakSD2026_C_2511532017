package pekan7_2511532017;

public class MahasiswaSort_2511532017 {
	private String nim_2017;
	private String nama_2017;
	private String prodi_2017;
	MahasiswaSort_2511532017(String nim_2017, String nama_2017, String prodi_2017){
		this.nim_2017 = nim_2017;
		this.nama_2017 = nama_2017;
		this.prodi_2017 = prodi_2017;
	}
	 public String Nim_2017() {return nim_2017;}
	 public void Nim_2017(String nim_2017) {this.nim_2017 = nim_2017;}
	 
	 public String Nama_2017() {return nama_2017;}
	 public void Nama_2017(String nama_2017) {this.nama_2017 = nama_2017;}
	 
	 public String Prodi_2017() {return prodi_2017;}
	 public void Prodi_2017(String prodi_2017) {this.prodi_2017 = prodi_2017;}
	
	
	public String toString() {
		return "\nNIM : " + nim_2017 + 
				"\nNama : " + nama_2017 + 
				"\nProdi: "+ prodi_2017;
				}
}
