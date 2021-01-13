package com.github.gtkwww.xunit;

import java.util.List;

public class TestCaseResult {

    private final String caseName;
    private final List<TestMethodResult> methodResults;

    public TestCaseResult(String caseName, List<TestMethodResult> methodResults) {
        this.caseName = caseName;
        this.methodResults = methodResults;
    }

    public String getCaseName() {
        return caseName;
    }

    public List<TestMethodResult> getMethodResults() {
        return methodResults;
    }

}
