package collectionjava;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
public class MainMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//key/value
			Map<Integer, MonHoc> map = new TreeMap<>();//nhu 1 danhsach nhung quan li ca vi tri cua doi tuong
			//map thi tim kiem doi tuong nhanh hon
			//list thi co the sap xep
			//set thi them xoa du lieu trung
			System.out.println(map.size());
			System.out.println(map.isEmpty());
			
			MonHoc v1 = new MonHoc();
			v1.setTenMonHoc("V1");
			
			MonHoc v2 = new MonHoc();
			v2.setTenMonHoc("V2");
			
			map.put(1, v1);
			map.put(2, v2);
			map.put(3, v1);
			//overide
			
			map.put(3,  v2);
			
			//xoa
			map.remove(3);
			
			MonHoc mh = map.get(2);//v2
			
			for (java.util.Map.Entry<Integer, MonHoc> entry : map.entrySet()) {
				System.out.println(entry.getKey());
				System.out.println(entry.getValue().getTenMonHoc());
			}
			
			Set<Integer> keySet = map.keySet();
			
	}

}
