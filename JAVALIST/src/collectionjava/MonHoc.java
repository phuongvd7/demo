package collectionjava;

import java.io.Serializable;

public class MonHoc implements Serializable{//bat buoc phai implement
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10L;
	private String tenMonHoc;

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	@Override// class object
	public boolean equals(Object obj) {
		if(obj instanceof MonHoc) {
			MonHoc mh = (MonHoc) obj;
			if (mh.getTenMonHoc().equals(this.getTenMonHoc()))
				return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.tenMonHoc.length();
	}
	
}
