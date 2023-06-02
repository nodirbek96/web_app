package com.example.web_app.job;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping("/insert")
    public Response insert(@RequestBody Job job){
        try{
            Job j=jobService.insert(job);
            return new Response(true,new Data(j));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public Response getAll(){
        try{
            List<Job> jobs=jobService.getAll();
            Data data=new Data();
            data.setJobs(jobs);
            return new Response(true,data);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            jobService.getById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/{id}")
    public Response deleteById(@PathVariable int id){
        try{
            jobService.deleteById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/job")
    public Response delete(@RequestBody Job job){
        try{
            jobService.delete(job);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
}
