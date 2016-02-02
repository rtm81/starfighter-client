package uk.co.leemorris.starfighter.model;

import java.util.Date;
import java.util.List;

import uk.co.leemorris.starfighter.MultiformatDateDeserializer;
import uk.co.leemorris.starfighter.dto.NewOrderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
/**
 * 
 * @author roscoe
 *
 *{
  "ok":true,
  "account": "TAH97715708", // trading account of the participant this execution is for
  "venue":"UYIEX",
  "symbol":"FERE",
  "order":   
    {
      "ok": true,
      "symbol":"FERE",
      "venue":"UYIEX",
      "direction":"buy",
      "originalQty":1,
      "qty":0,
      "price":0,
      "orderType":"market",
      "id":30,
      "account":"TAH97715708",
      "ts":"2015-08-10T16:54:25.803619968Z",
      "fills":[
        {
          "price":8332,
          "qty":1,
          "ts":"2015-08-10T16:54:25.803626698Z"
        }
      ],
    "totalFilled":1,
      "open":false
    },
  "standingId":25,
  "incomingId":30,
  "price":8332,
  "filled":1,
  "filledAt":"2015-08-10T16:54:25.803626698Z",
  "standingComplete":false,  // whether the order that was on the book is now complete
  "incomingComplete":true  // whether the incoming order is complete (as of this execution)
}
 *
 *
 */
public class FillSubsriptionWrapper extends BaseResponse {

	private final String account;
	private final String venue;
	private final String symbol;
	private final int standingId;
	private final int incomingId;
	private final int price;
	private final int filled;
	private final Date filledAt;
	private final boolean standingComplete;
	private final boolean incomingComplete;
	private final List<NewOrderResponse> order;

	public FillSubsriptionWrapper(@JsonProperty(value="ok") boolean ok,
                                    @JsonProperty(value="error", required=false) String error,
                                    @JsonProperty("account") String account,
                                    @JsonProperty("venue") String venue,
                                    @JsonProperty("symbol") String symbol,
                                    // TODO: order
                                    @JsonProperty("order") List<NewOrderResponse> order,
                                    @JsonProperty("standingId") int standingId,
                                    @JsonProperty("incomingId") int incomingId,
                                    @JsonProperty("price") int price,
                                    @JsonProperty("filled") int filled,
                                    @JsonProperty("filledAt") @JsonDeserialize(using = MultiformatDateDeserializer.class) Date filledAt,
                                    @JsonProperty("standingComplete") boolean standingComplete,
                                    @JsonProperty("incomingComplete") boolean incomingComplete
                                    ) {
		super(ok, error);
		this.account = account;
		this.venue = venue;
		this.symbol = symbol;
		this.order = order;
		this.standingId = standingId;
		this.incomingId = incomingId;
		this.price = price;
		this.filled = filled;
		this.filledAt = filledAt;
		this.standingComplete = standingComplete;
		this.incomingComplete = incomingComplete;
	}

	public String getAccount() {
		return account;
	}

	public String getVenue() {
		return venue;
	}

	public String getSymbol() {
		return symbol;
	}

	public int getStandingId() {
		return standingId;
	}

	public int getIncomingId() {
		return incomingId;
	}

	public int getPrice() {
		return price;
	}

	public Date getFilledAt() {
		return filledAt;
	}

	public int getFilled() {
		return filled;
	}

	public boolean isStandingComplete() {
		return standingComplete;
	}

	public boolean isIncomingComplete() {
		return incomingComplete;
	}

	@Override
	public String toString() {
		return "FillSubsriptionWrapper [account=" + account + ", venue=" + venue + ", symbol="
				+ symbol + ", standingId=" + standingId + ", incomingId=" + incomingId + ", price="
				+ price + ", filled=" + filled + ", filledAt=" + filledAt + ", standingComplete="
				+ standingComplete + ", incomingComplete=" + incomingComplete + "]";
	}

	public List<NewOrderResponse> getOrder() {
		return order;
	}

	
}
