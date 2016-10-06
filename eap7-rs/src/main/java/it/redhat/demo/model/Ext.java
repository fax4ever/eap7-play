package it.redhat.demo.model;

/**
 * Created by fabio on 06/10/16.
 */
public class Ext {

    private Info pratica;

    public Info getPratica() {
        return pratica;
    }

    public void setPratica(Info pratica) {
        this.pratica = pratica;
    }

    @Override
    public String toString() {
        return "Ext{" +
                "pratica=" + pratica +
                '}';
    }
}
