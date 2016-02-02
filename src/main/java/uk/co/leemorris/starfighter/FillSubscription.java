package uk.co.leemorris.starfighter;

import java.io.IOException;
import java.net.URI;

import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketListener;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import rx.Observable;
import rx.Subscriber;
import uk.co.leemorris.starfighter.model.FillSubsriptionWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebSocket
class FillSubscription implements WebSocketListener {
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	private WebSocketClient webSocketClient;
	private Subscriber<? super FillSubsriptionWrapper> quoteSubscriber;

    public Observable<FillSubsriptionWrapper> logon(String baseUrl, String account, String venue) {
        return logon(baseUrl + "/ws/" + account + "/venues/" + venue + "/executions/");
    }

    public Observable<FillSubsriptionWrapper> logon(String baseUrl, String account, String venue, String stock) {
        return logon(baseUrl + "/ws/" + account + "/venues/" + venue + "/executions/stocks/" + stock);
    }

    private Observable<FillSubsriptionWrapper> logon(String url) {
        return Observable.create(new Observable.OnSubscribe<FillSubsriptionWrapper>() {

			@Override
            public void call(Subscriber<? super FillSubsriptionWrapper> subscriber) {

                quoteSubscriber = subscriber;

                try {

                    if(url.startsWith("wss:")) {
                        webSocketClient = new WebSocketClient(new SslContextFactory());
                    } else {
                        webSocketClient = new WebSocketClient();
                    }

                    URI uri = new URI(url);
                    webSocketClient.start();
                    webSocketClient.connect(FillSubscription.this, uri);
                } catch (Exception ex) {
                    if(!quoteSubscriber.isUnsubscribed()) {
                        subscriber.onError(ex);
                    }
                }
            }
        });
    }
	
	@Override
	public void onWebSocketClose(int statusCode, String reason) {
        System.out.println(statusCode + " " + reason);
        if(!quoteSubscriber.isUnsubscribed()) {
            quoteSubscriber.onCompleted();
        }
	}

	@Override
	public void onWebSocketConnect(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWebSocketError(Throwable cause) {
        if(!quoteSubscriber.isUnsubscribed()) {
            quoteSubscriber.onError(cause);
        }
	}

	@Override
	public void onWebSocketBinary(byte[] payload, int offset, int len) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onWebSocketText(String message) {
        try {

            if(!quoteSubscriber.isUnsubscribed()) {
            	FillSubsriptionWrapper wrapper = objectMapper.readValue(message, FillSubsriptionWrapper.class);
                quoteSubscriber.onNext(wrapper);
            }
        } catch (IOException e) {
            if(!quoteSubscriber.isUnsubscribed()) {
                quoteSubscriber.onError(e);
            }
        }
	}

}
