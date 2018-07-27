package com.tfoms.smev3.identity;

import com.tfoms.api.indentity.IdentityService;

/**
 * The type Identity factory.
 */
public class IdentityFactory {
    /**
     * Gets identity generator.
     *
     * @return the identity generator
     */
    public static IdentityService getIdentityGenerator() {
        return new IdentificationServiceImpl();
    }
}
