package edu.formation;

import java.util.Scanner;

public class AllumettesMain
{

    public static void main(String args[])
    {

        int joueurInt = 1, tour = 0, tour1 = 0, conditionAllumettes,
                nbJoueur = 1;
        int allumettesInitiales, allumettes = 0, allumettesSelectionnees,
                nbAllumettesMax;
        String joueurString, allumetteDessin;
        Scanner sc = new Scanner(System.in);

        // Présentation du programme
        System.out.println(
                "********************************************************");
        System.out.println(
                "****               JEU DES ALLUMETTES               ****");
        System.out.println(
                "********************************************************\n");

        // Nombre d'allumettes maximales
        System.out.println("Avec combien d'allumettes voulez-vous jouer ?");
        allumettesInitiales = sc.nextInt();

        // Initialisation de mon nombre d'allumettes
        allumettes = allumettesInitiales;

        // Nombre d'allumettes maximales
        System.out.println(
                "Combien d'allumettes voulez-vous pouvoir retirer au maximum ?");
        nbAllumettesMax = sc.nextInt();

        // Boucle permettant de jouer tant qu'il reste plus de 1 allumettes
        while (allumettes > 1)
        {

            // Comptage des tours effectués
            tour += 1;
            System.out.println("Tour numéro : " + tour);

            // remise à zéro du nombre d'allumettes sélectionnées
            allumettesSelectionnees = 0;

            // Affichage du nombre d'allumettes restantes
            if (tour == 1)
            {
                System.out.println("Il y a " + allumettes + " allumettes.");
            }
            else
            {
                System.out.println("Il reste " + allumettes + " allumettes.");
            }

            // Permet de sauter une ligne pour une meilleure visibilité
            System.out.print("\n");

            // Affichage des allumettes
            System.out.println("Illustration des allumettes restantes :");
            for (int i = 1; i <= allumettes; ++i)
            {
                System.out.print("|");
            }
            System.out.println("\n");

            // Condition permettant de savoir quel joueur est en train de jouer
            if (tour % 2 != 0)
            {
                joueurString = "Joueur 1";
                joueurInt = 1;
            }
            else 
            {
                joueurString = "Joueur 2";
                joueurInt = 2;
            }

            // Condition permettant de modifier le nombre d'allumettes max
            // sélectionnables par le joueur
            if (allumettes > nbAllumettesMax)
            {
                conditionAllumettes = nbAllumettesMax;
            }
            else
            {
                conditionAllumettes = allumettes - 1;
            }

            // Cas à afficher suivant s'il s'agit du joueur 1 ou du joueur 2 de
            // jouer
            switch (joueurInt)
            {
                case 1:
                    tour1 = 0;

                    // condition permettant de choisir le nombre d'allumettes
                    while (allumettesSelectionnees < 1
                            || allumettesSelectionnees > conditionAllumettes)
                    {
                        if (tour1 == 0)
                        {
                            System.out.println(
                                    "Joueur 1, veuillez sélectionner 1 à "
                                            + conditionAllumettes
                                            + " allumettes ?");
                            allumettesSelectionnees = sc.nextInt();
                            tour1 += 1;
                        }
                        // Message d'erreur car pas le bon nombre d'allumettes
                        else
                        {
                            System.err.println(
                                    "Joueur 1, veuillez renseigner une valeur comprise entre 1 et "
                                            + conditionAllumettes);
                            allumettesSelectionnees = sc.nextInt();
                            tour1 += 1;
                        }
                    }
                    break;

                case 2:
                    tour1 = 0;

                    // condition permettant de choisir le nombre d'allumettes
                    while (allumettesSelectionnees < 1
                            || allumettesSelectionnees > conditionAllumettes)
                    {
                        if (tour1 == 0)
                        {
                            System.out.println(
                                    "Joueur 2, veuillez sélectionner 1 à "
                                            + conditionAllumettes
                                            + " allumettes ?");
                            allumettesSelectionnees = sc.nextInt();
                            tour1 += 1;
                        }
                        // Message d'erreur car pas le bon nombre d'allumettes
                        else
                        {
                            System.err.println(
                                    "Joueur 2, veuillez renseigner une valeur comprise entre 1 et "
                                            + conditionAllumettes);
                            allumettesSelectionnees = sc.nextInt();
                            tour1 += 1;
                        }
                    }
                    break;

                default:
                    System.err.println("Erreur de programmation !");
                    break;
            }

            // calcul du nombre d'allumettes restantes
            allumettes = allumettes - allumettesSelectionnees;

            // Phrase finale permettant de dire quel joueur a gagné
            if (allumettes == 1)
            {
                switch (joueurInt)
                {
                    case 1:
                        System.out.println("Joueur 1 a gagné.");
                        break;

                    case 2:
                        System.out.println("Joueur 2 a gagné.");
                        break;

                    default:
                        System.err.println("Erreur de programmation !");
                        break;
                } // fin de la
            } // fin de la boucle permettant de dire quel joueur a gagné

        }
    }

}
