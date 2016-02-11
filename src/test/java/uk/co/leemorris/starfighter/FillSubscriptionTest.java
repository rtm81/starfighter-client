package uk.co.leemorris.starfighter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.collect.Lists;

import rx.Subscriber;
import uk.co.leemorris.starfighter.model.FillSubsriptionWrapper;

public class FillSubscriptionTest {
    public FillSubscriptionTest() throws Exception {
        TestWebsocketServer testWebsocketServer = new TestWebsocketServer(8091, "fills.txt");
        testWebsocketServer.start();
    }

    @Test
    public void subscribeRetrievesQuotes() throws Exception {

    	FillSubscription subscription = new FillSubscription();

        CountDownLatch latch = new CountDownLatch(30);
        List<FillSubsriptionWrapper> quotes = Lists.newArrayList();

        subscription.logon("ws://localhost:8091/api", "KAT97952062", "YEPS")
                .subscribe(new Subscriber<FillSubsriptionWrapper>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        fail(throwable.getMessage());
                    }

                    @Override
                    public void onNext(FillSubsriptionWrapper stockQuote) {
                        quotes.add(stockQuote);
                        latch.countDown();
                    }
                });

        latch.await(5, TimeUnit.SECONDS);

        assertEquals(24, quotes.size());
//        assertEquals("YEPS", quotes.get(0).getSymbol());
//        assertEquals(5006, quotes.get(0).getBid());
//        assertEquals(11731, quotes.get(2).getAskSize());
//        assertEquals(5199, quotes.get(2).getAsk());
    }
}
