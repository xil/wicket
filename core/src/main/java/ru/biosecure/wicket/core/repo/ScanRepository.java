package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.biosecure.wicket.global.core.entities.Scan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 1:08
 * To change this template use File | Settings | File Templates.
 */
public interface ScanRepository extends JpaRepository<Scan, Long> {

    @Query("select s.scanId from Scan s where s.scanId in :scanIds")
    public List<Long> getExistsScanIdByIds(@Param("scanIds") List<Long> scanIds);
}
