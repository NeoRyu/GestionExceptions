package shell;
/*	GESTIONNAIRES D'EXCEPTIONS PERSONNALISÉES
 * 
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Frédéric
 *  @DateCreation     :  31 AOÛT 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de gérer chaque exception de manière plus simple :
 * 				 public static ErrorGestionPers Error = new ErrorGestionPers();
 *				 try { }(catch (typeexception e) { Error.gestionException(e); }
 */

// LIBRAIRIES


// GESTIONNAIRES D'EXCEPTIONS PERSONNALISÉES
public class ErrorGestionPers {
	private static final long serialVersionUID = 1L;
	
	public void gestionException(NombreException e){
		System.out.println("NombreException : "+e.toString());
	}	// Signale une erreur personnalisée.
	

}
