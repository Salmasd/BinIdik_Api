package ma.ensate.binidik.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Demandes")
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String titre;
    private String description;
    private String categorie;
    private String sousCategorie;
    private String paiement;
    private String adresse;
    private String ville;
    private int User_id;
    private String statut;


    @OneToOne(orphanRemoval = false)
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="demande_id", referencedColumnName = "id")
    private List<Image> Images;

    public Demande(){

    }

    public Demande(int id, Date date, String titre, String description, String categorie, String sousCategorie, String paiement, String ville, String adresse,String statut) {
        this.id = id;
        this.date = date;
        this.titre = titre;
        this.description = description;
        this.categorie = categorie;
        this.sousCategorie = sousCategorie;
        this.paiement = paiement;
        this.statut= statut;
        this.adresse= adresse;
        this.ville= ville;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImages() {
        return Images;
    }

    public void setImages(List<Image> images) {
        Images = images;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getVille() {
        return ville;
    }

    public String getStatut() {
        return statut;
    }
}