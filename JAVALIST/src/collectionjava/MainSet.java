package collectionjava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MainSet {//doi voi ham set khi hai doi tuong giong nhau thi bo di => ket hop them hashcode de check doi tuong
	//ham set khong sap xep dc
	public static void main(String[] args) {
		Set<MonHoc> setMH = new HashSet<MonHoc>();
		
		System.out.println(setMH.size());
		System.out.println(setMH.isEmpty());
		
		MonHoc v1 = new MonHoc();
		v1.setTenMonHoc("V1");
		
		MonHoc v2 = new MonHoc();
		v2.setTenMonHoc("V2");
		
		setMH.add(v1);
		setMH.add(v1);
		setMH.add(v2);
		
		System.out.println(setMH.size());
		
		for(MonHoc mh : setMH) {
			System.out.println(mh.getTenMonHoc());
			
		}
//		setMH.remove(v1);
		
		Iterator<MonHoc> iterator = setMH.iterator();
		//xoa
		
		while(iterator.hasNext()) {
			MonHoc mh = iterator.next();
			
			if(mh.getTenMonHoc().equals("V1"))
				iterator.remove();
		}
		MonHoc v3 = new MonHoc();
		v3.setTenMonHoc("V2");//ten = v2
		if(v2.getTenMonHoc().equals(v3.getTenMonHoc()))
			System.out.println("trung nhau");
		
		setMH.add(v3);// bi trung v2 theo tieu chi ten mh
		
		System.out.println(setMH.size());//3
	}
}
