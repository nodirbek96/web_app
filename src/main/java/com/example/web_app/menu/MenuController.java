package com.example.web_app.menu;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @PostMapping("/insert")
    public Response insert(@RequestBody Menu menu){
        try{
            Menu m=menuService.insert(menu);
            return new Response(true,new Data(m));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public Response getAll(){
        try{
            List<Menu> menus=menuService.getAll();
            Data data=new Data();
            data.setMenus(menus);
            return new Response(true,data);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id){
        try{
            Menu m=menuService.getById(id);
            return new Response(true,new Data(m));
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/{id}")
    public Response deleteById(@PathVariable int id){
        try{
            menuService.deleteById(id);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }
    @DeleteMapping("/delete/menu")
    public Response delete(@RequestBody Menu menu){
        try{
            menuService.delete(menu);
            return new Response(true);
        }catch (HttpStatusCodeException e){
            return new Response(false,new Error(e.getStatusCode().value(),e.getMessage()));
        }
    }

}
