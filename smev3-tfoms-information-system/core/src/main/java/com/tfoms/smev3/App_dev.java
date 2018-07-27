package com.tfoms.smev3;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class App_dev {
	
	public static void main(String f[]) throws InterruptedException, IOException, ParserConfigurationException, SAXException{
		
	/*	final String IS_IN_1 = Utils.getValueOfProperties("542201_3T.file.in", "src/resource/config.properties");
		Path path = Paths.get(IS_IN_1);
		File oiFile = null;
		while(true){
			
			DirectoryStream<Path> stream  = Files.newDirectoryStream(path);
			for(Path file : stream){
				oiFile = file.toFile();
				
				if(oiFile.isFile()  && oiFile.canRead()){
					//Utils.parse(oiFile);
					Utils.parse(oiFile);
				}
			}
			
			Thread.sleep(10000);
		}
	*/	
	}

}
