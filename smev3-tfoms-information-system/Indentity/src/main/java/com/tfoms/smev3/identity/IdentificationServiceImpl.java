package com.tfoms.smev3.identity;


import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.UUIDTimer;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.tfoms.api.indentity.IdentityService;

/**
 * The type Identification service.
 */
public class IdentificationServiceImpl implements IdentityService {
    /**
     * The constant ID_CONSTANT.
     */
    public static final String ID_CONSTANT = "__ATT_ID_SMEV_C_AUTOGEN__";

    private static final TimeBasedGenerator uuidGenerator;

    static {
        Random random = new Random(System.currentTimeMillis());
        UUIDTimer timer;
        try {
            timer = new UUIDTimer(random, null);
        } catch (IOException e) {
            // Will never be thrown.
            throw new RuntimeException(e);
        }
        EthernetAddress addr = EthernetAddress.fromInterface();

        uuidGenerator = new TimeBasedGenerator(addr, timer);
    }

    public String generateUUID() {
        return uuidGenerator.generate().toString();
    }

    public String generateAttachmentId(String mimeType, int attachmentNumber) {
        //String ext = Utils.guessFileExtension(mimeType);
        //return ID_CONSTANT + (attachmentNumber) + ext;
    	return null;
    }

    public UUID generateAttachmentUUID() {
        return UUID.randomUUID();
    }
}
