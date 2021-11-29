package ma.ensate.binidik.model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Candidatures")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String categorie;
    private String ville;


    public Candidature(){

    }

    public Candidature(int id, Date date, String nom, String prenom, String email, String telephone, String categorie,  String ville) {
        this.id = id;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone= telephone;
        this.categorie = categorie;
        this.ville= ville;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getCategorie() {
        return categorie;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getVille() {
        return ville;
    }

}