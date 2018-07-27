package egr_zags.adapter.request.request;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.persistence.internal.sessions.ClientSessionIdentityMapAccessor;
import org.w3c.dom.Document;

import com.tfoms.smev3.egr_zags.adapter.request.request.BusinessProcessMetadata;
import com.tfoms.smev3.egr_zags.adapter.request.request.ClientMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.Content;
import com.tfoms.smev3.egr_zags.adapter.request.request.CreateGroupIdentity;
import com.tfoms.smev3.egr_zags.adapter.request.request.MessagePrimaryContent;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestContentType;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestMessageType;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestMetadataType;
import com.tfoms.smev3.health.worth.query.request.InputDataType;
import com.tfoms.smev3.health.worth.query.request.InsuredRenderingInfoType;
import com.tfoms.smev3.health.worth.query.request.InsuredRenderingListRequestType;

public class MarshalUnmarshal {

	public static void main(String[] args) throws ParseException, DatatypeConfigurationException, ParserConfigurationException, JAXBException {
		
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(new SimpleDateFormat("dd.MM.yyyy").parse("20.07.1986"));
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		
		InputDataType idt = new InputDataType();
		InsuredRenderingListRequestType irlr = new InsuredRenderingListRequestType();
		irlr.setRegionCode("50000");
		irlr.setBirthDate(date2);
		irlr.setUnitedPolicyNumber("50004654134654");
		irlr.setDateFrom(date2);
		irlr.setDateTo(date2);
		idt.setInsuredRenderingListRequest(irlr);
		
		JAXBContext jc = JAXBContext.newInstance(InputDataType.class);
		 // Create the Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // Marshal the Object to a Document
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(idt, document);
		

		ClientMessage cm = new ClientMessage();
		cm.setItSystem("542201_3T");
		
			RequestMessageType rmt = new RequestMessageType();
			rmt.setMessageType("RequestMessageType");
				RequestMetadataType rmdt = new RequestMetadataType();
				rmdt.setClientId("3c1841aa-5751-11e8-b248-0050568f9mdf");
					CreateGroupIdentity cgi = new CreateGroupIdentity();
					cgi.setFRGUServiceCode("11111111111111111111");
					cgi.setFRGUServiceDescription("11111111111111111111");
					cgi.setFRGUServiceRecipientDescription("11111111111111111111");
				rmdt.setCreateGroupIdentity(cgi);
				rmdt.setNodeId("542201_3T");
				rmdt.setTestMessage(true);
				rmdt.setBusinessProcessMetadata(new BusinessProcessMetadata());
			rmt.setRequestMetadata(rmdt);
				RequestContentType rct = new RequestContentType();
					Content content = new Content();
						MessagePrimaryContent mpc = new MessagePrimaryContent();
						mpc.setAny(document.getDocumentElement());	
					content.setMessagePrimaryContent(mpc);
				rct.setContent(content);
			rmt.setRequestContent(rct);
		cm.setRequestMessage(rmt);
		
		try {

			File file = new File("C:\\temp\\file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ClientMessage.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(cm, file);
			jaxbMarshaller.marshal(cm, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		
	}

}
