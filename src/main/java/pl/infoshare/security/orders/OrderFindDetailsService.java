package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import pl.infoshare.security.domain.Order;
import pl.infoshare.security.domain.OrderRepository;

@Component
@RequiredArgsConstructor
public class OrderFindDetailsService {

    private final OrderRepository orderRepository;

    public Order findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
