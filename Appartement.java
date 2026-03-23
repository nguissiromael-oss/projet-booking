import java.util.ArrayList;

/**
 * Classe Appartement.
 * Specialisation de Hebergement representant un appartement en location.
 *
 * Attributs specifiques : superficie et acceptation des animaux.
 * Logique de prix : prix de base * nb nuits + frais de menage fixes (50 EUR).
 */
public class Appartement extends Hebergement {

    // Attributs prives specifiques a un appartement
    private double  superficieM2;
    private boolean animauxAcceptes;

    // -------------------------------------------------------------------------
    // Constructeur 1 : par defaut
    // -------------------------------------------------------------------------

    public Appartement() {
        super();
        this.superficieM2    = 0.0;
        this.animauxAcceptes = false;
    }

    // -------------------------------------------------------------------------
    // Constructeur 2 : avec parametres
    // -------------------------------------------------------------------------

    public Appartement(String idUnique, String nom, String adressePostale,
                       int nbMaxPersonnes, double prixNuit, String description,
                       ArrayList<String> equipements, String lienPhotos,
                       double superficieM2, boolean animauxAcceptes) {
        super(idUnique, nom, adressePostale, "Appartement",
              nbMaxPersonnes, prixNuit, description, equipements, lienPhotos);
        this.superficieM2    = superficieM2;
        this.animauxAcceptes = animauxAcceptes;
    }

    // -------------------------------------------------------------------------
    // Constructeur 3 : par copie
    // -------------------------------------------------------------------------

    public Appartement(Appartement a) {
        super(a);
        this.superficieM2    = a.superficieM2;
        this.animauxAcceptes = a.animauxAcceptes;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public double  getSuperficieM2()    { return superficieM2; }
    public boolean isAnimauxAcceptes()  { return animauxAcceptes; }

    // -------------------------------------------------------------------------
    // Methode abstraite : implementation
    // Prix total = prix/nuit * nb nuits + frais de menage (50 EUR fixes)
    // -------------------------------------------------------------------------

    @Override
    public double calculerPrixTotal(int nbNuits) {
        if (nbNuits <= 0)
            throw new IllegalArgumentException("Le nombre de nuits doit etre strictement positif.");
        double fraisMenage = 50.0;
        return getPrixNuit() * nbNuits + fraisMenage;
    }

    // -------------------------------------------------------------------------
    // Methode specifique : calcul du prix par m2 par nuit
    // -------------------------------------------------------------------------

    public double calculerPrixParM2() {
        if (superficieM2 <= 0)
            throw new IllegalStateException("La superficie doit etre positive pour ce calcul.");
        return getPrixNuit() / superficieM2;
    }

    // -------------------------------------------------------------------------
    // afficher()
    // -------------------------------------------------------------------------

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("  Superficie  : " + superficieM2 + " m2");
        System.out.println("  Animaux     : " + (animauxAcceptes ? "Oui" : "Non"));
        System.out.printf ("  Prix/m2/nuit: %.2f EUR%n", calculerPrixParM2());
    }

    // -------------------------------------------------------------------------
    // toString()
    // -------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Appartement{" + super.toString() +
               ", superficie=" + superficieM2 + " m2" +
               ", animaux=" + (animauxAcceptes ? "oui" : "non") +
               "}";
    }
}
