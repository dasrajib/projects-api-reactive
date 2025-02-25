package com.adu.api.service;

import com.adu.api.model.Address;
import com.adu.api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Flux<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public Mono<Address> getAddressById(Long address_id) {
        return addressRepository.findById(address_id);
    }

    public Mono<Address> createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Mono<Address> updateAddress(Long address_id, Address address) {
        return addressRepository.findById(address_id)
                .flatMap(existingAddress -> {
                    existingAddress.setAddress1(address.getAddress1());
                    existingAddress.setAddress2(address.getAddress2());
                    existingAddress.setAddress3(address.getAddress3());
                    existingAddress.setCity(address.getCity());
                    existingAddress.setState(address.getState());
                    existingAddress.setCounty(address.getCounty());
                    existingAddress.setCountry(address.getCountry());
                    existingAddress.setZip(address.getZip());

                    existingAddress.setUpdated_at(LocalDateTime.now());
                
                    return addressRepository.save(existingAddress);
                });
    }

    public Mono<Void> deleteAddress(Long address_id) {
        return addressRepository.deleteById(address_id);
    }
}
