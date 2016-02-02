package uk.co.leemorris.starfighter.dto;

import uk.co.leemorris.starfighter.model.Direction;
import uk.co.leemorris.starfighter.model.OrderType;

/**
 * Holds information for creating new orders.
 * @author lmorris
 */
public class NewOrderDetails {

    private final String account;
    private final String venue;
    private final String stock;
    private final int price;
    private final int qty;
    private final Direction direction;
    private final OrderType orderType;

    public NewOrderDetails(String account, String venue, String stock,
                           int price, int qty, Direction direction, OrderType orderType) {
        this.account = account;
        this.venue = venue;
        this.stock = stock;
        this.price = price;
        this.qty = qty;
        this.direction = direction;
        this.orderType = orderType;
    }

    public String getAccount() {
        return account;
    }

    public String getVenue() {
        return venue;
    }

    public String getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Direction getDirection() {
        return direction;
    }

    public OrderType getOrderType() {
        return orderType;
    }
}
