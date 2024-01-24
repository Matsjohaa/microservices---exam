package no.kristiania.userservice.repository;

import no.kristiania.userservice.dto.UserDto;
import no.kristiania.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
