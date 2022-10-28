package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.mapper.AddressMapper;
import liga.medical.personservice.core.model.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressMapper addressMapper;

    public AddressController(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @GetMapping
    public List<Address> getAddress() {
        return addressMapper.getListAddress();
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address) {
        return addressMapper.addAddress(address);
    }

}
