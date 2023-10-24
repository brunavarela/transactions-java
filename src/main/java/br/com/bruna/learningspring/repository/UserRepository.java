package br.com.bruna.learningspring.repository;
import br.com.bruna.learningspring.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
