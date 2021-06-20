package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderDeleteService {

    private final OrderRepository orderRepository;

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
