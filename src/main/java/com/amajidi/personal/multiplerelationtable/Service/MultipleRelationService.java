package com.amajidi.personal.multiplerelationtable.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.amajidi.personal.multiplerelationtable.Entity.Address;
import com.amajidi.personal.multiplerelationtable.Entity.Changes;
import com.amajidi.personal.multiplerelationtable.Entity.Shop;
import com.amajidi.personal.multiplerelationtable.Entity.User;
import com.amajidi.personal.multiplerelationtable.Repository.UserRepository;
import com.amajidi.personal.multiplerelationtable.Response.UserDto;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MultipleRelationService {

    private final UserRepository userRepository;

    public List<UserDto> getData(String id) {
        if (ObjectUtils.isEmpty(id)) {
            return Optional.ofNullable(userRepository.findAll())
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(user -> map(user))
                    .collect(Collectors.toList());
        } else {
            return userRepository.findById(id)
                    .map(user -> Collections.singletonList(map(user)))
                    .orElse(Collections.emptyList());
        }
    }

    private UserDto map(User user) {
        return Optional.ofNullable(user)
                .map(data -> UserDto.builder()
                        .name(data.getName())
                        .nationality(data.getNationality())
                        .shops(Optional.ofNullable(data.getShops())
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(shop -> getShop(shop))
                                .collect(Collectors.toList()))
                        .changes(Optional.ofNullable(data.getChanges())
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(changes -> getChanges(changes))
                                .collect(Collectors.toList()))
                        .build())
                .orElse(null);
    }

    private UserDto.Shop getShop(Shop shop) {
        return Optional.of(shop)
                .map(data -> UserDto.Shop.builder()
                        .name(data.getName())
                        .category(data.getCategory())
                        .addresses(Optional.ofNullable(data.getAddresses())
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(address -> getAddress(address))
                                .collect(Collectors.toList()))
                        .changes(Optional.ofNullable(data.getChanges())
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(changes -> getChanges(changes))
                                .collect(Collectors.toList()))
                        .build())
                .orElse(null);
    }

    private UserDto.Address getAddress(Address address) {
        return Optional.of(address)
                .map(data -> UserDto.Address.builder()
                        .city(data.getCity())
                        .country(data.getCountry())
                        .postalCode(data.getPostalCode())
                        .changes(Optional.ofNullable(data.getChanges())
                                .orElse(Collections.emptyList())
                                .stream()
                                .map(changes -> getChanges(changes))
                                .collect(Collectors.toList()))
                        .build())
                .orElse(null);
    }

    private UserDto.Changes getChanges(Changes changes) {
        return Optional.of(changes)
                .map(change -> UserDto.Changes.builder()
                        .before(change.getBefore())
                        .after(change.getAfter())
                        .requestedAt(change.getCreatedDate())
                        .status(change.getStatus())
                        .build())
                .orElse(null);
    }
}
