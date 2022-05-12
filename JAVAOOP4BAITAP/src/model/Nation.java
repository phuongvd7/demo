package model;

	import java.util.Scanner;

	public class Nation {
		private String quocGia;
		private int maVung;
		private Person[] persons;
		
		public Nation() {
			
		}

		public String getQuocGia() {
			return quocGia;
		}

		public void setQuocGia(String quocGia) {
			this.quocGia = quocGia;
		}

		public int getMaVung() {
			return maVung;
		}

		public void setMaVung(int maVung) {
			this.maVung = maVung;
		}

		public Person[] getPersons() {
			return persons;
		}

		public void setPersons(Person[] persons) {
			this.persons = persons;
		}
		
		//input
		public void input() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap quoc gia: ");
			this.setQuocGia(sc.nextLine());
			
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Nhap ma vung: ");
			this.setMaVung(sc1.nextInt());
		}
		
		//info
		public void info() {
			System.out.println("---------------");
			System.out.println("Quoc gia: " + quocGia + "| " + "Ma vung: " + maVung);
		}
	}

