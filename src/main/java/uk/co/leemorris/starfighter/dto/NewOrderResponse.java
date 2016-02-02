package uk.co.leemorris.starfighter.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import uk.co.leemorris.starfighter.MultiformatDateDeserializer;
import uk.co.leemorris.starfighter.model.BaseResponse;
import uk.co.leemorris.starfighter.model.Direction;
import uk.co.leemorris.starfighter.model.Fill;
import uk.co.leemorris.starfighter.model.OrderType;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

/**
 * @author lmorris
 */
public class NewOrderResponse extends BaseResponse {

    private final String symbol;
    private final String venue;
    private final Direction direction;
    private final int originalQty;
    private final int qty;
    private final int price;
    private final OrderType orderType;
    private final long id;
    private final String account;
    private final DateTime ts;
    private final int totalFilled;
    private final boolean open;
    private final List<Fill> fills;

    @JsonCreator
    public NewOrderResponse(@JsonProperty("ok") boolean ok,
                            @JsonProperty(value="error", required=false) String error,
                            @JsonProperty("symbol") String symbol,
                            @JsonProperty("venue") String venue,
                            @JsonProperty("direction") Direction direction,
                            @JsonProperty("originalQty") int originalQty,
                            @JsonProperty("qty") int qty,
                            @JsonProperty("price") int price,
                            @JsonProperty("orderType") OrderType orderType,
                            @JsonProperty("id") long id,
                            @JsonProperty("account") String account,
                            @JsonProperty("ts") @JsonDeserialize(using = MultiformatDateDeserializer.class) DateTime ts,
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
        this.totalFilled = totalFilled;
        this.open = open;
        this.fills = fills;
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

    public long getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public DateTime getTs() {
        return ts;
    }

    public int getTotalFilled() {
        return totalFilled;
    }

    public boolean isOpen() {
        return open;
    }

    public List<Fill> getFills() {
        return fills;
    }


	@Override
	public String toString() {
		return "NewOrderResponse [symbol=" + symbol + ", venue=" + venue
				+ ", direction=" + direction + ", originalQty=" + originalQty
				+ ", qty=" + qty + ", price=" + price + ", orderType="
				+ orderType + ", id=" + id + ", account=" + account + ", ts="
				+ ts + ", totalFilled=" + totalFilled + ", open=" + open
				+ ", fills=" + fills + "]";
	}
    
    
}
