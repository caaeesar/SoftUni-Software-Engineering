package com.example.resellerapp.service;

import com.example.resellerapp.model.binding.OfferAddBindingModel;
import com.example.resellerapp.model.view.OffersHomeViewModel;

public interface OfferService {
    void addOffer(OfferAddBindingModel offerAddBindingModel);

    OffersHomeViewModel findOffersForHomePage();

    void removeOffer(String id);

    void buy(String id);
}
