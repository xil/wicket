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
import java.util.*;

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
        Iterable<PersonToScan> personToScans = getPersonToScanById(scanIdList);
        Iterator<PersonToScan> personToScansIterator = personToScans.iterator();
        if (!personToScansIterator.hasNext()) {
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
            PersonToScan personToScan = personToScansIterator.next();
            if (personToScan == null) return;
            Person firstEmployee = personToScan.getPerson();
            createScannerTask(firstEmployee, ScanExecutionResult.SUCCESS);
        }
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
        List<Long> targetScanList = new ArrayList<Long>();
        List<Scan> scanList = scanService.scanList();
        for (Scan scan : scanList) {
            if (ids.contains(scan.getScanId())) {
                targetScanList.add(scan.getId());
            }
        }
        List<PersonToScan> targetPersonToScanList = new ArrayList<PersonToScan>();
        List<PersonToScan> personToScans = personToScanRepository.findAll();
        for (PersonToScan personToScan : personToScans) {
            Scan scan = personToScan.getScan();
            if (scan == null) continue;
            if (targetScanList.contains(scan.getId())) {
                targetPersonToScanList.add(personToScan);
            }
        }
        return personToScans;
    }
}
