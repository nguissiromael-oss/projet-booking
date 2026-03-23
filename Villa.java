import java.util.ArrayList;

/**
 * Classe Villa.
 * Specialisation de Hebergement representant une villa de luxe.
 *
 * Attributs specifiques : presence d'une piscine et nombre de chambres.
 * Logique de prix : prix de base * nb nuits, avec supplement piscine
 * et reduction de 15% pour les sejours de plus de 7 nuits.
 */
public class Villa extends Hebergement {

    // Attributs prives specifiques a une villa
    private boolean piscine;
    private int     nbChambres;

    // -------------------------------------------------------------------------
    // Constructeur 1 : par defaut
    // -------------------------------------------------------------------------

    public Villa() {
        super();
        this.piscine    = false;
        this.nbChambres = 1;
    }

    // -------------------------------------------------------------------------
    // Constructeur 2 : avec parametres
    // -------------------------------------------------------------------------

    public Villa(String idUnique, String nom, String adressePostale,
                 int nbMaxPersonnes, double prixNuit, String description,
                 ArrayList<String> equipements, String lienPhotos,
                 boolean piscine, int nbChambres) {
        super(idUnique, nom, adressePostale, "Villa",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.piscine    = piscine;
        this.nbChambres = nbChambres;
    }

    // -------------------------------------------------------------------------
    // Constructeur 3 : par copie
    // -------------------------------------------------------------------------

    public Villa(Villa v) {
        super(v);
        this.piscine    = v.piscine;
        this.nbChambres = v.nbChambres;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public boolean isPiscine()    { return piscine; }
    public int     getNbChambres() { return nbChambres; }

    // -------------------------------------------------------------------------
    // Methode abstraite : implementation
    // Prix total avec supplement piscine (30 EUR/nuit) et reduction longue duree.
    // -------------------------------------------------------------------------

    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre strictement positif.");

        double supplementPiscine = piscine ? 30.0 : 0.0;
        double prixBase = (getPrixNuit() + supplementPiscine) * nbNuits;

        // Reduction de 15% pour les sejours de plus de 7 nuits
        if (nbNuits > 7) {
            prixBase = prixBase * 0.85;
        }
        return prixBase;
    }

    // -------------------------------------------------------------------------
    // Methode specifique : prix par chambre par nuit
    // -------------------------------------------------------------------------

    public double calculerPrixParChambre() {
        if (nbChambres <= 0)
            throw new IllegalStateException("Le nombre de chambres doit etre positif.");
        return getPrixNuit() / nbChambres;
    }

    // -------------------------------------------------------------------------
    // afficher()
    // -------------------------------------------------------------------------

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("  Piscine     : " + (piscine ? "Oui" : "Non"));
        System.out.println("  Nb chambres : " + nbChambres);
        System.out.printf ("  Prix/chambre: %.2f EUR/nuit%n", calculerPrixParChambre());
    }

    // -------------------------------------------------------------------------
    // toString()
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
               ", piscine=" + (piscine ? "oui" : "non") +
               ", nbChambres=" + nbChambres +
               "}";
    }
}
