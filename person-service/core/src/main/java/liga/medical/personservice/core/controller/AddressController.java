package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.entity.Address;
import liga.medical.personservice.core.service.api.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Address saveAddress(@RequestBody Address address) {
        return addressService.save(address);
    }
}
