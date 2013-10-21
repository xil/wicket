package ru.biosecure.wicket.global.core.entities.scanner;

import ru.biosecure.wicket.global.core.enums.ScanExecutionResult;

import java.io.Serializable;

/**
 * User: Alexey Nevinsky
 * Date: 19.10.13 16:14
 */
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
