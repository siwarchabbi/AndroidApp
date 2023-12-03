package com.example.appuser.entreprise;

public class Model {
    private int id;
    private byte[]proavatar;
    private String texte;

    public Model(int id, byte[] proavatar, String texte) {
        this.id = id;
        this.proavatar = proavatar;
        this.texte = texte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getProavatar() {
        return proavatar;
    }

    public void setProavatar(byte[] proavatar) {
        this.proavatar = proavatar;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
