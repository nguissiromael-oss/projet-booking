import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe Main.
 * Point d'entree de l'application Booking.
 * Demontre les concepts des TP4 et TP5 avec 5 exemples par type d'hebergement.
 */
public class Main {

    // Scanner global reutilise dans tout le Main
    static Scanner scanner = new Scanner(System.in);

    // =========================================================================
    // POINT D'ENTREE
    // =========================================================================

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("   APPLICATION BOOKING - TP4 & TP5");
        System.out.println("============================================\n");

        // --- Initialisation de la collection ---
        CollectionHebergements collection = new CollectionHebergements();

        // =====================================================================
        // TP4 - Ex.1 & Ex.3 : Creation des hebergements (5 par type)
        // Demonstration des 3 constructeurs sur ChambreHotel
        // =====================================================================

        System.out.println("--- TP4 Ex.3 : Constructeur 1 (par defaut) ---");
        ChambreHotel chambreDefaut = new ChambreHotel();
        chambreDefaut.afficher();

        System.out.println("\n--- TP4 Ex.3 : Constructeur 2 (avec parametres) ---");
        // Lecture clavier avec validation (boucle + NumberFormatException)
        double prixSaisi = lirePrixValide("Entrez le prix/nuit pour la 1ere chambre (ex: 95.0) : ");

        ArrayList<String> eq1 = new ArrayList<String>();
        eq1.add("Wi-Fi");
        eq1.add("Climatisation");
        eq1.add("Minibar");
        ChambreHotel chambre1 = new ChambreHotel(
            "CH001", "Hotel Le Marais", "3 Rue de Bretagne, 75003 Paris",
            2, prixSaisi, "Chambre Standard au coeur du Marais",
            eq1, "https://booking.com/lemarais", 101, "Standard"
        );
        chambre1.afficher();

        System.out.println("\n--- TP4 Ex.3 : Constructeur 3 (par copie) ---");
        ChambreHotel chambre1Copie = new ChambreHotel(chambre1);
        System.out.println("Copie creee : " + chambre1Copie.toString());

        // --- 5 chambres d'hotel ---
        ArrayList<String> eqCH2 = new ArrayList<String>();
        eqCH2.add("Wi-Fi"); eqCH2.add("Jacuzzi"); eqCH2.add("Room Service");
        ChambreHotel chambre2 = new ChambreHotel(
            "CH002", "Hotel Lutetia", "45 Bd Raspail, 75006 Paris",
            2, 320.0, "Suite luxueuse avec vue sur Paris",
            eqCH2, "https://booking.com/lutetia", 501, "Suite"
        );

        ArrayList<String> eqCH3 = new ArrayList<String>();
        eqCH3.add("Wi-Fi"); eqCH3.add("Climatisation"); eqCH3.add("Coffre-fort");
        ChambreHotel chambre3 = new ChambreHotel(
            "CH003", "Hotel Ibis Nation", "10 Pl. de la Nation, 75011 Paris",
            2, 75.0, "Chambre Deluxe fonctionnelle et bien situee",
            eqCH3, "https://booking.com/ibis", 203, "Deluxe"
        );

        ArrayList<String> eqCH4 = new ArrayList<String>();
        eqCH4.add("Wi-Fi"); eqCH4.add("Parking"); eqCH4.add("Piscine");
        ChambreHotel chambre4 = new ChambreHotel(
            "CH004", "Mercure Montparnasse", "20 Rue du Maine, 75014 Paris",
            3, 130.0, "Chambre familiale avec vue jardin",
            eqCH4, "https://booking.com/mercure", 312, "Deluxe"
        );

        ArrayList<String> eqCH5 = new ArrayList<String>();
        eqCH5.add("Wi-Fi"); eqCH5.add("Spa"); eqCH5.add("Petit-dejeuner inclus");
        ChambreHotel chambre5 = new ChambreHotel(
            "CH005", "Le Bristol Paris", "112 Rue du Fg Saint-Honore, 75008 Paris",
            1, 890.0, "Suite Prestige avec acces spa privatif",
            eqCH5, "https://booking.com/bristol", 701, "Suite"
        );

