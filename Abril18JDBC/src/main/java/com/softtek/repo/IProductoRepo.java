package com.softtek.repo;

import com.softtek.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoRepo {
    List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException;
    Producto obtenerUno(int id) throws SQLException, ClassNotFoundException;
    void alta(Producto p) throws SQLException, ClassNotFoundException;
    void eliminarUno(int id) throws SQLException, ClassNotFoundException;
    Producto updateUno(int id) throws SQLException, ClassNotFoundException;
}
