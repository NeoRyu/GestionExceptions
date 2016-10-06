package shell;
import java.lang.reflect.Method;

import shell.ErrorRedirect;

// CLASSE GENERANT DES ERREURS...
public class Principal {
	
	// Obtention des object associés à cette classe

	public static boolean viewBloc = false;
	public static ErrorRedirect Error;
	
	public static void main(String[] args) {
		try {
			System.out.println("CREATION D'ERREURS");
			
			// CREATION D'ERREURS SUR DIVERS PACKAGE :
			
			test();		// JAVA.LANG.*Exception;
			
			test2();	// JAVA.IO.*Exception;
			
			test3("");	// Exception Personnelle
			
		} catch (Exception e) {
			System.out.println("ERREUR MAIN !");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e);
		}		
	}
	
	
	public static void test() {		// JAVA.LANG.*Exception;
		System.out.println("\n--------------------------\nTEST 1");
		try {
			if (viewBloc) System.out.println("TRY");	
			
			// ArrayIndexOutOfBoundsException
			int tab[] = new int[4];
			for(int i = 0 ; i < 1 ; i++) {
				i = i-1;
				System.out.println(""+tab[10]);
			}
			
			// Si l'erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println("\nCa roule mec ?\n");
			
		} catch (Exception e) {
			if (viewBloc) System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);

		} finally {	//Traitements pour terminer proprement
			if (viewBloc) System.out.println("FINALLY");				
		}
		if (viewBloc) System.out.println("SORTIE DU BLOC TRY / CATCH !");
	}
	
	
	public static void test2() {	// JAVA.IO.*Exception;
		System.out.println("\n--------------------------\nTEST 2");
		try {
			if (viewBloc) System.out.println("TRY");				
			
			// NoSuchMethodException
			shell.ErrorRedirect.Reflexivite();
			Method method = ErrorRedirect.c.getClass().getMethod(ErrorRedirect.c, null);
			ErrorRedirect.m = method.getName().toString();
			System.out.println(ErrorRedirect.m);  
			
			// Si l'erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println("\nCa roule mec ?\n");
			
		} catch (Exception e) {
			if (viewBloc) System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			if (ErrorRedirect.m != null && !ErrorRedirect.m.isEmpty())
				shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			else if (ErrorRedirect.c != null && !ErrorRedirect.c.isEmpty())
				shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c);
			else
				shell.ErrorRedirect.RedErreurs(e);

		} 
	}
	
	public static void test3(String chaine) throws NombreException {
		System.out.println("\n--------------------------\nTEST 3");
		try {
			if (viewBloc) System.out.println("TRY");	
			
			if (chaine.equals("") == true)
				throw new NombreException("Nombre erronée : chaine vide !");
			
		} catch (Exception e) {
			if (viewBloc) System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);

		}
	}
}


