package com.techelevator.dao.model;

public enum ProductSortOrder {
    PRICE_LOW_TO_HIGH("PriceLowToHigh"), PRICE_HIGH_TO_LOW("PriceHighToLow"), RATING_HIGH_TO_LOW("RatingHighToLow");

    public final String label;

    private ProductSortOrder(String label) {
        this.label = label;
    }

    public static ProductSortOrder valueOfLabel(String label) {
        for (ProductSortOrder productSortOrder : values()) {
            if (productSortOrder.label.equalsIgnoreCase(label)) {
                return productSortOrder;
            }
        }
        return null;
    }
}