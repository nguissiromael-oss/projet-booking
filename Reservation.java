import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.Objects;
public class Reservation {
private String idUnique;
private Client client;
private Hebergement hebergement;
private Date dateArrivee;
private Date dateDepart;
private double prixTotal;
private StatutReservation statut;
public Reservation(String idUnique, Client client, Hebergement
hebergement, Date dateArrivee, Date dateDepart) {
this.idUnique = idUnique;
this.client = client;
this.hebergement = hebergement;
this.dateArrivee = dateArrivee;
this.dateDepart = dateDepart;
this.statut = StatutReservation.EN_ATTENTE; // Statut initial par défaut
this.prixTotal =
calculerPrixTotal(client.verifierReductionFidelite()); // Calcul initial du prix
}
// Getters pour les attributs
public String getIdUnique() { return idUnique; }
public Client getClient() { return client; }
public Hebergement getHebergement() { return hebergement; }
public Date getDateArrivee() { return dateArrivee; }
public Date getDateDepart() { return dateDepart; }
public double getPrixTotal() { return prixTotal; }
public StatutReservation getStatut() { return statut; }
// Setter pour le statut (avec validation potentielle)
public void setStatut(StatutReservation statut) {
this.statut = statut;
}
public double calculerPrixTotal(double reduction) {
long diffInMillies = Math.abs(dateDepart.getTime() -
dateArrivee.getTime());
long nbNuits = TimeUnit.DAYS.convert(diffInMillies,
TimeUnit.MILLISECONDS);
if (nbNuits == 0) nbNuits = 1; // Minimum 1 nuit
double prixBase = hebergement.getPrixNuit() * nbNuits;
this.prixTotal = prixBase * (1 - reduction);
return this.prixTotal;
}
public void confirmerReservation() {
if (this.statut == StatutReservation.EN_ATTENTE) {
this.statut = StatutReservation.CONFIRMEE;
System.out.println("Réservation " + idUnique + " confirmée.");
} else {
System.out.println("Impossible de confirmer la réservation " +
idUnique + ": statut actuel est " + this.statut);
}
}
public void annulerReservation() {
if (this.statut == StatutReservation.CONFIRMEE || this.statut ==
StatutReservation.EN_ATTENTE) {
this.statut = StatutReservation.ANNULEE;
System.out.println("Réservation " + idUnique + " annulée.");
} else {
System.out.println("Impossible d'annuler la réservation " +
idUnique + ": statut actuel est " + this.statut);
}
}
@Override
public String toString() {
return "Reservation{" +
"idUnique='" + idUnique + '\'' +
", client=" + client.getNom() + " (" + client.getEmail() +
')' +
", hebergement=" + hebergement.getNom() +
", dateArrivee=" + dateArrivee +
", dateDepart=" + dateDepart +
", prixTotal=" + String.format("%.2f", prixTotal) +
", statut=" + statut +
'}';
}
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Reservation that = (Reservation) o;
return Objects.equals(idUnique, that.idUnique);
}
@Override
public int hashCode() {
return Objects.hash(idUnique);
}
}
