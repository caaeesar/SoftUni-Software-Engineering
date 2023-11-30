package com.example.mobilelelewebapplication.service.impl;

import com.example.mobilelelewebapplication.model.dto.BrandViewDto;
import com.example.mobilelelewebapplication.repository.BrandRepository;
import com.example.mobilelelewebapplication.repository.ModelRepository;
import com.example.mobilelelewebapplication.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewDto> getAllBrands() {
        return brandRepository.findAll().stream().map(brandEntity -> modelMapper.map(brandEntity, BrandViewDto.class)).toList();
    }

}
