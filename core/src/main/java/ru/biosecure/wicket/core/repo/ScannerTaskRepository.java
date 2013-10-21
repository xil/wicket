package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 21.10.13
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public interface ScannerTaskRepository extends JpaRepository<ScannerTask, Long> {
}
