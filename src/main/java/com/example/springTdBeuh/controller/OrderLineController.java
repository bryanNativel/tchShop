package com.example.springTdBeuh.controller;
import com.example.springTdBeuh.model.OrderLine;
import com.example.springTdBeuh.model.Product;
import com.example.springTdBeuh.repo.OrderLineRepository;
import com.example.springTdBeuh.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderLineController {

    private final OrderLineRepository repositoryOrderLine;
    private final ProductRepository repositoryProduct;


    OrderLineController(OrderLineRepository repositoryOrderLine,ProductRepository repositoryProduct) {
        this.repositoryOrderLine = repositoryOrderLine;
        this.repositoryProduct = repositoryProduct;
    }

    @GetMapping("/orderLine")
    List<OrderLine> all() {
        return repositoryOrderLine.findAll();
    }

    // end::get-aggregate-root[]
    @PostMapping("/orderLine")
    OrderLine newOrder(@RequestBody OrderLine newOrderLine) {
        Product productDontComplet = newOrderLine.getProduct();
        Optional<Product> resultProduct = repositoryProduct.findById(productDontComplet.getId());
       int resulte = resultProduct.get().getQuantityInStock() - newOrderLine.getQuantity() ;
       // Si il y a encore du stock on commande.
        if(resulte >= 0 ){
            repositoryProduct.findById(productDontComplet.getId())
                .map(product -> {
                    product.setQuantityInStock(resulte);
                    repositoryProduct.save(product);
                    return null;
                });
            return repositoryOrderLine.save(newOrderLine);
        }else{
            return null;
        }
    }

    // Single item
    @GetMapping("/orderLine/{id}")
    Optional<OrderLine> one(@PathVariable Long id) {
        return repositoryOrderLine.findById(id);
    }

    // Single item
    @GetMapping("/orderSearchByDate/{startDate}/{endDate}")
    List<OrderLine> Search(@PathVariable String startDate, @PathVariable String endDate) throws ParseException {
      Date startDateConvert = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
      Date endDateConvert = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

      return repositoryOrderLine.getAllBetweenDates(startDateConvert,endDateConvert);
    }

    @DeleteMapping("/orderLine/{id}")
    void deleteOrder(@PathVariable Long id) {
        repositoryOrderLine.deleteById(id);
    }
}
