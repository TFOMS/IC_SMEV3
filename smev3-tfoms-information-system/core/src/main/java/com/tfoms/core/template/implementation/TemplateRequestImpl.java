package com.tfoms.core.template.implementation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.tfoms.core.template.TemplateRequest;
import com.tfoms.smev3.egr_zags.adapter.request.request.AdapterMessage;
import com.tfoms.smev3.egr_zags.adapter.request.request.RequestMessageType;
import com.tfoms.smev3.model.Zl;

public class TemplateRequestImpl implements TemplateRequest {

	public Zl prepare_data_request(AdapterMessage am) {
		
		Zl zl = new Zl();
		 NodeList nl = null;
		 
		 RequestMessageType qmt = (RequestMessageType) am.getMessage();
		 Element element = qmt.getRequestContent().getContent().getMessagePrimaryContent().getAny();
		 
		 nl = element.getElementsByTagNameNS("*", "FamilyName");
		 zl.setSurname(nl.item(0).getTextContent());
		 
		 nl = element.getElementsByTagNameNS("*", "FirstName");
		 zl.setFirstname((nl.item(0).getTextContent()));
		 
		 nl = element.getElementsByTagNameNS("*", "Patronymic");
		 zl.setLastname((nl.item(0).getTextContent()));
		 
		 nl = element.getElementsByTagNameNS("*", "BirthDate");
		 zl.setDatebythday(nl.item(0).getTextContent());
		 
		 nl = element.getElementsByTagNameNS("*", "RegionCode");
		 zl.setRegionCode(Integer.valueOf(nl.item(0).getTextContent()));
		 
		 nl = element.getElementsByTagNameNS("*", "DateFrom");
		 zl.setDataFrom(nl.item(0).getTextContent());
		 
		 nl = element.getElementsByTagNameNS("*", "DateTo");
		 zl.setDataEnd(nl.item(0).getTextContent());
		 
		 nl = element.getElementsByTagNameNS("*", "UnitedPolicyNumber");
		 zl.setEnp(Long.valueOf(nl.item(0).getTextContent()));
		 
		 // TODO добавить номер входящего пакета. ВНАЧАЛЕ 
		 // TODO добавить номер исходящего пакета пакета. ВКОНЦЕ
		 // TODO дату вставки
		 // TODO ата редактирования
		 
		 
		return zl;
	}

}
