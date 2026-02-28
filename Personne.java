import java.util.Objects;
public abstract class Personne {
private String nom;
private String prenom;
private String email;
private String motDePasse;
public Personne(String nom, String prenom, String email, String
motDePasse) {
this.nom = nom;
this.prenom = prenom;
this.email = email;
this.motDePasse = motDePasse;
}
// Getters pour accéder aux attributs privés
public String getNom() { return nom; }
public String getPrenom() { return prenom; }
public String getEmail() { return email; }
public String getMotDePasse() { return motDePasse; }
// Méthode abstraite pour la connexion, à implémenter par les sousclasses
public abstract boolean seConnecter(String email, String motDePasse);
@Override
public String toString() {
return "Personne{" +
"nom='" + nom + '\'' +
", prenom='" + prenom + '\'' +
", email='" + email + '\'' +
'}';
}
@Override
public boolean equals(Object o) {
if (this == o) return true;
if (o == null || getClass() != o.getClass()) return false;
Personne personne = (Personne) o;
return Objects.equals(email, personne.email);
}
@Override
public int hashCode() {
return Objects.hash(email);
}
}