/**
 * 
 */
package br.com.bitbr.console.model.vo;

import java.io.Serializable;

/**
 * Classe para salvar as configurações do robô
 *
 */
public class Configuration implements Serializable {

	private String txMimSale; 
	private String txMaxSale; 
	private String txMimPurchase; 
	private String txMaxPurchase;
	
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 215531474050365670L;

	public Configuration(String txMimSale, String txMaxSale, String txMimPurchase, String txMaxPurchase) {
		this.txMimSale = txMimSale;
		this.txMaxSale = txMaxSale;
		this.txMimPurchase = txMimPurchase;
		this.txMaxPurchase = txMaxPurchase;
	}

	/**
	 * @return the txMimSale
	 */
	public String getTxMimSale() {
		return txMimSale;
	}

	/**
	 * @return the txMaxSale
	 */
	public String getTxMaxSale() {
		return txMaxSale;
	}

	/**
	 * @return the txMimPurchase
	 */
	public String getTxMimPurchase() {
		return txMimPurchase;
	}

	/**
	 * @return the txMaxPurchase
	 */
	public String getTxMaxPurchase() {
		return txMaxPurchase;
	}

}
