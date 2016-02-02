package uk.co.leemorris.starfighter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import uk.co.leemorris.starfighter.MultiformatDateDeserializer;

import java.util.Date;
import java.util.List;

/**
 * @author lmorris
 */
public class OrderStatus extends BaseResponse {

    private final String symbol;
    private final String venue;
    private final Direction direction;
    private final int originalQty;
    private final int qty;
    private final int price;
    private final OrderType orderType;
    private final int id;
    private final String account;
    private final Date ts;
    private final List<Fill> fills;
    private final int totalFilled;
    private final boolean open;

    @JsonCreator
    public OrderStatus(@JsonProperty("ok") boolean ok,
                       @JsonProperty(value="error", required=false) String error,
                       @JsonProperty("symbol") String symbol,
                       @JsonProperty("venue") String venue,
                       @JsonProperty("direction") Direction direction,
                       @JsonProperty("originalQty") int originalQty,
                       @JsonProperty("qty") int qty,
                       @JsonProperty("price") int price,
                       @JsonProperty("orderType") OrderType orderType,
                       @JsonProperty("id") int id,
                       @JsonProperty("account") String account,
                       @JsonProperty("ts") @JsonDeserialize(using = MultiformatDateDeserializer.class) Date ts,
                       @JsonProperty("fills") List<Fill> fills,
                       @JsonProperty("totalFilled") int totalFilled,
                       @JsonProperty("open") boolean open) {
        super(ok, error);
        this.symbol = symbol;
        this.venue = venue;
        this.direction = direction;
        this.originalQty = originalQty;
        this.qty = qty;
        this.price = price;
        this.orderType = orderType;
        this.id = id;
        this.account = account;
        this.ts = ts;
        this.fills = fills;
        this.totalFilled = totalFilled;
        this.open = open;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getVenue() {
        return venue;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getOriginalQty() {
        return originalQty;
    }

    public int getQty() {
        return qty;
    }

    public int getPrice() {
        return price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public Date getTs() {
        return ts;
    }

    public List<Fill> getFills() {
        return fills;
    }

    public int getTotalFilled() {
        return totalFilled;
    }

    public boolean isOpen() {
        return open;
    }
}
