package ru.biosecure.wicket.core.scanner;

import ru.biosecure.wicket.core.repo.PersonToScanRepository;
import ru.biosecure.wicket.core.repo.ScanRepository;
import ru.biosecure.wicket.core.repo.ScannerTaskRepository;
import ru.biosecure.wicket.global.core.app.PersonService;
import ru.biosecure.wicket.global.core.app.ScanService;
import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.PersonToScan;
import ru.biosecure.wicket.global.core.entities.Scan;
import ru.biosecure.wicket.global.core.entities.scanner.ScannerTask;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;
import ru.biosecure.wicket.global.scanner.DaemonMBean;
import ru.biosecure.wicket.global.scanner.PersonBean;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    @Inject
    private ScanRepository scanRepository;

    @Override
    public void failed(Object id) {
        Person firstEmployee = personBean.getPerson();
        createScannerTask(firstEmployee, ScanExecutionResult.FAILED);
    }

    @Override
    public void notifyId(Object ids) {
        if (ids == null) return;
        List<Long> scanIdList = convertToLongList((String[]) ids);
        if (personBean.getPerson() != null) {
            List<Long> excludeIdList = getExcludeIdList(scanIdList);
            for (Long id : excludeIdList) {
                Scan scan = createScan(id);
                createScanLink(scan);
            }
            personBean.setPerson(null);
        } else {
            List<PersonToScan> personToScans = getPersonToScanById(scanIdList);
            Iterator<PersonToScan> personToScansIterator = personToScans.iterator();
            if (personToScans.isEmpty()) return;
            PersonToScan personToScan = personToScansIterator.next();
            if (personToScan == null) return;
            Person firstEmployee = personToScan.getPerson();
            createScannerTask(firstEmployee, ScanExecutionResult.SUCCESS);
        }
    }

    private List<Long> getExcludeIdList(List<Long> scanIdList) {
        List<Long> scanByIds = scanRepository.getExistsScanIdByIds(scanIdList);
        List<Long> excludeIds = new ArrayList<Long>();
        for (Long scanId : scanIdList) {
            if (!scanByIds.contains(scanId)) {
                excludeIds.add(scanId);
            }

        }
        return excludeIds;
    }

    private Scan createScan(Long id) {
        Scan scan = new Scan();
        scan.setScanId(id);
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

    private List<PersonToScan> getPersonToScanById(List<Long> ids) {
        return personToScanRepository.getPersonToScanBy(ids);
    }
}
