package com.example.web_app.order;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/insert")
    public Response insert(@RequestBody Order order){
        try{
            Order or=orderService.insert(order);
            return new Response(true,new Data(or));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public Response getAll(){
        try{
            List<Order> orders=orderService.getAll();
            Data data=new Data();
            data.setOrders(orders);
            return new Response(true,data);
      }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            Order order=orderService.getById(id);
            return new Response(true,new Data(order));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/id")
    public Response deleteById(@PathVariable int id){
        try{
            orderService.deleteById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/order")
    public Response delete(@RequestBody Order order){
        try{
            orderService.delete(order);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
   @PutMapping("/update")
    public Response updateOrderedFood(@RequestBody Order order){
       try{
           int a=orderService.updateOrderedFood(order.getId(), order.getOrdered_food());
           return new Response(true,a);
       }catch (HttpStatusCodeException e){
           return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
       }
   }
   @PutMapping("/update/total-cost/{id}")
   public Response updateTotalCost(@PathVariable int id){
       try{
           int a=orderService.updateTotalCost(id);
           return new Response(true,a);
       }catch (HttpStatusCodeException e){
           return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
       }
   }
   @PutMapping("/close-order")
   public Response closeTheOrder(@RequestBody Order order){
       try{
           int a=orderService.closeOrder(order);
           return new Response(true,a);
       }catch (HttpStatusCodeException e){
           return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
       }
   }

}
