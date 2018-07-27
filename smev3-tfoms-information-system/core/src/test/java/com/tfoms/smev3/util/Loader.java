package com.tfoms.smev3.util;

import java.util.ServiceLoader;

import com.tfoms.smev3.loader.IdentityLoader;


public class Loader {
	
	public static void main(String[] args) {
        ServiceLoader<IdentityLoader> serviceLoader = ServiceLoader.load(IdentityLoader.class);

        System.out.println("Test "+serviceLoader.iterator().next().getIdentity().generateUUID());
    }

}
