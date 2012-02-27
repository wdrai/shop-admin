package com.wineshop.admin.services;

import java.util.Map;

import org.granite.messaging.service.annotations.RemoteDestination;
import org.granite.tide.data.DataEnabled;
import org.granite.tide.data.DataEnabled.PublishMode;

import com.wineshop.admin.entities.Domaine;


@RemoteDestination
@DataEnabled(topic="wineshopTopic", publish=PublishMode.ON_SUCCESS)
public interface DomaineService {

    public void sauve(Domaine domaine);
    
    public void supprime(Long domaineId);
    
    public Map<String, Object> liste(Domaine filtre, int debut, int max, String[] tri, boolean[] asc);
}
