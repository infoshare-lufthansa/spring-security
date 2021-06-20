package pl.infoshare.security.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderUserRepository extends JpaRepository<OrderUser, Integer> {

    Optional<OrderUser> findByEmail(String email);

}
