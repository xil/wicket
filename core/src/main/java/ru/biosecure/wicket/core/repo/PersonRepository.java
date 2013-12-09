package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.biosecure.wicket.global.core.entities.person.Person;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 30.06.13
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
