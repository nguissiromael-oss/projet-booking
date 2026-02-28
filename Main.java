import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
public class Main {
public static void main(String[] args) throws Exception {
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
// 1. Création d'hébergements
List<String> equipementsHotel = new ArrayList<>();
equipementsHotel.add("Wifi");
equipementsHotel.add("Piscine");
Hebergement hotel = new Hebergement("H001", "Hôtel de la Paix", "10
Rue de la Paix, Paris", "Hôtel", 2, 150.0, equipementsHotel);
List<String> equipementsAppart = new ArrayList<>();
equipementsAppart.add("Cuisine");
equipementsAppart.add("Lave-linge");
Hebergement appartement = new Hebergement("A002", "Appartement
Cosy", "25 Av. des Champs, Paris", "Appartement", 4, 100.0,
equipementsAppart);
// 2. Création de clients
NouveauClient nouveauClient = new NouveauClient("Durand", "Sophie",
"sophie.durand@example.com", "pass123", "5 Rue du Commerce, Lyon",
sdf.parse("01/01/2026"));
AncienClient ancienClientFidele = new AncienClient("Martin",
"Pierre", "pierre.martin@example.com", "secure456", "12 Bd de la Liberté,
Marseille", sdf.parse("15/03/2025"), 7);
AncienClient ancienClientNonFidele = new AncienClient("Petit",
"Laura", "laura.petit@example.com", "azerty", "3 Place de la Bourse,
Bordeaux", sdf.parse("10/02/2025"), 3);
System.out.println("--- Informations des Objets ---");
System.out.println(hotel);
System.out.println(nouveauClient);
System.out.println(ancienClientFidele);
System.out.println(ancienClientNonFidele);
System.out.println("\n");
// 3. Simulation de réservations
Date dateArrivee1 = sdf.parse("10/03/2026");
Date dateDepart1 = sdf.parse("15/03/2026");
Reservation reservation1 = new Reservation("RES001", nouveauClient,
hotel, dateArrivee1, dateDepart1);
reservation1.confirmerReservation();
Date dateArrivee2 = sdf.parse("20/04/2026");
Date dateDepart2 = sdf.parse("25/04/2026");
Reservation reservation2 = new Reservation("RES002",
ancienClientFidele, appartement, dateArrivee2, dateDepart2);
reservation2.confirmerReservation();
Date dateArrivee3 = sdf.parse("01/05/2026");
Date dateDepart3 = sdf.parse("03/05/2026");
Reservation reservation3 = new Reservation("RES003",
ancienClientNonFidele, hotel, dateArrivee3, dateDepart3);
System.out.println("--- Détails des Réservations ---");
System.out.println(reservation1);
System.out.println(reservation2);
System.out.println(reservation3);
System.out.println("\n");
// 4. Test des réductions et du polymorphisme
System.out.println("--- Test des Réductions ---");
double reductionNouveau = nouveauClient.verifierReductionFidelite();
System.out.println("Prix total réservation 1 (NouveauClient) : " +
String.format("%.2f", reservation1.calculerPrixTotal(reductionNouveau)) +
"€");
double reductionAncienFidele =
ancienClientFidele.verifierReductionFidelite();
System.out.println("Prix total réservation 2 (AncienClient Fidele) :
" + String.format("%.2f",
reservation2.calculerPrixTotal(reductionAncienFidele)) + "€");
double reductionAncienNonFidele =
ancienClientNonFidele.verifierReductionFidelite();
System.out.println("Prix total réservation 3 (AncienClient Non
Fidele) : " + String.format("%.2f",
reservation3.calculerPrixTotal(reductionAncienNonFidele)) + "€");
System.out.println("\n");
// 5. Simulation d'annulation
System.out.println("--- Simulation d'Annulation ---");
reservation1.annulerReservation();
System.out.println(reservation1);
System.out.println("\n");
// 6. Test de connexion
System.out.println("--- Test de Connexion ---");
System.out.println("Connexion de Sophie Durand (correct) : " +
nouveauClient.seConnecter("sophie.durand@example.com", "pass123"));
System.out.println("Connexion de Sophie Durand (incorrect mdp) : " +
nouveauClient.seConnecter("sophie.durand@example.com", "mauvais_mdp"));
System.out.println("Connexion de Pierre Martin (correct) : " +
ancienClientFidele.seConnecter("pierre.martin@example.com", "secure456"));
}
}