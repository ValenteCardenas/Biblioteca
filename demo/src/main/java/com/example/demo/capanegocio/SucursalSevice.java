package com.example.demo.capanegocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.capanegocio.modelo.Sucursal;
import com.example.demo.capapersistencia.SucursalRepository;

@Service
public class SucursalSevice {
    @Autowired
    private SucursalRepository sucursalRepository;

    public ArrayList<Sucursal> recuperaSucursales() {
        System.out.println("sucursalRepository = " + sucursalRepository);
        ArrayList<Sucursal> sucursales = (ArrayList<Sucursal>) sucursalRepository.findAll();
        return sucursales;
        
    }
}
