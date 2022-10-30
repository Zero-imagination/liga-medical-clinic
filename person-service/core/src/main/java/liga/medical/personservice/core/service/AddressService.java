package liga.medical.personservice.core.service;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.api.service.IService;
import liga.medical.personservice.core.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IService<Address> {

    private final IRepository<Address> addressRepository;

    public AddressService(IRepository<Address> addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.getAll();
    }

    @Override
    public Address getById(long id) {
        return addressRepository.getById(id);
    }

    @Override
    public int insert(Address address) {
        return addressRepository.insert(address);
    }
}
