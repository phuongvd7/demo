package model;

	import java.util.Scanner;

	public class House {
		private int id_House;
		private String address_House;
		private Person owner;	// quan he doi tuong 	1 nhieu
		public House() {		
		}
		
		public House(int id_House, String address_House, Person owner) {
			super();
			this.id_House = id_House;
			this.address_House = address_House;
			this.owner = owner;
		}

		
		public int getId_House() {
			return id_House;
		}
		public void setId_House(int id_House) {
			this.id_House = id_House;
		}
		

		
		public String getAddress_House() {
			return address_House;
		}
		public void setAddress_House(String address_House) {
			this.address_House = address_House;
		}


		public Person getOwner() {
			return owner;
		}

		public void setOwner(Person owner) {
			this.owner = owner;
		}

		//input
		public void input() {
			System.out.println("INFORMATION HOUSE !");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id_House: ");
			id_House = sc.nextInt();
			
			
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter address_House: ");
			address_House = sc2.nextLine();
			
		}
		
		//infor
		public void infor() {
			System.out.println("--------");
			System.out.println(" Thong tin nha ");
			System.out.println("id_House: " + id_House + "address_House: " + address_House );
		}
}
