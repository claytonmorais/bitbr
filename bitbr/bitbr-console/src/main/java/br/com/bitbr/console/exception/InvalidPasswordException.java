package br.com.bitbr.console.exception;


/**
 * Classe para tratar erro de usuário/senha
 *
 */
public class InvalidPasswordException extends Exception {

	
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -2239112366579910446L;

	/**
	 * 
	 */
	public InvalidPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidPasswordException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public InvalidPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public InvalidPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
