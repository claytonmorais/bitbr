
package br.com.bitbr.console.awt.dialog;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bitbr.console.awt.util.AwtUtil;
import br.com.bitbr.console.exception.ConsoleException;
import br.com.bitbr.console.model.configuration.bean.ConfigurationBean;
import br.com.bitbr.console.model.instance.bean.InstanceBean;
import br.com.bitbr.console.model.vo.Configuration;
import br.com.bitbr.console.model.vo.Instance;
import br.com.bitbr.util.Constants;

/**
 * Classe Swing para caixa de diálogo de geração de relatório.
 *
 */
public class ConfigurationtDialog extends JFrame implements Constants  {

 
	
	/**
	 * Serial id
	 */
	private static final long serialVersionUID = -6939450930468559681L;


	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationtDialog.class);

    private static JPanel principalPanel = new JPanel();

	
    
    /**
     * Construtor padrão
     * @param gitLabApplication objeto gitLab para manipulação de informações.
     */
    private ConfigurationtDialog()  {         
    	    
    	
    	    super(CONFIGURATION_NAME);
    	    setIconImage(AwtUtil.getIconeImage());
    	    LOGGER.debug("invocando o constutor: ["+this.getClass().getName()+"]");
            
    	    JLabel instanceLabel = new JLabel("Instância: ");
            addCompontLayout(instanceLabel,10,10,125,25);
            final JComboBox<Instance> instanceCombo  = new JComboBox<Instance>();                        
            loadComboItem(instanceCombo);
            addCompontLayout(instanceCombo,150,10,390,25); 
            
           
            JLabel taxMimSaleLabel = new JLabel("Taxa Min. Compra"); 
            addCompontLayout(taxMimSaleLabel,10,40,125,25);
            final JTextField taxMimSaleTxt = new JTextField("");
            addCompontLayout(taxMimSaleTxt,150,40,390,25);

            JLabel taxMaxSaleLabel = new JLabel("Taxa Max. Compra: "); 
            addCompontLayout(taxMaxSaleLabel,10,70,125,25);
            final JTextField taxMaxSaleTxt = new JTextField("");
            addCompontLayout(taxMaxSaleTxt,150,70,390,25);            

            
            JLabel taxMimPurchaseLabel = new JLabel("Taxa Min. Venda: "); 
            addCompontLayout(taxMimPurchaseLabel,10,100,125,25);
            final JTextField taxMimPurchaseTxt = new JTextField("");
            addCompontLayout(taxMimPurchaseTxt,150,100,390,25);            
           
            JLabel taxMaxPurchaseLabel = new JLabel("Taxa Max. Venda: "); 
            addCompontLayout(taxMaxPurchaseLabel,10,130,130,25);
            final JTextField taxMaxPurchaseTxt = new JTextField("");
            addCompontLayout(taxMaxPurchaseTxt,150,130,390,25);            
            
            JButton cancel = new JButton( "Cancel" );                
            addCompontLayout(cancel,140,190,125,30);
            
            JButton buttonOK = new JButton( "OK" );
            buttonOK.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent event){  
        			try{
        				ConfigurationBean.getInstance().save(new Configuration(taxMimSaleTxt.getText(),taxMaxSaleTxt.getText(),taxMimPurchaseTxt.getText(),taxMaxPurchaseTxt.getText()),(Instance)instanceCombo.getSelectedItem());
        				JOptionPane.showMessageDialog(null, "Configuração Salva com sucesso");
        			}catch (ConsoleException expt){
        				LOGGER.debug("Erro ao salvar as configurações: "+ expt.getMessage());
        				JOptionPane.showMessageDialog(null, "Erro ao salvar as configurações");
        			}	
        		}
        	});
            addCompontLayout(buttonOK,285,190,125,30);
            
            
            
            
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(580, 270);
            setLocationRelativeTo(null);
            principalPanel.setLayout(null);
            add(principalPanel);
            setVisible(true);
            
    }

	private void loadComboItem(JComboBox<Instance> instanceCombo) {		
		List<Instance> items = InstanceBean.getInstance().getAllInstances();
		for (Instance item : items){
			instanceCombo.addItem(item);
		}
		
	}
    
    /**
    * Função para adicionar componentes no painel no formulario
    * 
    * @param component Objeto componente
    * @param column coluna
    * @param row linha
    * @param width lagura 
    * @param height altura
    */
    private void addCompontLayout(Component component, int column, int row, int width, int height ) {
       principalPanel.add(component) ; 
       component.setBounds(column,row,width,height);
    }     
    
    /**
     * Inicia a caixa de dialogo para o processamento
     * @param gitLabApplication objeto da sessão do gitLab
     */
    public static void runReportDialog(){
    	
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	LOGGER.debug("invocando a janela de geração de relatório");
            	new ConfigurationtDialog();	
            }
        });
    }
}
