package com.appeltabak.jodo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class LabelResource {
    @Id
    @GeneratedValue
    private long id;

    private String color;

    LabelResource(){}

    LabelResource(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LabelResource)) {
            return false;
        }

        LabelResource labelResource = (LabelResource) obj;

        return Objects.equals(this.id, labelResource.id) && Objects.equals(this.color, labelResource.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(this.id, this.color);
    }

}
