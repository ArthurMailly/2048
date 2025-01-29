package com.ares.Model;
import java.util.Random;

/**
 * Cette classe crée le modèle du plateau de jeu
 */
public class Plateau
{
    private int score;
    private int cote_x;
    private int cote_y;
    private Case tableau_case[][];


    /**
     * Constructeur d'un plateau
     * @param x Nombre de lignes
     * @param y Nombre de colonnes
     */
    public Plateau(int x, int y)
    {
        this.score = 0;
        this.cote_x = x;
        this.cote_y = y;

        this.tableau_case = new Case[this.cote_x][this.cote_y];

        // Initialisation d'un tableau vierge
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = 0; j < this.cote_y; j++)
            {
                CreerCase(i, j, true);
            }
        }
        // Initialisation des deux premières cases différentes de 0

        PlaceCaseAleatoire();
        PlaceCaseAleatoire();
    }


    /**
     * Affiche le plateau dans la console, sert au débug
     */
    public void AfficherPlateau()
    {
        for (int j = 0; j < this.cote_y; j++)
        {
            for (int i = 0; i < this.cote_x; i++)
            {
                this.tableau_case[i][j].print();
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }


    /**
     * Creer soit une case vide soit une nouvelle case 2 ou 4 tirée aléatoirement
     * @param x numéro de la ligne
     * @param y numéro de la colonne
     * @param b est à égal false si on veut créer une nouvelle case qui contient soit un 2 ou un 4. Si b = true, il s'agit d'une case vide
     */
    public void CreerCase(int x, int y, boolean b) { this.tableau_case[x][y] = new Case(b);}


    /**
     * Creer une case en lui donnant la valeur que nous voulons dedans
     * @param x numéro de la ligne
     * @param y numéro de la colonne
     * @param n valeur de la case
     */
    public void CreerCaseNum(int x, int y, int n) { this.tableau_case[x][y] = new Case(n);}


    /**
     * Choisi aléatoirement un emplacement vide et y créer un 2 ou un 4
     */
    public void PlaceCaseAleatoire()
    {
        // Choisi une case aléatoirement
        Random randomCase = new Random();
        int case_x = randomCase.nextInt(this.cote_x);
        int case_y = randomCase.nextInt(this.cote_y);

        // Choisi une nouvelle case tant que l'on n'a pas une case vide
        while(this.tableau_case[case_x][case_y].getNombre() != 0)
        {
            case_x = randomCase.nextInt(this.cote_x);
            case_y = randomCase.nextInt(this.cote_y);
        }

        CreerCase(case_x, case_y, false);

    }


    /**
     * Déplace l'ensemble des cases vers la gauche et fusionne les cases s'il y a besoin
     * @return deplacement_fait qui est à égal à true si au moins une case a été ajouté
     */
    public Boolean DeplacementGauche() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int j = 0; j < this.cote_y; j++) {
            for (int i = 1; i < this.cote_x; i++) { // On commence à la deuxième colonne
                int new_I = i;

                // Déplacement des cases vers la gauche
                while (new_I > 0 && this.tableau_case[new_I - 1][j].getNombre() == 0) {
                    if (this.tableau_case[new_I][j].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[new_I - 1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I, j, true); // Vide l'ancienne position
                    new_I--;
                }

                // Vérifie si une fusion est possible
                if (new_I > 0 &&
                        !this.tableau_case[new_I - 1][j].getDeja_fusionne() &&
                        this.tableau_case[new_I - 1][j].getNombre() == this.tableau_case[new_I][j].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[new_I - 1][j].getNombre() * 2;
                    CreerCaseNum(new_I - 1, j, num_case); // Crée la case fusionnée
                    CreerCase(new_I, j, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[new_I - 1][j].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }
        return deplacement_fait;
    }


    /**
     * Déplace l'ensemble des cases vers la droite et fusionne les cases s'il y a besoin
     * @return deplacement_fait qui est à égal à true si au moins une case a été ajouté
     */
    public Boolean DeplacementDroite() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int j = 0; j < this.cote_y; j++) {
            for (int i = this.cote_x - 2; i >= 0; i--) { // On commence à l'avant-dernière colonne
                int new_I = i;

                // Déplacement des cases vers la droite
                while (new_I < this.cote_x - 1 && this.tableau_case[new_I + 1][j].getNombre() == 0) {
                    if (this.tableau_case[new_I][j].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[new_I + 1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I, j, true); // Vide l'ancienne position
                    new_I++;
                }

                // Vérifie si une fusion est possible
                if (new_I < this.cote_x - 1 &&
                        !this.tableau_case[new_I + 1][j].getDeja_fusionne() &&
                        this.tableau_case[new_I + 1][j].getNombre() == this.tableau_case[new_I][j].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[new_I + 1][j].getNombre() * 2;
                    CreerCaseNum(new_I + 1, j, num_case); // Crée la case fusionnée
                    CreerCase(new_I, j, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[new_I + 1][j].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }
        return deplacement_fait;
    }


    /**
     * Déplace l'ensemble des cases vers le haut et fusionne les cases s'il y a besoin
     * @return deplacement_fait qui est à égal à true si au moins une case a été ajouté
     */
    public Boolean DeplacementHaut() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int i = 0; i < this.cote_x; i++) {
            for (int j = 1; j < this.cote_y; j++) { // On commence à la deuxième ligne
                int new_J = j;

                // Déplacement des cases vers le haut
                while (new_J > 0 && this.tableau_case[i][new_J - 1].getNombre() == 0) {
                    if (this.tableau_case[i][new_J].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[i][new_J - 1] = this.tableau_case[i][new_J];
                    CreerCase(i, new_J, true); // Vide l'ancienne position
                    new_J--;
                }

                // Vérifie si une fusion est possible
                if (new_J > 0 &&
                        !this.tableau_case[i][new_J - 1].getDeja_fusionne() &&
                        this.tableau_case[i][new_J - 1].getNombre() == this.tableau_case[i][new_J].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[i][new_J - 1].getNombre() * 2;
                    CreerCaseNum(i, new_J - 1, num_case); // Crée la case fusionnée
                    CreerCase(i, new_J, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[i][new_J - 1].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }
        return deplacement_fait;
    }


    /**
     * Déplace l'ensemble des cases vers le bas et fusionne les cases s'il y a besoin
     * @return deplacement_fait qui est à égal à true si au moins une case a été ajouté
     */
    public Boolean DeplacementBas() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int i = 0; i < this.cote_x; i++) {
            for (int j = this.cote_y - 2; j >= 0; j--) { // On part de l'avant-dernière ligne
                int new_J = j;

                // Déplacement des cases vers le bas
                while (new_J < this.cote_y - 1 && this.tableau_case[i][new_J + 1].getNombre() == 0) {
                    if (this.tableau_case[i][new_J].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[i][new_J + 1] = this.tableau_case[i][new_J];
                    CreerCase(i, new_J, true); // Vide l'ancienne position
                    new_J++;
                }

                // Vérifie si une fusion est possible
                if (new_J < this.cote_y - 1 &&
                        !this.tableau_case[i][new_J + 1].getDeja_fusionne() &&
                        this.tableau_case[i][new_J + 1].getNombre() == this.tableau_case[i][new_J].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[i][new_J + 1].getNombre() * 2;
                    CreerCaseNum(i, new_J + 1, num_case); // Crée la case fusionnée
                    CreerCase(i, new_J, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[i][new_J + 1].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }
        return deplacement_fait;
    }


    /**
     * Remet l'attribut deja_fusionne de chaque case à false pour le prochain mouvement
     */
    public void ToutesCasesPasFusionnees()
    {
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = 0; j < this.cote_y; j++)
            {
                this.tableau_case[i][j].setDeja_fusionne(false);
            }
        }
    }


    /**
     * Retourne le score du joueur
     * @return score
     */
    public int getScore()
    {
        return this.score;
    }


    /**
     * Retourne la case en fonction de sa position
     * @param i numéro de ligne
     * @param j numéro de colonne
     * @return la case à l'emplacement i,j
     */
    public Case getCase(int i,int j)
    {
        return this.tableau_case[i][j];
    }


    /**
     * Renvoie tableau_case
     * @return tableau_case
     */
    public Case[][] getTableau()
    {
        return this.tableau_case;
    }


    /**
     * Copie le plateau
     * @param plateau2 plateau à copier
     */
    public void copyPlateau(Plateau plateau2)
    {
        this.score = plateau2.score;
        this.cote_x = plateau2.cote_x;
        this.cote_y = plateau2.cote_y;

        for (int i = 0; i < cote_x; i++)
        {
            for (int j = 0; j < cote_y; j++)
            {
                // Utilise la fonction copyCase créé dans la classe Case
                this.tableau_case[i][j].copyCase(plateau2.tableau_case[i][j]);
            }
        }
    }

    /**
     * Regarde s'il y a une case qui contient un nombre supérieur ou égal à 2048 auquel cas le joueur a gagné.
     * @return true si le joueur a gagné
     */
    public boolean plateauGagne()
    {
        for (int i = 0; i < cote_x; i++)
        {
            for (int j = 0; j < cote_y; j++)
            {
                if (getCase(i,j).getNombre()>=2048) {return true;}
            }
        }

        return false;
    }

}
