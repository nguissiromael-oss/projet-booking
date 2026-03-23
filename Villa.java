import java.util.ArrayList;

/*
 * Classe Villa
 * Represente une villa ou maison de vacances.
 * Herite de Hebergement.
 *
 * Attributs specifiques : presence d'une piscine et nombre de chambres.
 * Prix total : supplement piscine de 30 EUR/nuit + reduction -15% si sejour > 7 nuits.
 */
public class Villa extends Hebergement {

    private boolean piscine;
    private int     nbChambres;


    // constructeur par defaut
    public Villa() {
        super();
        this.piscine    = false;
        this.nbChambres = 1;
    }

    // constructeur avec parametres
    public Villa(String idUnique, String nom, String adressePostale, String zone,
                 int nbMaxPersonnes, double prixNuit, String description,
                 ArrayList<String> equipements, String lienPhotos,
                 boolean piscine, int nbChambres) {
        super(idUnique, nom, adressePostale, zone, "Villa",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.piscine    = piscine;
        this.nbChambres = nbChambres;
    }

    // constructeur par copie
    public Villa(Villa v) {
        super(v);
        this.piscine    = v.piscine;
        this.nbChambres = v.nbChambres;
    }


    // getters
    public boolean isPiscine()     { return piscine; }
    public int     getNbChambres() { return nbChambres; }


    // implementation de la methode abstraite
    // supplement de 30 EUR/nuit si piscine, et -15% si plus de 7 nuits
    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre positif.");

        double supplementPiscine = piscine ? 30.0 : 0.0;
        double total = (getPrixNuit() + supplementPiscine) * nbNuits;

        if (nbNuits > 7)
            total = total * 0.85; // reduction longue duree

        return total;
    }

    // prix par chambre par nuit (pour comparer)
    public double calculerPrixParChambre() {
        if (nbChambres <= 0)
            throw new IllegalStateException("Le nombre de chambres doit etre positif.");
        return getPrixNuit() / nbChambres;
    }


    @Override
    public void afficher() {
        super.afficher();
        System.out.println("  Piscine     : " + (piscine ? "Oui" : "Non"));
        System.out.println("  Nb chambres : " + nbChambres);
        System.out.printf ("  Prix/chambre: %.2f EUR/nuit%n", calculerPrixParChambre());
    }

    @Override
    public String toString() {
        return "Villa{" + super.toString() +
               ", piscine=" + (piscine ? "oui" : "non") +
               ", nbChambres=" + nbChambres + "}";
    }
}
