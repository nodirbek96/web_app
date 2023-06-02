package com.example.web_app.table;

import com.example.web_app.model.Data;
import com.example.web_app.model.Error;
import com.example.web_app.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class ResTableController {
    @Autowired
    private ResTableService resTableService;

    @PostMapping("/insert")
    public Response insert(@RequestBody ResTable resTable) {
        try {
            ResTable r = resTableService.insert(resTable);
            return new Response(true, new Data(r));
        } catch (HttpStatusCodeException e) {
            return new Response(false, new Error(e.getStatusCode().value(), e.getMessage()));
        }
    }

    @GetMapping("/getAll")
    public Response getAll() {
        try {
            List<ResTable> resTables = resTableService.getAll();
            Data data = new Data();
            data.setTables(resTables);
            return new Response(true, data);
        } catch (HttpStatusCodeException e) {
            return new Response(false, new Error(e.getStatusCode().value(), e.getMessage()));
        }
    }

    @GetMapping("/get/{id}")
    public Response getById(@PathVariable int id) {
        try {
            ResTable r = resTableService.getById(id);
            return new Response(true, new Data(r));
        } catch (HttpStatusCodeException e) {
            return new Response(false, new Error(e.getStatusCode().value(), e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteById(@PathVariable int id) {
        try {
            resTableService.deleteById(id);
            return new Response(true);
        } catch (HttpStatusCodeException e) {
            return new Response(false, new Error(e.getStatusCode().value(), e.getMessage()));
        }
    }

    @DeleteMapping("/delete/table")
    public Response delete(@RequestBody ResTable resTable) {
        try {
            resTableService.delete(resTable);
            return new Response(true);
        } catch (HttpStatusCodeException e) {
            return new Response(false, new Error(e.getStatusCode().value(), e.getMessage()));
        }
    }
}
