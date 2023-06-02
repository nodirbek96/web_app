package com.example.web_app.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public Menu insert(Menu menu) {
        menu.setDone_time(LocalDateTime.now());
        return menuRepository.save(menu);
    }

    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    public Menu getById(int id) {
        return menuRepository.findById(id).get();
    }

    public void deleteById(int id) {
        menuRepository.deleteById(id);
    }

    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }
}
