package ru.biosecure.wicket.core.scanner;

import org.springframework.util.CollectionUtils;
import ru.biosecure.wicket.core.repo.PersonToScanRepository;
import ru.biosecure.wicket.core.repo.ScannerTaskRepository;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.app.ScanService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.PersonToScan;
import ru.biosecure.wicket.global.core.entities.Scan;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;
import ru.biosecure.wicket.global.scanner.DaemonMBean;
import ru.biosecure.wicket.global.scanner.DataService;
import ru.biosecure.wicket.global.scanner.PersonBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 01.10.13
 * Time: 23:49
 * To change this template use File | Settings | File Templates.
 */

public class DaemonMBeanImpl implements DaemonMBean {

    public static final String ADMIN = "admin";

    @Inject
    private PersonService personService;
    @Inject
    private PersonBean personBean;
    @Inject
    private ScanService scanService;
    @Inject
    private PersonToScanRepository personToScanRepository;
    @Inject
    private ScannerTaskRepository scannerTaskRepository;

    @Override
    public void failed(Object id) {
        Person firstEmployee = personBean.getPerson();
        createScannerTask(firstEmployee, ScanExecutionResult.FAILED);
    }

    @Override
    public void notifyId(Object ids) {
        if (ids == null) return;
        List<Long> scanIdList = convertToLongList((String[]) ids);
        List<Person> persons = getPersonById(scanIdList);
        if (CollectionUtils.isEmpty(persons)) {
            if (personBean.getPerson() != null) {
                for (Long id : scanIdList) {
                    Scan scan = createScan(id);
                    createScanLink(scan);
                }
                personBean.setPerson(null);
            } else {
                //todo exeption
            }
        } else {
            Person firstEmployee = persons.iterator().next();
            createScannerTask(firstEmployee, ScanExecutionResult.SUCCESS);
        }
    }

    private Scan createScan(Long id) {
        Scan scanById = scanService.getScanById(id);
        if (scanById != null) return scanById;
        Scan scan = new Scan();
        scan.setId(id);
        scan.setCreateDate(new Date());
        scan.setCreatedBy(ADMIN);
        scanService.addScan(scan);
        return scan;
    }

    private List<Long> convertToLongList(String[] idStr) {
        List<Long> idList = new ArrayList<Long>();
        for (String id : idStr) {
            if (id == null || id.isEmpty()) continue;
            idList.add(Long.valueOf(id));
        }
        return idList;
    }

    private void createScanLink(Scan scan) {
        PersonToScan scanLink = new PersonToScan();
        scanLink.setCreatedBy(ADMIN);
        scanLink.setCreateDate(new Date());
        scanLink.setPerson(personBean.getPerson());
        scanLink.setScan(scan);
        personToScanRepository.saveAndFlush(scanLink);
    }

    private void createScannerTask(Person firstEmployee, ScanExecutionResult type) {
        ScannerTask scannerTask = new ScannerTask();
        scannerTask.setCreatedBy(ADMIN);
        scannerTask.setCreateDate(new Date());
        scannerTask.setPerson(firstEmployee);
        scannerTask.setResult(type);
        scannerTaskRepository.saveAndFlush(scannerTask);
    }

    private List<Person> getPersonById(List<Long> ids) {
        return (List<Person>) personService.findPersonByScanId(ids);
    }
}
