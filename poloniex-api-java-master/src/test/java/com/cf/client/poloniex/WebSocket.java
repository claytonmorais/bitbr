/**
 * 
 */
package com.cf.client.poloniex;

import com.cf.client.WSSClient;
import com.cf.data.handler.poloniex.PoloniexSubscription;

import ws.wamp.jawampa.ApplicationError;

/**
 * @author Proprio
 *
 */
public class WebSocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		try (WSSClient poloniexWSSClient = new WSSClient("wss://api.poloniex.com", "realm1")) {
			
			
		    poloniexWSSClient.subscribe(PoloniexSubscription.TICKER);
		    poloniexWSSClient.subscribe(new PoloniexSubscription("USDT_BTC"));
		    poloniexWSSClient.run(60000);
		    
		   
		    
		} catch (ApplicationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
