package shell;
/*	GESTIONNAIRES D'EXCEPTIONS
 *  
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Frédéric
 *  @DateCreation     :  31 AOÛT 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de gérer chaque exception de manière plus simple :
 * 				 public static ErrorGestionSys Error = new ErrorGestionSys();
 *				 try { }(catch (typeexception e) { Error.gestionException(e); }
 */

// LIBRAIRIES
// JAVAX.*
import javax.naming.AuthenticationException;
import javax.swing.JOptionPane;
// JAVA.IO.*
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.InterruptedIOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectStreamException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
// JAVA.TEXT.*
import java.text.ParseException;


// GESTIONNAIRES D'EXCEPTIONS
public class ErrorGestionSys {
	private static final long serialVersionUID = 1L;
	
	// AFFICHAGE SOUS FORME D'INFO-BULLES ?	
	public boolean jOptionPaneActif = false;
	public String exNom = "Exception";
	
	//----- L'exception qui va capturer toutes les exceptions : ------------------------------------------
	public void gestionException(Exception e){
		if (jOptionPaneActif)
			JOptionPane.showInternalMessageDialog(null, e.toString(), exNom, JOptionPane.ERROR_MESSAGE);
		else
			System.out.println("Exception : "+e.toString());
	}	// Levée lorsqu'une tentative de récupérer le résultat d'une tâche échoue...
	//----------------------------------------------------------------------------------------------------
	
	
// A --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ArithmeticException e){
	    System.out.println("ArithmeticException : "+e.toString());
	}	// Exception levée lorsqu'une condition arithmétique exceptionnelle a eu lieu.
	
	public void gestionException(ArrayIndexOutOfBoundsException e){
		System.out.println("ArrayIndexOutOfBoundsException : \n"+e.toString());
		// TODO Exemple avec 'linterrogation d'une cellule hors d'un tableau
		System.out.println("> Essayez de lire une cellule située DANS le tableau !");
	}	// Exceptions levée quand vous dépassez la taille d'un tableau
	
	public void gestionException(ArrayStoreException e){
		System.out.println("ArrayStoreException : \n"+e.toString());
	}	// Indique qu'une tentative a été faite pour stocker le mauvais type d'objet dans un tableau d'objets.
	
	public void gestionException(AuthenticationException e){
	    System.out.println("AuthenticationException : "+e.toString());
	}	// Exceptions liées à un objet d'authentification étant invalide pour une raison quelconque.
	
// C --------------------------------------------------------------------------------------------------------------------
	public void gestionException(CharConversionException e){
	    System.out.println("CharConversionException : "+e.toString());
	}	// Ceci est une classe de base pour les exceptions de conversion de caractères.
	
	public void gestionException(ClassCastException e){
	    System.out.println("ClassCastException : "+e.toString());
	}	// Indique que le code a tenté de throw un objet à une sous-classe dont il n'est pas une instance.
	
	public void gestionException(ClassNotFoundException e){
	    System.out.println("ClassNotFoundException : "+e.toString());
	}	// Exception soulevée si une erreur est survenue lors de la tentative de charger une classe 
	
	public void gestionException(CloneNotSupportedException e){
	    System.out.println("CloneNotSupportedException : "+e.toString());
	}	// Indique que la méthode clone dans la classe Object a été appelée à cloner un objet, 
		// mais que la classe de l'objet ne met pas en oeuvre d'interface Clonable.
	
// E --------------------------------------------------------------------------------------------------------------------
	public void gestionException(EOFException  e){
	    System.out.println("EOFException  : "+e.toString());
	}	// Signale une fin innatendue de fichier ou de flux.
	
	public void gestionException(EnumConstantNotPresentException  e){
	    System.out.println("EnumConstantNotPresentException  : "+e.toString());
	}	// Levée lorsqu'une application tente d'accéder à une constante d'une enum par nom,
		// mais que le type enum ne contient pas de constante avec le nom spécifié.
	
// F --------------------------------------------------------------------------------------------------------------------
	public void gestionException(FileNotFoundException  e){
	    System.out.println("FileNotFoundException  : "+e.toString());
	}	// Echec lors de la tentative d'ouvrerture d'une fichier désigné par un chemin d'accès spécifié.
	
