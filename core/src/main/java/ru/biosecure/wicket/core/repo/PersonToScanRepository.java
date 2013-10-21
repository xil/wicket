package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.biosecure.wicket.global.core.entities.PersonToScan;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 21.10.13
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public interface PersonToScanRepository extends JpaRepository<PersonToScan, Long> {
}
