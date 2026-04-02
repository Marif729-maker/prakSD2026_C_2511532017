package pekan1_2511532017;
import java.util.*;
public class ADTmobil_2511532017 {
	  private static final int MAX = 10; 
	    
	
	    private String[] Nama  = new String[MAX];
	    private int[]    Tahun = new int[MAX];
	    private int[]    Cc    = new int[MAX];
	    private long[]   Harga = new long[MAX];
	    private String[] Merk  = new String[MAX];
	    private int jumlah = 0;

	    public String getNama(int i)  { return isValid(i) ? Nama[i] : null; }
	    public int getTahun(int i)    { return isValid(i) ? Tahun[i] : 0; }
	    public int getCc(int i)       { return isValid(i) ? Cc[i] : 0; }
	    public long getHarga(int i)   { return isValid(i) ? Harga[i] : 0; }
	    public String getMerk(int i)  { return isValid(i) ? Merk[i] : null; }
	    
	    public void setNama(int i, String nama) { if (isValid(i)) Nama[i] = nama; }
	    public void setTahun(int i, int tahun)  { if (isValid(i)) Tahun[i] = tahun; }
	    public void setCc(int i, int cc)        { if (isValid(i)) Cc[i] = cc; }
	    public void setHarga(int i, long harga) { if (isValid(i)) Harga[i] = harga; }
	    public void setMerk(int i, String merk) { if (isValid(i)) Merk[i] = merk; }
	    
	    private boolean isValid(int i) {
	        return i >= 0 && i < jumlah;
	    }

	    
	    public boolean tambahMobil(String nama, int tahun, int cc, long harga, String merk) {
	        if (jumlah < MAX) {
	            Nama[jumlah] = nama;
	            Tahun[jumlah] = tahun;
	            Cc[jumlah] = cc;
	            Harga[jumlah] = harga;
	            Merk[jumlah] = merk;
	            jumlah++;
	            return true;
	        }
	        System.out.println("[!] Gagal: Daftar mobil sudah penuh (maks " + MAX + ")");
	        return false;
	    }
	    public boolean hapusMobil(int index) {
	        if (index >= 0 && index < jumlah) {
	            for (int i = index; i < jumlah - 1; i++) {
	                Nama[i]  = Nama[i + 1];
	                Tahun[i] = Tahun[i + 1];
	                Cc[i]    = Cc[i + 1];
	                Harga[i] = Harga[i + 1];
	                Merk[i]  = Merk[i + 1];
	            }
	           
	            Nama[jumlah - 1]  = null;
	            Tahun[jumlah - 1] = 0;
	            Cc[jumlah - 1]    = 0;
	            Harga[jumlah - 1] = 0;
	            Merk[jumlah - 1]  = null;
	            jumlah--;
	            return true;
	        }
	        return false;}
	    
	    public void cetakSemua() {
	        System.out.println("=== Daftar Mobil ===");
	        for (int i = 0; i < jumlah; i++) {
	            System.out.printf("[%d] %s | %d | %d cc | Rp %,d | %s%n",
	                    i, Nama[i], Tahun[i], Cc[i], Harga[i], Merk[i]);
	        }}

}