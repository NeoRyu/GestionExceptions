package shell;
import java.lang.reflect.Method;

import shell.ErrorRedirect;

// CLASSE GENERANT DES ERREURS...
public class Principal {
	
	// Obtention des object associés à cette classe

	public static boolean viewFatalError = false;
	public static boolean viewBloc = false;	
	public static ErrorRedirect Error;
	
	public static void main(String[] args) {
		try {
			System.out.println("CREATION D'ERREURS");
			
			// CREATION D'ERREURS SUR DIVERS PACKAGE :
			
			test3("");	// Exception Personnelle			
			
			test2();	// JAVA IO *Exception;
			
			test1();	// JAVA LANG *Exception;
			
			test0();	// JAVA LANG *Exception;
			
		} catch (Exception e) {
			System.out.println("\nCALLBACK CATCH EXCEPTION : shell.Principal");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e);
			
			System.out.println("Fermeture de l'application...");
		}		
	}
	
	
	// AUCUNE ERREUR DANS CETTE METHODE
	public static void test0() {
		System.out.println("\n--------------------------\nMETHODE 0");
		try {
			if (viewBloc) 
				System.out.println("TRY");		

			System.out.println("\nICI TOUT CE PASSE BIEN !\n");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			// Divers moyen d'afficher le message d'erreur (surcharge de methode)
			shell.ErrorRedirect.Reflexivite();			
			if (ErrorRedirect.m != null && !ErrorRedirect.m.isEmpty())
				shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			else if (ErrorRedirect.c != null && !ErrorRedirect.c.isEmpty())
				shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c);
			else
				shell.ErrorRedirect.RedErreurs(e);

		} 
	}
	
	// ERREURS DE TYPE : JAVA.LANG.*Exception;
	public static void test1() {
		System.out.println("\n--------------------------\nMETHODE 1");
		int tab[] = new int[9];
		try {
			if (viewBloc) 
				System.out.println("TRY");	
			
			// ArrayIndexOutOfBoundsException			
			for(int i = 0 ; i < 1 ; i++) {
				i = i-1;
				System.out.println(""+tab[10]);
			}
			
			// NoSuchMethodException
			shell.ErrorRedirect.Reflexivite();
			Method method = ErrorRedirect.c.getClass().getMethod(ErrorRedirect.c, null);
			ErrorRedirect.m = method.getName().toString();
			System.out.println(ErrorRedirect.m);  
			
			// Si une erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println("\nCa roule mec ?\n");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			
			// SI VOUS MODIFIEZ MAIS EN RECREANT UNE SECONDE ERREUR :
			if (viewFatalError) 
				System.out.println("RESULTAT : "+tab[9]);

		} finally {	//Traitements pour terminer proprement
			if (viewBloc) 
				System.out.println("FINALLY");				
		}
		if (viewBloc) 
			System.out.println("SORTIE DU BLOC TRY / CATCH !");
	}
	
	// ERREUR DE TYPE JAVA.IO.*Exception;
	public static void test2() {
		System.out.println("\n--------------------------\nMETHODE 2");
		try {
			if (viewBloc) 
				System.out.println("TRY");				
			
			// TODO : GENERER UNE ERREUR I/O ici (pourquoi pas serializable)
			
			
			
			// Si l'erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println("\nCa roule mec ?\n");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);

		} 
	}
	
	// ERREUR CUSTOM PAR LE DEVELOPPEUR	
	public static void test3(String chaine) throws NombreException {
		System.out.println("\n--------------------------\nMETHODE 3");
		try {
			if (viewBloc) 
				System.out.println("TRY");	
			
			if (chaine.equals("") == true)
				throw new NombreException("Nombre erronée : chaine vide !");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);

		}
	}
}


