package com.amajidi.personal.multiplerelationtable.Service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amajidi.personal.multiplerelationtable.Common.MapperUtils;
import com.amajidi.personal.multiplerelationtable.Repository.AddressRepository;
import com.amajidi.personal.multiplerelationtable.Repository.ChangesRepository;
import com.amajidi.personal.multiplerelationtable.Repository.ShopRepository;
import com.amajidi.personal.multiplerelationtable.Repository.UserRepository;
import com.amajidi.personal.multiplerelationtable.Response.UserDto;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MultipleRelationService {

	private final UserRepository userRepository;
	private final ShopRepository shopRepository;
	private final AddressRepository addressRepository;
	private final ChangesRepository changesRepository;

	public List<UserDto> getData(String id) {
		if (ObjectUtils.isEmpty(id)) {
			return Optional.ofNullable(userRepository.findAll())
					.orElse(Collections.emptyList())
					.stream()
					.map(user -> MapperUtils.map(user))
					.collect(Collectors.toList());
		} else {
			return userRepository.findById(id)
					.map(user -> Collections.singletonList(MapperUtils.map(user)))
					.orElse(Collections.emptyList());
		}
	}

	public Map<String, Object> getChanges(Integer id) {
		return changesRepository.findById(id)
					.map(changes -> {
						Map<String, Object> response = new LinkedHashMap<>();
						response.put("changes", MapperUtils.getChanges(changes));

						switch (changes.getEntity()) {
							case USER:
								userRepository.findById(changes.getEntityId())
									.ifPresent(user -> response.put("user", UserDto.builder()
										.name(user.getName())
										.nationality(user.getNationality())
										.build()));
								break;
							case SHOP:
								shopRepository.findById(changes.getEntityId())
									.ifPresent(shop -> response.put("shop", UserDto.Shop.builder()
										.name(shop.getName())
										.category(shop.getCategory().name())
										.build()));
								break;
							case ADDRESS:
								addressRepository.findById(changes.getEntityId())
									.ifPresent(address -> response.put("address", UserDto.Address.builder()
										.city(address.getCity())
										.country(address.getCountry())
										.postalCode(address.getPostalCode())
										.build()));
								break;
							default:
								break;
						}

						return response;
					}).orElse(null);
	}
}
