package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.biosecure.wicket.global.core.entities.Scan;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 1:08
 * To change this template use File | Settings | File Templates.
 */
public interface ScanRepository extends JpaRepository<Scan, Long> {
}
