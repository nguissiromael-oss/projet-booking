import java.io.Serializable;
import java.util.ArrayList;

/*
 * Classe abstraite Hebergement
 * C'est la classe de base pour tous les types d'hebergements de notre application.
 * On la met abstraite car on ne cree jamais un "hebergement" tout seul,
 * on cree toujours soit une ChambreHotel, soit un Appartement, soit une Villa.
 *
 * Elle implemente Comparable pour pouvoir trier par prix,
 * et Serializable pour sauvegarder les objets dans un fichier .ser (TP5).
 */
public abstract class Hebergement implements Comparable<Hebergement>, Serializable {

    private static final long serialVersionUID = 1L;

    // attributs prives communs a tous les hebergements
    private String idUnique;
    private String nom;
    private String adressePostale;
    private String zone;           // zone geographique de l'hebergement
    private String type;
    private int    nbMaxPersonnes;
    private double prixNuit;
    private String description;
    private ArrayList<String> equipements;
    private String lienPhotos;
    private ArrayList<String> commentairesClients;


    // --- constructeur par defaut ---
    public Hebergement() {
        this.idUnique            = "H000";
        this.nom                 = "Hebergement inconnu";
        this.adressePostale      = "Adresse inconnue";
        this.zone                = "Zone inconnue";
        this.type                = "Indefini";
        this.nbMaxPersonnes      = 1;
        this.prixNuit            = 0.0;
        this.description         = "Aucune description";
        this.equipements         = new ArrayList<String>();
        this.lienPhotos          = "";
        this.commentairesClients = new ArrayList<String>();
    }

    // --- constructeur avec parametres ---
    public Hebergement(String idUnique, String nom, String adressePostale, String zone,
                       String type, int nbMaxPersonnes, double prixNuit,
                       String description, ArrayList<String> equipements, String lienPhotos) {
        this.idUnique            = idUnique;
        this.nom                 = nom;
        this.adressePostale      = adressePostale;
        this.zone                = zone;
        this.type                = type;
        this.nbMaxPersonnes      = nbMaxPersonnes;
        this.prixNuit            = prixNuit;
        this.description         = description;
        this.equipements         = (equipements != null) ? equipements : new ArrayList<String>();
        this.lienPhotos          = lienPhotos;
        this.commentairesClients = new ArrayList<String>();
    }

    // --- constructeur par copie ---
    // on utilise this pour referencer l'objet en cours de construction
    public Hebergement(Hebergement h) {
        this.idUnique            = h.idUnique;
        this.nom                 = h.nom;
        this.adressePostale      = h.adressePostale;
        this.zone                = h.zone;
        this.type                = h.type;
        this.nbMaxPersonnes      = h.nbMaxPersonnes;
        this.prixNuit            = h.prixNuit;
        this.description         = h.description;
        this.equipements         = new ArrayList<String>(h.equipements);
        this.lienPhotos          = h.lienPhotos;
        this.commentairesClients = new ArrayList<String>(h.commentairesClients);
    }


    // --- methode abstraite ---
    // chaque sous-classe calcule son prix total a sa facon
    public abstract double calculerPrixTotal(int nbNuits);


    // --- getters ---
    public String            getIdUnique()            { return idUnique; }
    public String            getNom()                 { return nom; }
    public String            getAdressePostale()      { return adressePostale; }
    public String            getZone()                { return zone; }
    public String            getType()                { return type; }
    public int               getNbMaxPersonnes()      { return nbMaxPersonnes; }
    public double            getPrixNuit()            { return prixNuit; }
    public String            getDescription()         { return description; }
    public ArrayList<String> getEquipements()         { return equipements; }
    public String            getLienPhotos()          { return lienPhotos; }
    public ArrayList<String> getCommentairesClients() { return commentairesClients; }


    // --- setters avec validation basique ---
    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty())
            throw new IllegalArgumentException("Le nom ne peut pas etre vide.");
        this.nom = nom;
    }

    public void setPrixNuit(double prixNuit) {
        if (prixNuit < 0)
            throw new IllegalArgumentException("Le prix ne peut pas etre negatif.");
        this.prixNuit = prixNuit;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }


    // --- methodes utilitaires ---

    public void ajouterCommentaire(String commentaire) {
        if (commentaire == null || commentaire.trim().isEmpty())
            throw new IllegalArgumentException("Le commentaire ne peut pas etre vide.");
        commentairesClients.add(commentaire);
    }

    // verifie si l'hebergement peut accueillir le nombre de personnes demande
    public boolean estDisponiblePour(int nbPersonnes) {
        if (nbPersonnes <= 0)
            throw new IllegalArgumentException("Le nombre de personnes doit etre positif.");
        return nbPersonnes <= this.nbMaxPersonnes;
    }

    // retourne un resume sur une seule ligne (utile pour l'affichage compact)
    public String retournerResume() {
        return "[" + type + "] " + nom + " (" + zone + ")" +
               " - " + nbMaxPersonnes + " pers. max" +
               " - " + prixNuit + " EUR/nuit";
    }


    // --- Comparable : on trie par prix croissant ---
    @Override
    public int compareTo(Hebergement autre) {
        return Double.compare(this.prixNuit, autre.prixNuit);
    }


    // --- afficher() : affiche toutes les infos ---
    public void afficher() {
        System.out.println("==============================================");
        System.out.println("  ID          : " + idUnique);
        System.out.println("  Nom         : " + nom);
        System.out.println("  Type        : " + type);
        System.out.println("  Zone        : " + zone);
        System.out.println("  Adresse     : " + adressePostale);
        System.out.println("  Capacite    : " + nbMaxPersonnes + " personne(s)");
        System.out.println("  Prix/nuit   : " + prixNuit + " EUR");
        System.out.println("  Description : " + description);
        System.out.println("  Equipements : " + equipements);
        System.out.println("  Photos      : " + lienPhotos);
        if (!commentairesClients.isEmpty())
            System.out.println("  Avis        : " + commentairesClients);
        System.out.println("==============================================");
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "Hebergement{id='" + idUnique + "', nom='" + nom +
               "', zone='" + zone + "', type='" + type +
               "', capacite=" + nbMaxPersonnes + ", prix=" + prixNuit + " EUR/nuit}";
    }
}
