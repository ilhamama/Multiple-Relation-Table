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
        if(ObjectUtils.isEmpty(id)) {
            return userRepository.findAll()
                .stream()
                .map(user -> map(user))
                .collect(Collectors.toList());
        } else {
            return userRepository.findById(id)
                .map(user -> Collections.singletonList(map(user)))
                .orElse(null);
        }
    }

    private UserDto map(User user){
        return Optional.ofNullable(user)
            .map(data -> UserDto.builder()
                    .name(data.getName())
                    .nationality(data.getNationality())
                    .shops(getShops(data.getShops()))
                    .changes(getChanges(data.getChanges()))
                    .build())
            .orElse(null);
    }

    private List<UserDto.Shop> getShops(List<Shop> shops){
        return Optional.of(shops)
            .orElse(Collections.emptyList())
            .stream()
            .map(shop -> UserDto.Shop.builder()
                .name(shop.getName())
                .category(shop.getCategory())
                .addresses(getAddresses(shop.getAddresses()))
                .changes(getChanges(shop.getChanges()))
                .build())
            .collect(Collectors.toList());
    }

    private List<UserDto.Address> getAddresses(List<Address> addresses){
        return Optional.of(addresses)
            .orElse(Collections.emptyList())
            .stream()
            .map(address -> UserDto.Address.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .changes(getChanges(address.getChanges()))
                .build())
            .collect(Collectors.toList());
    }

    private List<UserDto.Changes> getChanges(List<Changes> changes){
        return Optional.of(changes)
            .orElse(Collections.emptyList())
            .stream()
            .map(change -> UserDto.Changes.builder()
                .before(change.getBefore())
                .after(change.getAfter())
                .requestedAt(change.getCreatedDate())
                .status(change.getStatus())
                .build())
            .collect(Collectors.toList());
    }
}
