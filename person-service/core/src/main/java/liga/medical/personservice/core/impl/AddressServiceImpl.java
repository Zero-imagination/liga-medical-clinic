package liga.medical.personservice.core.impl;

import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.repository.AddressRepository;
import liga.medical.personservice.core.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address editAddress(Address address) {
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
