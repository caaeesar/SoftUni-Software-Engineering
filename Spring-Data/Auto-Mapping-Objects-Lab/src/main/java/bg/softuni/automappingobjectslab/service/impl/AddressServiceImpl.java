package bg.softuni.automappingobjectslab.service.impl;

import bg.softuni.automappingobjectslab.dao.AddressRepository;
import bg.softuni.automappingobjectslab.model.entity.Address;
import bg.softuni.automappingobjectslab.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepo;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public void seedAddress(Address address) {
        this.addressRepo.saveAndFlush(address);
    }
}
