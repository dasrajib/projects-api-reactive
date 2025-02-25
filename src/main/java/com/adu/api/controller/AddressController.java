package com.adu.api.controller;

import com.adu.api.model.Address;
import com.adu.api.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Tag(name = "Address Management", description = "APIs for managing addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @Operation(summary = "Get all address")
    public Flux<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/{address_id}")
    @Operation(summary = "Get address by ID")
    public Mono<Address> getAddressById(@PathVariable Long address_id) {
        return addressService.getAddressById(address_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new address")
    public Mono<Address> createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/{address_id}")
    @Operation(summary = "Update an existing address")
    public Mono<Address> updateAddress(@PathVariable Long address_id, @RequestBody Address address) {
        return addressService.updateAddress(address_id, address);
    }

    @DeleteMapping("/{address_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a address")
    public Mono<Void> deleteAddress(@PathVariable Long address_id) {
        return addressService.deleteAddress(address_id);
    }
}
