import java.util.ArrayList;

/**
 * Classe ChambreHotel.
 * Specialisation de Hebergement representant une chambre dans un hotel.
 *
 * Attributs specifiques : numero de chambre et categorie (Standard, Deluxe, Suite).
 * Logique de prix : prix de base + taxe de sejour de 2 EUR par nuit.
 */
public class ChambreHotel extends Hebergement {

    // Attributs prives specifiques a une chambre d'hotel
    private int    numero;
    private String categorie; // "Standard", "Deluxe", "Suite"

    // -------------------------------------------------------------------------
    // Constructeur 1 : par defaut
    // -------------------------------------------------------------------------

    public ChambreHotel() {
        super(); // appel du constructeur par defaut de Hebergement
        this.numero    = 0;
        this.categorie = "Standard";
    }

    // -------------------------------------------------------------------------
    // Constructeur 2 : avec parametres
    // -------------------------------------------------------------------------

    public ChambreHotel(String idUnique, String nom, String adressePostale,
                        int nbMaxPersonnes, double prixNuit, String description,
                        ArrayList<String> equipements, String lienPhotos,
                        int numero, String categorie) {
        // super() transmet les attributs communs a la classe parent Hebergement
        super(idUnique, nom, adressePostale, "ChambreHotel",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.numero    = numero;
        this.categorie = categorie;
    }

    // -------------------------------------------------------------------------
    // Constructeur 3 : par copie
    // On utilise this pour referencer l'objet en cours de construction,
    // et super(ch) pour copier les attributs de la classe parent.
    // -------------------------------------------------------------------------

    public ChambreHotel(ChambreHotel ch) {
        super(ch); // copie les attributs herites de Hebergement
        this.numero    = ch.numero;    // this designe l'objet cible (nouveau)
        this.categorie = ch.categorie; // ch designe l'objet source (a copier)
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public int    getNumero()    { return numero; }
    public String getCategorie() { return categorie; }

    // -------------------------------------------------------------------------
    // Methode abstraite : implementation obligatoire
    // Prix total = (prix/nuit + taxe de sejour) * nb nuits
    // La taxe varie selon la categorie de chambre.
    // -------------------------------------------------------------------------

    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre strictement positif.");

        double taxeSejour;
        if (this.categorie.equalsIgnoreCase("Suite")) {
            taxeSejour = 5.0; // taxe plus elevee pour une suite
        } else if (this.categorie.equalsIgnoreCase("Deluxe")) {
            taxeSejour = 3.5;
        } else {
            taxeSejour = 2.0; // taxe standard
        }
        return (getPrixNuit() + taxeSejour) * nbNuits;
    }

    // -------------------------------------------------------------------------
    // Methode specifique : promotion week-end
    // Reduit le prix de 10% pour les sejours de 2 nuits le week-end.
    // -------------------------------------------------------------------------

    public double calculerPrixWeekEnd() {
        double reduction = 0.10;
        return calculerPrixTotal(2) * (1 - reduction);
    }

    // -------------------------------------------------------------------------
    // afficher() : surcharge de la methode parent
    // -------------------------------------------------------------------------

    @Override
    public void afficher() {
        super.afficher(); // affiche les attributs communs
        System.out.println("  Numero ch.  : " + numero);
        System.out.println("  Categorie   : " + categorie);
        System.out.println("  Week-end    : " + calculerPrixWeekEnd() + " EUR (2 nuits, -10%)");
    }

    // -------------------------------------------------------------------------
    // toString()
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "ChambreHotel{" + super.toString() +
               ", numero=" + numero +
               ", categorie='" + categorie + "'" +
               "}";
    }
}
