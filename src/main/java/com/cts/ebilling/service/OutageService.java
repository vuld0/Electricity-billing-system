package com.cts.ebilling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.ebilling.model.Outage;
import com.cts.ebilling.repository.OutageRepository;

@Service
public class OutageService {
	
	@Autowired
    private OutageRepository repo;
	
	public List<Outage> listAll() {
        return repo.findAll();
    }
     
    public void save(Outage con) {
        repo.save(con);
    }
     
    public Outage get(long id) {
        return repo.findById(id).get();
    }
    
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
   
}