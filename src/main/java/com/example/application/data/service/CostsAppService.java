package com.example.application.data.service;

import org.springframework.stereotype.Service;

import com.example.application.data.entity.CarTrip;
import com.example.application.data.entity.Item;
import com.example.application.data.repository.CarTripRepository;
import com.example.application.data.repository.ItemRepository;

@Service
public class CostsAppService {
    
    private final CarTripRepository carTripRepository;
    private final ItemRepository itemRepository;

    public CostsAppService(CarTripRepository carTripRepository, ItemRepository itemRepository) {
        this.carTripRepository = carTripRepository;
        this.itemRepository = itemRepository;
    }

    public void saveCarTrip(CarTrip carTrip) {
        this.carTripRepository.save(carTrip);
    }

    public void saveItem(Item item) {
        this.itemRepository.save(item);
    }
}
