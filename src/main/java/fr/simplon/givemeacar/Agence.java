package fr.simplon.givemeacar;


public class Agence {


    private long idAgence;
private String ville;

    public Agence(long idAgence, String ville) {
        this.idAgence = idAgence;
        this.ville = ville;
    }

    public Agence() {
        super();
    }

    public long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(long idAgence) {
        this.idAgence = idAgence;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
