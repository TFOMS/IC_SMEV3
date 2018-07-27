package com.tfoms.core.template;

import com.tfoms.smev3.egr_zags.adapter.request.request.AdapterMessage;
import com.tfoms.smev3.model.Zl;

/**
 * Формирование входящей информации из запроса смэв 3 в "пригодную форму"
 * @author pylypiv.sergey
 *
 */
public interface TemplateRequest {

	 
	/**
	 * Метод обворачивает необоходимую информацию с входящих данных из запроса
	 * @param am данные запроса
	 * @return обвернутые данные
	 */
	Zl prepare_data_request(AdapterMessage am); 
}
