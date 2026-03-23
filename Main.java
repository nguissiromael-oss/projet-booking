import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Classe Main
 * Point d'entree de l'application Booking.
 * On cree ici les hebergements fictifs, on les ajoute a la collection,
 * puis on teste les differentes fonctionnalites des TP4 et TP5.
 *
 * Les donnees (noms, adresses, zones) sont entierement fictives,
 * elles servent juste a simuler le fonctionnement d'une plateforme
 * de type Booking.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("    APPLICATION BOOKING  -  TP4 & TP5");
        System.out.println("============================================\n");

        CollectionHebergements collection = new CollectionHebergements();

        // =====================================================================
        // TP4 - Exercice 3 : demonstration des 3 constructeurs sur ChambreHotel
        // =====================================================================

        System.out.println("--- Constructeur 1 : par defaut ---");
        ChambreHotel chambreDefaut = new ChambreHotel();
        chambreDefaut.afficher();

        System.out.println("--- Constructeur 2 : avec parametres ---");
        // lecture clavier avec boucle de validation (capture NumberFormatException)
        double prixSaisi = lirePrixValide("Entrez le prix/nuit de la premiere chambre (ex: 95.0) : ");

        ArrayList<String> eq1 = new ArrayList<String>();
        eq1.add("Wi-Fi"); eq1.add("Climatisation"); eq1.add("Minibar");

        ChambreHotel chambre1 = new ChambreHotel(
            "CH001", "Hotel des Roses", "12 Rue des Fleurs, Villebourg", "Zone Nord",
            2, prixSaisi, "Chambre Standard agreable avec cour interieure",
            eq1, "https://monsite-booking.fr/hotel-des-roses", 101, "Standard"
        );
        chambre1.afficher();

        System.out.println("--- Constructeur 3 : par copie ---");
        ChambreHotel chambre1Copie = new ChambreHotel(chambre1);
        System.out.println("Copie : " + chambre1Copie.toString());


        // =====================================================================
        // Creation des 5 chambres d'hotel fictives (zones variees)
        // =====================================================================

        ArrayList<String> eqCH2 = new ArrayList<String>();
        eqCH2.add("Wi-Fi"); eqCH2.add("Jacuzzi"); eqCH2.add("Room Service");
        ChambreHotel chambre2 = new ChambreHotel(
            "CH002", "Hotel Le Belvedere", "7 Avenue du Soleil, Hauteville", "Zone Sud",
            2, 220.0, "Suite avec jacuzzi et vue panoramique sur la vallee",
            eqCH2, "https://monsite-booking.fr/belvedere", 204, "Suite"
        );

        ArrayList<String> eqCH3 = new ArrayList<String>();
        eqCH3.add("Wi-Fi"); eqCH3.add("Climatisation"); eqCH3.add("Coffre-fort");
        ChambreHotel chambre3 = new ChambreHotel(
            "CH003", "Hotel Central", "3 Place de la Mairie, Centreville", "Zone Centre",
            2, 80.0, "Chambre Deluxe en plein centre-ville",
            eqCH3, "https://monsite-booking.fr/central", 305, "Deluxe"
        );

        ArrayList<String> eqCH4 = new ArrayList<String>();
        eqCH4.add("Wi-Fi"); eqCH4.add("Parking gratuit"); eqCH4.add("Piscine");
        ChambreHotel chambre4 = new ChambreHotel(
            "CH004", "Hotel du Lac", "45 Route du Bord du Lac, Lacville", "Zone Est",
            3, 140.0, "Chambre familiale avec acces direct a la piscine",
            eqCH4, "https://monsite-booking.fr/hotel-du-lac", 112, "Deluxe"
        );

        ArrayList<String> eqCH5 = new ArrayList<String>();
        eqCH5.add("Spa privatif"); eqCH5.add("Petit-dejeuner inclus"); eqCH5.add("Concierge 24h");
        ChambreHotel chambre5 = new ChambreHotel(
            "CH005", "Hotel Grand Luxe", "1 Boulevard des Etoiles, Grandville", "Zone Ouest",
            1, 450.0, "Suite prestige avec spa privatif et service de concierge",
            eqCH5, "https://monsite-booking.fr/grand-luxe", 601, "Suite"
        );

        chambre1.ajouterCommentaire("Personnel tres accueillant, chambre propre.");
        chambre2.ajouterCommentaire("Vue magnifique, jacuzzi tres agreable.");
        chambre3.ajouterCommentaire("Bon rapport qualite/prix pour une nuit.");
        chambre4.ajouterCommentaire("Piscine excellente, les enfants ont adore.");
        chambre5.ajouterCommentaire("Experience inoubliable, service impeccable.");


        // =====================================================================
        // Creation des 5 appartements fictifs
        // =====================================================================

        ArrayList<String> eqA1 = new ArrayList<String>();
        eqA1.add("Cuisine equipee"); eqA1.add("Lave-linge"); eqA1.add("Wi-Fi");
        Appartement appart1 = new Appartement(
            "AP001", "Studio Le Coquet", "8 Rue des Lilas, Fleurville", "Zone Nord",
            2, 55.0, "Petit studio bien agence ideal pour 1 ou 2 personnes",
            eqA1, "https://monsite-booking.fr/studio-coquet", 30.0, false
        );

        ArrayList<String> eqA2 = new ArrayList<String>();
        eqA2.add("Cuisine equipee"); eqA2.add("Balcon"); eqA2.add("Wi-Fi"); eqA2.add("Parking");
        Appartement appart2 = new Appartement(
            "AP002", "Appartement Les Terrasses", "22 Rue des Cimes, Montval", "Zone Est",
            4, 120.0, "T3 lumineux avec balcon et vue sur la montagne",
            eqA2, "https://monsite-booking.fr/les-terrasses", 65.0, true
        );

        ArrayList<String> eqA3 = new ArrayList<String>();
        eqA3.add("Cuisine equipee"); eqA3.add("Jardin prive"); eqA3.add("Barbecue");
        Appartement appart3 = new Appartement(
            "AP003", "Duplex Le Jardin", "5 Impasse des Cerisiers, Verdon", "Zone Centre",
            3, 95.0, "Duplex avec jardin prive, calme et verdure garantis",
            eqA3, "https://monsite-booking.fr/duplex-jardin", 50.0, false
        );

        ArrayList<String> eqA4 = new ArrayList<String>();
        eqA4.add("Cuisine equipee"); eqA4.add("Wi-Fi"); eqA4.add("Lave-vaisselle");
        Appartement appart4 = new Appartement(
            "AP004", "Le Loft Moderne", "14 Rue de l'Atelier, Artville", "Zone Ouest",
            2, 110.0, "Loft au style industriel, tres lumineux",
            eqA4, "https://monsite-booking.fr/loft-moderne", 48.0, false
        );

        ArrayList<String> eqA5 = new ArrayList<String>();
        eqA5.add("Cuisine equipee"); eqA5.add("Wi-Fi"); eqA5.add("Parking"); eqA5.add("Animaux acceptes");
        Appartement appart5 = new Appartement(
            "AP005", "Appartement Familial", "3 Allee des Pins, Forestville", "Zone Sud",
            6, 85.0, "Grand T4 avec parking, animaux de compagnie bienvenus",
            eqA5, "https://monsite-booking.fr/familial", 90.0, true
        );

        appart1.ajouterCommentaire("Studio propre et fonctionnel, rien a redire.");
        appart2.ajouterCommentaire("Vue superbe, appartement bien equipe.");
        appart3.ajouterCommentaire("Le jardin est un vrai plus, tres reposant.");
        appart4.ajouterCommentaire("Deco originale, quartier anime.");
        appart5.ajouterCommentaire("Parfait pour la famille, le chien etait bienvenu.");


        // =====================================================================
        // Creation des 5 villas fictives
        // =====================================================================

        ArrayList<String> eqV1 = new ArrayList<String>();
        eqV1.add("Piscine"); eqV1.add("Jardin"); eqV1.add("Barbecue"); eqV1.add("Parking");
        Villa villa1 = new Villa(
            "VI001", "Villa Les Oliviers", "12 Chemin des Collines, Soleilville", "Zone Sud",
            8, 280.0, "Grande villa avec piscine et jardin arbore, ideale en groupe",
            eqV1, "https://monsite-booking.fr/villa-oliviers", true, 4
        );

        ArrayList<String> eqV2 = new ArrayList<String>();
        eqV2.add("Piscine chauffee"); eqV2.add("Sauna"); eqV2.add("Salle de sport");
        Villa villa2 = new Villa(
            "VI002", "Villa Prestige", "9 Allee des Palmiers, Luxovia", "Zone Sud",
            12, 900.0, "Villa haut de gamme avec piscine chauffee et sauna",
            eqV2, "https://monsite-booking.fr/villa-prestige", true, 6
        );

        ArrayList<String> eqV3 = new ArrayList<String>();
        eqV3.add("Jardin"); eqV3.add("Terrasse"); eqV3.add("Barbecue"); eqV3.add("Wi-Fi");
        Villa villa3 = new Villa(
            "VI003", "Villa Les Lavandes", "Route des Champs, Campagnol", "Zone Centre",
            6, 195.0, "Maison de campagne avec grande terrasse, sans piscine",
            eqV3, "https://monsite-booking.fr/villa-lavandes", false, 3
        );

        ArrayList<String> eqV4 = new ArrayList<String>();
        eqV4.add("Piscine"); eqV4.add("Jacuzzi"); eqV4.add("Home cinema"); eqV4.add("Garage");
        Villa villa4 = new Villa(
            "VI004", "Villa L'Horizon", "55 Boulevard de la Mer, Rivieraville", "Zone Est",
            10, 620.0, "Villa moderne avec piscine et vue mer",
            eqV4, "https://monsite-booking.fr/villa-horizon", true, 5
        );

        ArrayList<String> eqV5 = new ArrayList<String>();
        eqV5.add("Piscine"); eqV5.add("Cave"); eqV5.add("Terrasse"); eqV5.add("Vignoble inclus");
        Villa villa5 = new Villa(
            "VI005", "Domaine du Vallon", "Route du Vignoble, Vinopolis", "Zone Ouest",
            16, 750.0, "Domaine fictif avec piscine, cave et visite du vignoble",
            eqV5, "https://monsite-booking.fr/domaine-vallon", true, 8
        );

        villa1.ajouterCommentaire("Sejour fantastique, la piscine etait parfaite.");
        villa2.ajouterCommentaire("Villa magnifique, on se sent comme des rois.");
        villa3.ajouterCommentaire("Endroit tres calme, ideal pour decompresser.");
        villa4.ajouterCommentaire("Vue mer incroyable, on recommande.");
        villa5.ajouterCommentaire("Visite du vignoble incluse, tres bonne surprise.");


        // =====================================================================
        // TP4 - Exercice 4 : ajout dans la collection, tri et filtres
        // =====================================================================

        System.out.println("\n=== Ajout des hebergements dans la collection ===");
        collection.ajouter(chambre1); collection.ajouter(chambre2); collection.ajouter(chambre3);
        collection.ajouter(chambre4); collection.ajouter(chambre5);
        collection.ajouter(appart1);  collection.ajouter(appart2);  collection.ajouter(appart3);
        collection.ajouter(appart4);  collection.ajouter(appart5);
        collection.ajouter(villa1);   collection.ajouter(villa2);   collection.ajouter(villa3);
        collection.ajouter(villa4);   collection.ajouter(villa5);

        System.out.println("\nTotal : " + collection.getTaille() + " hebergements dans la collection.");

        collection.afficherResumes();

        // tri par prix croissant
        System.out.println("\n--- Tri par prix croissant ---");
        collection.trierParPrix();
        collection.afficherResumes();

        // affichage du prix total pour quelques exemples
        System.out.println("\n--- Exemples de prix total ---");
        System.out.printf("  %s (5 nuits) : %.2f EUR%n", chambre2.getNom(), chambre2.calculerPrixTotal(5));
        System.out.printf("  %s (7 nuits) : %.2f EUR%n", appart2.getNom(),  appart2.calculerPrixTotal(7));
        System.out.printf("  %s (10 nuits, -15%%) : %.2f EUR%n", villa2.getNom(), villa2.calculerPrixTotal(10));

        // toString()
        System.out.println("\n--- toString() ---");
        System.out.println(chambre2.toString());
        System.out.println(appart2.toString());
        System.out.println(villa2.toString());


        // =====================================================================
        // Menu interactif
        // =====================================================================

        menuInteractif(collection);


        // =====================================================================
        // TP5 - Exercice 1 : exceptions
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 1 : Gestion des exceptions");
        System.out.println("============================================");

        // test prix negatif
        try {
            chambre1.setPrixNuit(-50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }

        // test nombre de nuits invalide
        try {
            chambre1.calculerPrixTotal(0);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }

        // test commentaire vide
        try {
            appart1.ajouterCommentaire("");
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }

        // test ajout null
        try {
            collection.ajouter(null);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }

        // test capacite invalide
        try {
            villa1.estDisponiblePour(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] " + e.getMessage());
        }


        // =====================================================================
        // TP5 - Exercice 2 : fichier texte
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 2 : Fichier texte");
        System.out.println("============================================");

        String cheminTxt = "hebergements.txt";

        try {
            ecrireFichierTexte(cheminTxt, collection.getListe());
            System.out.println("[OK] Hebergements ecrits dans : " + cheminTxt);
        } catch (IOException e) {
            System.out.println("[ERREUR] " + e.getMessage());
        }

        try {
            ArrayList<String[]> donnees = lireFichierTexte(cheminTxt);
            System.out.println("[OK] " + donnees.size() + " ligne(s) lue(s) depuis " + cheminTxt);
            for (String[] ligne : donnees) {
                System.out.println("   Nom : " + ligne[0].trim() + " | Zone : " + ligne[1].trim());
            }
        } catch (IOException e) {
            System.out.println("[ERREUR] " + e.getMessage());
        }


        // =====================================================================
        // TP5 - Exercice 3 : serialisation / deserialisation
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 3 : Serialisation");
        System.out.println("============================================");

        String cheminSer = "hebergements.ser";

        try {
            serializerCollection(cheminSer, collection.getListe());
            System.out.println("[OK] Collection serialisee dans : " + cheminSer);
        } catch (IOException e) {
            System.out.println("[ERREUR] Serialisation : " + e.getMessage());
        }

        try {
            ArrayList<Hebergement> charges = deserializerCollection(cheminSer);
            System.out.println("[OK] " + charges.size() + " hebergement(s) deserialise(s) :");
            for (Hebergement h : charges) {
                System.out.println("   -> " + h.retournerResume());
            }
        } catch (IOException e) {
            System.out.println("[ERREUR] Deserialisation : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[ERREUR] Classe introuvable : " + e.getMessage());
        }

        scanner.close();
        System.out.println("\n=== Fin de l'application ===");
    }


    // =========================================================================
    // Menu interactif
    // =========================================================================

    public static void menuInteractif(CollectionHebergements collection) {

        int choix = -1;

        while (choix != 0) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Afficher tous les hebergements");
            System.out.println("2. Rechercher par ID");
            System.out.println("3. Trier par prix");
            System.out.println("4. Filtrer par type");
            System.out.println("5. Filtrer par prix maximum");
            System.out.println("6. Filtrer par zone");
            System.out.println("0. Quitter le menu");
            System.out.print("Votre choix : ");

            try {
                choix = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrez un chiffre valide.");
                continue;
            }

            switch (choix) {

                case 1:
                    collection.afficherResumes();
                    break;

                case 2:
                    System.out.print("Entrez l'ID (ex: CH001, AP002, VI003) : ");
                    String id = scanner.nextLine().trim();
                    Hebergement trouve = collection.rechercherParId(id);
                    if (trouve != null) {
                        trouve.afficher();
                    } else {
                        System.out.println("Aucun hebergement trouve avec l'ID : " + id);
                    }
                    break;

                case 3:
                    collection.trierParPrix();
                    collection.afficherResumes();
                    break;

                case 4:
                    System.out.print("Type (ChambreHotel / Appartement / Villa) : ");
                    String type = scanner.nextLine().trim();
                    ArrayList<Hebergement> parType = collection.filtrerParType(type);
                    if (parType.isEmpty()) {
                        System.out.println("Aucun hebergement de type : " + type);
                    } else {
                        for (Hebergement h : parType)
                            System.out.println("  " + h.retournerResume());
                    }
                    break;

                case 5:
                    double prixMax = lirePrixValide("Prix maximum par nuit (EUR) : ");
                    ArrayList<Hebergement> parPrix = collection.filtrerParPrixMax(prixMax);
                    if (parPrix.isEmpty()) {
                        System.out.println("Aucun hebergement dans cette tranche de prix.");
                    } else {
                        for (Hebergement h : parPrix)
                            System.out.println("  " + h.retournerResume());
                    }
                    break;

                case 6:
                    // on affiche d'abord les zones disponibles pour aider l'utilisateur
                    collection.afficherZonesDisponibles();
                    System.out.print("Entrez une zone : ");
                    String zone = scanner.nextLine().trim();
                    ArrayList<Hebergement> parZone = collection.filtrerParZone(zone);
                    // si la zone est valide et contient des resultats, on les affiche
                    if (!parZone.isEmpty()) {
                        System.out.println(parZone.size() + " hebergement(s) dans la zone " + zone + " :");
                        for (Hebergement h : parZone)
                            System.out.println("  " + h.retournerResume());
                    }
                    break;

                case 0:
                    System.out.println("Fermeture du menu.");
                    break;

                default:
                    System.out.println("Choix invalide, reessayez.");
            }
        }
    }


    // =========================================================================
    // Methode utilitaire : lecture d'un prix valide au clavier
    // =========================================================================

    public static double lirePrixValide(String message) {
        double prix = -1;
        while (prix <= 0) {
            System.out.print(message);
            try {
                prix = Double.parseDouble(scanner.nextLine().trim());
                if (prix <= 0)
                    System.out.println("Le prix doit etre strictement positif.");
            } catch (NumberFormatException e) {
                System.out.println("Valeur invalide. Entrez un nombre decimal (ex: 95.0).");
            }
        }
        return prix;
    }


    // =========================================================================
    // TP5 - Fichier texte
    // =========================================================================

    /*
     * Ecrit tous les hebergements dans un fichier texte.
     * Format de chaque ligne :
     * nom ; zone ; adresse ; lienPhotos ; commentaires ; equipements
     */
    public static void ecrireFichierTexte(String chemin, ArrayList<Hebergement> liste)
            throws IOException {

        try (PrintWriter writer = new PrintWriter(new FileWriter(chemin))) {
            for (Hebergement h : liste) {

                // construction manuelle des commentaires (separes par " - ")
                String commentaires = "";
                for (int i = 0; i < h.getCommentairesClients().size(); i++) {
                    if (i > 0) commentaires += " - ";
                    commentaires += h.getCommentairesClients().get(i);
                }

                // construction manuelle des equipements (separes par ", ")
                String equipements = "";
                for (int i = 0; i < h.getEquipements().size(); i++) {
                    if (i > 0) equipements += ", ";
                    equipements += h.getEquipements().get(i);
                }

                writer.println(
                    h.getNom()           + " ; " +
                    h.getZone()          + " ; " +
                    h.getAdressePostale() + " ; " +
                    h.getLienPhotos()    + " ; " +
                    commentaires         + " ; " +
                    equipements
                );
            }
        }
        // IOException propagee vers le Main
    }

    /*
     * Lit le fichier texte et retourne une liste de tableaux.
     * Chaque tableau contient les champs d'un hebergement.
     */
    public static ArrayList<String[]> lireFichierTexte(String chemin)
            throws IOException {

        ArrayList<String[]> resultats = new ArrayList<String[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(chemin))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    resultats.add(ligne.split(";"));
                }
            }
        }
        return resultats;
    }


    // =========================================================================
    // TP5 - Serialisation / Deserialisation
    // =========================================================================

    /*
     * Serialise la liste dans un fichier binaire .ser
     * (necessite que Hebergement implemente Serializable)
     */
    public static void serializerCollection(String chemin, ArrayList<Hebergement> liste)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
            oos.writeObject(liste);
        }
    }

    /*
     * Deserialise la liste depuis le fichier .ser
     * ClassNotFoundException si la classe n'est plus disponible au chargement
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Hebergement> deserializerCollection(String chemin)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
            return (ArrayList<Hebergement>) ois.readObject();
        }
    }
}
