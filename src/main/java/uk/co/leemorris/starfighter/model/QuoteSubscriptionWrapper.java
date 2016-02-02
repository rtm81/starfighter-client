package uk.co.leemorris.starfighter.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author lmorris
 * 
 * 
 * {
  "ok": true,
  "quote": { // the below is the same as returned through the REST quote API
    "symbol": "FAC",
    "venue": "OGEX",
    "bid": 5100, // best price currently bid for the stock
    "ask": 5125, // best price currently offered for the stock
    "bidSize": 392, // aggregate size of all orders at the best bid
    "askSize": 711, // aggregate size of all orders at the best ask
    "bidDepth": 2748, // aggregate size of *all bids*
    "askDepth": 2237, // aggregate size of *all asks*
    "last": 5125, // price of last trade
    "lastSize": 52, // quantity of last trade
    "lastTrade": "2015-07-13T05:38:17.33640392Z", // timestamp of last trade,
    "quoteTime": "2015-07-13T05:38:17.33640392Z" // server ts of quote generation
  }
}
 * 
 * 
 */
public class QuoteSubscriptionWrapper extends BaseResponse {

    private final StockQuote quote;

    @JsonCreator
    public QuoteSubscriptionWrapper(@JsonProperty(value="ok") boolean ok,
                                    @JsonProperty(value="error", required=false) String error,
                                    @JsonProperty("quote") StockQuote quote) {
        super(ok, error);
        this.quote = quote;
    }

    public StockQuote getQuote() {
        return quote;
    }
}
