package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier mgm = new Supplier("MGM Distribution Co.", "Digital content and services");
        supplierDataStore.add(mgm);


        //setting up a new product category
        ProductCategory horror = new ProductCategory("Horror");
        productCategoryDataStore.add(horror);

        //setting up products and printing it
        productDataStore.add(new Product("Legally Blonde",
                new BigDecimal("9.99"), "USD",
                "Elle Woods, a sorority girl who attempts to win back her ex-boyfriend Warner Huntington III by getting a Juris Doctor degree at Harvard Law School, and in the process, overcomes stereotypes against blondes and triumphs as a successful lawyer through unflappable self-confidence and fashion/beauty knowhow.",
                horror,
                mgm,
                "https://www.youtube.com/watch?v=vWOHwI_FgAo"));
    }
}
