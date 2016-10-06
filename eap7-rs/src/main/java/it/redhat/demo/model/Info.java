package it.redhat.demo.model;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by fabio on 06/10/16.
 */
public class Info {

    @XmlElement(name = "dashed-field")
    private Values value;

    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }
}
