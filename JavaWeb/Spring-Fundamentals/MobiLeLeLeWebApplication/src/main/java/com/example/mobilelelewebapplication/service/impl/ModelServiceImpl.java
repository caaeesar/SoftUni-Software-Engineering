package com.example.mobilelelewebapplication.service.impl;

import com.example.mobilelelewebapplication.repository.ModelRepository;
import com.example.mobilelelewebapplication.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

}
