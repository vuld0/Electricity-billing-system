package com.cts.ebilling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.ebilling.model.Tariff;
import com.cts.ebilling.repository.TariffRepository;

@Service
public class TariffService {
	
	@Autowired
    private TariffRepository repo;
	
	public List<Tariff> listAll() {
        return repo.findAll();
    }
     
    public void save(Tariff con) {
        repo.save(con);
    }
     
    public Tariff get(long id) {
        return repo.findById(id).get();
    }
    
     
}