// I --------------------------------------------------------------------------------------------------------------------
	public void gestionException(IllegalAccessException e){
	    System.out.println("IllegalAccessException : "+e.toString());
	}	// Lancée lorsqu'une application tente de créer reflexivement une instance (autre qu'un tableau), 
		// définir ou obtenir un champ, ou invoquer une méthode ; mais que la méthode en cours d'exécution 
		// n'a pas accès à la définition de la classe, au champ spécifié, à la méthode ou au constructeur.
	
	public void gestionException(IllegalArgumentException e) {
	    System.out.println("IllegalArgumentException : "+e.toString());
	}	// Levée lorsque qu'une méthode a reçue un argument illégal ou inapproprié.
	
	public void gestionException(IllegalMonitorStateException e) {
	    System.out.println("IllegalMonitorStateException : "+e.toString());
	}	// Indique qu'un thread a tenté d'attendre sur le moniteur d'un objet, ou d'informer les autres threads
		// en attente sur le moniteur d'un objet sans posséder de droits sur le moniteur spécifié.
	
	public void gestionException(IllegalStateException e) {
	    System.out.println("IllegalStateException : "+e.toString());
	}	// L'environnement Java ou l'application Java ne sont pas dans un etat approprie pour l'opération demandée.
	
	public void gestionException(IllegalThreadStateException e) {
	    System.out.println("IllegalThreadStateException : "+e.toString());
	}	// Indique qu'un thread ne se trouve pas dans un état approprié pour l'opération demandée.
	
	public void gestionException(IndexOutOfBoundsException e) {
	    System.out.println("IndexOutOfBoundsException : "+e.toString());
	}	// L'indice est hors de portée (par exemple for(int i = 0;  ; i++))
	 	
	public void gestionException(InstantiationException e){
	    System.out.println("InstantiationException : "+e.toString());
	}	// Levée lorsqu'une instanciation echoue (diverses raisons possibles...)
		// Exemples : la classe n'a pas de constructeur, l'objet de classe représente une
		// classe abstraite, une interface, une classe de tableau, un type primitif, null, ... 
	
	public void gestionException(InterruptedException e) {
	    System.out.println("InterruptedException : "+e.toString());
	}	// Levée lorsqu'un thread attend, dors, ou est occupé, et que le thread est interrompu.
	
	public void gestionException(InterruptedIOException e){
	    System.out.println("InterruptedIOException : "+e.toString());
	}	// Signale qu'une opération d'Entrée/Sortie à été interrompue.
	
	public void gestionException(InvalidClassException e){
	    System.out.println("InvalidClassException : "+e.toString());
	}	// Levée lorsque le moteur d'exécution de sérialisation détecte un problème avec une classe.
	
	public void gestionException(InvalidObjectException e){
	    System.out.println("InvalidObjectException : "+e.toString());
	}	// Indique qu'un ou plusieurs objets désérialisés ont échoués au test de validation.
	
	public void gestionException(IOException e){
	    System.out.println("IOException : "+e.toString());
	}	// Un flux en entrée/sortie (I/O) a echoué ou a été interrompu
	
// N --------------------------------------------------------------------------------------------------------------------
	public void gestionException(NegativeArraySizeException e){
	    System.out.println("NegativeArraySizeException : "+e.toString());
	}	// Levée si une application tente de créer un tableau avec une taille négative.
	
	public void gestionException(NoSuchFieldException e){
	    System.out.println("NoSuchFieldException : "+e.toString());
	}	// Signale que la classe n'a pas de champ avec le nom spécifié.
	
	public void gestionException(NoSuchMethodException e){
	    System.out.println("NoSuchMethodException : "+e.toString());
	}	
	
	public void gestionException(NotActiveException e){
	    System.out.println("NotActiveException : "+e.toString());
	}	// Exception levée lorsque sérialisation ou désérialisation n'est pas active.
	
	public void gestionException(NotSerializableException e){
	    System.out.println("NotSerializableException : "+e.toString());
	}	// Exceptions levée lorsqu'une instance nécessite d'avoir une interface Serializable.
	
	public void gestionException(NullPointerException e){
	    System.out.println("NullPointerException : "+e.toString());
	}	// Levée lorsqu'une application tente d'utiliser null dans un cas où un objet est nécessaire.
	
	public void gestionException(NumberFormatException e){
	    System.out.println("NumberFormatException : "+e.toString());
	}	// Indique que l'application a tenté de convertir une chaîne dans l'un des types numériques, 
		// mais que la chaîne n'a pas le format approprié.

// O --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ObjectStreamException e){
	    System.out.println("ObjectStreamException : "+e.toString());
	}	// Ceci est une superclasse de toutes les exceptions spécifiques à l'objet des classes Stream.
	
	public void gestionException(OptionalDataException e){
	    System.out.println("OptionalDataException : "+e.toString());
	}	// Indiquant l'échec d'une opération de lecture d'un objet en raison de données primitives
		// non lues, ou la fin des données appartenant à un objet sérialisé dans le flux.
	
// P --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ParseException e){
	    System.out.println("ParseException : "+e.toString());
	}	// Signale une erreur innatendue lors de l'analyse.
	
