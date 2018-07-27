package com.tfoms.smev3.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.tika.mime.MimeTypes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.tfoms.api.indentity.IdentityService;
import com.tfoms.smev3.App_dev_v2;
import com.tfoms.smev3.egr_zags.adapter.request.request.AdapterMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.ClientMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.Message;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestMessageType;
import com.tfoms.smev3.loader.IdentityLoader;


public class Utils {
	
	
	public static final String UNKNOWN_FILE_EXTENSION = "";

	/**
	 * Метод извлекает из файла .properties
	 * @param path имя опции которой надо взять значение. Например destination=C:/folderWithFile
	 * @param nameProperties название файла .properties Например "src/main/resources/config.properties" 
	 * @return  Возвращает значение из файла .properties
	 * @throws IOException
	 */
	public static String getValueOfProperties(String path,String nameProperties) throws IOException
	 {
		try {
			
		 Properties properties = new Properties();
		 
		 InputStream is = App_dev_v2.class.getClassLoader().getResourceAsStream("com/tfoms/smev3/config.properties");
		 //FileInputStream is = new FileInputStream(nameProperties);
		 
		 properties.load(is);
		 
		return properties.getProperty(path);

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
            return null;
        }
		
		
	 }
	
	private static void getChildNode(Node nl){
		for(int l = 0 ; l < nl.getChildNodes().getLength(); l++){
			 System.out.println("CC "+nl.getChildNodes().item(l).getNodeName()+ " - "+ nl.getChildNodes().item(l).getChildNodes().getLength());
			 System.out.println(" Node.ELEMENT_NODE "+nl.getChildNodes().item(l).getNodeType());
			 if(nl.getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE){
				 	getContainNode(nl.getChildNodes().item(l));
			 }else{
				 	System.out.println(nl.getChildNodes().item(l).getParentNode().getNodeName()+" - "+ nl.getChildNodes().item(l).getNodeValue());
				 	System.out.println(">>> ===============================================================");
			 }
			 getChildNode(nl.getChildNodes().item(l));
		 }
	}
	private static void getContainNode(Node nl){
		
			for(int y = 0; y < nl.getAttributes().getLength(); y ++){
				 System.out.println(">>> NodeName "+nl.getAttributes().item(y).getNodeName());
				 //System.out.println(">>> LocalName "+nl.getAttributes().item(y).getLocalName());
				 System.out.println(">>> NodeValue "+nl.getAttributes().item(y).getNodeValue());
				 //System.out.println(">>> TextContent "+nl.getAttributes().item(y).getTextContent());
				 
			 }
		
		 System.out.println(">>> ===============================================================");
	}
	
	/**
	 * Метод предназначен для дебага сложных xml (ЕГР ЗАГС фатал). Руки надо оторвать налоговой за такой xml
	 * @param fXmlFile  входящий файл 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void  debugDomParser(File fXmlFile) throws ParserConfigurationException, SAXException, IOException{
		   
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 
		 Document doc = dBuilder.parse(fXmlFile);
		 doc.getDocumentElement().normalize();
		 
		 NodeList nl = doc.getElementsByTagName("FATALRequest:СведРегСмерт");
		 
		 // бежим по каждому FATALRequest:СведРегСмерт
		 for(int i = 0 ; i < nl.getLength(); i ++){
			 System.out.println("NodeName "+nl.item(i).getNodeName());
			 // собираем внутренности каждой nod'ы FATALRequest:СведРегСмерт
			 getContainNode(nl.item(i));
			 // смотрим детей (рекурсивно спукскаем по дереву)
			 getChildNode(nl.item(i));
		 }
	}
	
	/**
	 * @param fXmlFile
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void parse(File fXmlFile) throws ParserConfigurationException, SAXException, IOException{
		
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 
		 Document doc = dBuilder.parse(fXmlFile);
		 doc.getDocumentElement().normalize();
		 
		 NodeList nl = doc.getElementsByTagName("FATALRequest:СведРегСмерт");
		 
		 // бежим по каждому FATALRequest:СведРегСмерт
		 for(int i = 0 ; i < nl.getLength(); i ++){
			 System.out.println("NodeName "+nl.item(i).getNodeName());
			 // собираем внутренности каждой nod'ы FATALRequest:СведРегСмерт
			 getContainNode_env(nl.item(i));
			 // смотрим детей (рекурсивно спукскаем по дереву)
			 getChildNode_env(nl.item(i));
		 }
	}
	
	
	
	private static void getChildNode_env(Node nl){
		for(int l = 0 ; l < nl.getChildNodes().getLength(); l++){
			 System.out.println("ParentNode "+transliterate(nl.getChildNodes().item(l).getNodeName())+ " - "+ nl.getChildNodes().item(l).getChildNodes().getLength());
			 if(nl.getChildNodes().item(l).getNodeType() == Node.ELEMENT_NODE){
				 	getContainNode_env(nl.getChildNodes().item(l));
			 }else{
				 	System.out.println(transliterate(nl.getChildNodes().item(l).getParentNode().getNodeName())+" - "+ nl.getChildNodes().item(l).getNodeValue());
				 	System.out.println(">>> ===============================================================");
			 }
			 getChildNode_env(nl.getChildNodes().item(l));
		 }
	}
	
	
	
	private static void getContainNode_env(Node nl){
		
			for(int y = 0; y < nl.getAttributes().getLength(); y ++){
				 System.out.println(transliterate(nl.getAttributes().item(y).getNodeName()) + " - "+ nl.getAttributes().item(y).getNodeValue());
				 
			 }
		
		 System.out.println(">>> ===============================================================");
	}
	
	/**
	 * Преобразовывает кирилицу в латицину
	 * 
	 * @param message входящий кирилицеский тест
	 * @return преобразованный текст в латинице
	 */
	public static String transliterate(String message){
	    char[] abcCyr =   {' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	    String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < message.length(); i++) {
	        for (int x = 0; x < abcCyr.length; x++ ) {
	            if (message.charAt(i) == abcCyr[x]) {
	                builder.append(abcLat[x]);
	            }
	        }
	    }
	    return builder.toString();
	}
	
