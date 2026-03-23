import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe abstraite Hebergement.
 * Represente un hebergement generique dans l'application Booking.
 *
 * Choix de la classe abstraite : un hebergement sans type precis n'existe pas
 * concretement dans notre systeme. On reserve toujours une ChambreHotel,
 * un Appartement ou une Villa, jamais un "Hebergement" generique.
 *
 * Implements Comparable pour le tri par prix.
 * Implements Serializable pour la sauvegarde binaire (TP5).
 */
public abstract class Hebergement implements Comparable<Hebergement>, Serializable {

    // Necessaire pour la serialisation : identifie la version de la classe
    private static final long serialVersionUID = 1L;

    // Attributs prives communs a tous les hebergements
    private String idUnique;
    private String nom;
    private String adressePostale;
    private String type;
    private int    nbMaxPersonnes;
    private double prixNuit;
    private String description;
    private ArrayList<String> equipements;
    private String lienPhotos;
    private ArrayList<String> commentairesClients;

    // -------------------------------------------------------------------------
    // Constructeurs
    // -------------------------------------------------------------------------

    /** Constructeur par defaut : valeurs neutres */
    public Hebergement() {
        this.idUnique             = "H000";
        this.nom                  = "Hebergement inconnu";
        this.adressePostale       = "Adresse inconnue";
        this.type                 = "Indefini";
        this.nbMaxPersonnes       = 1;
        this.prixNuit             = 0.0;
        this.description          = "Aucune description";
        this.equipements          = new ArrayList<String>();
        this.lienPhotos           = "";
        this.commentairesClients  = new ArrayList<String>();
    }

    /** Constructeur avec parametres */
    public Hebergement(String idUnique, String nom, String adressePostale,
                       String type, int nbMaxPersonnes, double prixNuit,
                       String description, ArrayList<String> equipements,
                       String lienPhotos) {
        this.idUnique             = idUnique;
        this.nom                  = nom;
        this.adressePostale       = adressePostale;
        this.type                 = type;
        this.nbMaxPersonnes       = nbMaxPersonnes;
        this.prixNuit             = prixNuit;
        this.description          = description;
        this.equipements          = (equipements != null) ? equipements : new ArrayList<String>();
        this.lienPhotos           = lienPhotos;
        this.commentairesClients  = new ArrayList<String>();
    }

    /** Constructeur par copie */
    public Hebergement(Hebergement h) {
        this.idUnique             = h.idUnique;
        this.nom                  = h.nom;
        this.adressePostale       = h.adressePostale;
        this.type                 = h.type;
        this.nbMaxPersonnes       = h.nbMaxPersonnes;
        this.prixNuit             = h.prixNuit;
        this.description          = h.description;
        this.equipements          = new ArrayList<String>(h.equipements);
        this.lienPhotos           = h.lienPhotos;
        this.commentairesClients  = new ArrayList<String>(h.commentairesClients);
    }

    // -------------------------------------------------------------------------
    // Methode abstraite
    // Chaque sous-classe definit sa propre logique de tarification.
    // -------------------------------------------------------------------------

    /**
     * Calcule le prix total du sejour pour un nombre de nuits donne.
     * Methode abstraite : la logique depend du type d'hebergement.
     * @param nbNuits nombre de nuits du sejour
     * @return prix total en euros
     */
    public abstract double calculerPrixTotal(int nbNuits);

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public String            getIdUnique()              { return idUnique; }
    public String            getNom()                   { return nom; }
    public String            getAdressePostale()        { return adressePostale; }
    public String            getType()                  { return type; }
    public int               getNbMaxPersonnes()        { return nbMaxPersonnes; }
    public double            getPrixNuit()              { return prixNuit; }
    public String            getDescription()           { return description; }
    public ArrayList<String> getEquipements()           { return equipements; }
    public String            getLienPhotos()            { return lienPhotos; }
    public ArrayList<String> getCommentairesClients()   { return commentairesClients; }

    // -------------------------------------------------------------------------
    // Setters avec validation
    // -------------------------------------------------------------------------

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty())
            throw new IllegalArgumentException("Le nom de l'hebergement ne peut pas etre vide.");
        this.nom = nom;
    }

    public void setPrixNuit(double prixNuit) {
        if (prixNuit < 0)
            throw new IllegalArgumentException("Le prix par nuit ne peut pas etre negatif.");
        this.prixNuit = prixNuit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // -------------------------------------------------------------------------
    // Autres methodes
    // -------------------------------------------------------------------------

    /**
     * Ajoute un commentaire client a la liste.
     * @param commentaire texte du commentaire
     */
    public void ajouterCommentaire(String commentaire) {
        if (commentaire == null || commentaire.trim().isEmpty())
            throw new IllegalArgumentException("Le commentaire ne peut pas etre vide.");
        this.commentairesClients.add(commentaire);
    }

    /**
     * Verifie si l'hebergement est disponible pour un nombre de personnes donne.
     * @param nbPersonnes nombre de voyageurs
     * @return true si la capacite est suffisante
     */
    public boolean estDisponiblePour(int nbPersonnes) {
        if (nbPersonnes <= 0)
            throw new IllegalArgumentException("Le nombre de personnes doit etre positif.");
        return nbPersonnes <= this.nbMaxPersonnes;
    }

    /**
     * Retourne un resume court de l'hebergement.
     */
    public String retournerResume() {
        return "[" + type + "] " + nom + " - " + adressePostale +
               " | " + nbMaxPersonnes + " pers. max | " + prixNuit + " EUR/nuit";
    }

    // -------------------------------------------------------------------------
    // Comparable : tri par prix croissant
    // -------------------------------------------------------------------------

    @Override
    public int compareTo(Hebergement autre) {
        return Double.compare(this.prixNuit, autre.prixNuit);
    }

    // -------------------------------------------------------------------------
    // afficher() et toString()
    // -------------------------------------------------------------------------

    /** Affiche toutes les informations de l'hebergement dans la console. */
    public void afficher() {
        System.out.println("==============================================");
        System.out.println("  ID          : " + idUnique);
        System.out.println("  Nom         : " + nom);
        System.out.println("  Type        : " + type);
        System.out.println("  Adresse     : " + adressePostale);
        System.out.println("  Capacite    : " + nbMaxPersonnes + " personne(s)");
        System.out.println("  Prix/nuit   : " + prixNuit + " EUR");
        System.out.println("  Description : " + description);
        System.out.println("  Equipements : " + equipements);
        System.out.println("  Photos      : " + lienPhotos);
        if (!commentairesClients.isEmpty())
            System.out.println("  Avis clients: " + commentairesClients);
        System.out.println("==============================================");
    }

    @Override
    public String toString() {
        return "Hebergement{" +
               "id='" + idUnique + "'" +
               ", nom='" + nom + "'" +
               ", type='" + type + "'" +
               ", adresse='" + adressePostale + "'" +
               ", capacite=" + nbMaxPersonnes +
               ", prix=" + prixNuit + " EUR/nuit" +
               "}";
    }
}