        // Ajout des commentaires
        chambre1.ajouterCommentaire("Tres bien situe, personnel agreable.");
        chambre2.ajouterCommentaire("Luxueux et tres calme.");
        chambre3.ajouterCommentaire("Bon rapport qualite/prix.");
        chambre4.ajouterCommentaire("Chambre spacieuse, idéale en famille.");
        chambre5.ajouterCommentaire("Experience incroyable, service 5 etoiles.");

        // --- 5 appartements ---
        ArrayList<String> eqA1 = new ArrayList<String>();
        eqA1.add("Cuisine equipee"); eqA1.add("Lave-linge"); eqA1.add("Parking");
        Appartement appart1 = new Appartement(
            "AP001", "Studio Bastille", "8 Rue de la Roquette, 75011 Paris",
            2, 65.0, "Studio moderne a deux pas de la Bastille",
            eqA1, "https://booking.com/bastille", 28.0, false
        );

        ArrayList<String> eqA2 = new ArrayList<String>();
        eqA2.add("Cuisine equipee"); eqA2.add("Balcon"); eqA2.add("Wi-Fi"); eqA2.add("Parking");
        Appartement appart2 = new Appartement(
            "AP002", "T3 Champs-Elysees", "25 Av. des Champs-Elysees, 75008 Paris",
            4, 180.0, "Appartement lumineux avec vue panoramique",
            eqA2, "https://booking.com/champselysees", 75.0, true
        );

        ArrayList<String> eqA3 = new ArrayList<String>();
        eqA3.add("Cuisine equipee"); eqA3.add("Jardin prive"); eqA3.add("Wi-Fi");
        Appartement appart3 = new Appartement(
            "AP003", "Duplex Montmartre", "5 Rue Lepic, 75018 Paris",
            3, 110.0, "Duplex avec terrasse vue sur le Sacre-Coeur",
            eqA3, "https://booking.com/montmartre", 55.0, false
        );

        ArrayList<String> eqA4 = new ArrayList<String>();
        eqA4.add("Cuisine equipee"); eqA4.add("Lave-linge"); eqA4.add("Cave a vins");
        Appartement appart4 = new Appartement(
            "AP004", "Loft Saint-Germain", "14 Rue Jacob, 75006 Paris",
            2, 155.0, "Loft industriel chic au coeur de Saint-Germain",
            eqA4, "https://booking.com/saintgermain", 62.0, false
        );

        ArrayList<String> eqA5 = new ArrayList<String>();
        eqA5.add("Cuisine equipee"); eqA5.add("Wi-Fi"); eqA5.add("Animaux acceptes"); eqA5.add("Parking");
        Appartement appart5 = new Appartement(
            "AP005", "T4 Vincennes", "3 Rue de Montreuil, 94300 Vincennes",
            5, 90.0, "Grand appartement familial proche du bois de Vincennes",
            eqA5, "https://booking.com/vincennes", 88.0, true
        );

        appart1.ajouterCommentaire("Propre et bien equipe, ideal pour une courte duree.");
        appart2.ajouterCommentaire("Vue magnifique, emplacement exceptionnel.");
        appart3.ajouterCommentaire("Tres romantique, on reviendra !");
        appart4.ajouterCommentaire("Deco tres soignee, quartier vivant.");
        appart5.ajouterCommentaire("Parfait pour toute la famille avec le chien.");

        // --- 5 villas ---
        ArrayList<String> eqV1 = new ArrayList<String>();
        eqV1.add("Piscine"); eqV1.add("Jardin"); eqV1.add("Barbecue"); eqV1.add("Parking");
        Villa villa1 = new Villa(
            "VI001", "Villa Provence", "12 Chemin des Oliviers, 13100 Aix-en-Provence",
            8, 350.0, "Mas provencal avec piscine et grand jardin",
            eqV1, "https://booking.com/villaprovence", true, 4
        );

