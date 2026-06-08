package manga_collection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;
    private Integer tomeNumero;
    private boolean possede;

    // Constructeur vide (Indispensable pour JPA)
    public Manga() {
    }

    // Constructeur complet
    public Manga(String titre, String auteur, Integer tomeNumero, boolean possede) {
        this.titre = titre;
        this.auteur = auteur;
        this.tomeNumero = tomeNumero;
        this.possede = possede;
    }

    // --- GETTERS ET SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getTomeNumero() {
        return tomeNumero;
    }

    public void setTomeNumero(Integer tomeNumero) {
        this.tomeNumero = tomeNumero;
    }

    public boolean isPossede() {
        return possede;
    }

    public void setPossede(boolean possede) {
        this.possede = possede;
    }
}