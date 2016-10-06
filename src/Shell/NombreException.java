package Shell;

//Un petit exemple de classe d'exception personnalisée
public class NombreException extends Exception {
	private static final long serialVersionUID = 1L;

	public NombreException() {
		  super();
	}
	  
	public NombreException(int s) {
		  super(Integer.toString(s));
	}	

	public NombreException(String s) {
		super(s);
	}	
	
	public NombreException(Exception s) {
		super(s.getStackTrace().toString());
	}
	
}
