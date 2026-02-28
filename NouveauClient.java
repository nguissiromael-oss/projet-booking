import java.util.Date;
public class NouveauClient extends Client {
public NouveauClient(String nom, String prenom, String email, String
motDePasse, String adresse, Date dateInscription) {
super(nom, prenom, email, motDePasse, adresse, dateInscription);
}
@Override
public double verifierReductionFidelite() {
System.out.println("Nouveau client : pas de réduction de fidélité pour le moment.");
return 0.0; // Pas de réduction pour un nouveau client
}
@Override
public String toString() {
return "NouveauClient{" +
"nom='" + getNom() + '\'' +
", email='" + getEmail() + '\'' +
'}';
}
}
