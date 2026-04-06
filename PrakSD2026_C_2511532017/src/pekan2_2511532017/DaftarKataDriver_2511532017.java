package pekan2_2511532017;

public class DaftarKataDriver_2511532017 {

	public static void main(String[] args) {
		DaftarKata_2511532017 al = new DaftarKata_2511532017();
		
//		menambah elemen (akhir)
		al.tambah_2511532017("kami");
		al.tambah_2511532017("informatika");
		
		//menyisipkan elemen pada index 1
		al.tambahPada_2511532017(1, "Mahasiswa");
		
		//cetak isi awal
		System.out.println("Awal   : "+ al);
		
		//mengubah elemen (index 1)
		al.ubahElement_2511532017(1, "Departemen");
		System.out.println("Setelah Ubah :" + al);
		
		//hapus index 0
		String terhapus_2511532017 = al.hapusElemen_2511532017(0);
		System.out.println("Terhapus  :" + terhapus_2511532017);
		System.out.println("Setelah Hapus :" + al);
		
		//iterasi pada ArrayList (cetak setiap elemen)
		System.out.print("Iterasi:");
		al.iterasiCetak_2511532017();
		System.out.println();

	}

}
