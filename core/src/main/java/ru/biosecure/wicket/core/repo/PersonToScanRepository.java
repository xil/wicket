package ru.biosecure.wicket.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.biosecure.wicket.global.core.entities.PersonToScan;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 21.10.13
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public interface PersonToScanRepository extends JpaRepository<PersonToScan, Long> {

    @Query("select ps from PersonToScan ps LEFT join ps.scan s where s.scanId in :scanIds")
    public List<PersonToScan> getPersonToScanBy(@Param("scanIds") List<Long> scanIds);

}
