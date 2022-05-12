package filejava;

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
	
}
