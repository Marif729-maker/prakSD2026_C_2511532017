package pekan3_2511532017;

public class Website_2511532017 {
	
	 private String judul_2017; 
	 private String URL_2017;
	 
	//constructor 
	 public Website_2511532017(String judul_2017, String URL_2017){
			this.judul_2017 = judul_2017;
			  if (URL_2017 == null || URL_2017.trim().isEmpty()) {
		            System.out.println("❌ Error: URL tidak boleh kosong!");
		        } else {
		            this.URL_2017 = URL_2017.trim();
		        }
		    }

	 //getter dan setter
	 public String getJudul_2017() {return judul_2017;}
	 public void setJudul_2017(String judul_2017) {this.judul_2017 = judul_2017;}
	 
	 public String getURL_2017() {return URL_2017;}
	  public void setURL_2017(String URL_2017) { 
		  if (URL_2017== null || URL_2017.trim().isEmpty()) {
			  System.out.println("URL tidak boleh kosong");
	     } else {this.URL_2017 = URL_2017.trim();}
		  }
	  
	@Override
	  public String toString() {
			 return "\n Nama Website: " + judul_2017 +
					 "\nURL : "+ URL_2017;
}
}