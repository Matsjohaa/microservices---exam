package no.kristiania.userservice.repository;

import no.kristiania.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
