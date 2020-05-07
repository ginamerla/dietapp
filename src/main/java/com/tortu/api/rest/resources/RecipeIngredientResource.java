package com.tortu.api.rest.resources;

/**
 * Representa el recurso de ingredientes para crear una receta completa
 */
public class RecipeIngredientResource {
    private Double quantity;
    private Integer unitId;
    private Integer  itemId;

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
