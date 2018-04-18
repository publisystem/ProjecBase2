package Suporte;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;

public class CarregarIMG {

	public ImageIcon CarregarIMG() {
		// pacote onde estao as imagens no seu projeto
		String diretorio = "/Project_Report_Mantis/extras/icon.PNG";

		try {

			URL resource = getClass().getResource(diretorio);
			File file = new File(resource.toURI());
			// setando o icone
			ImageIcon logo = new ImageIcon(file.getPath());

			// jLabel.setIcon(logo);
			return logo;

		} catch (URISyntaxException ex) {
			// algo errado
		}
		return null;
	}
}
