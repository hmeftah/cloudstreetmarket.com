package edu.zipcloud.cloudstreetmarket.api.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

import edu.zipcloud.cloudstreetmarket.api.resources.HistoricalIndexResource;
import edu.zipcloud.cloudstreetmarket.core.entities.HistoricalIndex;

@Component
public class HistoricalIndexResourceConverter implements Converter<HistoricalIndex, HistoricalIndexResource> {
	
	@Autowired
	EntityLinks entityLinks;
	
	@Override
	public HistoricalIndexResource convert(HistoricalIndex historicalIndex) {
		HistoricalIndexResource resource = new HistoricalIndexResource(historicalIndex);
		resource.add(entityLinks.linkToSingleResource(historicalIndex.getIndex()));
		return resource;
	}
}