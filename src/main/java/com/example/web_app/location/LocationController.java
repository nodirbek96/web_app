package com.example.web_app.location;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;
    @PostMapping("/insert")
    public Response insert(@RequestBody Location location){
        try{
            Location l=locationService.insert(location);
            return new Response(true,new Data(l));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public Response getAll(){
        try{
            List<Location> locations=locationService.getAll();
            Data data=new Data();
            data.setLocations(locations);
            return new Response(true,data);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            Location l=locationService.getById(id);
            return new Response(true,new Data(l));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/id")
    public Response deleteById(@PathVariable int id){
        try{
            locationService.deleteById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }

}
