package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.Order;
import pl.infoshare.security.domain.OrderRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFindService {

    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

}
