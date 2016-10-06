package shell;
/*
 * GESTIONNAIRE DE REDIRECTIONS D'EXCEPTIONS
 *	
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Frédéric
 *  @DateCreation     :  05 OCTOBRE 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de rediriger chaque exception de manière plus simple :
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
					// Ceci est une classe de base pour les exceptions de conversion de caractères.
					ErrorSys.gestionException((CharConversionException) ex);
					break;
				case "java.io.EOFException" :
					// Signale une fin innatendue de fichier ou de flux.
					ErrorSys.gestionException((EOFException) ex);
					break;
				case "java.io.FileNotFoundException" :
					// Echec lors de la tentative d'ouvrerture d'une fichier désigné par un chemin d'accès spécifié.
					ErrorSys.gestionException((FileNotFoundException) ex);
					break;
				case "java.io.InterruptedIOException" :
					// Signale qu'une opération d'Entrée/Sortie à été interrompue.
					ErrorSys.gestionException((InterruptedIOException) ex);
					break;
				case "java.io.InvalidClassException" :
					// Levée lorsque le moteur d'exécution de sérialisation détecte un problème avec une classe.
					ErrorSys.gestionException((InvalidClassException) ex);
					break;
				case "java.io.InvalidObjectException" :
					// Indique qu'un ou plusieurs objets désérialisés ont échoués au test de validation.
					ErrorSys.gestionException((InvalidObjectException) ex);
					break;					
				case "java.io.IOException" :
					// Un flux en entrée/sortie (I/O) a echoué ou a été interrompu
					ErrorSys.gestionException((IOException) ex);
					break;
				case "java.io.NotActiveException" :
					// Exception levée lorsque sérialisation ou désérialisation n'est pas active.
					ErrorSys.gestionException((NotActiveException) ex);
					break;
				case "java.io.NotSerializableException" :
					// Exceptions levée lorsqu'une instance nécessite d'avoir une interface Serializable.
					ErrorSys.gestionException((NotSerializableException) ex);
					break;
				case "java.io.ObjectStreamException" :
					// Ceci est une superclasse de toutes les exceptions spécifiques à l'objet des classes Stream.
					ErrorSys.gestionException((ObjectStreamException) ex);
					break;
				case "java.io.OptionalDataException" :
					// Indiquant l'échec d'une opération de lecture d'un objet en raison de données primitives
					// non lues, ou la fin des données appartenant à un objet sérialisé dans le flux.
					ErrorSys.gestionException((OptionalDataException) ex);
					break;
				case "java.io.StreamCorruptedException" :
					// Levée lorsque les informations de contrôle lues à partir d'un flux d'objet 
					// violent les contrôles de cohérence interne.
					ErrorSys.gestionException((StreamCorruptedException) ex);
					break;
				case "java.io.SyncFailedException" :
					// Signale qu'une opération de synchronisation a échouée.
					ErrorSys.gestionException((SyncFailedException) ex);
					break;
				case "java.io.UnsupportedEncodingException" :
					// Ce codage de caractères n'est pas pris en charge.
					ErrorSys.gestionException((UnsupportedEncodingException) ex);
					break;
				case "java.io.UTFDataFormatException" :
					// Signale qu'une chaîne malformée au format UTF-8 modifié a été lue dans un flux d'entrée de données
					// ou par toute classe qui implémente l'interface d'entrée de données.
					ErrorSys.gestionException((UTFDataFormatException) ex);
					break;
				case "java.io.WriteAbortedException" :
					// Signale que l'un des ObjectStreamExceptions a été lancé au cours d'une opération d'écriture.
					ErrorSys.gestionException((WriteAbortedException) ex);
					break;
					
					
				// (26 - 1(Exception)) JAVA.LANG.*
				case "java.lang.ArithmeticException" :
					// Exception levée lorsqu'une condition arithmétique exceptionnelle a eu lieu.
					ErrorSys.gestionException((ArithmeticException) ex);
					break;
				case "java.lang.ArrayIndexOutOfBoundsException" :
					// Exceptions levée quand vous dépassez la taille d'un tableau
					ErrorSys.gestionException((ArrayIndexOutOfBoundsException) ex);
					break;
				case "java.lang.ArrayStoreException" :
					// Indique qu'une tentative a été faite pour stocker le mauvais type d'objet dans un tableau d'objets.
					ErrorSys.gestionException((ArrayStoreException) ex);
					break;
				case "java.lang.ClassCastException" :
					// Indique que le code a tenté de throw un objet à une sous-classe dont il n'est pas une instance.
					ErrorSys.gestionException((ClassCastException) ex);
					break;
				case "java.lang.ClassNotFoundException" :
					// Exception soulevée si une erreur est survenue lors de la tentative de charger une classe 
					ErrorSys.gestionException((ClassNotFoundException) ex);
					break;
				case "java.lang.CloneNotSupportedException" :
					// Indique que la méthode clone dans la classe Object a été appelée à cloner un objet, 
					// mais que la classe de l'objet ne met pas en oeuvre d'interface Clonable.
					ErrorSys.gestionException((CloneNotSupportedException) ex);
					break;
				case "java.lang.EnumConstantNotPresentException" :
					// Levée lorsqu'une application tente d'accéder à une constante d'une enum par nom,
					// mais que le type enum ne contient pas de constante avec le nom spécifié.
					ErrorSys.gestionException((EnumConstantNotPresentException) ex);
					break;				
				case "java.lang.IllegalAccessException" :
					// Lancée lorsqu'une application tente de créer reflexivement une instance (autre qu'un tableau), 
					// définir ou obtenir un champ, ou invoquer une méthode ; mais que la méthode en cours d'exécution 
					// n'a pas accès à la définition de la classe, au champ spécifié, à la méthode ou au constructeur.
					ErrorSys.gestionException((IllegalAccessException) ex);
					break;
				case "java.lang.IllegalArgumentException" :
					// Levée lorsque qu'une méthode a reçue un argument illégal ou inapproprié.
					ErrorSys.gestionException((IllegalArgumentException) ex);
					break;
				case "java.lang.IllegalMonitorStateException" :
					// Indique qu'un thread a tenté d'attendre sur le moniteur d'un objet, ou d'informer les autres threads
					// en attente sur le moniteur d'un objet sans posséder de droits sur le moniteur spécifié.
					ErrorSys.gestionException((IllegalMonitorStateException) ex);
					break;
				case "java.lang.IllegalStateException" :
					// L'environnement Java ou l'application Java ne sont pas dans un etat approprie pour l'opération demandée.
					ErrorSys.gestionException((IllegalStateException) ex);
					break;
				case "java.lang.IllegalThreadStateException" :
					// Indique qu'un thread ne se trouve pas dans un état approprié pour l'opération demandée.
					ErrorSys.gestionException((IllegalThreadStateException) ex);
					break;
				case "java.lang.IndexOutOfBoundsException" :
					// L'indice est hors de portée
					ErrorSys.gestionException((IndexOutOfBoundsException) ex);
					break;
				case "java.lang.InstantiationException" :
					// Levée lorsqu'une instanciation echoue (diverses raisons possibles...)
					// Exemples : la classe n'a pas de constructeur, l'objet de classe représente une
					// classe abstraite, une interface, une classe de tableau, un type primitif, null, ... 
					ErrorSys.gestionException((InstantiationException) ex);
					break;
				case "java.lang.InterruptedException" :
					// Levée lorsqu'un thread attend, dors, ou est occupé, et que le thread est interrompu.
					ErrorSys.gestionException((InterruptedException) ex);
					break;
				case "java.lang.NegativeArraySizeException" :
					// Levée si une application tente de créer un tableau avec une taille négative.
					ErrorSys.gestionException((NegativeArraySizeException) ex);
					break;
				case "java.lang.NoSuchFieldException" :
					// Signale que la classe n'a pas de champ avec le nom spécifié.
					ErrorSys.gestionException((NoSuchFieldException) ex);
					break;
				case "java.lang.NoSuchMethodException" :
					// Exceptions levée quand une methode particulière n'a pas pû être trouvée.
					ErrorSys.gestionException((NoSuchMethodException) ex);
					break;	
				case "java.lang.NullPointerException" :
					// Levée lorsqu'une application tente d'utiliser null dans un cas où un objet est nécessaire.
					ErrorSys.gestionException((NullPointerException) ex);
					break;
				case "java.lang.NumberFormatException" :
					// Indique que l'application a tenté de convertir une chaîne dans l'un des types numériques, 
					// mais que la chaîne n'a pas le format approprié.
					ErrorSys.gestionException((NumberFormatException) ex);
					break;
				case "java.lang.RuntimeException" :
					// C'est la superclasse des exceptions qui peuvent être levées pendant le fonctionnement normal de la JMV.
					ErrorSys.gestionException((RuntimeException) ex);
					break;
				case "java.lang.SecurityException" :
					// Exceptions levée par le security manager pour indiquer une violation de sécurité.
					ErrorSys.gestionException((SecurityException) ex);
					break;
				case "java.lang.StringIndexOutOfBoundsException" :
					// Levée par des méthodes String pour indiquer qu'un index est négatif ou supérieur à la taille de la chaîne.
					ErrorSys.gestionException((StringIndexOutOfBoundsException) ex);
					break;
				case "java.lang.TypeNotPresentException" :
					// Levée lorsqu'une application tente d'accéder à un type en utilisant une chaîne représentant le nom du type,
					// mais pas de définition pour le type avec le nom spécifié introuvable.
					ErrorSys.gestionException((TypeNotPresentException) ex);
					break;
				case "java.lang.UnsupportedOperationException" :
					// Exception levée pour indiquer que l'opération demandée n'est pas prise en charge.
					ErrorSys.gestionException((UnsupportedOperationException) ex);
					break;
					
					
				// JAVA.TEXT.*
				case "java.text.ParseException" :
					// Signale une erreur innatendue lors de l'analyse.
					ErrorSys.gestionException((ParseException) ex);
					break;
					
					
				// JAVAX.*
				case "javax.naming.AuthenticationException" :
					// Exceptions liées à un objet d'authentification étant invalide pour une raison quelconque.
					ErrorSys.gestionException((AuthenticationException) ex);
					break;		
					
				/*	
				// EXCEPTIONS PERSONNALISÉES :
				case "NombreException" :
					// TODO : Exemple d'une exception crée par un utilisateur pour des besoins spécifiques à son projet
					ErrorSys.gestionException((NombreException) ex);
					break;
				*/
				
				// SINON PAR DEFAUT : EXCEPTION
				default :
					// Levée lorsqu'une tentative de récupérer le résultat d'une tâche échoue...
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