package com.example.web_app.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ResTableService {
    @Autowired
    private ResTableRepository resTableRepository;

    public ResTable insert(ResTable resTable){
        resTable.setDone_time(LocalDateTime.now());
        return resTableRepository.save(resTable);
    }

    public List<ResTable> getAll(){
        return resTableRepository.findAll();
    }
    public ResTable getById(int id){
        return resTableRepository.findById(id).get();
    }
    public void deleteById(int id){
        resTableRepository.deleteById(id);
    }
    public void delete(ResTable resTable){
        resTableRepository.delete(resTable);
    }
}
