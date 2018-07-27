package com.tfoms.api.indentity;


/**
 * Сервис идентификации
 */
public interface IdentityService {

    /**
     * Сгенерировать ID для нового сообщения.
     * Этот ID нужно будет передавать первым параметром методам sendRequest, sendMessage.
     * Если в ходе передачи сообщения HTTP-соединение разорвалось,
     * повторную передачу нужно делать с тем же message ID.
     *
     * @return идентификатор сообщения
     */
    String generateUUID();

    /**
     * Генерирует идентификатор вложения на основе порядкового номера и MIME-типа
     *
     * @param mimeType         MIME-тип вложения
     * @param attachmentNumber порядковый номер вложения
     * @return string string
     */
    String generateAttachmentId(String mimeType, int attachmentNumber);

    /**
     * Генерирует идентификатор вложения
     *
     * @return идентификатор
     */
    java.util.UUID generateAttachmentUUID();
}

