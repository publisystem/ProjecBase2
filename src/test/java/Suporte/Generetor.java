package Suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generetor {
	
	public static String dataHoraParaArquivo() {
		Timestamp temp = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMDHMMSS").format(temp);
	}

}
