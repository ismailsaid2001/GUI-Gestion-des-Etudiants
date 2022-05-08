import java.util.Objects;

public class Etudiant {
  String Nom;
  String Prenom;
  String Sexe;
  String Filiere;
  int ID;
public Etudiant() {

}

    public Etudiant(String nom, String prenom, String sexe, String filiere,int id) {
        Nom = nom;
        Prenom = prenom;
        Sexe = sexe;
        Filiere = filiere;
        ID=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return Objects.equals(Nom, etudiant.Nom) && Objects.equals(Prenom, etudiant.Prenom) && Objects.equals(Sexe, etudiant.Sexe) && Objects.equals(Filiere, etudiant.Filiere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nom, Prenom, Sexe, Filiere);
    }


    @Override
    public String toString() {
        return "Etudiant{" +
                "Nom='" + Nom + '\'' +
                ", Prenom='" + Prenom + '\'' +
                ", Sexe='" + Sexe + '\'' +
                ", Filiere='" + Filiere + '\'' +
                ", ID=" + ID +
                '}';
    }
}

