package com.github.gtkwww.xunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestCase {

    private final List<TestMethod> testMethods = new ArrayList<>(2);
    private final String name;

    public TestCase(String name, TestMethod... testMethods) {
        this.name = name;
        this.testMethods.addAll(Arrays.asList(testMethods));
    }

    public String name() {
        return name;
    }

    public List<String> methodNames() {
        return Collections.unmodifiableList(testMethods.stream().map(TestMethod::getName).collect(Collectors.toList()));
    }

    public Integer numberOfTestMethods() {
        return this.testMethods.size();
    }

    public void register(String name, Runnable method) {
        testMethods.add(TestMethod.create(name, method));
    }

    public void registerMethod(TestMethod testMethod) {
        testMethods.add(testMethod);
    }

    public TestCaseResult run() {
        List<TestMethodResult> results = new ArrayList<>(testMethods.size());
        this.testMethods.forEach(x -> results.add(x.run()));
        return new TestCaseResult(this.name(), results);
    }

}
