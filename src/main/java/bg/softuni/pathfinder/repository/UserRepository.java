package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAllById(Iterable<Long> longs);

    User findByUsername(String username);
}
