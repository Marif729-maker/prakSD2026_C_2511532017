package pekan1_2511532017;


	public final class Jam_2511532017{
		private int hh;
		private int mm;
		private int ss;
		
		public static boolean isValid(int h, int m, int s) {
			return (0<=h && h <= 23) && (0<=m && m <= 59) && (0<=s && s <= 59);
			
		}
		public Jam_2511532017(int h, int m, int s) {
			this.hh=h; this.mm=m; this.ss=s;
			}
		public int getHour() {return hh;}
		public int getMinute() {return mm;}
		public int getSecond() {return ss;}
		
		public void setHour(int h) {this.hh=h;}
		public void setMinute(int m) {this.mm=m;}
		public void setSecond(int s) {this.ss=s;}
		
		public int toSeconds () {return hh*3600 + mm * 60 + ss; }
		public static Jam_2511532017 fromSeconds (int total) {
			if (total < 0 ) throw new IllegalArgumentException ("detik negatif");
			total %= 24 * 3600;
			int h = total/3600; total %=3600;
			int m = total/60; int s = total % 60;
			return new Jam_2511532017 (h, m,s);
		}
		
		public int compareTo (Jam_2511532017 other) {return Integer.compare(this.toSeconds(),other.toSeconds());}
		public boolean equals (Object o) {
			if (!(o instanceof Jam_2511532017 j)) return false;
			return hh == j.hh && mm==j.mm && ss==j.ss;
		}
		public int hashCode() {return java.util.Objects.hash(hh,mm,ss); }
		
		public Jam_2511532017 plus (Jam_2511532017 other) {return fromSeconds(this.toSeconds()+other.toSeconds());}
		public Jam_2511532017 minus (Jam_2511532017 other) {return fromSeconds(Math.floorMod(this.toSeconds()-other.toSeconds(), 24*3600));}
		public Jam_2511532017 nextSeconds () {return fromSeconds(this.toSeconds()+1);}
		public Jam_2511532017 nextNSeconds (int n) {return fromSeconds(this.toSeconds()+Math.max(0, n));}
		public Jam_2511532017 prevSeconds () {return fromSeconds(Math.floorMod(this.toSeconds()-1, 24*3600));}
		public Jam_2511532017 prevNSeconds (int n) {return fromSeconds(Math.floorMod(this.toSeconds()-Math.max(0, n), 24*3600));}
		
		public static int durasiDetik (Jam_2511532017 jaw, Jam_2511532017 jakh) {return jakh.toSeconds()-jaw.toSeconds();}
		
		public String toString () {return String.format("%02d:%02d:%02d", hh,mm,ss);}
		}
		

	

