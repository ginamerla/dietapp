package com.tortu.api.rest.resources;

/**
 * Representa el recurso para la capa de REST de la lista de compras "ShoppingIngredientDTO"
 */
public class ShoppingIngredientResource {
    // Cantidad|medida  |id_ingrediente|Ingrediente      |Categoria   |
    private Double quantity;
    private String unit;
    private Integer idIngredient;
    private String item;
    private String category;

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

    public Integer getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Integer idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