	public static String transliterateCyrilic(String message){
	    char[] abcCyr =   {' ','а','б','в','г','д','е','ё', 'ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х', 'ц','ч', 'ш','щ','ъ','ы','ь','э', 'ю','я','А','Б','В','Г','Д','Е','Ё', 'Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х', 'Ц', 'Ч','Ш', 'Щ','Ъ','Ы','Ь','Э','Ю','Я','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	    String[] abcLat = {" ","a","b","v","g","d","e","e","zh","z","i","y","k","l","m","n","o","p","r","s","t","u","f","h","ts","ch","sh","sch", "","i", "","e","ju","ja","A","B","V","G","D","E","E","Zh","Z","I","Y","K","L","M","N","O","P","R","S","T","U","F","H","Ts","Ch","Sh","Sch", "","I", "","E","Ju","Ja","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	    StringBuilder builder = new StringBuilder();
	    for (int i = 0; i < message.length(); i++) {
	    	builder.append(message.charAt(i));
	    	
	        for (int x = 0; x < abcCyr.length; x++ ) {
	        	//if(Character.UnicodeBlock.of(message.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
	            
	            if (message.charAt(i) == abcCyr[x] && Character.UnicodeBlock.of(message.charAt(i)).equals(Character.UnicodeBlock.CYRILLIC)) {
	                builder.delete(builder.length()-1, builder.length());
	                builder.append(abcLat[x]);
	            }
	        }
	    }
	    return builder.toString();
	}
	
	public static AdapterMessage unmarshalAdapter(File file) throws JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(AdapterMessage.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		AdapterMessage adapterMessage = (AdapterMessage) jaxbUnmarshaller.unmarshal(file);
		
		return adapterMessage;
	}
	
	public static ClientMessage unmarshalTamplateResponse(File file) throws JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ClientMessage.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ClientMessage client = (ClientMessage) jaxbUnmarshaller.unmarshal(file);
		
		return client;
	}

	
public static void marshalTamplateResponse(ClientMessage cm,File fileTo) throws JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ClientMessage.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

		jaxbMarshaller.marshal(cm, fileTo);
		//jaxbMarshaller.marshal(customer, System.out);
		
	}

/**
 * Возращает наиболее часто используемое расширение файла для указанного MIME типа.
 *
 * @param mimeType MIME тип файла
 * @return расширение или пустую строку, если не удалось определить
 */
public static String guessFileExtension(String mimeType) {
    try {
        return MimeTypes.getDefaultMimeTypes().forName(mimeType).getExtension();
    } catch (Exception ex) {
        return UNKNOWN_FILE_EXTENSION;
    }
}


public static IdentityService getIdentityGeneratorInstance() throws Exception {
    ServiceLoader<IdentityLoader> services = ServiceLoader.load(IdentityLoader.class);
    for (IdentityLoader loader : services) {
        return loader.getIdentity();
    }
    throw new Exception("Unable to load identity generator implementation");
}

public static String stripNonValidXMLCharacters(String in) {
    StringBuffer out = new StringBuffer(); // Used to hold the output.
    char current; // Used to reference the current character.

    if (in == null || ("".equals(in))) return ""; // vacancy test.
    for (int i = 0; i < in.length(); i++) {
        current = in.charAt(i); // NOTE: No IndexOutOfBoundsException caught here; it should not happen.
        if ((current == 0x9) ||
            (current == 0xA) ||
            (current == 0xD) ||
            ((current >= 0x20) && (current <= 0xD7FF)) ||
            ((current >= 0xE000) && (current <= 0xFFFD)) ||
            ((current >= 0x10000) && (current <= 0x10FFFF)))
            out.append(current);
    }
    return out.toString();
}    


}
