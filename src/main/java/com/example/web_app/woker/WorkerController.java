package com.example.web_app.woker;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @PostMapping("/insert")
    public Response insert(@RequestBody Worker worker){
        try {
            Worker w=workerService.insert(worker);
            return new Response(true,new Data(w));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }

    }
    @GetMapping("/getAll")
    public Response getAll(){
        try {
            List<Worker> workers=workerService.getAll();
            Data data=new Data();
            data.setWorkers(workers);
            return new Response(true,data);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/{id}")
    public Response deleteById(@PathVariable int id){
        try{
            workerService.deleteById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/worker")
    public Response delete(@RequestBody Worker worker){
        try{
            workerService.delete(worker);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            Worker w=workerService.getById(id);
            return new Response(true,new Data(w));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
}
