package com.wineshop.admin.services;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wineshop.admin.entities.Domaine;

@Service
public class DomaineServiceImpl implements DomaineService {

    @PersistenceContext
    private EntityManager entityManager;
    

    @Transactional
    public void sauve(Domaine domaine) {
        entityManager.merge(domaine);
        entityManager.flush();
    }
    
    @Transactional
    public void supprime(Long domaineId) {
    	Domaine domaine = entityManager.find(Domaine.class, domaineId);
    	entityManager.remove(domaine);
        entityManager.flush();
    }
    
    @Transactional(readOnly=true)
    public Map<String, Object> liste(Domaine filtre, int debut, int max, String[] tri, boolean[] asc) {
    	StringBuilder sb = new StringBuilder("from Domaine d ");
    	if (filtre.getNom() != null)
    		sb.append("where d.nom like '%' || :nom || '%'");
    	if (tri.length > 0)
    		sb.append("order by ");
    	for (int i = 0; i < tri.length; i++)
    		sb.append(tri[i]).append(" ").append(asc[i] ? " asc" : " desc");
    	
    	Query qcount = entityManager.createQuery("select count(d) " + sb.toString());
    	Query qliste = entityManager.createQuery("select d " + sb.toString()).setFirstResult(debut).setMaxResults(max);
    	if (filtre.getNom() != null) {
    		qcount.setParameter("nom", filtre.getNom());
    		qliste.setParameter("nom", filtre.getNom());
    	}
    	
    	Map<String, Object> result = new HashMap<String, Object>(4);
    	result.put("resultCount", (Long)qcount.getSingleResult());
    	result.put("resultList", qliste.getResultList());
    	result.put("firstResult", debut);
    	result.put("maxResults", max);
    	return result;
    }
}
