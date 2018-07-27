package com.tfoms.smev3.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import com.tfoms.smev3.model.Zl;

public class MyHealthDAO {
	
	private static final String PERSISTENCE_UNIT_NAME = "core";
	private static EntityManagerFactory factory;
	
	private static EntityManagerFactory getEMFactory(String pUName){
		if (factory == null){
			factory = Persistence.createEntityManagerFactory(pUName);
		}
		return factory;
		}
	
	
	public String getWorth(Zl zl){
		
    	
        //factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		factory = getEMFactory(PERSISTENCE_UNIT_NAME);
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
        
        
        
        storedProcedure.setParameter("regionCode", zl.getRegionCode());
        storedProcedure.setParameter("surname",zl.getSurname());
        storedProcedure.setParameter("firstname",zl.getFirstname());
        storedProcedure.setParameter("lastname",zl.getLastname());
        storedProcedure.setParameter("datebythday",zl.getDatebythday());
        storedProcedure.setParameter("enp",zl.getEnp());
        storedProcedure.setParameter("dataFrom",zl.getDataFrom());
        storedProcedure.setParameter("dataEnd",zl.getDataEnd());
        
        
        // execute SP
        storedProcedure.execute();
        // get result
        String res = (String)storedProcedure.getOutputParameterValue("response");
        //System.out.println("BLOB "+res);
        
        em.getTransaction().commit();
        em.close();
        
        return res;

		
	}

}
