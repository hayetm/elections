package elections;

public class ElectionsExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ElectionsExceptions() {
		super();
	}
	
	public ElectionsExceptions(String message) {
		super(message);
	}
	
	public ElectionsExceptions(Throwable cause) {
		super(cause);
	}
	
	public ElectionsExceptions(String message, Throwable cause) {
		super(message, cause);
	}
}
