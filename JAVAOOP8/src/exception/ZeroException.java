package exception;

public class ZeroException extends Exception{
	private String error;
	
	public ZeroException(String err) {
		super();
		this.error = err;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
