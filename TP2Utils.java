
import java.util.Random;
import java.io.*;

/**
 * Cette classe contient une methode utile pour la realisation du TP2 
 * (INF1120 H18).
 * 
 * @author melanie lord
 * @version 26/02/2018
 */
public class TP2Utils {
   
   //CONSTANTES DE CLASSE PRIVEES
   private static final String PATH_FIC_JEUX = "jeux.txt";
   private static final String SEP_JEUX = "------------";
   
   //VARIABLE DE CLASSE PRIVEE
   private static String [] tabJeux;
   
   /* ********************************************************
    * METHODE PUBLIQUE - À UTILISER DANS TP2
    * ********************************************************/
   
   /**
    * Permet d'obtenir aleatoirement, sous forme d'une chaine de caracteres, un  
    * jeu de mot mystere defini dans le fichier PATH_FIC_JEUX.
    * 
    * @return un jeu de mot mystere.
    */
   public static String obtenirJeu () {
      String jeu = null;
      
      if (tabJeux == null) {
         initTabJeux();
      }
      
      //return tabJeux[2];  //Pour retourner un jeu specifique (0, 1 ou 2).
                            //Pour tests seulement. Va faire planter le programme
                            //si vous utilisez d'autres valeurs que 0, 1 ou 2.
                              
      return tabJeux[tirerUnNombreEntreMinEtMax(0, tabJeux.length - 1)];
   }
   
   
   /* ********************************************************
    * METHODES PRIVEES
    * ********************************************************/
   
   /**
    * Lit tous les jeux contenus dans le fichier PATH_FIC_JEU et initialise 
    * le tableau tabJeux.
    */
   private static void initTabJeux() {
      BufferedReader in;
      String jeux = "";
      String [] tab;
      try {
         in = new BufferedReader(new FileReader(PATH_FIC_JEUX));
         while (in.ready()) {
            jeux = jeux + in.readLine() + "\n";
         }
         jeux = jeux.trim();
         tabJeux = jeux.split(SEP_JEUX);
         
      } catch (IOException e) {
         System.err.println("ERREUR FATALE ! LE FICHIER JEUX.TXT REQUIS NE SE "
                 + "TROUVE PAS\nA LA RACINE DE VOTRE PROJET JAVA.\n\n");
      }
   }
   
   /**
    * Genere un nombre aleatoire entre min et max.
    * @param min la borne minimale (incluse) pour la generation du nombre
    * @param max la borne maximale (incluse) pour la generation du nombre
    * @return un nombre aleatoire entre min et max
    */
   private static int tirerUnNombreEntreMinEtMax(int min, int max) {
      Random generateurAlea = new Random();
      return generateurAlea.nextInt(max - min + 1) + min;
   }

}
