import java.util.ArrayList;
import java.util.Collections;

/*
 * Interface IGestionHebergements
 * Definit les operations de base pour gerer une collection d'hebergements.
 */
interface IGestionHebergements {
    void ajouter(Hebergement h);
    void afficherTous();
    void trierParPrix();
    int  getTaille();
}

/*
 * Classe CollectionHebergements
 * Gere la liste des hebergements de l'application.
 *
 * On utilise une ArrayList et non un tableau classique car :
 * - sa taille est dynamique (on n'a pas a prevoir combien d'hebergements il y aura)
 * - elle possede des methodes pratiques : add(), remove(), size()...
 * - Collections.sort() fonctionne directement avec grace a l'interface Comparable
 */
public class CollectionHebergements implements IGestionHebergements {

    // la liste dynamique de tous nos hebergements
    private ArrayList<Hebergement> liste;

    /*
     * Zones predefinies dans notre application.
     * Si une zone saisie n'est pas dans cette liste,
     * on affiche un message a l'utilisateur.
     */
    private static final String[] ZONES_DISPONIBLES = {
        "Zone Nord",
        "Zone Sud",
        "Zone Est",
        "Zone Ouest",
        "Zone Centre"
    };


    // constructeur
    public CollectionHebergements() {
        this.liste = new ArrayList<Hebergement>();
    }


    // --- methodes de l'interface ---

    @Override
    public void ajouter(Hebergement h) {
        if (h == null)
            throw new IllegalArgumentException("Impossible d'ajouter un hebergement null.");
        liste.add(h);
        System.out.println("  [+] " + h.getNom() + " ajoute.");
    }

    @Override
    public void afficherTous() {
        if (liste.isEmpty()) {
            System.out.println("La collection est vide.");
            return;
        }
        System.out.println("\n=== " + liste.size() + " hebergement(s) disponible(s) ===");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println("\n--- Hebergement " + (i + 1) + " ---");
            liste.get(i).afficher();
        }
    }

    // tri par prix croissant avec Collections.sort()
    // qui utilise la methode compareTo() definie dans Hebergement
    @Override
    public void trierParPrix() {
        Collections.sort(liste);
        System.out.println("Collection triee par prix croissant.");
    }

    @Override
    public int getTaille() { return liste.size(); }


    // --- methodes de filtrage ---

    // filtre par type d'hebergement
    public ArrayList<Hebergement> filtrerParType(String type) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getType().equalsIgnoreCase(type)) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    // filtre par prix maximum par nuit
    public ArrayList<Hebergement> filtrerParPrixMax(double prixMax) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getPrixNuit() <= prixMax) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    // filtre par capacite minimale
    public ArrayList<Hebergement> filtrerParCapacite(int nbPersonnes) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getNbMaxPersonnes() >= nbPersonnes) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    /*
     * Filtre par zone geographique.
     *
     * On verifie d'abord si la zone demandee fait partie des zones predefinies.
     * Si ce n'est pas le cas, on informe l'utilisateur qu'on n'a pas de logements
     * dans cette zone. Sinon, on retourne tous les hebergements de cette zone.
     */
    public ArrayList<Hebergement> filtrerParZone(String zone) {

        // on verifie si la zone existe dans notre liste de zones predefinies
        boolean zoneConnue = false;
        for (String z : ZONES_DISPONIBLES) {
            if (z.equalsIgnoreCase(zone)) {
                zoneConnue = true;
                break;
            }
        }

        // si la zone n'est pas reconnue, on previent l'utilisateur
        if (!zoneConnue) {
            System.out.println("Nous n'avons pas de logements disponibles dans la zone : " + zone);
            System.out.println("Zones disponibles : ");
            for (String z : ZONES_DISPONIBLES) {
                System.out.println("   - " + z);
            }
            return new ArrayList<Hebergement>(); // on retourne une liste vide
        }

        // sinon on cherche les hebergements correspondants
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getZone().equalsIgnoreCase(zone)) {
                resultats.add(h);
            }
        }

        if (resultats.isEmpty()) {
            System.out.println("Aucun hebergement trouve dans la zone : " + zone);
        }

        return resultats;
    }

    // affiche uniquement les zones disponibles dans notre appli
    public void afficherZonesDisponibles() {
        System.out.println("Zones disponibles dans notre application :");
        for (String z : ZONES_DISPONIBLES) {
            System.out.println("   - " + z);
        }
    }

    // recherche par identifiant unique
    public Hebergement rechercherParId(String id) {
        for (Hebergement h : liste) {
            if (h.getIdUnique().equalsIgnoreCase(id)) {
                return h;
            }
        }
        return null;
    }

    // supprime un hebergement par son identifiant
    public boolean supprimerParId(String id) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getIdUnique().equalsIgnoreCase(id)) {
                System.out.println("  [-] " + liste.get(i).getNom() + " supprime.");
                liste.remove(i);
                return true;
            }
        }
        return false;
    }

    // affiche un resume court de tous les hebergements
    public void afficherResumes() {
        if (liste.isEmpty()) {
            System.out.println("La collection est vide.");
            return;
        }
        System.out.println("\n=== Liste des hebergements ===");
        for (Hebergement h : liste) {
            System.out.println("  " + h.retournerResume());
        }
    }

    public ArrayList<Hebergement> getListe() { return liste; }

    // getter pour les zones predefinies (utile dans le Main)
    public static String[] getZonesDisponibles() { return ZONES_DISPONIBLES; }
}
