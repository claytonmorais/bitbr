package br.com.bitbr.console.awt.util;

import java.awt.Image;
import java.awt.Toolkit;

public class AwtUtil {

	/**
	 * M�todo est�tico para retornar a imagem do icone
	 * 
	 * @return
	 */
	public static Image getIconeImage() {		
		return Toolkit.getDefaultToolkit().getImage(AwtUtil.class.getResource("/bitbr.png"));
	}

}
