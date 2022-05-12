package bai1;

public enum FoodMenu {
	CAFE(1,"Cafe"), MILK_TEA(2,"Milk Tea"); // co thuoc tinh, phai fix cung truoc

	
	private int id;
	private String name;
	
	private FoodMenu(int id, String name) { // contructor la private chu ko public
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) { // enum ko dung ham set nua vi fix cung contructor roi =))
		this.name = name;
	}
	
	public static void main(String[] args) {
		
		for(FoodMenu fms : FoodMenu.values()) {
			System.out.println(fms.getId() + " - " + fms.getName());
	//		System.out.println(fms);
	//		System.out.println(FoodMenu.CAFE.toString());
		}
	}

}
