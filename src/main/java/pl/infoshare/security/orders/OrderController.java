package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.security.domain.Order;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderFindService orderFindService;
    private final OrderCreateService orderCreateService;
    private final OrderDeleteService orderDeleteService;
    private final OrderFindDetailsService orderFindDetailsService;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return orderFindService.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderDetails(@PathVariable Integer id) {
        return orderFindDetailsService.findById(id);
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        orderCreateService.createOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderDeleteService.deleteOrder(id);
    }
}
