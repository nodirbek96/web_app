package com.example.web_app.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public Job insert(Job job){
        job.setDone_time(LocalDateTime.now());
        return jobRepository.save(job);
    }
    public List<Job> getAll(){
        return jobRepository.findAll();
    }
    public Job getById(int id){
        return jobRepository.findById(id).get();
    }
    public void deleteById(int id){
        jobRepository.deleteById(id);
    }
    public void delete(Job job){
        jobRepository.delete(job);
    }
}
