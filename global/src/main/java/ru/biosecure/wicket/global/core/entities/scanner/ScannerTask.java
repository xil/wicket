package ru.biosecure.wicket.global.core.entities.scanner;

import ru.biosecure.wicket.global.core.entities.Person;
import ru.biosecure.wicket.global.core.entities.base.BaseEntity;
import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 18.07.13
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "SCANNER_TASK")
public class ScannerTask extends BaseEntity {
    private static final long serialVersionUID = -5837363605144242913L;

    @Column(name = "RESULT")
    protected ScanExecutionResult result;

    @Column(name = "REASON")
    protected String reason;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    protected Person person;

    public ScanExecutionResult getResult() {
        return result;
    }

    public void setResult(ScanExecutionResult result) {
        this.result = result;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
