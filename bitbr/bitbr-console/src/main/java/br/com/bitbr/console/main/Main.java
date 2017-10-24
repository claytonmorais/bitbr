package br.com.bitbr.console.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bitbr.console.awt.dialog.LoginDialog;


/**
 * Classe para executar o console de configurações
 *
 */
public class Main {
	
	static Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {	
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LoginDialog.runLoginDialog();
	}

}
