package com.github.gtkwww.xunit;

public final class TestMethodResult {

    public enum Result {
        successful,
        failed
    }

    private final String methodName;
    private final Result result;
    private final String message;

    public TestMethodResult(String methodName, Result result, String message) {
        this.methodName = methodName;
        this.result = result;
        this.message = message;
    }

    public String getMethodName() {
        return methodName;
    }

    public Result getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
