package com.example.mobilelelewebapplication.service.impl;

import com.example.mobilelelewebapplication.model.dto.AddOfferDto;
import com.example.mobilelelewebapplication.model.entity.ModelEntity;
import com.example.mobilelelewebapplication.model.entity.OfferEntity;
import com.example.mobilelelewebapplication.repository.ModelRepository;
import com.example.mobilelelewebapplication.repository.OfferRepository;
import com.example.mobilelelewebapplication.service.ModelService;
import com.example.mobilelelewebapplication.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void createOffer(AddOfferDto addOfferDto) {
        OfferEntity offerEntity = modelMapper.map(addOfferDto, OfferEntity.class);
        ModelEntity modelEntity = modelRepository.getById(addOfferDto.getModelId());
        offerEntity.setModel(modelEntity);
        offerRepository.save(offerEntity);
    }
}
