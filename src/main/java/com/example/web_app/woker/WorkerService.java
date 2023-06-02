package com.example.web_app.woker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    public Worker insert(Worker worker){
        LocalDateTime localDateTime=LocalDateTime.now();
        worker.setDone_time(localDateTime);
        return workerRepository.save(worker);
    }
    public List<Worker> getAll(){
        return workerRepository.findAll();
    }
    public void deleteById(int id){
        workerRepository.deleteById(id);
    }
    public void delete(Worker worker){
        workerRepository.delete(worker);
    }
    public Worker getById(int id){
        return workerRepository.findById(id).get();
    }
}
