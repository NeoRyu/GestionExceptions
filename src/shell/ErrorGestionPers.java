package shell;
/*	GESTIONNAIRES D'EXCEPTIONS PERSONNALIS�ES
 * 
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Fr�d�ric
 *  @DateCreation     :  31 AO�T 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de g�rer chaque exception de mani�re plus simple :
 * 				 public static ErrorGestionPers Error = new ErrorGestionPers();
 *				 try { }(catch (typeexception e) { Error.gestionException(e); }
 */

// LIBRAIRIES


// GESTIONNAIRES D'EXCEPTIONS PERSONNALIS�ES
public class ErrorGestionPers {
	private static final long serialVersionUID = 1L;
	
	public void gestionException(NombreException e){
		System.out.println("NombreException : "+e.toString());
	}	// Signale une erreur personnalis�e.
	

}
