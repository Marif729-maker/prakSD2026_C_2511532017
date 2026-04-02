package pekan1_2511532017;

public class driverMobil_2511532017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Inisialisasi objek ADT
        ADTmobil_2511532017 dataMobil = new ADTmobil_2511532017();

        System.out.println("--- Menambah Data Mobil ---");
        dataMobil.tambahMobil("Avanza", 2020, 1300, 150000000, "Toyota");
        dataMobil.tambahMobil("Civic", 2021, 1500, 350000000, "Honda");
        dataMobil.tambahMobil("Pajero", 2019, 2400, 550000000, "Mitsubishi");
        dataMobil.cetakSemua();
       
        System.out.println("\n--- gett (Index 0) ---");
        System.out.println("Nama  : " + dataMobil.getNama(0));
        System.out.println("Tahun : " + dataMobil.getTahun(0));
        System.out.println("CC    : " + dataMobil.getCc(0));
        System.out.println("Harga : Rp " + dataMobil.getHarga(0));
        System.out.println("Merk  : " + dataMobil.getMerk(0));
     
        System.out.println("\n--- set (index 1) ---");
        System.out.println("Sebelum: " + dataMobil.getNama(1) + " | Tahun " + dataMobil.getTahun(1) + " | Rp " + dataMobil.getHarga(1));
        dataMobil.setTahun(1, 2023);
        dataMobil.setHarga(1, 360000000);
        System.out.println("Sesudah: " + dataMobil.getNama(1) + " | Tahun " + dataMobil.getTahun(1) + " | Rp " + dataMobil.getHarga(1));
  
        System.out.println("\n--- Test Hapus Mobil (Index 0) ---");
        boolean berhasil = dataMobil.hapusMobil(0);
        if (berhasil) {System.out.println();
            System.out.println("Berhasil menghapus data index 0.");
        }
        dataMobil.cetakSemua();
        System.out.println("\n=== Program Selesai ===");
    
}
	}


