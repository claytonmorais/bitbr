package br.com.bitbr.console.exception;

/**
 * Classe de exceção do GitLabApi
 *
 */
public class ConsoleException extends RuntimeException {

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -2412898770017806362L;

	/**
	 * 
	 */
	public ConsoleException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConsoleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConsoleException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ConsoleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ConsoleException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
