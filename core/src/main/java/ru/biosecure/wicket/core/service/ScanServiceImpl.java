package ru.biosecure.wicket.core.service;

import org.springframework.stereotype.Service;
import ru.biosecure.wicket.core.repo.ScanRepository;
import ru.biosecure.wicket.global.core.app.ScanService;
import ru.biosecure.wicket.global.core.entities.Scan;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Marina
 * Date: 14.10.13
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ScanServiceImpl implements ScanService {

    @Inject
    private ScanRepository scanRepository;

    @Override
    public void addScan(Scan scan) {
        scanRepository.saveAndFlush(scan);
    }

    @Override
    public Scan getScanById(Long id) {
        return scanRepository.findOne(id);
    }

    @Override
    public List<Scan> scanList() {
        return scanRepository.findAll();
    }
}
