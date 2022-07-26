package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import javax.sql.DataSource;
import java.util.List;

public class SupplierDaoMem implements SupplierDao {




    private final DataSource dataSource;

    /* A private Constructor prevents any other class from instantiating.
     */
    public SupplierDaoMem(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public SupplierDaoMem getInstance() {
       return this;
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {
    }

    @Override
    public Supplier getSupplier(String name) {
        return null;
    }

    @Override
    public List<Supplier> getAll() {
        return null;
    }
}
