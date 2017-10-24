package br.com.bitbr.bot.main;

import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.bitbr.bot.task.TradeTask;
import br.com.bitbr.bot.util.CalutationsUtils;


/**
 * Classe para executar o robô
 *
 */
public class Main {
	
	static Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	static Timer timer;
	
    public static void main(String[] args) {
    	//timer = new Timer();
        //timer.schedule(new TradeTask(),0,CalutationsUtils.secondsToMilliseconds(3));
    	new TradeTask().run();
    }
}