        ArrayList<String> eqV2 = new ArrayList<String>();
        eqV2.add("Piscine chauffee"); eqV2.add("Sauna"); eqV2.add("Tennis"); eqV2.add("Chef a domicile");
        Villa villa2 = new Villa(
            "VI002", "Villa Cote d'Azur", "88 Blvd de la Croisette, 06400 Cannes",
            12, 1200.0, "Villa de luxe avec acces plage privee",
            eqV2, "https://booking.com/villacannes", true, 6
        );

        ArrayList<String> eqV3 = new ArrayList<String>();
        eqV3.add("Jardin"); eqV3.add("Barbecue"); eqV3.add("Parking"); eqV3.add("Wi-Fi");
        Villa villa3 = new Villa(
            "VI003", "Mas Luberon", "Route des Lavandes, 84400 Apt",
            6, 220.0, "Mas authentique au coeur du Luberon sans piscine",
            eqV3, "https://booking.com/masluberon", false, 3
        );

        ArrayList<String> eqV4 = new ArrayList<String>();
        eqV4.add("Piscine"); eqV4.add("Jacuzzi"); eqV4.add("Home cinema"); eqV4.add("Salle de sport");
        Villa villa4 = new Villa(
            "VI004", "Villa Biarritz", "5 Av. de l'Ocean, 64200 Biarritz",
            10, 680.0, "Villa contemporaine avec vue ocean et piscine",
            eqV4, "https://booking.com/villabiarritz", true, 5
        );

        ArrayList<String> eqV5 = new ArrayList<String>();
        eqV5.add("Piscine"); eqV5.add("Vignoble"); eqV5.add("Cave"); eqV5.add("Terrasse");
        Villa villa5 = new Villa(
            "VI005", "Chateau Bordeaux", "Route des Chateaux, 33250 Pauillac",
            16, 850.0, "Chateau viticole avec piscine et degustation incluse",
            eqV5, "https://booking.com/chateaubordeaux", true, 8
        );

        villa1.ajouterCommentaire("Sejour paradisiaque, on recommande vivement.");
        villa2.ajouterCommentaire("Service impeccable, villa somptueuse.");
        villa3.ajouterCommentaire("Cadre exceptionnel, tres au calme.");
        villa4.ajouterCommentaire("Vue sur ocean incroyable au lever du soleil.");
        villa5.ajouterCommentaire("Degustation de vins incluse, moment inoubliable.");

        // =====================================================================
        // TP4 - Ex.4 : Remplissage de la collection et tri
        // =====================================================================

        System.out.println("\n=== Ajout des hebergements dans la collection ===");
        // Chambres
        collection.ajouter(chambre1); collection.ajouter(chambre2);
        collection.ajouter(chambre3); collection.ajouter(chambre4);
        collection.ajouter(chambre5);
        // Appartements
        collection.ajouter(appart1); collection.ajouter(appart2);
        collection.ajouter(appart3); collection.ajouter(appart4);
        collection.ajouter(appart5);
        // Villas
        collection.ajouter(villa1); collection.ajouter(villa2);
        collection.ajouter(villa3); collection.ajouter(villa4);
        collection.ajouter(villa5);

        System.out.println("\nTotal : " + collection.getTaille() + " hebergements dans la collection.");

        // Affichage des resumes
        collection.afficherResumes();

        // Tri par prix
        System.out.println("\n--- Tri par prix croissant ---");
        collection.trierParPrix();
        collection.afficherResumes();

        // Filtres
        System.out.println("\n--- Filtre : appartements uniquement ---");
        ArrayList<Hebergement> appartements = collection.filtrerParType("Appartement");
        for (Hebergement h : appartements)
            System.out.println("  " + h.retournerResume());

        System.out.println("\n--- Filtre : prix <= 150 EUR/nuit ---");
        ArrayList<Hebergement> prixBas = collection.filtrerParPrixMax(150.0);
        for (Hebergement h : prixBas)
            System.out.println("  " + h.retournerResume());

        System.out.println("\n--- Filtre : capacite >= 6 personnes ---");
        ArrayList<Hebergement> grands = collection.filtrerParCapacite(6);
        for (Hebergement h : grands)
            System.out.println("  " + h.retournerResume());

