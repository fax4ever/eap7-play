package it.redhat.demo.model;

/**
 * @author Fabio Massimo Ercoli
 *         fabio.ercoli@redhat.com
 *         on 26/05/16
 */
public class Item {

    private String name;
    private String code;

    public Item(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
