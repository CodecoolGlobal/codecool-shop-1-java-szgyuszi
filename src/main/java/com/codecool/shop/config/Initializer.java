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
        Supplier filmirage = new Supplier("Filmirage", "Digital content and services");
        supplierDataStore.add(filmirage);
        Supplier warner = new Supplier("Warner Brothers.", "Digital content and services");
        supplierDataStore.add(warner);
        Supplier dw = new Supplier("DreamWorks Pictures", "Digital content and services");
        supplierDataStore.add(dw);
        Supplier tommy = new Supplier("Tommy Wiseau", "Digital content and services");
        supplierDataStore.add(tommy);


        //setting up a new product category
        ProductCategory horror = new ProductCategory("Horror");
        productCategoryDataStore.add(horror);
        ProductCategory action = new ProductCategory("Action");
        productCategoryDataStore.add(action);
        ProductCategory comedy = new ProductCategory("Comedy");
        productCategoryDataStore.add(comedy);

        //setting up products and printing it
        productDataStore.add(new Product("Legally Blonde",
                new BigDecimal("9.99"), "USD",
                "Elle Woods, a sorority girl who attempts to win back her ex-boyfriend Warner Huntington III by getting a Juris Doctor degree at Harvard Law School, and in the process, overcomes stereotypes against blondes and triumphs as a successful lawyer through unflappable self-confidence and fashion/beauty knowhow.",
                horror,
                mgm,
                "https://www.youtube.com/watch?v=vWOHwI_FgAo"));
        productDataStore.add(new Product("Troll 2", new BigDecimal("5.99"), "USD", "The plot concerns a family pursued by vegetarian goblins who seek to transform them into plants so that they can eat them.",
                horror, filmirage, "https://www.youtube.com/watch?v=CkNB0w1fYKk"));
        productDataStore.add(new Product("Gremlins", new BigDecimal("7.99"), "USD", "Gremlins is a 1984 American comedy horror film directed by Joe Dante and written by Chris Columbus. It draws on legends of folkloric mischievous creatures that cause malfunctions",
                horror, warner, "https://www.youtube.com/watch?v=WeNVftiefOE"));
        productDataStore.add(new Product("Tropic Thunder", new BigDecimal("12.99"), "USD", "The film stars Stiller, Jack Black, Robert Downey Jr., Jay Baruchel, and Brandon T. Jackson as a group of prima donna actors making a Vietnam War film. When their frustrated director (Steve Coogan) drops them in the middle of a jungle, they are forced to rely on their acting skills to survive the real action and danger. \n",
                action, dw, "https://www.youtube.com/watch?v=ASJvlHExnMA"));
        productDataStore.add(new Product("The Room", new BigDecimal("10.99"), "USD", "Johnny is a successful bank executive who lives quietly in a San Francisco townhouse with his fiancée, Lisa. One day, putting aside any scruple, she seduces Johnny's best friend, Mark. From there, nothing will be the same again.\n",
                comedy, tommy, "https://www.youtube.com/watch?v=9-dIdFXeFhs"));
    }
}
