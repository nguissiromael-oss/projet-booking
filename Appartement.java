import java.util.ArrayList;

/*
 * Classe Appartement
 * Represente un appartement en location.
 * Herite de Hebergement.
 *
 * Attributs specifiques : superficie et si les animaux sont acceptes.
 * Prix total = prix/nuit * nb nuits + frais de menage fixes (50 EUR).
 */
public class Appartement extends Hebergement {

    private double  superficieM2;
    private boolean animauxAcceptes;


    // constructeur par defaut
    public Appartement() {
        super();
        this.superficieM2    = 0.0;
        this.animauxAcceptes = false;
    }

    // constructeur avec parametres
    public Appartement(String idUnique, String nom, String adressePostale, String zone,
                       int nbMaxPersonnes, double prixNuit, String description,
                       ArrayList<String> equipements, String lienPhotos,
                       double superficieM2, boolean animauxAcceptes) {
        super(idUnique, nom, adressePostale, zone, "Appartement",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.superficieM2    = superficieM2;
        this.animauxAcceptes = animauxAcceptes;
    }

    // constructeur par copie
    public Appartement(Appartement a) {
        super(a);
        this.superficieM2    = a.superficieM2;
        this.animauxAcceptes = a.animauxAcceptes;
    }


    // getters
    public double  getSuperficieM2()   { return superficieM2; }
    public boolean isAnimauxAcceptes() { return animauxAcceptes; }


    // implementation de la methode abstraite
    // on ajoute 50 EUR de frais de menage fixes pour tout sejour
    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre positif.");
        double fraisMenage = 50.0;
        return getPrixNuit() * nbNuits + fraisMenage;
    }

    // calcul du prix par m2 par nuit (pour comparer les appartements)
    public double calculerPrixParM2() {
        if (superficieM2 <= 0)
            throw new IllegalStateException("La superficie doit etre positive.");
        return getPrixNuit() / superficieM2;
    }


    @Override
    public void afficher() {
        super.afficher();
        System.out.println("  Superficie  : " + superficieM2 + " m2");
        System.out.println("  Animaux     : " + (animauxAcceptes ? "Oui" : "Non"));
        System.out.printf ("  Prix/m2     : %.2f EUR/nuit%n", calculerPrixParM2());
    }

    @Override
    public String toString() {
        return "Appartement{" + super.toString() +
               ", superficie=" + superficieM2 + "m2" +
               ", animaux=" + (animauxAcceptes ? "oui" : "non") + "}";
    }
}
