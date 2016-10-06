package shell;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import shell.ErrorRedirect;

// CLASSE GENERANT DES ERREURS...
public class Principal {
	
	// INSTANCIATION DE LA CLASSE DE GESTION DES EXCEPTIONS SYSTEMES
	public static ErrorRedirect Error;
	
	
	// CONFIGURATION : true / false
	public static boolean viewFatalError = false;
	public static boolean viewBloc = false;	
	
	
	// DEBUT DU PROGRAMME
	public static void main(String[] args) {
		
		// CREATION D'UN LOGGER 
		// (mettre LOG etc hors de la methode pour l'utiliser ailleurs)
		Principal osef = new Principal();		
		Logger LOG = Logger.getLogger(Principal.class.getName());	
		
		try {
			System.out.println("CREATION D'ERREURS");
			LOG.log(Level.INFO, "Démarrage de l'application");	
			System.out.print("");
			
			// CREATION D'ERREURS SUR DIVERS PACKAGE :
			
			test3("");	// Exception Personnelle			
			
			// false = erreur au premier tour puis resolution
			// true = pas d'erreur (identique a resolution)
			
			test2(false);
			
			test1(false);
			
			test0();
			
		} catch (Exception e) {	
			System.out.println("\n"); 
			LOG.log(Level.SEVERE, "Fermeture de l'application...");
					   /* SEVERE (highest value)
						* WARNING
						* INFO
						* CONFIG
						* FINE
						* FINER
						* FINEST (lowest value)
						*/
			System.out.println("\nCALLBACK CATCH EXCEPTION : shell.Principal");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e);
		}		
	}
	
	
	// AUCUNE ERREUR DANS CETTE METHODE
	public static void test0() {
		System.out.println("\n--------------------------\nMETHODE 4/4");
		try {
			if (viewBloc) 
				System.out.println("TRY");		

			System.out.println("\n TOUT CE PASSE BIEN !\n");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			System.out.println("Oups, il ne devait pas y avoir d'erreur ici !");
			
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
	public static void test1(boolean error) {
		System.out.println("\n--------------------------\nMETHODE 3/4");
	
		// Declaration hors du TRY pour etre accessible dans le CATCH :
		int tab[] = new int[9];
		
		try {
			if (viewBloc) 
				System.out.println("TRY");	
			
			// ArrayIndexOutOfBoundsException				
			for(int i = 0 ; i < 9 ; i++) {
				tab[i] = i;
				if (!error)
					if (i == 9)
						System.out.println(""+tab[10]);
				else
					if (i == 9)
						System.out.println(""+tab[9]);
			}
			
			if (!error) {
				// NoSuchMethodException
				shell.ErrorRedirect.Reflexivite();
				Method method = ErrorRedirect.c.getClass().getMethod(ErrorRedirect.c, null);
				ErrorRedirect.m = method.getName().toString();
				System.out.println(ErrorRedirect.m);  
				// Genere normallement une exception
			}
			
			// Si une erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println("\nHello World !!!\n");
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			
			System.out.println("Oups, reessayont autrement !");

		} finally {	//Traitements pour terminer proprement
			if (viewBloc) 
				System.out.println("FINALLY");	
			
			//RESOLUTION DE L'ERREUR
			// SI VOUS MODIFIEZ MAIS EN RECREANT UNE SECONDE ERREUR :
			if (viewFatalError) {
				System.out.println("RESULTAT : "+tab[12]);
			} else {
				if (!error) {			
					try {
						test1(true);
					} catch (Exception e) {
						if (viewBloc) 
							System.out.println("CATCH");
						
						shell.ErrorRedirect.Reflexivite();			
						shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
					}
				}	
			}
		}
		if (viewBloc) 
			System.out.println("SORTIE DU BLOC TRY / CATCH !");
	}
	
	// ERREUR DE TYPE JAVA.IO.*Exception;
	public static void test2(boolean error) {
		System.out.println("\n--------------------------\nMETHODE 2/4");
		try {
			if (viewBloc) 
				System.out.println("TRY");			
			
			// 1- Creation d'un fichier et envoi
			String objetEnvoi = "Hello world !!";
			FileOutputStream fos = new FileOutputStream("fichier.temp");			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			GZIPOutputStream gzout = new GZIPOutputStream(oos);			
			oos.writeObject(objetEnvoi);
			oos.close();
			fos.close();

			// 2- Reception (& //decompression) pour affichage
			FileInputStream fis  = new FileInputStream("fichier.temp");
			ObjectInputStream ois = new ObjectInputStream(fis);	
			if (error) 
			{
				GZIPInputStream gzin = new GZIPInputStream(ois);
			}
			String objetRecu = (String) ois.readObject();
			ois.close();
			fis.close();
			
			// Si l'erreur apparait comme prévue, le message suivant n'apparaitra pas :
			System.out.println(objetRecu);
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			
			System.out.println("Oups, reessayont autrement !");

		} finally {	//Traitements pour terminer proprement
			if (viewBloc) 
				System.out.println("FINALLY");
			
			if (!error) {
				try {
					test2(true);
				} catch (Exception e) {
					if (viewBloc) 
						System.out.println("CATCH");
					
					shell.ErrorRedirect.Reflexivite();			
					shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
				}
			}	
			
		}
	}
	
	// ERREUR CUSTOM PAR LE DEVELOPPEUR	
	public static void test3(String chaine) throws NombreException {
		System.out.println("\n--------------------------\nMETHODE 1/4");
		try {
			if (viewBloc) 
				System.out.println("TRY");	
			
			if (chaine.equals("") == true)
				throw new NombreException("Nombre erronée : chaine vide !");
			else
				System.out.println(chaine);
			
		} catch (Exception e) {
			if (viewBloc) 
				System.out.println("CATCH");
			
			shell.ErrorRedirect.Reflexivite();			
			shell.ErrorRedirect.RedErreurs(e,ErrorRedirect.c,ErrorRedirect.m);
			
			System.out.println("Oups, reessayont autrement !");
			
			// RESOLUTION ERREUR :
			test3("Hello World !");
		} 
	}
}


