
/**
 * I N F 1 1 2 0 
 * groupe 41
 * Professeur: Céline Descheneaux
 *
 * D�crivez votre classe Ébauche_1 ici.
 * 
 * @author (votre nom) Kayla Louis
 * @version (une date) 25 octobre 2014
 *
 * (votre code permanent) LOUK13628902
 * (votre adresse de courriel) kaylalouis@hotmail.com
 */

import java.text.*;
 
public class Tp1Gr41 {

    // Autres m�thodes s'il y a lieu
    static final double BG = 2.25;
    static final double JUS = 2.65;
    static final double EAU = 1.55;
    static final double BE = 2.95;
    static final double CINQ = 0.05;
    static final double DIX = 0.10;
    static final double VINGT_CINQ = 0.25;
    static final double UN = 1.00;
    static final double DEUX = 2.00;
    static final DecimalFormat dec2 = new DecimalFormat ( "0.00" );
    public static void main (String[] params) {
        char choix;
        char piece = 'g';
        int nbChangeDonne = 0;
        int nbMontantExact = 0;
        int nbBoissonGazeuse = 0;
        int nbJus = 0;
        int nbEau = 0;
        int nbBoissonEnergisante = 0;
        double prix = 0;
        double vente = 0;
        double totalVente = 0;
        int temp = 0;
        
        System.out.println ("Bienvenue sur le simulateur de distributrice de breuvage de la COOP etudiante");
    
        System.out.println("\nCHOIX DE BREUVAGE");
        System.out.println("a - Boisson gazeuze (2,25$)");
        System.out.println("b - Jus (2,65$)");
        System.out.println("c - Eau (1,55$)");
        System.out.println("d - Boisson énergisante (2.95$)");
        System.out.println("e - Terminer la simulation");
    
        System.out.print("\nQuel est votre choix? ");
        choix = Clavier.lireCharLn(); 
    
        while (choix  < 'A' || choix > 'E' && choix < 'a' || choix > 'e') {
            System.out.println ("\nErreur! Ceci ne fait pas partie des choix.");
            System.out.print("Quel est votre choix? ");
            choix = Clavier.lireCharLn();
        }
        
        if (choix == 'e' || choix == 'E'){
           System.out.println("\nFIN NORMALE DE LA SIMULATION");
        }
        
        while (!( choix == 'e' || choix == 'E')) {
            
            if (choix == 'a' || choix == 'A'){
                prix = BG;
                vente = BG;
                nbBoissonGazeuse = nbBoissonGazeuse + 1;
            } else if (choix == 'b' || choix == 'B'){
                prix = JUS;
                vente = JUS;
                nbJus = nbJus +1;
            } else if (choix == 'c' || choix == 'C') {
                prix = EAU;
                vente = EAU;
                nbEau = nbEau + 1;
            } else {
                prix = BE;
                vente = BE;
                nbBoissonEnergisante = nbBoissonEnergisante +1;
            }
            
            piece = 'g';
            
            while (!(prix <= 0 || piece == 'f' || piece == 'F')) {
                System.out.println("\nPIECE ENTREE");
                System.out.println("a - 5 cents");
                System.out.println("b - 10 cents");
                System.out.println("c - 25 cents");
                System.out.println("d - 1 dollar");
                System.out.println("e - 2 dollars");
                System.out.println("f - Annuler");
            
                System.out.print("\nEntrez votre piece: ");
                piece = Clavier.lireCharLn();
            
                while (piece < 'A' || piece > 'F' && piece < 'a' || piece > 'f'){
                    System.out.println("\nErreur! Ceci ne fait pas partie des choix.");
                    System.out.print("Entrez votre piece: ");
                    piece = Clavier.lireCharLn();
                }
                
                if (piece == 'a' || piece == 'A'){
                    prix = prix - CINQ;
                    temp = (int)(prix*100);
                    if (temp % 5 == 4) {
                        prix = (temp + 1) / 100.0;
                    }else {
                        prix = temp / 100.0;
                    }
                    System.out.println("\nMontant restant: " + dec2.format(prix));
                } else if (piece == 'b' || piece == 'B') {
                    prix = prix - DIX;
                    temp = (int)(prix*100);
                    if (temp % 5 == 4) {
                        prix = (temp + 1) / 100.0;
                    }else {
                        prix = temp / 100.0;
                    }
                    System.out.println("\nMontant restant: " + dec2.format(prix));
                } else if (piece == 'c' || piece == 'C') {
                    prix = prix - VINGT_CINQ;
                    temp = (int)(prix*100);
                    if (temp % 5 == 4) {
                        prix = (temp + 1) / 100.0;
                    }else {
                        prix = temp / 100.0;
                    }
                    System.out.println("\nMontant restant: " + dec2.format(prix));
                } else if (piece == 'd' || piece == 'D') {
                    prix = prix - UN;
                    temp = (int)(prix*100);
                    if (temp % 5 == 4) {
                        prix = (temp + 1) / 100.0;
                    }else {
                        prix = temp / 100.0;
                    }
                    System.out.println("\nMontant restant: " + dec2.format(prix));
                } else if (piece == 'e' || piece == 'E') {
                    prix = prix - DEUX;
                    temp = (int)(prix*100);
                    if (temp % 5 == 4) {
                        prix = (temp + 1) / 100.0;
                    }else {
                        prix = temp / 100.0;
                    }
                    System.out.println("\nMontant restant: " + dec2.format(prix));
                } else {
                    System.out.println("\nTransaction nulle.");
                }
                
                if (prix < 0) {
                    nbChangeDonne = nbChangeDonne +1;
                    totalVente = totalVente + vente;
                } else if (prix == 0) {
                    nbMontantExact = nbMontantExact + 1;
                    totalVente = totalVente + vente;
                }
            } 
 
            if (!(piece == 'f' || piece == 'F')) {
                if (prix < 0) {
                    prix = - prix;
                }
                System.out.println("\nMontant à remettre: " + dec2.format(prix));
                if (choix == 'a' || choix == 'A') {
                    System.out.println("Voici votre breuvage: Boisson gazeuse");
                } else if (choix == 'b' || choix == 'B') {
                    System.out.println("Voici votre breuvage: Jus");
                } else if (choix == 'c' || choix == 'C') {
                    System.out.println("Voici votre breuvage: Eau minérale");
                } else {
                    System.out.println("Voici votre breuvage: Boisson Energisante");
                }
            }
            
             System.out.println("\nCHOIX DE BREUVAGE");
             System.out.println("a - Boisson gazeuze (2,25$)");
             System.out.println("b - Jus (2,65$)");
             System.out.println("c - Eau (1,55$)");
             System.out.println("d - Boisson énergisante (2.95$)");
             System.out.println("e - Terminer la simulation");
    
             System.out.print("\nQuel est votre choix? ");
             choix = Clavier.lireCharLn(); 
    
            while (choix  < 'A' || choix > 'E' && choix < 'a' || choix > 'e') {
                System.out.println ("\nErreur! Ceci ne fait pas partie des choix.");
                System.out.print("Quel est votre choix? ");
                choix = Clavier.lireCharLn();
               }
                
        }    
       
        System.out.println ("\n\nVoici les statistiques de fermeture:");
        
        System.out.println ("\nNombre de boisson gazeuses sélectionnées: " + nbBoissonGazeuse);
        System.out.println ("Nombre de jus selectionné: " + nbJus);
        System.out.println ("Nombre d'eaux minérales sélectionnées: " + nbEau);
        System.out.println ("Nombre de boissons énergisantes sélectionnées: " + nbBoissonEnergisante);
        
        System.out.println ("Total des ventes: " + dec2.format(totalVente));
        
        System.out.println ("Nombre de fois que le montant exact a été donné: " + nbMontantExact);
        System.out.println ("Nombre de fois qu'on a dû doner du change: " + nbChangeDonne);
    } // Ébauche_1
}
