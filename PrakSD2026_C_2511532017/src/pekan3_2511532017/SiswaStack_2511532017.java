package pekan3_2511532017;

import java.util.*;
 class Siswa_2511532017 {
	 String nama_2017;
	 int nim_2017;
	 
	 public Siswa_2511532017 (String nama_2017, int nim_2017) {
		 this.nama_2017 = nama_2017;
		 this.nim_2017 = nim_2017;
		 
	 }
	 public String toString() {
		 return "Nim : " + nim_2017 +", Nama : "+ nama_2017;
	 }
}

 
public class SiswaStack_2511532017 {
	private ArrayList<Siswa_2511532017>stack;
	
	public SiswaStack_2511532017 () {
		stack = new ArrayList<>();
		
	}
	public void push (Siswa_2511532017 mhs) {
		stack.add(mhs);
	}
	public Siswa_2511532017 pop() {
		if(!isEmpty()) {
			return stack.remove(stack.size()-1);
			
		}return null;
	}
	
	public Siswa_2511532017 peek() {
		if(!isEmpty()) {
			return stack.get(stack.size()-1);
		}return null;
	}
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public void tampilkanSiswa_2511532017() {
		for (int i = stack.size()-1; i>=0; i--) {
			System.out.println(stack.get(i));
		}
	}
	public static void main(String[]args) {
		SiswaStack_2511532017 studentStack = new SiswaStack_2511532017();
		
		Siswa_2511532017 mhs1 = new Siswa_2511532017 ("Ali", 1);
		Siswa_2511532017 mhs2 = new Siswa_2511532017 ("Boby", 2);
		Siswa_2511532017 mhs3 = new Siswa_2511532017 ("Charles", 3);
		
		studentStack.push(mhs1);
		studentStack.push(mhs2);
		studentStack.push(mhs3);
		
		System.out.println("siswa dalam stack ");
		studentStack.tampilkanSiswa_2511532017();
		
		System.out.println("siswa teratas : "+ studentStack.peek() );
		System.out.println("mengeluarkan siswa teratas dari stack : "+ studentStack.pop());
		studentStack.tampilkanSiswa_2511532017();
	}
	
}
