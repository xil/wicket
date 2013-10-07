package ru.biosecure.wicket.core.scanner;

import org.springframework.util.CollectionUtils;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.PersonToScan;
import ru.biosecure.wicket.global.core.entities.Scan;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanTaskExecutionResult;
import ru.biosecure.wicket.global.scanner.DaemonMBean;
import ru.biosecure.wicket.global.scanner.DataService;

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

    private Person person = null;

    @Inject
    private PersonService personService;

    @Inject
    private DataService dataService;

    @Override
    public void failed(Object id) {
        Person firstEmployee = getPerson();
        ScannerTask scannerTask = createScannerTask(firstEmployee, ScanTaskExecutionResult.FAILED);
        dataService.commit(scannerTask);
    }

    @Override
    public void notifyId(Object id) {
        if (id == null) return;
        String ids = id.toString();
        String[] splitId = ids.split(",");
        List<Person> employees = getEmployeeById(splitId);
        List<BaseEntity> commitEntities = new ArrayList<BaseEntity>();
        if (CollectionUtils.isEmpty(employees)) {
            if (getPerson() != null) {
                for (String scanId : splitId) {
                    createScanLink(commitEntities, scanId);
                }
                setPerson(null);
            } else {
                //todo exeption
            }
        } else {
            Person firstEmployee = employees.iterator().next();
            ScannerTask scannerTask = createScannerTask(firstEmployee, ScanTaskExecutionResult.SUCCESS);
            commitEntities.add(scannerTask);
        }
        commit(commitEntities);
    }

    private void createScanLink(List<BaseEntity> commitEntities, String scanId) {
        PersonToScan scanLink = new PersonToScan();
        scanLink.setCreatedBy(ADMIN);
        scanLink.setCreateDate(new Date());
        scanLink.setPerson(getPerson());
        scanLink.setScan(getScan());
        commitEntities.add(scanLink);
    }

    private Scan getScan() {
        return null;
    }

    private ScannerTask createScannerTask(Person firstEmployee, ScanTaskExecutionResult type) {
        ScannerTask scannerTask = new ScannerTask();
        scannerTask.setCreatedBy(ADMIN);
        scannerTask.setCreateDate(new Date());
        scannerTask.setPerson(firstEmployee);
        scannerTask.setResult(type);
        return scannerTask;

    }

    private void commit(List<BaseEntity> commitEntities) {
        if (!CollectionUtils.isEmpty(commitEntities)) {
            dataService.commit(commitEntities);
        }
    }

    private List<Person> getEmployeeById(String[] splitIds) {
        return personService.findPersonByScanId(splitIds);
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    protected Person getPerson() {
        return person;
    }
}
