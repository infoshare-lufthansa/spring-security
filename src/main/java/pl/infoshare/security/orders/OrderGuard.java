package pl.infoshare.security.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.infoshare.security.domain.OrderRepository;
import pl.infoshare.security.domain.OrderUser;

@Component
@RequiredArgsConstructor
public class OrderGuard {

    private final OrderRepository orderRepository;

    public boolean canDisplay(OrderUser user, Integer orderId) {
        if (user.isAdmin()) {
            return true;
        }

        return isOwner(user, orderId);
    }

    public boolean canDelete(OrderUser user, Integer orderId) {
        return isOwner(user, orderId);
    }

    private boolean isOwner(OrderUser user, Integer orderId) {
        return orderRepository.findById(orderId)
                .filter(o -> o.getUser().getId().equals(user.getId()))
                .isPresent();
    }
}
