package Package;

import java.io.*;

/**
* Le principal but de la classe Clavier est de proposer des
* entr�es clavier sans exception. On propose ainsi
* une op�ration �l�mentaire de lecture sur l'entr�e standard. Cette
* classe permet d'�viter de rentrer dans les d�tails complexes des
* entr�es-sorties.
*/

public class Clavier {
 /**
  * Cette m�thode lit un entier dans une cha�ne de caract�res.
  * Elle s'occupe des �ventuelles exceptions. Si une exception
  * (NumberFormatException) est attrap�e, la m�thode renvoie l'entier
  * nul et affiche un message d'erreur.  
  * @param s la cha�ne de caract�res dans laquelle on lit
  * @return l'entier lu (0 en cas d'erreur) */
 public static int toInt(String s) {
   int result=0;
   try {
     result=Integer.valueOf(s).intValue();
   } catch (NumberFormatException e) {
     System.err.println("Erreur de format: "+e.getMessage());
   }
   return result;
 }

 /**
  * Cette m�thode lit un r�el (double) dans une cha�ne de caract�res.
  * Elle s'occupe des �ventuelles exceptions. Si une exception
  * (NumberFormatException) est attrap�e, la m�thode renvoie le r�el
  * nul et affiche un message d'erreur.  
  * @param s la cha�ne de caract�res dans laquelle on lit
  * @return le r�el lu (0 en cas d'erreur) 
  */
 public static double toDouble(String s) {
   double result=0;
   try {
     result=Double.valueOf(s).doubleValue();
   } catch (NumberFormatException e) {
     System.err.println("Erreur de format: "+e.getMessage());
   }
   return result;
 }

 /**
  * Cette m�thode lit une ligne sur l'entr�e standard et s'occupe des
  * �ventuelles exceptions. Si une exception (IOException) est
  * attrap�e, la m�thode renvoie une cha�ne vide et affiche un
  * message d'erreur.
  * @return la cha�ne lue (vide en cas d'erreur) 
  */
 public static String lireString() {
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   String result;
   try {
     result=br.readLine();
   } catch (IOException e) {
     System.err.println("Erreur de lecture: "+e.getMessage());
     result="";
   }
   return result;
 }

 /**
  * Cette m�thode lit un entier sur l'entr�e standard. 
  * Elle s'occupe des �ventuelles exceptions et utilise la m�thode
  * toInt pour obtenir un entier. S'il y a un probl�me de lecture,
  * la m�thode affiche un message d'erreur et renvoie 0.
  * @return l'entier lu (0 en cas d'erreur)
  */
 public static int lireInt() {
   return toInt(lireString());
 }

 /**
  * Cette m�thode lit un r�el sur l'entr�e standard. 
  * Elle s'occupe des �ventuelles exceptions et utilise la m�thode
  * toDouble pour obtenir un r�el. S'il y a un probl�me de lecture,
  * la m�thode affiche un message d'erreur et renvoie 0.
  * @return le r�el lu (0 en cas d'erreur)
  */
 public static double lireDouble() {
   return toDouble(lireString());
 }
 
 /**
  * Cette m�thode lit un bool�en sur l'entr�e standard. 
  * Elle s'occupe des �ventuelles exceptions et renvoie false
  * s'il y a un probl�me de lecture.
  * @return le bool�en lu (false en cas d'erreur)
  */
 public static boolean lireBoolean() {
   return Boolean.valueOf(lireString()).booleanValue();
 }
 
 /**
  * Cette m�thode lit un caract�re sur l'entr�e standard. 
  * Elle s'occupe des �ventuelles exceptions et renvoie NULL
  * s'il y a un probl�me de lecture.
  * N.B.: si plusieurs caract�res sont entr�s, c'est le premier
  * qui est pris en compte.
  * @return le (premier) caract�re lu (caract�re sp�cial NULL en cas d'erreur)
  */
 public static char lireChar() {
   char result='\u0000';
   try {
     result=lireString().charAt(0);
   } catch (IndexOutOfBoundsException e) {
     System.err.println("Erreur de lecture: aucun caract�re entr�");
   }
   return result;
 }
 
}
