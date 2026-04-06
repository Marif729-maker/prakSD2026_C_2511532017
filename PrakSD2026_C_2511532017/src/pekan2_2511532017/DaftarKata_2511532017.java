package pekan2_2511532017;
import java.util.*;
public class DaftarKata_2511532017 {
private final ArrayList<String> data;

public DaftarKata_2511532017() {
	this.data = new ArrayList<>();
}
public void tambah_2511532017 (String elemen) {
	data.add(elemen);
}
public void tambahPada_2511532017(int index, String elemen) {
	data.add(index, elemen);
	}
public void ubahElement_2511532017(int index, String nilaiBaru) {
	data.set(index, nilaiBaru);
}

public String hapusElemen_2511532017(int index) {
	return data.remove(index);
}public void iterasiCetak_2511532017() {
	for(int i = 0; i< data.size(); i++) {
		System.out.print(data.get(i)+ " ");
	}
}
public String get (int index) {
	return data.get(index);
	}

public String toString () {
	return data.toString();
}
}
