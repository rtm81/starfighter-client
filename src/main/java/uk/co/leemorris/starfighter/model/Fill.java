package uk.co.leemorris.starfighter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import uk.co.leemorris.starfighter.MultiformatDateDeserializer;

import java.util.Date;

import org.joda.time.DateTime;

/**
 * @author lmorris
 */
public class Fill {

    private final int price;
    private final int qty;
    private final DateTime ts;

    @JsonCreator
    public Fill(@JsonProperty("price") int price,
                @JsonProperty("qty") int qty,
                @JsonProperty("ts") @JsonDeserialize(using = MultiformatDateDeserializer.class) DateTime ts) {
        this.price = price;
        this.qty = qty;
        this.ts = ts;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public DateTime getTs() {
        return ts;
    }
}