        // =====================================================================
        // TP4 - Ex.4 : toString() et calculerPrixTotal()
        // =====================================================================

        System.out.println("\n--- toString() ---");
        System.out.println(chambre2.toString());
        System.out.println(appart2.toString());
        System.out.println(villa2.toString());

        System.out.println("\n--- Calcul du prix total ---");
        System.out.printf("  Chambre Suite (5 nuits)  : %.2f EUR%n", chambre2.calculerPrixTotal(5));
        System.out.printf("  Appartement (7 nuits)    : %.2f EUR%n", appart2.calculerPrixTotal(7));
        System.out.printf("  Villa (10 nuits, -15%%)   : %.2f EUR%n", villa2.calculerPrixTotal(10));

        // =====================================================================
        // TP4 - Ex.4 : Menu interactif
        // =====================================================================

        menuInteractif(collection);

        // =====================================================================
        // TP5 - Ex.1 : Exceptions
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 1 : Gestion des exceptions");
        System.out.println("============================================");

        // Test 1 : prix negatif
        try {
            chambre1.setPrixNuit(-50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] Prix negatif capture : " + e.getMessage());
        }

        // Test 2 : nombre de nuits invalide
        try {
            chambre1.calculerPrixTotal(0);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] Nuits invalides capture : " + e.getMessage());
        }

        // Test 3 : commentaire vide
        try {
            appart1.ajouterCommentaire("");
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] Commentaire vide capture : " + e.getMessage());
        }

        // Test 4 : ajout null dans la collection
        try {
            collection.ajouter(null);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] Hebergement null capture : " + e.getMessage());
        }

        // Test 5 : capacite invalide
        try {
            villa1.estDisponiblePour(-2);
        } catch (IllegalArgumentException e) {
            System.out.println("[EXCEPTION] Capacite invalide capture : " + e.getMessage());
        }

        // =====================================================================
        // TP5 - Ex.2 : Fichier texte
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 2 : Fichier texte");
        System.out.println("============================================");

        String cheminTxt = "hebergements.txt";

        try {
            ecrireFichierTexte(cheminTxt, collection.getListe());
            System.out.println("[OK] " + collection.getTaille() + " hebergements ecrits dans " + cheminTxt);
        } catch (IOException e) {
            System.out.println("[ERREUR] Ecriture fichier : " + e.getMessage());
        }

        try {
            ArrayList<String[]> donnees = lireFichierTexte(cheminTxt);
            System.out.println("[OK] " + donnees.size() + " lignes lues depuis " + cheminTxt + " :");
            for (String[] ligne : donnees) {
                System.out.println("   Nom : " + ligne[0].trim() + " | Adresse : " + ligne[1].trim());
            }
        } catch (IOException e) {
            System.out.println("[ERREUR] Lecture fichier : " + e.getMessage());
        }

        // =====================================================================
        // TP5 - Ex.3 : Serialisation / Deserialisation
        // =====================================================================

        System.out.println("\n============================================");
        System.out.println("TP5 - Exercice 3 : Serialisation");
        System.out.println("============================================");

        String cheminSer = "hebergements.ser";

        try {
            serializerCollection(cheminSer, collection.getListe());
            System.out.println("[OK] Collection serialisee dans " + cheminSer);
        } catch (IOException e) {
            System.out.println("[ERREUR] Serialisation : " + e.getMessage());
        }

        try {
            ArrayList<Hebergement> charges = deserializerCollection(cheminSer);
            System.out.println("[OK] " + charges.size() + " hebergements deserialises :");
            for (Hebergement h : charges) {
                System.out.println("   -> " + h.retournerResume());
            }
        } catch (IOException e) {
            System.out.println("[ERREUR] Deserialisation (IO) : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[ERREUR] Classe introuvable : " + e.getMessage());
        }

        scanner.close();
        System.out.println("\n=== Fin de l'application Booking ===");
    }

    // =========================================================================
    // Menu interactif (TP4 Ex.4)
    // =========================================================================

    /**
     * Affiche un menu permettant d'interagir avec la collection.
     */
    public static void menuInteractif(CollectionHebergements collection) {
        int choix = -1;
        while (choix != 0) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Afficher tous les hebergements");
            System.out.println("2. Rechercher par ID");
            System.out.println("3. Trier par prix");
            System.out.println("4. Filtrer par type");
            System.out.println("5. Filtrer par prix maximum");
            System.out.println("0. Quitter le menu");
            System.out.print("Votre choix : ");

            try {
                choix = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("[ERREUR] Entrez un nombre entier.");
                continue;
            }

            switch (choix) {
                case 1:
                    collection.afficherResumes();
                    break;
                case 2:
                    System.out.print("Entrez l'ID (ex: CH001) : ");
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
                    ArrayList<Hebergement> filtres = collection.filtrerParType(type);
                    if (filtres.isEmpty()) {
                        System.out.println("Aucun hebergement de ce type.");
                    } else {
                        for (Hebergement h : filtres)
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
                case 0:
                    System.out.println("Fermeture du menu.");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // =========================================================================
    // Methode utilitaire : lecture d'un prix valide au clavier
    // =========================================================================

    /**
     * Lit un prix valide (> 0) au clavier avec une boucle de validation.
     * Capture NumberFormatException si la saisie n'est pas numerique.
     */
    public static double lirePrixValide(String message) {
        double prix = -1;
        while (prix <= 0) {
            System.out.print(message);
            try {
                prix = Double.parseDouble(scanner.nextLine().trim());
                if (prix <= 0) {
                    System.out.println("[ERREUR] Le prix doit etre strictement positif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERREUR] Valeur invalide, entrez un nombre decimal (ex: 95.0).");
            }
        }
        return prix;
    }

    // =========================================================================
    // TP5 - Methodes fichier texte
    // =========================================================================

    /**
     * Ecrit tous les hebergements dans un fichier texte.
     * Format : nom ; adresse ; lienPhotos ; commentaires (sep. par -) ; equipements
     */
    public static void ecrireFichierTexte(String chemin, ArrayList<Hebergement> liste)
            throws IOException {
        // try-with-resources : le PrintWriter est ferme automatiquement
        try (PrintWriter writer = new PrintWriter(new FileWriter(chemin))) {
            for (Hebergement h : liste) {
                // Construction manuelle de la chaine (sans String.join pour rester lisible)
                String commentaires = "";
                for (int i = 0; i < h.getCommentairesClients().size(); i++) {
                    if (i > 0) commentaires += " - ";
                    commentaires += h.getCommentairesClients().get(i);
                }
                String equipements = "";
                for (int i = 0; i < h.getEquipements().size(); i++) {
                    if (i > 0) equipements += ", ";
                    equipements += h.getEquipements().get(i);
                }
                writer.println(
                    h.getNom()           + " ; " +
                    h.getAdressePostale() + " ; " +
                    h.getLienPhotos()     + " ; " +
                    commentaires         + " ; " +
                    equipements
                );
            }
        }
        // L'IOException est propagee vers le Main qui la capture
    }

    /**
     * Lit les hebergements depuis un fichier texte.
     * Retourne une liste de tableaux : chaque case correspond a un champ.
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
    // TP5 - Methodes serialisation
    // =========================================================================

    /**
     * Serialise la liste d'hebergements dans un fichier binaire .ser.
     * Necessite que Hebergement implements Serializable.
     */
    public static void serializerCollection(String chemin, ArrayList<Hebergement> liste)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(chemin))) {
            oos.writeObject(liste);
        }
    }

    /**
     * Deserialise la liste d'hebergements depuis un fichier binaire .ser.
     * ClassNotFoundException est levee si la classe n'est plus disponible.
     */
    @SuppressWarnings("unchecked")
    public static ArrayList<Hebergement> deserializerCollection(String chemin)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(chemin))) {
            return (ArrayList<Hebergement>) ois.readObject();
        }
    }
}
