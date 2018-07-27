package com.tfoms.smev3;

import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 * Hello world!
 *
 */
public class App 
{
	 private static final String PERSISTENCE_UNIT_NAME = "smev3";
	 private static EntityManagerFactory factory;

	    public static void main(String[] args) {
	    /*	
	    	
	    	
	        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();

	        // Create call stored procedure
	        em.getTransaction().begin();
	        
	        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("smev3_my_health.info_worth");
	        // set parameters
	        storedProcedure.registerStoredProcedureParameter("regionCode", Integer.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("surname", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("firstname", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("lastname", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("datebythday", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("enp", Long.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("dataFrom", String.class, ParameterMode.IN);
	        storedProcedure.registerStoredProcedureParameter("dataEnd", String.class, ParameterMode.IN);
	        
	        storedProcedure.registerStoredProcedureParameter("response", String.class, ParameterMode.OUT);
	        
	        
	        
	        storedProcedure.setParameter("regionCode", 50000);
	        storedProcedure.setParameter("surname","пылыпив");
	        storedProcedure.setParameter("firstname","егор");
	        storedProcedure.setParameter("lastname","сергеевич");
	        storedProcedure.setParameter("datebythday","2014-03-01");
	        storedProcedure.setParameter("enp",505454545);
	        storedProcedure.setParameter("dataFrom","2017-02-21");
	        storedProcedure.setParameter("dataEnd","2018-05-14");
	        
	        
	        // execute SP
	        storedProcedure.execute();
	        // get result
	        String res = (String)storedProcedure.getOutputParameterValue("response");
	        System.out.println("BLOB "+res);
	        
	        
	        
	        em.getTransaction().commit();
	        em.close();
	        */
	    }
}
