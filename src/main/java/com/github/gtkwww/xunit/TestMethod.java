package com.github.gtkwww.xunit;

public final class TestMethod {

    private final String name;
    private final Runnable method;

    private TestMethod(String name, Runnable method) {
        this.name = name;
        this.method = method;
    }

    public static TestMethod create(String name, Runnable method) {
        return new TestMethod(name, method);
    }

    public TestMethodResult run() {
        try {
            method.run();
            return new TestMethodResult(name, TestMethodResult.Result.successful, "OK!");
        } catch (Exception ex) {
            return new TestMethodResult(name, TestMethodResult.Result.failed, ex.getMessage());
        }
    }

    public String getName() {
        return name;
    }

}
