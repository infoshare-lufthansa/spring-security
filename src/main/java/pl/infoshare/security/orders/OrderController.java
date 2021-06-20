package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.security.domain.Order;
import pl.infoshare.security.domain.OrderUser;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderFindService orderFindService;
    private final OrderCreateService orderCreateService;
    private final OrderDeleteService orderDeleteService;
    private final OrderFindDetailsService orderFindDetailsService;

    @GetMapping("/orders")
    public Page<Order> getOrders(@AuthenticationPrincipal OrderUser orderUser,
                                 Pageable pageable) {
        return orderFindService.findAll(orderUser, pageable);
    }

    @GetMapping("/orders/{id}")
    @PreAuthorize("@orderGuard.canDisplay(principal, #id)")
    public Order getOrderDetails(@PathVariable Integer id) {
        return orderFindDetailsService.findById(id);
    }

    @PostMapping("/orders")
    public void createOrder(@RequestBody Order order) {
        orderCreateService.createOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    @PreAuthorize("@orderGuard.canDelete(principal, #id)")
    public void deleteOrder(@PathVariable Integer id) {
        orderDeleteService.deleteOrder(id);
    }
}
