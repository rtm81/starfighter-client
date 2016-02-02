package uk.co.leemorris.starfighter.dto;

/**
 * @author lmorris
 */
public class OrderCancelRequest {

    private final String venue;
    private final String stock;
    private final int orderId;

    public OrderCancelRequest(String venue, String stock, int orderId) {
        this.venue = venue;
        this.stock = stock;
        this.orderId = orderId;
    }

    public String getVenue() {
        return venue;
    }

    public String getStock() {
        return stock;
    }

    public int getOrderId() {
        return orderId;
    }
}
