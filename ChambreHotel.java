import java.util.ArrayList;

/*
 * Classe ChambreHotel
 * Represente une chambre dans un hotel.
 * Herite de Hebergement et implemente calculerPrixTotal().
 *
 * Attributs specifiques : le numero de chambre et la categorie.
 * La taxe de sejour varie selon la categorie (Standard, Deluxe ou Suite).
 */
public class ChambreHotel extends Hebergement {

    private int    numero;
    private String categorie;  // "Standard", "Deluxe" ou "Suite"


    // constructeur par defaut
    public ChambreHotel() {
        super();
        this.numero    = 0;
        this.categorie = "Standard";
    }

    // constructeur avec parametres
    public ChambreHotel(String idUnique, String nom, String adressePostale, String zone,
                        int nbMaxPersonnes, double prixNuit, String description,
                        ArrayList<String> equipements, String lienPhotos,
                        int numero, String categorie) {
        super(idUnique, nom, adressePostale, zone, "ChambreHotel",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.numero    = numero;
        this.categorie = categorie;
    }

    // constructeur par copie
    // on utilise this.numero et this.categorie pour affecter les valeurs
    // sur l'objet cible (le nouveau), et ch.numero pour lire depuis la source
    public ChambreHotel(ChambreHotel ch) {
        super(ch);
        this.numero    = ch.numero;
        this.categorie = ch.categorie;
    }


    // getters
    public int    getNumero()    { return numero; }
    public String getCategorie() { return categorie; }


    /*
     * Implementation de la methode abstraite.
     * Prix total = (prix/nuit + taxe de sejour) * nb nuits
     * La taxe depend de la categorie de la chambre.
     */
    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre positif.");

        double taxe;
        if (categorie.equalsIgnoreCase("Suite")) {
            taxe = 5.0;
        } else if (categorie.equalsIgnoreCase("Deluxe")) {
            taxe = 3.5;
        } else {
            taxe = 2.0; // Standard
        }

        return (getPrixNuit() + taxe) * nbNuits;
    }

    // prix special week-end : 2 nuits avec 10% de reduction
    public double calculerPrixWeekEnd() {
        return calculerPrixTotal(2) * 0.90;
    }


    @Override
    public void afficher() {
        super.afficher();
        System.out.println("  Numero ch.  : " + numero);
        System.out.println("  Categorie   : " + categorie);
        System.out.printf ("  Week-end    : %.2f EUR (2 nuits -10%%)%n", calculerPrixWeekEnd());
    }

    @Override
    public String toString() {
        return "ChambreHotel{" + super.toString() +
               ", numero=" + numero + ", categorie='" + categorie + "'}";
    }
}
