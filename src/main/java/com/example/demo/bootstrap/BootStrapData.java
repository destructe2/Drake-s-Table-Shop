package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count() == 0) {
            InhousePart tableLeg = new InhousePart();

            tableLeg.setName("Table Leg");
            tableLeg.setPrice(15.99);
            tableLeg.setInv(30);
            tableLeg.setMaxInv(50);
            tableLeg.setMinInv(4);
            partRepository.save(tableLeg);

            InhousePart tableTopWood = new InhousePart();
            tableTopWood.setName("Table Top(wood)");
            tableTopWood.setPrice(25.99);
            tableTopWood.setInv(15);
            tableTopWood.setMaxInv(30);
            tableTopWood.setMinInv(1);
            partRepository.save(tableTopWood);


            InhousePart tableTopGlass = new InhousePart();
            tableTopGlass.setName("Table Top(Glass)");
            tableTopGlass.setPrice(49.99);
            tableTopGlass.setInv(15);
            tableTopGlass.setMaxInv(30);
            tableTopGlass.setMinInv(1);
            partRepository.save(tableTopGlass);

            InhousePart screwSet = new InhousePart();
            screwSet.setName("Screw Set");
            screwSet.setPrice(4.99);
            screwSet.setInv(45);
            screwSet.setMaxInv(100);
            screwSet.setMinInv(1);
            partRepository.save(screwSet);

            InhousePart steelBracket = new InhousePart();
            steelBracket.setName("Steel Bracket");
            steelBracket.setPrice(25.99);
            steelBracket.setInv(15);
            steelBracket.setMaxInv(30);
            steelBracket.setMinInv(1);
            partRepository.save(steelBracket);


        }
        if (productRepository.count() == 0) {

            Product diningTable = new Product("Dining Table", 299.99, 10);
            productRepository.save(diningTable);
            Product coffeeTable = new Product("Coffee Table", 199.99, 15);
            productRepository.save(coffeeTable);
            Product officeTable = new Product("Office Table", 399.99, 10);
            productRepository.save(officeTable);
            Product outdoorTable = new Product("Outdoor Table", 249.99, 10);
            productRepository.save(outdoorTable);
            Product glassTable = new Product("Glass Table", 399.99, 10);
            productRepository.save(glassTable);
        }
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }

}