package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.Order;
import pl.infoshare.security.domain.OrderRepository;
import pl.infoshare.security.domain.OrderUser;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFindService {

    private final OrderRepository orderRepository;

    public Page<Order> findAll(OrderUser orderUser, Pageable pageable) {
        return orderRepository.findAllByUser(orderUser, pageable);
    }
}
