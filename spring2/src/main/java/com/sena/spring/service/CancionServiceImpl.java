package com.sena.spring.service;

import java.util.List;
import com.sena.spring.model.Cancion;
import com.sena.spring.model.ICancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl implements ICancionService{
    @Autowired
    private ICancion canciond;

    @Override
    public List<Cancion> findAll() {
        return (List<Cancion>) canciond.findAll();
    }

    @Override
    public void save(Cancion cancion) {
       canciond.save(cancion);        
    }

    @Override
    public Cancion findOne(Integer id) {
        return canciond.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        canciond.deleteById(id);
        
    }
}
