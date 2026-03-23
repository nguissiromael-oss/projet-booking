import java.util.ArrayList;
import java.util.Collections;

/**
 * Interface IGestionHebergements.
 * Definit le contrat minimal pour gerer une collection d'hebergements.
 */
interface IGestionHebergements {
    void    ajouter(Hebergement h);
    void    afficherTous();
    void    trierParPrix();
    int     getTaille();
}

/**
 * Classe CollectionHebergements.
 * Gere une liste dynamique d'hebergements.
 *
 * Avantages d'ArrayList vs tableau :
 * - Taille dynamique (pas besoin de dimensionner a l'avance)
 * - Methodes integrees : add(), remove(), size(), contains()
 * - Fonctionne directement avec Collections.sort() via Comparable
 * - Generique : securite de type verifiee a la compilation
 */
public class CollectionHebergements implements IGestionHebergements {

    // Liste dynamique d'hebergements (peut contenir ChambreHotel, Appartement, Villa)
    private ArrayList<Hebergement> liste;

    // -------------------------------------------------------------------------
    // Constructeur
    // -------------------------------------------------------------------------

    public CollectionHebergements() {
        this.liste = new ArrayList<Hebergement>();
    }

    // -------------------------------------------------------------------------
    // Methodes de l'interface
    // -------------------------------------------------------------------------

    /**
     * Ajoute un hebergement a la collection.
     */
    @Override
    public void ajouter(Hebergement h) {
        if (h == null)
            throw new IllegalArgumentException("Impossible d'ajouter un hebergement null.");
        liste.add(h);
        System.out.println("  [+] Ajoute : " + h.getNom());
    }

    /**
     * Affiche tous les hebergements de la collection.
     */
    @Override
    public void afficherTous() {
        if (liste.isEmpty()) {
            System.out.println("La collection est vide.");
            return;
        }
        System.out.println("\n=== Collection : " + liste.size() + " hebergement(s) ===");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println("\n--- Hebergement n" + (i + 1) + " ---");
            liste.get(i).afficher();
        }
    }

    /**
     * Trie la liste par prix croissant.
     * Collections.sort() utilise la methode compareTo() de Hebergement.
     */
    @Override
    public void trierParPrix() {
        Collections.sort(liste);
        System.out.println("Collection triee par prix croissant.");
    }

    @Override
    public int getTaille() {
        return liste.size();
    }

    // -------------------------------------------------------------------------
    // Methodes de filtrage (sans Stream, niveau ING3)
    // -------------------------------------------------------------------------

    /**
     * Retourne une liste des hebergements d'un type donne.
     * @param type "ChambreHotel", "Appartement" ou "Villa"
     */
    public ArrayList<Hebergement> filtrerParType(String type) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getType().equalsIgnoreCase(type)) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    /**
     * Retourne une liste des hebergements dont le prix est inferieur ou egal a un seuil.
     * @param prixMax prix maximum par nuit en euros
     */
    public ArrayList<Hebergement> filtrerParPrixMax(double prixMax) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getPrixNuit() <= prixMax) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    /**
     * Retourne une liste des hebergements pouvant accueillir au moins nbPersonnes personnes.
     * @param nbPersonnes nombre de voyageurs minimum
     */
    public ArrayList<Hebergement> filtrerParCapacite(int nbPersonnes) {
        ArrayList<Hebergement> resultats = new ArrayList<Hebergement>();
        for (Hebergement h : liste) {
            if (h.getNbMaxPersonnes() >= nbPersonnes) {
                resultats.add(h);
            }
        }
        return resultats;
    }

    /**
     * Recherche un hebergement par son identifiant unique.
     * Retourne null si aucun hebergement ne correspond.
     * @param id identifiant recherche
     */
    public Hebergement rechercherParId(String id) {
        for (Hebergement h : liste) {
            if (h.getIdUnique().equalsIgnoreCase(id)) {
                return h;
            }
        }
        return null; // non trouve
    }

    /**
     * Supprime un hebergement par son identifiant.
     * @param id identifiant de l'hebergement a supprimer
     * @return true si supprime, false sinon
     */
    public boolean supprimerParId(String id) {
        for (int i = 0; i < liste.size(); i++) {
            if (liste.get(i).getIdUnique().equalsIgnoreCase(id)) {
                System.out.println("  [-] Supprime : " + liste.get(i).getNom());
                liste.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Affiche un resume compact de tous les hebergements (une ligne par hebergement).
     */
    public void afficherResumes() {
        if (liste.isEmpty()) {
            System.out.println("La collection est vide.");
            return;
        }
        System.out.println("\n=== Resumes ===");
        for (Hebergement h : liste) {
            System.out.println("  " + h.retournerResume());
        }
    }

    public ArrayList<Hebergement> getListe() {
        return liste;
    }
}
