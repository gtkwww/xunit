package com.github.gtkwww.xunit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestSuite {

    private final List<TestCase> testCases = new ArrayList<>(2);
    private final String name;

    public TestSuite(String name, TestCase... testCases) {
        this.name = name;
        this.testCases.addAll(Arrays.asList(testCases));
    }

    public void registerCase(TestCase testCase) {
        this.testCases.add(testCase);
    }

    public String name() {
        return name;
    }

    public List<TestCaseResult> run() {
        List<TestCaseResult> results = new ArrayList<>(testCases.size());
        testCases.forEach(x -> results.add(x.run()));
        return results;
    }

    public Integer numberOfTestCases() {
        return this.testCases.size();
    }

    public List<String> caseNames() {
        return Collections.unmodifiableList(testCases.stream().map(TestCase::name).collect(Collectors.toList()));
    }

}
