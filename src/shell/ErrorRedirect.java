package shell;
/*
 * GESTIONNAIRE DE REDIRECTIONS D'EXCEPTIONS
 *	
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Fr�d�ric
 *  @DateCreation     :  05 OCTOBRE 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de rediriger chaque exception de mani�re plus simple :
 * 				 public static GestionErreurs Error = new GestionErreurs();
 *				 try { }(catch (typeexception e) { Error.gestionException(e); }
 */

import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.lang.reflect.Method;
import java.text.ParseException;
// LIBRAIRIES
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.AuthenticationException;

// GESTIONNAIRE DE REDIRECTIONS D'EXCEPTIONS
public class ErrorRedirect {
	private static final long serialVersionUID = 1L;
 	
	// INSTANCIATIONS
	public static ErrorGestionSys ErrorSys = new ErrorGestionSys();
	public static ErrorGestionPers ErrorPers = new ErrorGestionPers();
	private static final Logger LOGGER = Logger.getLogger( ErrorRedirect.class.getName() );		
		
 	// GESTIONNAIRE DE REDIRECTION DE TRAITEMENT D'ERREURS
	public static void RedErreurs(Exception ex) {		
		try {
			//System.out.println("ERREUR : "+ex +" :\n"+ex.getClass().getName());
			//ex.printStackTrace();
			
			// REDIRECTION VERS LA METHODE DE TRAITEMENT ADEQUATE	
			//System.out.println(ex.getClass().getName());
			switch(ex.getClass().getName()) {
			
				// (16) JAVA.IO.*
				case "java.io.CharConversionException" :
					// Ceci est une classe de base pour les exceptions de conversion de caract�res.
					ErrorSys.gestionException((CharConversionException) ex);
					break;
				case "java.io.EOFException" :
					// Signale une fin innatendue de fichier ou de flux.
					ErrorSys.gestionException((EOFException) ex);
					break;
				case "java.io.FileNotFoundException" :
					// Echec lors de la tentative d'ouvrerture d'une fichier d�sign� par un chemin d'acc�s sp�cifi�.
					ErrorSys.gestionException((FileNotFoundException) ex);
					break;
				case "java.io.InterruptedIOException" :
					// Signale qu'une op�ration d'Entr�e/Sortie � �t� interrompue.
					ErrorSys.gestionException((InterruptedIOException) ex);
					break;
				case "java.io.InvalidClassException" :
					// Lev�e lorsque le moteur d'ex�cution de s�rialisation d�tecte un probl�me avec une classe.
					ErrorSys.gestionException((InvalidClassException) ex);
					break;
				case "java.io.InvalidObjectException" :
					// Indique qu'un ou plusieurs objets d�s�rialis�s ont �chou�s au test de validation.
					ErrorSys.gestionException((InvalidObjectException) ex);
					break;					
				case "java.io.IOException" :
					// Un flux en entr�e/sortie (I/O) a echou� ou a �t� interrompu
					ErrorSys.gestionException((IOException) ex);
					break;
				case "java.io.NotActiveException" :
					// Exception lev�e lorsque s�rialisation ou d�s�rialisation n'est pas active.
					ErrorSys.gestionException((NotActiveException) ex);
					break;
				case "java.io.NotSerializableException" :
					// Exceptions lev�e lorsqu'une instance n�cessite d'avoir une interface Serializable.
					ErrorSys.gestionException((NotSerializableException) ex);
					break;
				case "java.io.ObjectStreamException" :
					// Ceci est une superclasse de toutes les exceptions sp�cifiques � l'objet des classes Stream.
					ErrorSys.gestionException((ObjectStreamException) ex);
					break;
				case "java.io.OptionalDataException" :
					// Indiquant l'�chec d'une op�ration de lecture d'un objet en raison de donn�es primitives
					// non lues, ou la fin des donn�es appartenant � un objet s�rialis� dans le flux.
					ErrorSys.gestionException((OptionalDataException) ex);
					break;
				case "java.io.StreamCorruptedException" :
					// Lev�e lorsque les informations de contr�le lues � partir d'un flux d'objet 
					// violent les contr�les de coh�rence interne.
					ErrorSys.gestionException((StreamCorruptedException) ex);
					break;
				case "java.io.SyncFailedException" :
					// Signale qu'une op�ration de synchronisation a �chou�e.
					ErrorSys.gestionException((SyncFailedException) ex);
					break;
				case "java.io.UnsupportedEncodingException" :
					// Ce codage de caract�res n'est pas pris en charge.
					ErrorSys.gestionException((UnsupportedEncodingException) ex);
					break;
				case "java.io.UTFDataFormatException" :
					// Signale qu'une cha�ne malform�e au format UTF-8 modifi� a �t� lue dans un flux d'entr�e de donn�es
					// ou par toute classe qui impl�mente l'interface d'entr�e de donn�es.
					ErrorSys.gestionException((UTFDataFormatException) ex);
					break;
				case "java.io.WriteAbortedException" :
					// Signale que l'un des ObjectStreamExceptions a �t� lanc� au cours d'une op�ration d'�criture.
					ErrorSys.gestionException((WriteAbortedException) ex);
					break;
					
					
				// (26 - 1(Exception)) JAVA.LANG.*
				case "java.lang.ArithmeticException" :
					// Exception lev�e lorsqu'une condition arithm�tique exceptionnelle a eu lieu.
					ErrorSys.gestionException((ArithmeticException) ex);
					break;
				case "java.lang.ArrayIndexOutOfBoundsException" :
					// Exceptions lev�e quand vous d�passez la taille d'un tableau
					ErrorSys.gestionException((ArrayIndexOutOfBoundsException) ex);
					break;
				case "java.lang.ArrayStoreException" :
					// Indique qu'une tentative a �t� faite pour stocker le mauvais type d'objet dans un tableau d'objets.
					ErrorSys.gestionException((ArrayStoreException) ex);
					break;
				case "java.lang.ClassCastException" :
					// Indique que le code a tent� de throw un objet � une sous-classe dont il n'est pas une instance.
					ErrorSys.gestionException((ClassCastException) ex);
					break;
				case "java.lang.ClassNotFoundException" :
					// Exception soulev�e si une erreur est survenue lors de la tentative de charger une classe 
					ErrorSys.gestionException((ClassNotFoundException) ex);
					break;
				case "java.lang.CloneNotSupportedException" :
					// Indique que la m�thode clone dans la classe Object a �t� appel�e � cloner un objet, 
					// mais que la classe de l'objet ne met pas en oeuvre d'interface Clonable.
					ErrorSys.gestionException((CloneNotSupportedException) ex);
					break;
				case "java.lang.EnumConstantNotPresentException" :
					// Lev�e lorsqu'une application tente d'acc�der � une constante d'une enum par nom,
					// mais que le type enum ne contient pas de constante avec le nom sp�cifi�.
					ErrorSys.gestionException((EnumConstantNotPresentException) ex);
					break;				
				case "java.lang.IllegalAccessException" :
					// Lanc�e lorsqu'une application tente de cr�er reflexivement une instance (autre qu'un tableau), 
					// d�finir ou obtenir un champ, ou invoquer une m�thode ; mais que la m�thode en cours d'ex�cution 
					// n'a pas acc�s � la d�finition de la classe, au champ sp�cifi�, � la m�thode ou au constructeur.
					ErrorSys.gestionException((IllegalAccessException) ex);
					break;
				case "java.lang.IllegalArgumentException" :
					// Lev�e lorsque qu'une m�thode a re�ue un argument ill�gal ou inappropri�.
					ErrorSys.gestionException((IllegalArgumentException) ex);
					break;
				case "java.lang.IllegalMonitorStateException" :
					// Indique qu'un thread a tent� d'attendre sur le moniteur d'un objet, ou d'informer les autres threads
					// en attente sur le moniteur d'un objet sans poss�der de droits sur le moniteur sp�cifi�.
					ErrorSys.gestionException((IllegalMonitorStateException) ex);
					break;
				case "java.lang.IllegalStateException" :
					// L'environnement Java ou l'application Java ne sont pas dans un etat approprie pour l'op�ration demand�e.
					ErrorSys.gestionException((IllegalStateException) ex);
					break;
				case "java.lang.IllegalThreadStateException" :
					// Indique qu'un thread ne se trouve pas dans un �tat appropri� pour l'op�ration demand�e.
					ErrorSys.gestionException((IllegalThreadStateException) ex);
					break;
				case "java.lang.IndexOutOfBoundsException" :
					// L'indice est hors de port�e
					ErrorSys.gestionException((IndexOutOfBoundsException) ex);
					break;
				case "java.lang.InstantiationException" :
					// Lev�e lorsqu'une instanciation echoue (diverses raisons possibles...)
					// Exemples : la classe n'a pas de constructeur, l'objet de classe repr�sente une
					// classe abstraite, une interface, une classe de tableau, un type primitif, null, ... 
					ErrorSys.gestionException((InstantiationException) ex);
					break;
				case "java.lang.InterruptedException" :
					// Lev�e lorsqu'un thread attend, dors, ou est occup�, et que le thread est interrompu.
					ErrorSys.gestionException((InterruptedException) ex);
					break;
				case "java.lang.NegativeArraySizeException" :
					// Lev�e si une application tente de cr�er un tableau avec une taille n�gative.
					ErrorSys.gestionException((NegativeArraySizeException) ex);
					break;
				case "java.lang.NoSuchFieldException" :
					// Signale que la classe n'a pas de champ avec le nom sp�cifi�.
					ErrorSys.gestionException((NoSuchFieldException) ex);
					break;
				case "java.lang.NoSuchMethodException" :
					// Exceptions lev�e quand une methode particuli�re n'a pas p� �tre trouv�e.
					ErrorSys.gestionException((NoSuchMethodException) ex);
					break;	
				case "java.lang.NullPointerException" :
					// Lev�e lorsqu'une application tente d'utiliser null dans un cas o� un objet est n�cessaire.
					ErrorSys.gestionException((NullPointerException) ex);
					break;
				case "java.lang.NumberFormatException" :
					// Indique que l'application a tent� de convertir une cha�ne dans l'un des types num�riques, 
					// mais que la cha�ne n'a pas le format appropri�.
					ErrorSys.gestionException((NumberFormatException) ex);
					break;
				case "java.lang.RuntimeException" :
					// C'est la superclasse des exceptions qui peuvent �tre lev�es pendant le fonctionnement normal de la JMV.
					ErrorSys.gestionException((RuntimeException) ex);
					break;
				case "java.lang.SecurityException" :
					// Exceptions lev�e par le security manager pour indiquer une violation de s�curit�.
					ErrorSys.gestionException((SecurityException) ex);
					break;
				case "java.lang.StringIndexOutOfBoundsException" :
					// Lev�e par des m�thodes String pour indiquer qu'un index est n�gatif ou sup�rieur � la taille de la cha�ne.
					ErrorSys.gestionException((StringIndexOutOfBoundsException) ex);
					break;
				case "java.lang.TypeNotPresentException" :
					// Lev�e lorsqu'une application tente d'acc�der � un type en utilisant une cha�ne repr�sentant le nom du type,
					// mais pas de d�finition pour le type avec le nom sp�cifi� introuvable.
					ErrorSys.gestionException((TypeNotPresentException) ex);
					break;
				case "java.lang.UnsupportedOperationException" :
					// Exception lev�e pour indiquer que l'op�ration demand�e n'est pas prise en charge.
					ErrorSys.gestionException((UnsupportedOperationException) ex);
					break;
					
					
				// JAVA.TEXT.*
				case "java.text.ParseException" :
					// Signale une erreur innatendue lors de l'analyse.
					ErrorSys.gestionException((ParseException) ex);
					break;
					
					
				// JAVAX.*
				case "javax.naming.AuthenticationException" :
					// Exceptions li�es � un objet d'authentification �tant invalide pour une raison quelconque.
					ErrorSys.gestionException((AuthenticationException) ex);
					break;		
					
				/*	
				// EXCEPTIONS PERSONNALIS�ES :
				case "NombreException" :
					// TODO : Exemple d'une exception cr�e par un utilisateur pour des besoins sp�cifiques � son projet
					ErrorSys.gestionException((NombreException) ex);
					break;
				*/
				
				// SINON PAR DEFAUT : EXCEPTION
				default :
					// Lev�e lorsqu'une tentative de r�cup�rer le r�sultat d'une t�che �choue...
					ErrorSys.gestionException(ex);
					break;
			}
			
		} catch (Exception e) {
			LOGGER.log( Level.FINE, "ERREUR > PointeursErreurs : "+e.toString(), e );
		}
	}
	// AFFICHAGE DES PATHS (POUR LOCALISATION PLUS PRECISE DE L'ERREUR)
	public static void RedErreurs(Exception ex, String classe) {
		System.out.print("\nCLASSE : "+classe+"\n> ");
		RedErreurs(ex);
	}
	public static void RedErreurs(Exception ex, String classe, String methode) {
		System.out.print("\nCLASSE : "+classe+"\n> METHODE : "+ methode +"\n>> ");
		RedErreurs(ex);
	}
	
	// METHODE STOCKANT LE NOM DE LA METHODE ET DE LA CLASSE APPELANTE
	public static String c;		// Nom de la classe
	public static String m; 	// Nom de la methode
	public static void Reflexivite() {
		Throwable t = new Throwable();
		t.fillInStackTrace();
		StackTraceElement s = t.getStackTrace()[1];
		c = s.getClassName();	// STRING
		m = s.getMethodName();	// STRING
	}
	
}