// R --------------------------------------------------------------------------------------------------------------------
	public void gestionException(RuntimeException e){
		System.out.println("RuntimeException : "+e.toString());
	}	// C'est la superclasse des exceptions qui peuvent être levées pendant le fonctionnement normal de la JMV.
	
// S --------------------------------------------------------------------------------------------------------------------
	public void gestionException(SecurityException e){
	    System.out.println("SecurityException : "+e.toString());
	}	// Exceptions levée par le security manager pour indiquer une violation de sécurité.
	
	public void gestionException(StreamCorruptedException e){
	    System.out.println("StreamCorruptedException : "+e.toString());
	}	// Levée lorsque les informations de contrôle lues à partir d'un flux d'objet violent les contrôles de cohérence interne.
	
	public void gestionException(StringIndexOutOfBoundsException e){
		System.out.println("StringIndexOutOfBoundsException : "+e.toString());
	}	// Levée par des méthodes String pour indiquer qu'un index est négatif ou supérieur à la taille de la chaîne.
	
	public void gestionException(SyncFailedException e){
	    System.out.println("SyncFailedException : "+e.toString());
	}	// Signale qu'une opération de synchronisation a échouée.


// T --------------------------------------------------------------------------------------------------------------------
	public void gestionException(TypeNotPresentException e){
		System.out.println("SecurityException : "+e.toString());
	}	// Levée lorsqu'une application tente d'accéder à un type en utilisant une chaîne représentant le nom du type,
		// mais pas de définition pour le type avec le nom spécifié introuvable.
		
// U --------------------------------------------------------------------------------------------------------------------
	public void gestionException(UnsupportedEncodingException e){
	    System.out.println("UnsupportedEncodingException : "+e.toString());
	}	// Ce codage de caractères n'est pas pris en charge.
	
	public void gestionException(UnsupportedOperationException e){
	    System.out.println("UnsupportedOperationException : "+e.toString());
	}	// Exception levée pour indiquer que l'opération demandée n'est pas prise en charge.
	
	public void gestionException(UTFDataFormatException e){
	    System.out.println("UTFDataFormatException : "+e.toString());
	}	// Signale qu'une chaîne malformée au format UTF-8 modifié a été lue dans un flux d'entrée de données
		// ou par toute classe qui implémente l'interface d'entrée de données.
	
// W --------------------------------------------------------------------------------------------------------------------
	public void gestionException(WriteAbortedException e){
	    System.out.println("WriteAbortedException : "+e.toString());
	}	// Signale que l'un des ObjectStreamExceptions a été lancé au cours d'une opération d'écriture.

//-----------------------------------------------------------------------------------------------------------------------
	/* // Diverses autres Exceptions :
	AclNotFoundException, ActivationException, AlreadyBoundException, ApplicationException, AWTException, 
	BackingStoreException, BadAttributeValueExpException, BadBinaryOpValueExpException, BadLocationException, 
	BadStringOperationException, BrokenBarrierException, CertificateException, CloneNotSupportedException, 
	DataFormatException, DatatypeConfigurationException, DestroyFailedException, ExecutionException, ExpandVetoException,
	FontFormatException, GeneralSecurityException, GSSException, IllegalClassFormatException, InterruptedException, 
	IntrospectionException, InvalidApplicationException, InvalidMidiDataException, InvalidPreferencesFormatException, 
	InvalidTargetObjectTypeException, IOException, JAXBException, JMException, KeySelectorException, LastOwnerException, 
	LineUnavailableException, MarshalException, MidiUnavailableException, MimeTypeParseException, MimeTypeParseException, 
	NamingException, NoninvertibleTransformException, NotBoundException, NotOwnerException, ParseException, 
	ParserConfigurationException, PrinterException, PrintException, PrivilegedActionException, PropertyVetoException, 
	ReflectiveOperationException, RefreshFailedException, RemarshalException, RuntimeException, SAXException, ScriptException, 
	ServerNotActiveException, SOAPException, SQLException, TimeoutException, TooManyListenersException, TransformerException, 
	TransformException, UnmodifiableClassException, UnsupportedAudioFileException, UnsupportedCallbackException, 
	UnsupportedFlavorException, UnsupportedLookAndFeelException, URIReferenceException, URISyntaxException, UserException, 
	XAException, XMLParseException, XMLSignatureException, XMLStreamException, XPathException
	*/
	
	/*
	public void gestionException(ClientProtocolException e){
	    JOptionPane.showInternalMessageDialog(null, e.toString(), exNom, JOptionPane.ERROR_MESSAGE);
	    System.out.println("ClientProtocolException : "+e.toString());
	}	// Signale une erreur dans le protocole HTTP.
	*/
}
