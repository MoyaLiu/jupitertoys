package com.jupiter.common;

public class Utils {
    public static float calculateSubtotal(String productPrice, int quantity) {
        float subtotal = Float.parseFloat(formatPrice(productPrice)) * quantity;
        return convertPrecision(subtotal);
    }

    public static String reFormatFloat(float subtotal) {
        return reFormatPrice(Float.toString(subtotal));
    }

    public static float convertPrecision(float number) {
        return (float) (Math.round(number * 100)) / 100;
    }

    public static String formatPrice(String price) {
        return price.replace("$", "");
    }

    public static String reFormatPrice(String price) {
        return "$" + price;
    }

    public static String reFormatTotalPrice(float total) {
        return "Total: " + total;
    }

}
