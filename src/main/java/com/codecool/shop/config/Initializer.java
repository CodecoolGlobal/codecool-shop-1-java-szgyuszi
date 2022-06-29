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
        Supplier timburton = new Supplier("Tim Burton Productions", "Digital content and services");
        supplierDataStore.add(timburton);
        Supplier metro = new Supplier("Metro-Goldwyn-Mayer", "Digital content and services");
        supplierDataStore.add(metro);
        Supplier southward = new Supplier("Southward Films", "Digital content and services");
        supplierDataStore.add(southward);
        Supplier columbia = new Supplier("Columbia Pictures", "Digital content and services");
        supplierDataStore.add(columbia);
        Supplier revolution = new Supplier("Revolution Studios", "Digital content and services");
        supplierDataStore.add(revolution);
        Supplier virgin = new Supplier("Virgin Produced", "Digital content and services");
        supplierDataStore.add(virgin);
        Supplier wayans = new Supplier("Wayans Bros. EntertainmentGold", "Digital content and services");
        supplierDataStore.add(wayans);
        Supplier fourSquare = new Supplier("Four Square Productions", "Digital content and services");
        supplierDataStore.add(wayans);



        //setting up a new product category
        ProductCategory horror = new ProductCategory("horror");
        productCategoryDataStore.add(horror);
        ProductCategory action = new ProductCategory("action");
        productCategoryDataStore.add(action);
        ProductCategory comedy = new ProductCategory("comedy");
        productCategoryDataStore.add(comedy);

        //setting up products and printing it
        productDataStore.add(new Product("Legally Blonde", new BigDecimal("9.99"), "USD", "Elle Woods, a sorority girl who attempts to win back her ex-boyfriend Warner Huntington III by getting a Juris Doctor degree at Harvard Law School, and in the process, overcomes stereotypes against blondes and triumphs as a successful lawyer through unflappable self-confidence and fashion/beauty knowhow.",
                horror, mgm, "https://www.youtube.com/watch?v=vWOHwI_FgAo"));
        productDataStore.add(new Product("Troll 2", new BigDecimal("5.99"), "USD", "The plot concerns a family pursued by vegetarian goblins who seek to transform them into plants so that they can eat them.",
                horror, filmirage, "https://www.youtube.com/watch?v=CkNB0w1fYKk"));
        productDataStore.add(new Product("Gremlins", new BigDecimal("7.99"), "USD", "Gremlins is a 1984 American comedy horror film directed by Joe Dante and written by Chris Columbus. It draws on legends of folkloric mischievous creatures that cause malfunctions",
                horror, warner, "https://www.youtube.com/watch?v=WeNVftiefOE"));
        productDataStore.add(new Product("Tropic Thunder", new BigDecimal("12.99"), "USD", "The film stars Stiller, Jack Black, Robert Downey Jr., Jay Baruchel, and Brandon T. Jackson as a group of prima donna actors making a Vietnam War film. When their frustrated director (Steve Coogan) drops them in the middle of a jungle, they are forced to rely on their acting skills to survive the real action and danger. \n",
                action, dw, "https://www.youtube.com/watch?v=ASJvlHExnMA"));
        productDataStore.add(new Product("The Room", new BigDecimal("10.99"), "USD", "Johnny is a successful bank executive who lives quietly in a San Francisco townhouse with his fiancée, Lisa. One day, putting aside any scruple, she seduces Johnny's best friend, Mark. From there, nothing will be the same again.\n",
                comedy, tommy, "https://www.youtube.com/watch?v=9-dIdFXeFhs"));
        productDataStore.add(new Product("Abraham Lincoln  : Vampire Hunter", new BigDecimal("7.99"), "USD", "Abraham Lincoln, the 16th President of the United States, discovers vampires are planning to take over the United States. He makes it his mission to eliminate them.\n",
                horror, timburton, "https://www.youtube.com/watch?v=wZp7eBStN1U"));
        productDataStore.add(new Product("Spaceballs", new BigDecimal("5.99"), "USD", "A star-pilot for hire and his trusty sidekick must come to the rescue of a princess and save Planet Druidia from the clutches of the evil Spaceballs.\n",
                action, metro, "https://www.youtube.com/watch?v=jhb1--ibhFE"));
        productDataStore.add(new Product("Sharknado", new BigDecimal("10.99"), "USD", "When a freak hurricane swamps Los Angeles, nature's deadliest killer rules sea, land, and air as thousands of sharks terrorize the waterlogged populace.\n",
                action, southward, "https://www.youtube.com/watch?v=M-pXDoe5a0E"));
        productDataStore.add(new Product("Pineapple Express", new BigDecimal("12.99"), "USD", "A process server and his marijuana dealer wind up on the run from hitmen and a corrupt police officer after he witnesses his dealer's boss murder a competitor while trying to serve papers on him.\n",
                comedy, columbia, "https://www.youtube.com/watch?v=BWZt4v6b1hI"));
        productDataStore.add(new Product("White Chicks", new BigDecimal("7.99"), "USD", "Two disgraced FBI agents go way undercover in an effort to protect hotel heiresses the Wilson sisters from a kidnapping plot.",
                comedy, revolution, "https://www.youtube.com/watch?v=aeVkbNka9HM"));
        productDataStore.add(new Product("Movie 43", new BigDecimal("10.99"), "USD", "A series of interconnected short films follows a washed-up producer as he pitches insane story lines featuring some of the biggest stars in Hollywood",
                comedy, virgin, "https://www.youtube.com/watch?v=A9fBCkwDW8c"));
        productDataStore.add(new Product("Scary Movie", new BigDecimal("7.99"), "USD", "\u200B\u200BA year after disposing of the body of a man they accidentally killed, a group of dumb teenagers are stalked by a bumbling serial killer.\n",
                horror, wayans, "https://www.youtube.com/watch?v=HTLPULt0eJ4"));
        productDataStore.add(new Product("Attack of the Killer Tomatoes!", new BigDecimal("10.99"), "USD", "A group of scientists band together to save the world from mutated killer tomatoes.",
                action, fourSquare, "https://www.youtube.com/watch?v=txfdGlxEsG8"));

    }
}
