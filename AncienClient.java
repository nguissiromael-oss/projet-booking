import java.util.Date;
public class AncienClient extends Client {
private int nombreReservations;
public AncienClient(String nom, String prenom, String email, String
motDePasse, String adresse, Date dateInscription, int nombreReservations) {
super(nom, prenom, email, motDePasse, adresse, dateInscription);
this.nombreReservations = nombreReservations;
}
// Getter spécifique
public int getNombreReservations() { return nombreReservations; }
@Override
public double verifierReductionFidelite() {
if (nombreReservations >= 5) {
System.out.println("Ancien client : 10% de réduction de fidélité appliquée.");
return 0.10; // 10% de réduction pour les clients ayant 5 réservations ou plus
} else {
System.out.println("Ancien client : pas de réduction de fidélité suffisante pour le moment.");
return 0.0;
}
}
public void voirHistoriqueReservations() {
System.out.println("Affichage de l'historique des réservations pour " + getEmail());
// Logique pour afficher l'historique
}
@Override
public String toString() {
return "AncienClient{" +
"nom='" + getNom() + '\'' +
", email='" + getEmail() + '\'' +
", nombreReservations=" + nombreReservations +
'}';
}
}
