package Shell;
import Shell.ErrorRedirect;
/*
 * PAGE DE TESTS AFFICHAGE ERREURS
 * 
 * Vous pouvez mettre dans la methode test n'importe quel type d'erreur
 * PS :  Toutes les exceptions ne sont pas g�r�es, mais dans ce cas l� ce
 *       sera Exception qui h�ritera des erreurs non trait�es par defaut.
 */

import java.lang.reflect.Method;

// CLASSE GENERANT DES ERREURS...
public class Principal {
	
	// Obtention des object associ�s � cette classe

	
	public static ErrorRedirect Error;
	
	public static void controle(String chaine) throws NombreException {
		if (chaine.equals("") == true)
		throw new NombreException("Nombre erron�e : chaine vide !");
	}
		
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			Shell.ErrorRedirect.Reflexivite();
			System.out.println("ERREUR MAIN !");
			Shell.ErrorRedirect.RedErreurs(e);
		}		
	}
	
	public static void test() {
		
		try {							// TODO : Creer des erreurs ici ! =)
			System.out.println("TRY");
			/*
			// CREATION D'UNE ERREUR 
			Method method = classe.getClass().getMethod(c, null);
			m = method.getName().toString();
			System.out.println(m);  
			*/
			
			
			// MET TON ERREUR ICI ! =)
			int tab[] = new int[4];
			for(int i = 0 ; i < 1 ; i++) {
				i = i-1;
				System.out.println(""+tab[10]);
			}
			
			
			
			

			System.out.println("\nCa roule mec ?\n");
		} catch (Exception e) { 		// TODO : Pointeur de redirection
			Shell.ErrorRedirect.Reflexivite();
			System.out.println("CATCH");
			if (ErrorRedirect.m != null && !ErrorRedirect.m.isEmpty())
				Shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			else if (ErrorRedirect.c != null && !ErrorRedirect.c.isEmpty())
				Shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c);
			else
				Shell.ErrorRedirect.RedErreurs(e);

		} finally {						// TODO : Traitements pour terminer proprement		
			System.out.println("FINALLY");
				
		}
		System.out.println("SORTIE DU BLOC TRY / CATCH !");
	}
}


