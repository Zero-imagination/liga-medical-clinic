package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address addAddress(Address address);

    void deleteAddress(Address address);

    Optional<Address> getAddressById(Long id);

    Address editAddress(Address address);

    List<Address> getAll();

}
