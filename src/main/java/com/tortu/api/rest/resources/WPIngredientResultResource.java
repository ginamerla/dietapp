package com.tortu.api.rest.resources;

/**
 * Representa el recurso para la capa REST de la lista de ingredientes de una receta
 */
public class WPIngredientResultResource {
    private Double quantity;
    private String unit;
    private String item;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
