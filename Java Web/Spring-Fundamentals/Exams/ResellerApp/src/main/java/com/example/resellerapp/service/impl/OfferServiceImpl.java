package com.example.resellerapp.service.impl;

import com.example.resellerapp.model.binding.OfferAddBindingModel;
import com.example.resellerapp.model.entity.Condition;
import com.example.resellerapp.model.entity.Offer;
import com.example.resellerapp.model.entity.User;
import com.example.resellerapp.model.service.UserServiceModel;
import com.example.resellerapp.model.view.BoughtOffersViewModel;
import com.example.resellerapp.model.view.MyOffersViewModel;
import com.example.resellerapp.model.view.OffersHomeViewModel;
import com.example.resellerapp.model.view.OtherOffersViewModel;
import com.example.resellerapp.repository.ConditionRepository;
import com.example.resellerapp.repository.OfferRepository;
import com.example.resellerapp.repository.UserRepository;
import com.example.resellerapp.service.OfferService;
import com.example.resellerapp.service.UserService;
import com.example.resellerapp.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ConditionRepository conditionRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, ConditionRepository conditionRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.conditionRepository = conditionRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addOffer(OfferAddBindingModel offerAddBindingModel) {
        Offer offer = modelMapper.map(offerAddBindingModel, Offer.class);
        Condition condition = conditionRepository.getConditionByName(offerAddBindingModel.getCondition());
        offer.setCondition(condition);
        // TODO: refactor service model ?
        offer.setCreatedBy(userRepository.findByUsername(loggedUser.getUsername()).get());
        offerRepository.save(offer);
    }

    @Override
    public OffersHomeViewModel findOffersForHomePage() {
        List<MyOffersViewModel> myOffers = new ArrayList<>();
        List<BoughtOffersViewModel> boughtOffers = new ArrayList<>();
        List<OtherOffersViewModel> allOtherOffers = new ArrayList<>();
        OffersHomeViewModel offersHomeViewModel = new OffersHomeViewModel();

        List<Offer> allOffers = offerRepository.findAll();

        for (int i = 0; i < allOffers.size(); i++) {

            Offer offer = allOffers.get(i);

            if (offer.getBoughtBy() == null && offer.getCreatedBy().getUsername().equals(loggedUser.getUsername())) {
                myOffers.add(new MyOffersViewModel(offer.getId(), offer.getDescription(), offer.getCondition().getName(), offer.getPrice()));
            } else if (offer.getBoughtBy() != null && offer.getBoughtBy().getUsername().equals(loggedUser.getUsername())) {
                boughtOffers.add(new BoughtOffersViewModel(offer.getDescription(), offer.getPrice()));
            } else if (offer.getBoughtBy() == null) {
                allOtherOffers.add(new OtherOffersViewModel(offer.getId(), offer.getCreatedBy().getUsername(), offer.getDescription(), offer.getCondition().getName(), offer.getPrice()));
            }

            offersHomeViewModel = new OffersHomeViewModel(myOffers, boughtOffers, allOtherOffers);
        }
        return offersHomeViewModel;
    }

    @Override
    public void removeOffer(String id) {
        UserServiceModel userServiceModel = modelMapper.map(userRepository.findByUsername(loggedUser.getUsername()), UserServiceModel.class);
        userServiceModel.getOffers().remove(offerRepository.findById(id).get());
        offerRepository.deleteById(id);
    }

    @Override
    public void buy(String id) {
        Offer offer = offerRepository.findById(id).get();
        User user = userRepository.findByUsername(loggedUser.getUsername()).get();
        offer.setBoughtBy(user);
        offerRepository.save(offer);
    }
}
