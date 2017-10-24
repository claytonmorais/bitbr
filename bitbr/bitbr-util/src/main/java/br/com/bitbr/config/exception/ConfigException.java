package br.com.bitbr.config.exception;

public class ConfigException extends RuntimeException {
	
	

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -1468712610743564331L;

	/**
	 * 
	 */
	public ConfigException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConfigException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConfigException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ConfigException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ConfigException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
