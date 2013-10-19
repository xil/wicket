package ru.biosecure.wicket.core.scanner;

import org.springframework.util.CollectionUtils;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.app.ScanService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.PersonToScan;
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
    private DataService dataService;

    @Override
    public void failed(Object id) {
        Person firstEmployee = personBean.getPerson();
        ScannerTask scannerTask = createScannerTask(firstEmployee, ScanExecutionResult.FAILED);
        dataService.commit(scannerTask);
    }

    @Override
    public void notifyId(Object ids) {
        if (ids == null) return;
        List<Long> scanIdList = convertToLongList((String[]) ids);
        List<Person> persons = getPersonById(scanIdList);
        List<BaseEntity> commitEntities = new ArrayList<BaseEntity>();
        if (CollectionUtils.isEmpty(persons)) {
            if (personBean.getPerson() != null) {
                for (Long id : scanIdList) {
                    createScanLink(commitEntities, id);
                }
                personBean.setPerson(null);
            } else {
                //todo exeption
            }
        } else {
            Person firstEmployee = persons.iterator().next();
            ScannerTask scannerTask = createScannerTask(firstEmployee, ScanExecutionResult.SUCCESS);
            commitEntities.add(scannerTask);
        }
        commit(commitEntities);
    }

    private List<Long> convertToLongList(String[] idStr) {
        List<Long> idList = new ArrayList<Long>();
        for (String id : idStr) {
            if (id == null || id.isEmpty()) continue;
            idList.add(Long.valueOf(id));
        }
        return idList;
    }

    private void createScanLink(List<BaseEntity> commitEntities, Long id) {
        PersonToScan scanLink = new PersonToScan();
        scanLink.setCreatedBy(ADMIN);
        scanLink.setCreateDate(new Date());
        scanLink.setPerson(personBean.getPerson());
        scanLink.setScan(scanService.getScanById(id));
        commitEntities.add(scanLink);
    }

    private ScannerTask createScannerTask(Person firstEmployee, ScanExecutionResult type) {
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

    private List<Person> getPersonById(List<Long> ids) {
        return (List<Person>) personService.findPersonByScanId(ids);
    }
}
