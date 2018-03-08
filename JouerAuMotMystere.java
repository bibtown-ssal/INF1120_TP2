
/**
 * JouerAuMotMystere est une classe qui permet a un utilisateur de jouer a un
 * ou plusieurs mot mystere dans le terminal.
 *
 * @author Charles Therien
 * Code Permanent THEC03029208
 * Courriel : therien.charles@courrier.uqam.ca
 * Cours : INF1120-30
 * @version 22 mars 2018
 */
public class JouerAuMotMystere
{
    //initialisation constantes
    public final static String PRESENTATION = 
         "_________________________________________________________\n" +
         " _____       _                        _                  \n" +
         "|     | ___ | |_     _____  _ _  ___ | |_  ___  ___  ___ \n" +
         "| | | || . ||  _|   |     || | ||_ -||  _|| -_||  _|| -_|\n" +
         "|_|_|_||___||_|     |_|_|_||_  ||___||_|  |___||_|  |___|\n" +
         "                           |___|                         \n" +
         "_________________________________________________________\n";


    
    /**
     * La classe tailleJeu retourne le nombre de ligne dans le tableau du mot mystere
     * (puisque les tableaux sont carres, c'est egalement le nombre de colonne)
     * 
     * @param  jeu  le String composant le tableau de jeu
     * @return      le nombre de ligne composant ce tableau
     */
    public static int tailleJeu(String jeu){
        int taille = -1;
        int indice = 0;
        if(!(jeu == null)){
            while(indice != -1){
                taille++;
                indice = jeu.indexOf('\n',indice+1);
                //fonctionne puisque taille = -1 au départ et on attend
                //un "\n" de plus que la taille du jeu
            }
        }
        return taille;
    }
    
    /** La classe obtenirTableau retourne le tableau a afficher a partir 
     * d'un String contenant l'ensemble du jeu
     * 
     * @param  jeu  le String composant l'ensemble du jeu
     * @return      le tableau de jeu
     */
    public static String obtenirTableau(String jeu){
        String tableau = "*";
        int index;
        if(!(jeu == null)){
            index = jeu.indexOf('#');
            if(index >= 0){
                tableau = jeu.substring(0, index);
            }
        }
        return tableau;
    }
    
    /** la classe obtenirReponses extrait de l'ensemble du jeu la liste de 
     * reponses valides que l'utilisateur doit donner.
     * 
     * @param  jeu  le String composant l'ensemble du jeu
     * @return      la lise des reponses attendue
     */
    public static String obtenirReponses(String jeu){
        String liste = "*";
        int indexDebut;
        int indexFin;
        if(!(jeu == null)){
            indexDebut = jeu.indexOf('#');
            indexFin = jeu.lastIndexOf('#');
            if(indexDebut != indexFin && indexDebut >= 0 && indexFin > 0){
                liste = jeu.substring(indexDebut+1,indexFin);
            }
        }
        return liste;
    }
    
    /** La classe afficherTableauMotMystere fait l'affichage d'un tableau MotMystere
     *  selon le tableau extrait de TP2Utils et la taille du tableau
     * 
     * @param  tableau  tableau extrait du jeu retourne par TP2Utils
     * @param  taille   la taille du tableau de jeu
     */
    public static void afficherTableauMotMystere(String tableau, int taille){
        int indice = 1;
        if(!(tableau == null)){
            for(int i = 0; i <= taille; i++){
                for(int j = 0; j <= taille; j++){
                    if(i==0){
                        if(j==0){
                            System.out.print("   ");
                        }else{
                            System.out.printf("  %-2d",j);
                        }
                    }else{
                        if(j==0){
                            System.out.printf("%-3d",i);
                        }else{
                            System.out.print("| " + tableau.charAt((taille+1)*(i-1)+j)+" ");
                        }
                    }
                }
                if(i!=0){
                    System.out.print("|");
                }
                System.out.print("\n   ");
                for(int k = 0; k < taille; k++){
                    System.out.print("----");
                }
                System.out.println("-");
            }
        }
    }
    /**Cette classe s'assure que le tableau de jeu retourne par TP2Utils commence
     * par un '\n'.
     * 
     * @param  jeu  Le String retournee par TP2Utils
     * @return      Le String incluant un '\n' comme premier charactere
     */
    public static String corrigerFormatTableau(String jeu){
        if(!(jeu.startsWith("\n"))){
            jeu = "\n" + jeu;
        }
        return jeu;
    }
    /**La classe obtenirListeMot permet d'extraire la liste de mot de la liste de
     * reponse attendu extraite du jeu obtenu par TP2Utils
     * @param listeRep
     * @return listeMot
     */
    public static String obtenirListeMot(String listeRep){
        String listeMot = "";
        int indice = 1;
            while(listeRep.indexOf("\n", indice) != -1){
                listeMot = listeMot + listeRep.substring(indice, listeRep.indexOf(":"))+",";
                indice = listeRep.indexOf("\n" , listeRep.indexOf("\n", indice));
            }
        return listeMot;
    }
    public static void main(String [] args){
        //initialisation des variables
        String jeuCourant;
        String tableauJeu;
        String listeMot;
        String listeReponse;
        String motMystere;
        String listeMotTrouve;
        String input;
        int tailleJeu;
        
        System.out.print(PRESENTATION);
        
        do{
            jeuCourant = corrigerFormatTableau(TP2Utils.obtenirJeu());
            tableauJeu = obtenirTableau(jeuCourant);
            tailleJeu = tailleJeu(tableauJeu);
            listeReponse = obtenirReponses(jeuCourant);
            listeMot = obtenirListeMot(listeReponse);
            motMystere = jeuCourant.substring(jeuCourant.lastIndexOf('#')+1);
            do{
                afficherTableauMotMystere(tableauJeu, tailleJeu);
                System.out.print(listeMot);
                input = "q"; 
            }while(input != "q" && input != "Q");
            
            
        }while(false);
    }
}
