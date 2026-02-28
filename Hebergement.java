import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Hebergement {
private String idUnique;
private String nom;
private String adressePostale;
private String type;
private int nbMaxPersonnes;
private double prixNuit;
private List<String> equipements;
public Hebergement(String idUnique, String nom, String adressePostale,
String type, int nbMaxPersonnes, double prixNuit, List<String> equipements)
{
this.idUnique = idUnique;
this.nom = nom;
this.adressePostale = adressePostale;
this.type = type;
this.nbMaxPersonnes = nbMaxPersonnes;
this.prixNuit = prixNuit;
this.equipements = equipements != null ? new ArrayList<>
(equipements) : new ArrayList<>();
}
// Getters pour tous les attributs
public String getIdUnique() { return idUnique; }
public String getNom() { return nom; }
public String getAdressePostale() { return adressePostale; }
public String getType() { return type; }
public int getNbMaxPersonnes() { return nbMaxPersonnes; }
public double getPrixNuit() { return prixNuit; }
public List<String> getEquipements() { return new ArrayList<>
(equipements); }
// Méthodes de comportement de l'hébergement
public boolean verifierDatesLibres(Date dateArrivee, Date dateDepart) {
// Logique complexe de vérification de disponibilité (non implémentée ici pour simplicité)

System.out.println("Vérification des dates libres pour " + nom + "du "
 + dateArrivee + " au " + dateDepart);
return true; // Pour l'exemple, toujours disponible
}
public String retournerResume() {
return "Hébergement{nom='" + nom + '\'' +
", type='" + type + '\'' +
", prixNuit=" + prixNuit +
'}';
}
public double retournerPrixTotalSejour(long nbNuits) {
return prixNuit * nbNuits;
}
public void ajouterPeriodeDisponible(Date debut, Date fin) {
System.out.println("Ajout de disponibilité pour " + nom + " du " +
debut + " au " + fin);
}
public void supprimerPeriodeDisponible(Date debut, Date fin) {
System.out.println("Suppression de disponibilité pour " + nom + " du " + debut + " au " + fin);
}
public void ajouterNote(int note, String commentaire) {
System.out.println("Note " + note + " ajoutée à " + nom + ": " +
commentaire);
}
@Override
public String toString() {
return "Hebergement{" +
"idUnique='" + idUnique + '\'' +
", nom='" + nom + '\'' +
", adressePostale='" + adressePostale + '\'' +
", type='" + type + '\'' +
", nbMaxPersonnes=" + nbMaxPersonnes +
", prixNuit=" + prixNuit +
", equipements=" + equipements +
'}';
}
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Hebergement that = (Hebergement) o;
return Objects.equals(idUnique, that.idUnique);
}
@Override
public int hashCode() {
return Objects.hash(idUnique);
}
}