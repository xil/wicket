package ru.biosecure.wicket.global.core.entities.scanner;

import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: inver
 * Date: 19.10.13
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */

/**
 * @deprecated use {@link ScanExecutionResult}
 */

@Deprecated
public class ScanResult implements Serializable {

    private ScanExecutionResult result;

    private String resultMessage;

    public ScanExecutionResult getResult() {
        return result;
    }

    public void setResult(ScanExecutionResult result) {
        this.result = result;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
}
