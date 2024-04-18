package com.softtek.servicio;

import com.softtek.modelo.Producto;
import com.softtek.repo.IProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductoServicio implements IProductoServicio {
    @Autowired
    private IProductoRepo repo;

    @Override
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        return repo.obtenerTodos();
    }

    @Override
    public Producto obtenerUno(int id) throws SQLException, ClassNotFoundException {
        return repo.obtenerUno(id);
    }

    @Override
    public void alta(Producto p) throws SQLException, ClassNotFoundException {
        repo.alta(p);
    }

    @Override
    public void eliminarUno(int id) throws SQLException, ClassNotFoundException {
        repo.eliminarUno(id);
    }

    @Override
    public Producto updateUno(int id) throws SQLException, ClassNotFoundException {
        return repo.updateUno(id);
    }
}
