package com.tfoms.smev3;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBException;

import com.tfoms.smev3.egr_zags.adapter.request.request.AdapterMessage;
import com.tfoms.smev3.service.Smev3_MyHealth_Service;
import com.tfoms.smev3.util.Utils;

public class App_dev_v2 {
// App.class.getClassLoader().getResourceAsStream("myFirstProperties.properties");
	public static void main(String[] args) throws Exception {
		Smev3_MyHealth_Service service = new Smev3_MyHealth_Service();
		// will being processed
		final String IS_IN_WORTH = Utils.getValueOfProperties("542202_3S.file.in", "src/resources/config.properties");
		// store with staus done and have send's response on this message
		final String IS_IN_WORTH_OK = Utils.getValueOfProperties("542202_3S.file.in.ok", "src/resources/config.properties");
		final String IS_OUT = Utils.getValueOfProperties("542202_3S.file.out", "src/resources/config.properties");
		
		Path path = Paths.get(IS_IN_WORTH);
		File oiFile = null;
		AdapterMessage am = null;
		
		while(true){
			
			DirectoryStream<Path> stream  = Files.newDirectoryStream(path);
			for(Path file : stream){
				oiFile = file.toFile();
				
				if(oiFile.isFile()  && oiFile.canRead()){
					System.out.println(oiFile.getName());
					am = Utils.unmarshalAdapter(oiFile);
					service.getDataResponse(am);
					
					// копируем в отработанную директорию 
					Files.copy(file, Paths.get(IS_IN_WORTH_OK+File.separator+file.getFileName().toString()));
					Files.delete(file);
				}
			}
			
			Thread.sleep(10000);
		}

	}

}
