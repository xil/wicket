package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.biosecure.wicket.global.core.entities.security.User;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 29.06.13
 * Time: 20:17
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
