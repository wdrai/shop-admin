package com.wineshop.admin.services;

import org.granite.messaging.service.annotations.RemoteDestination;
import org.granite.tide.data.DataEnabled;
import org.granite.tide.data.DataEnabled.PublishMode;
import org.granite.tide.spring.data.FilterableJpaRepository;
import org.springframework.security.access.annotation.Secured;

import com.wineshop.admin.entities.Vineyard;


@RemoteDestination
@DataEnabled(topic="wineshopTopic", publish=PublishMode.ON_SUCCESS)
@Secured({"ROLE_USER"})
public interface VineyardRepository extends FilterableJpaRepository<Vineyard, Long> {

}
