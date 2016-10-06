package shell;
/*	GESTIONNAIRES D'EXCEPTIONS
 *  
 *  @license MIT ( https://fr.wikipedia.org/wiki/Licence_MIT )
 *  		 Copyright (c) <2016> <coupez.frederic@gmail.com>
 *  
 *	@author COUPEZ Fr�d�ric
 *  @DateCreation     :  31 AO�T 2016 
 *  @DateModification :  05 OCTOBRE 2016 
 *
 *  @description Permettre de g�rer chaque exception de mani�re plus simple :
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
	}	// Lev�e lorsqu'une tentative de r�cup�rer le r�sultat d'une t�che �choue...
	//----------------------------------------------------------------------------------------------------
	
	
// A --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ArithmeticException e){
	    System.out.println("ArithmeticException : "+e.toString());
	}	// Exception lev�e lorsqu'une condition arithm�tique exceptionnelle a eu lieu.
	
	public void gestionException(ArrayIndexOutOfBoundsException e){
		System.out.println("ArrayIndexOutOfBoundsException : \n"+e.toString());
		// TODO Exemple avec 'linterrogation d'une cellule hors d'un tableau
		System.out.println("> Essayez de lire une cellule situ�e DANS le tableau !");
	}	// Exceptions lev�e quand vous d�passez la taille d'un tableau
	
	public void gestionException(ArrayStoreException e){
		System.out.println("ArrayStoreException : \n"+e.toString());
	}	// Indique qu'une tentative a �t� faite pour stocker le mauvais type d'objet dans un tableau d'objets.
	
	public void gestionException(AuthenticationException e){
	    System.out.println("AuthenticationException : "+e.toString());
	}	// Exceptions li�es � un objet d'authentification �tant invalide pour une raison quelconque.
	
// C --------------------------------------------------------------------------------------------------------------------
	public void gestionException(CharConversionException e){
	    System.out.println("CharConversionException : "+e.toString());
	}	// Ceci est une classe de base pour les exceptions de conversion de caract�res.
	
	public void gestionException(ClassCastException e){
	    System.out.println("ClassCastException : "+e.toString());
	}	// Indique que le code a tent� de throw un objet � une sous-classe dont il n'est pas une instance.
	
	public void gestionException(ClassNotFoundException e){
	    System.out.println("ClassNotFoundException : "+e.toString());
	}	// Exception soulev�e si une erreur est survenue lors de la tentative de charger une classe 
	
	public void gestionException(CloneNotSupportedException e){
	    System.out.println("CloneNotSupportedException : "+e.toString());
	}	// Indique que la m�thode clone dans la classe Object a �t� appel�e � cloner un objet, 
		// mais que la classe de l'objet ne met pas en oeuvre d'interface Clonable.
	
// E --------------------------------------------------------------------------------------------------------------------
	public void gestionException(EOFException  e){
	    System.out.println("EOFException  : "+e.toString());
	}	// Signale une fin innatendue de fichier ou de flux.
	
	public void gestionException(EnumConstantNotPresentException  e){
	    System.out.println("EnumConstantNotPresentException  : "+e.toString());
	}	// Lev�e lorsqu'une application tente d'acc�der � une constante d'une enum par nom,
		// mais que le type enum ne contient pas de constante avec le nom sp�cifi�.
	
// F --------------------------------------------------------------------------------------------------------------------
	public void gestionException(FileNotFoundException  e){
	    System.out.println("FileNotFoundException  : "+e.toString());
	}	// Echec lors de la tentative d'ouvrerture d'une fichier d�sign� par un chemin d'acc�s sp�cifi�.
	
// I --------------------------------------------------------------------------------------------------------------------
	public void gestionException(IllegalAccessException e){
	    System.out.println("IllegalAccessException : "+e.toString());
	}	// Lanc�e lorsqu'une application tente de cr�er reflexivement une instance (autre qu'un tableau), 
		// d�finir ou obtenir un champ, ou invoquer une m�thode ; mais que la m�thode en cours d'ex�cution 
		// n'a pas acc�s � la d�finition de la classe, au champ sp�cifi�, � la m�thode ou au constructeur.
	
	public void gestionException(IllegalArgumentException e) {
	    System.out.println("IllegalArgumentException : "+e.toString());
	}	// Lev�e lorsque qu'une m�thode a re�ue un argument ill�gal ou inappropri�.
	
	public void gestionException(IllegalMonitorStateException e) {
	    System.out.println("IllegalMonitorStateException : "+e.toString());
	}	// Indique qu'un thread a tent� d'attendre sur le moniteur d'un objet, ou d'informer les autres threads
		// en attente sur le moniteur d'un objet sans poss�der de droits sur le moniteur sp�cifi�.
	
	public void gestionException(IllegalStateException e) {
	    System.out.println("IllegalStateException : "+e.toString());
	}	// L'environnement Java ou l'application Java ne sont pas dans un etat approprie pour l'op�ration demand�e.
	
	public void gestionException(IllegalThreadStateException e) {
	    System.out.println("IllegalThreadStateException : "+e.toString());
	}	// Indique qu'un thread ne se trouve pas dans un �tat appropri� pour l'op�ration demand�e.
	
	public void gestionException(IndexOutOfBoundsException e) {
	    System.out.println("IndexOutOfBoundsException : "+e.toString());
	}	// L'indice est hors de port�e (par exemple for(int i = 0;  ; i++))
	 	
	public void gestionException(InstantiationException e){
	    System.out.println("InstantiationException : "+e.toString());
	}	// Lev�e lorsqu'une instanciation echoue (diverses raisons possibles...)
		// Exemples : la classe n'a pas de constructeur, l'objet de classe repr�sente une
		// classe abstraite, une interface, une classe de tableau, un type primitif, null, ... 
	
	public void gestionException(InterruptedException e) {
	    System.out.println("InterruptedException : "+e.toString());
	}	// Lev�e lorsqu'un thread attend, dors, ou est occup�, et que le thread est interrompu.
	
	public void gestionException(InterruptedIOException e){
	    System.out.println("InterruptedIOException : "+e.toString());
	}	// Signale qu'une op�ration d'Entr�e/Sortie � �t� interrompue.
	
	public void gestionException(InvalidClassException e){
	    System.out.println("InvalidClassException : "+e.toString());
	}	// Lev�e lorsque le moteur d'ex�cution de s�rialisation d�tecte un probl�me avec une classe.
	
	public void gestionException(InvalidObjectException e){
	    System.out.println("InvalidObjectException : "+e.toString());
	}	// Indique qu'un ou plusieurs objets d�s�rialis�s ont �chou�s au test de validation.
	
	public void gestionException(IOException e){
	    System.out.println("IOException : "+e.toString());
	}	// Un flux en entr�e/sortie (I/O) a echou� ou a �t� interrompu
	
// N --------------------------------------------------------------------------------------------------------------------
	public void gestionException(NegativeArraySizeException e){
	    System.out.println("NegativeArraySizeException : "+e.toString());
	}	// Lev�e si une application tente de cr�er un tableau avec une taille n�gative.
	
	public void gestionException(NoSuchFieldException e){
	    System.out.println("NoSuchFieldException : "+e.toString());
	}	// Signale que la classe n'a pas de champ avec le nom sp�cifi�.
	
	public void gestionException(NoSuchMethodException e){
	    System.out.println("NoSuchMethodException : "+e.toString());
	}	
	
	public void gestionException(NotActiveException e){
	    System.out.println("NotActiveException : "+e.toString());
	}	// Exception lev�e lorsque s�rialisation ou d�s�rialisation n'est pas active.
	
	public void gestionException(NotSerializableException e){
	    System.out.println("NotSerializableException : "+e.toString());
	}	// Exceptions lev�e lorsqu'une instance n�cessite d'avoir une interface Serializable.
	
	public void gestionException(NullPointerException e){
	    System.out.println("NullPointerException : "+e.toString());
	}	// Lev�e lorsqu'une application tente d'utiliser null dans un cas o� un objet est n�cessaire.
	
	public void gestionException(NumberFormatException e){
	    System.out.println("NumberFormatException : "+e.toString());
	}	// Indique que l'application a tent� de convertir une cha�ne dans l'un des types num�riques, 
		// mais que la cha�ne n'a pas le format appropri�.

// O --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ObjectStreamException e){
	    System.out.println("ObjectStreamException : "+e.toString());
	}	// Ceci est une superclasse de toutes les exceptions sp�cifiques � l'objet des classes Stream.
	
	public void gestionException(OptionalDataException e){
	    System.out.println("OptionalDataException : "+e.toString());
	}	// Indiquant l'�chec d'une op�ration de lecture d'un objet en raison de donn�es primitives
		// non lues, ou la fin des donn�es appartenant � un objet s�rialis� dans le flux.
	
// P --------------------------------------------------------------------------------------------------------------------
	public void gestionException(ParseException e){
	    System.out.println("ParseException : "+e.toString());
	}	// Signale une erreur innatendue lors de l'analyse.
	
// R --------------------------------------------------------------------------------------------------------------------
	public void gestionException(RuntimeException e){
		System.out.println("RuntimeException : "+e.toString());
	}	// C'est la superclasse des exceptions qui peuvent �tre lev�es pendant le fonctionnement normal de la JMV.
	
// S --------------------------------------------------------------------------------------------------------------------
	public void gestionException(SecurityException e){
	    System.out.println("SecurityException : "+e.toString());
	}	// Exceptions lev�e par le security manager pour indiquer une violation de s�curit�.
	
	public void gestionException(StreamCorruptedException e){
	    System.out.println("StreamCorruptedException : "+e.toString());
	}	// Lev�e lorsque les informations de contr�le lues � partir d'un flux d'objet violent les contr�les de coh�rence interne.
	
	public void gestionException(StringIndexOutOfBoundsException e){
		System.out.println("StringIndexOutOfBoundsException : "+e.toString());
	}	// Lev�e par des m�thodes String pour indiquer qu'un index est n�gatif ou sup�rieur � la taille de la cha�ne.
	
	public void gestionException(SyncFailedException e){
	    System.out.println("SyncFailedException : "+e.toString());
	}	// Signale qu'une op�ration de synchronisation a �chou�e.


// T --------------------------------------------------------------------------------------------------------------------
	public void gestionException(TypeNotPresentException e){
		System.out.println("SecurityException : "+e.toString());
	}	// Lev�e lorsqu'une application tente d'acc�der � un type en utilisant une cha�ne repr�sentant le nom du type,
		// mais pas de d�finition pour le type avec le nom sp�cifi� introuvable.
		
// U --------------------------------------------------------------------------------------------------------------------
	public void gestionException(UnsupportedEncodingException e){
	    System.out.println("UnsupportedEncodingException : "+e.toString());
	}	// Ce codage de caract�res n'est pas pris en charge.
	
	public void gestionException(UnsupportedOperationException e){
	    System.out.println("UnsupportedOperationException : "+e.toString());
	}	// Exception lev�e pour indiquer que l'op�ration demand�e n'est pas prise en charge.
	
	public void gestionException(UTFDataFormatException e){
	    System.out.println("UTFDataFormatException : "+e.toString());
	}	// Signale qu'une cha�ne malform�e au format UTF-8 modifi� a �t� lue dans un flux d'entr�e de donn�es
		// ou par toute classe qui impl�mente l'interface d'entr�e de donn�es.
	
// W --------------------------------------------------------------------------------------------------------------------
	public void gestionException(WriteAbortedException e){
	    System.out.println("WriteAbortedException : "+e.toString());
	}	// Signale que l'un des ObjectStreamExceptions a �t� lanc� au cours d'une op�ration d'�criture.

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
