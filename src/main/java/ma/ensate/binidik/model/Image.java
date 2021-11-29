package ma.ensate.binidik.model;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private int demande_id;

    public Image() {

    }


    public Image(String image, int annonce_id) {
        this.image = image;
        this.demande_id = annonce_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDemande_id() {
        return demande_id;
    }

    public void setDemande_id(int demande_id) {
        this.demande_id = demande_id;
    }
}