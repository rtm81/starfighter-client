package uk.co.leemorris.starfighter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import uk.co.leemorris.starfighter.MultiformatDateDeserializer;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author lmorris
 */
public class StockQuote extends BaseResponse {
	
    private final static DateTimeFormatter millisecondFormat = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private final String symbol;
    private final String venue;
    private final int bid;
    private final int ask;
    private final int bidSize;
    private final int askSize;
    private final int bidDepth;
    private final int askDepth;
    private final int last;
    private final int lastSize;
    private final DateTime lastTrade;
    private final DateTime quoteTime;

    @JsonCreator
    public StockQuote(@JsonProperty(value="ok", required=false) Boolean ok,
                      @JsonProperty(value="error", required=false) String error,
                      @JsonProperty("symbol") String symbol,
                      @JsonProperty("venue") String venue,
                      @JsonProperty("bid") int bid,
                      @JsonProperty("ask") int ask,
                      @JsonProperty("bidSize") int bidSize,
                      @JsonProperty("askSize") int askSize,
                      @JsonProperty("bidDepth") int bidDepth,
                      @JsonProperty("askDepth") int askDepth,
                      @JsonProperty("last") int last,
                      @JsonProperty("lastSize") int lastSize,
                      @JsonProperty("lastTrade") @JsonDeserialize(using = MultiformatDateDeserializer.class) DateTime lastTrade,
                      @JsonProperty("quoteTime") @JsonDeserialize(using = MultiformatDateDeserializer.class) DateTime quoteTime) {
        super(ok == null ? true : ok, error);
        this.symbol = symbol;
        this.venue = venue;
        this.bid = bid;
        this.ask = ask;
        this.bidSize = bidSize;
        this.askSize = askSize;
        this.bidDepth = bidDepth;
        this.askDepth = askDepth;
        this.last = last;
        this.lastSize = lastSize;
        this.lastTrade = lastTrade;
        this.quoteTime = quoteTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getVenue() {
        return venue;
    }

    public int getBid() {
        return bid;
    }

    public int getAsk() {
        return ask;
    }

    public int getBidSize() {
        return bidSize;
    }

    public int getAskSize() {
        return askSize;
    }

    public int getBidDepth() {
        return bidDepth;
    }

    public int getAskDepth() {
        return askDepth;
    }

    public int getLast() {
        return last;
    }

    public int getLastSize() {
        return lastSize;
    }

    public DateTime getLastTrade() {
        return lastTrade;
    }

    public DateTime getQuoteTime() {
        return quoteTime;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "symbol='" + symbol + '\'' +
                ", venue='" + venue + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", bidSize=" + bidSize +
                ", askSize=" + askSize +
                ", bidDepth=" + bidDepth +
                ", askDepth=" + askDepth +
                ", last=" + last +
                ", lastSize=" + lastSize +
                ", lastTrade=" + lastTrade + 
                ", quoteTime=" + quoteTime +
                '}';
    }
    
    public String shortToString() {
    	return "b=" + bid +
    			"\ta=" + ask +
    			"\tbS=" + bidSize +
    			"\tbD=" + bidDepth +
    			"\taS=" + askSize +
    			"\taD=" + askDepth +
    			"\tla=" + last +
    			"\tlS=" + lastSize +
    			"\tlastTrade=" + lastTrade +
    			"\tquoteTime=" + quoteTime +
    			'}';
    }
}
