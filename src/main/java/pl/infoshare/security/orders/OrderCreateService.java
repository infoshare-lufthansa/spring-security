package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.Order;
import pl.infoshare.security.domain.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderCreateService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
