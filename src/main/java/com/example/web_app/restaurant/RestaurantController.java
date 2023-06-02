package com.example.web_app.restaurant;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/insert")
    public Response insert(@RequestBody Restaurant restaurant){
        try{
            Restaurant r= restaurantService.insert(restaurant);
            return new Response(true,new Data(r));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public Response getAll(){
        try{
            List<Restaurant> restaurants=restaurantService.getAll();
            Data data=new Data();
            data.setRestaurants(restaurants);
            return new Response(true,data);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/{id}")
    public Response deleteById(@PathVariable int id){
        try{
            restaurantService.deleteBytId(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/restaurant")
    public Response delete(@RequestBody Restaurant restaurant){
        try{
            restaurantService.delete(restaurant);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            Restaurant r=restaurantService.getById(id);
            return new Response(true,new Data(r));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }

}
