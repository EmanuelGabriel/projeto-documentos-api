package br.com.meta.projetoapimeta.service.mapper;

import org.springframework.stereotype.Component;

import br.com.meta.projetoapimeta.model.response.LocationModelResponse;
import br.com.meta.projetoapimeta.persistence.entity.Location;

@Component
public class LocationResponseMapper implements Mapper<Location, LocationModelResponse> {

	@Override
	public LocationModelResponse map(Location input) {
		if (input == null) {
			return null;
		}

		LocationModelResponse response = new LocationModelResponse();
		response.setId(input.getId());
		response.setAddressStreet(input.getAddressStreet());
		response.setCodePostal(input.getCodePostal());
		response.setCity(input.getCity());
		response.setStateProvince(input.getStateProvince());

		return response;
	}

}
