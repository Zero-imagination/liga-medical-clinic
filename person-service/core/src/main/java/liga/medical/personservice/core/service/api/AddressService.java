package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.entity.Address;

import java.util.Optional;

public interface AddressService {
    Address save(Address address);

    Optional<Address> findById(Long id);
}
