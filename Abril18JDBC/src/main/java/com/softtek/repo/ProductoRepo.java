package com.softtek.repo;

import com.softtek.modelo.Producto;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepo extends Conexion implements IProductoRepo {

    @Override
    public List<Producto> obtenerTodos() throws SQLException, ClassNotFoundException {
        Statement sentencias;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products;";
        List<Producto> productos = new ArrayList<>();
        abrirConexion();
        sentencias = miConexion.createStatement();
        resultado = sentencias.executeQuery(sql);
        while (resultado.next()) {
            productos.add(new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")
            ));
        }
        return productos;
    }

    @Override
    public Producto obtenerUno(int id) throws SQLException, ClassNotFoundException {
        Statement sentencias;
        ResultSet resultado;
        String sql = "Select product_id, product_name, unit_price, units_in_stock from products WHERE product_id = " + id +  ";";
        Producto producto = new Producto();
        abrirConexion();
        sentencias = miConexion.createStatement();
        resultado = sentencias.executeQuery(sql);
        while (resultado.next()) {
            producto = new Producto(
                    resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock")
            );
        }
        return producto;
    }

    @Override
    public void alta(Producto p) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO products (product_id, product_name, supplier_id, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level, discontinued) VALUES (?, ?, 12, 2, '12 boxes', ?, ?, 0, 15, 0);";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.setInt(1, p.getIdProducto());
        sentencia.setString(2, p.getNombreProducto());
        sentencia.setDouble(3, p.getPrecioUnitario());
        sentencia.setInt(4, p.getUnidadesStock());
        sentencia.executeUpdate();
    }

    @Override
    public void eliminarUno(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM products WHERE product_id = " + id + ";";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.executeUpdate();
    }

    @Override
    public Producto updateUno(int id) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE products SET product_name = 'Leche' WHERE product_id = " + id + ";";
        abrirConexion();
        PreparedStatement sentencia = miConexion.prepareStatement(sql);
        sentencia.executeUpdate();
        Producto p = obtenerUno(id);
        return p;
    }
}
