package com.tfoms.smev3.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.InputSource;

import com.tfoms.api.indentity.IdentityService;
import com.tfoms.core.template.TemplateRequest;
import com.tfoms.core.template.implementation.TemplateRequestImpl;
import com.tfoms.smev3.dao.MyHealthDAO;
import com.tfoms.smev3.egr_zags.adapter.request.request.AdapterMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.ClientMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.Content;
import com.tfoms.smev3.egr_zags.adapter.request.request.MessagePrimaryContent;
import com.tfoms.smev3.egr_zags.adapter.request.request.Reject;
import com.tfoms.smev3.egr_zags.adapter.request.request.RejectCode;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestMessageType;
import com.tfoms.smev3.egr_zags.adapter.request.request.ResponseContentType;
import com.tfoms.smev3.egr_zags.adapter.request.request.ResponseMessageType;
import com.tfoms.smev3.egr_zags.adapter.request.request.ResponseMetadataType;
import com.tfoms.smev3.loader.IdentityLoader;
import com.tfoms.smev3.model.Zl;
import com.tfoms.smev3.util.Utils;

public class Smev3_MyHealth_Service {

	private  MyHealthDAO dao;
	private IdentityService identificationService;
	private TemplateRequest templateRequest;
	
	public Smev3_MyHealth_Service() {
		this.dao = new MyHealthDAO();
		this.templateRequest = new TemplateRequestImpl();
	}
	
	public Smev3_MyHealth_Service(String str) {
	    if(str==""){
	    	//this.dao = new fdfsfsf();
	    	//this.templateRequest = new dfsfdgf();
	    }else{
	    	
	    }
	}

	public void getDataResponse(AdapterMessage am) throws Exception {
		 
		final String tamplate = Utils.getValueOfProperties("542202_3S.file.tamlate.response", "src/resources/config.properties");
		final String file_out = Utils.getValueOfProperties("542202_3S.file.out", "src/resources/config.properties");
		// формирование карточки ЗЛ
		
		/*
		templateRequest = factory.create(adapter am);
		
		templateRequest.prepare_data_request();
		templateRequest.addToDb(this.dao); // MyHealthDAOInterface dao = new ipmlement
		templateRequest.getInfoWorth();
		templateRequest.prepare_data_response();
		
		in dao resolve methods for worth and smo polis 
		
		
		
		*/
		Zl zl  = templateRequest.prepare_data_request(am);
		// TODO логирование 
		 
		 System.out.println(zl);
		 // ФИКСАЦИЯ В БАЗУ ЗАПРОСА ПО СУЩНОСТИ ZL
		 
		 
		 // ЗАПРОС В БД ЗА СТОИМОСТЬЮ
		  String  s = (dao.getWorth(zl) == null) ? "" : dao.getWorth(zl);
		  
		  
		  
		  
		  
		  // ФОРМИРОВАНИЕ ОТВЕТА на основе овета из базы и структуры xml ответа
		  
		  org.w3c.dom.Element e  = null;
		  if(s.length() >0){
		  ByteArrayInputStream sbis = new ByteArrayInputStream(s.getBytes(Charset.forName("UTF-8")));
		  
		  javax.xml.parsers.DocumentBuilderFactory b = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		  b.setNamespaceAware(true);
		  org.w3c.dom.Document doc = null;
		  javax.xml.parsers.DocumentBuilder db = null;
		  db = b.newDocumentBuilder();
		  doc = db.parse(sbis);     

		  e	= doc.getDocumentElement();
		  }
		 
		 //File file_tamplate = Paths.get(tamplate).toFile();
		 ClientMessage cm = new ClientMessage();//Utils.unmarshalTamplateResponse(file_tamplate);
		 cm.setItSystem("542202_3S");
			 ResponseMessageType rmt = new ResponseMessageType();
			 	rmt.setMessageType("ResponseMessageType");
			 	ResponseMetadataType rmdt = new ResponseMetadataType();
			 	IdentityService is = Utils.getIdentityGeneratorInstance();
			 	rmdt.setClientId(is.generateUUID());
			 	rmt.setResponseMetadata(rmdt);
			 cm.setResponseMessage(rmt);
			 // устанавливаем replyRefId
			 RequestMessageType rm = (RequestMessageType)am.getMessage();
			 cm.getResponseMessage().getResponseMetadata().setReplyToClientId(rm.getRequestMetadata().getClientId());
			 // устанавливаем бизнес логику ответа ис
			 	ResponseContentType rct = new ResponseContentType();
			 	
			 	if(s.length() == 0){
			 		Reject rej = new Reject();
			 		rej.setCode(RejectCode.NO_DATA);
			 		rej.setDescription("Сведения не найдены");
			 		rct.getRejects().add(rej);
			 	}else{
			 		Content content = new Content();
		 			MessagePrimaryContent mpc = new MessagePrimaryContent();
		 				mpc.setAny(e);
		 			content.setMessagePrimaryContent(mpc);
		 			rct.setContent(content);
			 		
			 	}
			 		
		 cm.getResponseMessage().setResponseContent(rct);	
		 
		 
		 Utils.marshalTamplateResponse(cm, new File(file_out+File.separator+rmdt.getClientId()+".xml"));
		 
	}

	
}
