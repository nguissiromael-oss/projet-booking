import java.util.Date;
import java.util.Objects;
public class Client extends Personne {
private String adresse;
private Date dateInscription;
public Client(String nom, String prenom, String email, String
motDePasse, String adresse, Date dateInscription) {
super(nom, prenom, email, motDePasse);
this.adresse = adresse;
this.dateInscription = dateInscription;
}
// Getters spécifiques à la classe Client
public String getAdresse() { return adresse; }
public Date getDateInscription() { return dateInscription; }
// Méthodes de comportement du client
public void filtrerHebergements(String criteres) {
System.out.println("Filtrage des hébergements avec les critères : "
+ criteres);
}
public void visualiserInformations() {
System.out.println("Visualisation des informations du client : " +
this.getEmail());
}
public double verifierReductionFidelite() {
// Implémentation par défaut, sera surchargée par NouveauClient et AncienClient

return 0.0;
}
@Override
public boolean seConnecter(String email, String motDePasse) {
// Logique de connexion simple pour l'exemple
return this.getEmail().equals(email) &&
this.getMotDePasse().equals(motDePasse);
}
@Override
public String toString() {
return "Client{" +
"nom='" + getNom() + '\'' +
", prenom='" + getPrenom() + '\'' +
", email='" + getEmail() + '\'' +
", adresse='" + adresse + '\'' +
", dateInscription=" + dateInscription +
'}';
}
}