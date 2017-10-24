package br.com.bitbr.console.awt.dialog;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bitbr.console.awt.util.AwtUtil;
import br.com.bitbr.console.exception.AuthenticationException;
import br.com.bitbr.console.exception.InvalidPasswordException;
import br.com.bitbr.console.model.login.bean.LoginBean;
import br.com.bitbr.console.util.Constants;

/**
 * Objeto swing para criação da caixa de diálogo de login 
 */
public class LoginDialog extends JFrame implements Constants {
	

	/**
	 * Serial id
	 */
	private static final long serialVersionUID = 1051091079320868355L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginDialog.class);

	
	private JTextField username;
	private JPasswordField password;
	private JButton login;
	private JButton clear;
	private JLabel user;
	private JLabel pass;
	
	private LoginBean loginBean;
	
	private LoginDialog() throws AuthenticationException {
		super("Console - Autenticação");
		setIconImage(AwtUtil.getIconeImage());
		setLayout(new FlowLayout());		
		user = new JLabel("Usuário: ");
		add(user);		
		username = new JTextField(15);
		add(username);
		
		pass = new JLabel("Senha:   ");
		add(pass);
		
		password = new JPasswordField(15);
		add(password);
		
		login = new JButton("Entrar");
		login.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event){
				
			try {  				
					loginBean = LoginBean.getInstance();	
					loginBean.login(username.getText(), String.valueOf( password.getPassword() ));
					ConfigurationtDialog.runReportDialog();					
					closeFrame();
						
				} catch (InvalidPasswordException e) {
					LOGGER.debug(USR_PASS_INVALID);
					JOptionPane.showMessageDialog(null, USR_PASS_INVALID);
				
				} catch (AuthenticationException e) {
					LOGGER.debug("");
					JOptionPane.showMessageDialog(null, "");
				}				
			}
		 }
		);
		add(login);
		
		clear = new JButton("Limpar");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento){
				if(evento.getSource() == clear){
					username.setText("");
					password.setText("");
				}
			}
		 }
		);
		add(clear);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(610,110);
		setLocationRelativeTo( null );		
		setVisible(true);
	}		 


	/**
	 * Método para fechar a caixa de dialogo
	 */
	public void closeFrame(){
		dispose();
	}
	
	
    /**
     * Inicia a caixa de dialogo para o processamento
     * @param loginBean objeto da sessão do gitLab
     * @return Insancia do gitLab
     * @throws AuthenticationException 
     */
    public static void runLoginDialog() throws AuthenticationException{
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new LoginDialog();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		});
    }	
	
}