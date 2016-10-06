package it.redhat.demo.model;

/**
 * Created by fabio on 06/10/16.
 */
public class Values {

    private Integer importo;
    private String id;

    public Integer getImporto() {
        return importo;
    }

    public void setImporto(Integer importo) {
        this.importo = importo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Values{" +
                "importo=" + importo +
                ", id='" + id + '\'' +
                '}';
    }

}
