package com.tfoms.smev3.identity.loader;

import com.tfoms.api.indentity.IdentityService;
import com.tfoms.smev3.identity.IdentificationServiceImpl;
import com.tfoms.smev3.loader.IdentityLoader;

/**
 * The type Loader.
 */
public class Loader implements IdentityLoader {

    public  IdentityService getIdentity() {
        return new IdentificationServiceImpl();
    }
}
