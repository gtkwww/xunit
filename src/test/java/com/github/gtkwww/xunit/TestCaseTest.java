package com.github.gtkwww.xunit;

import com.github.gtkwww.xunit.cases.SingleFailMethodTestCase;
import com.github.gtkwww.xunit.cases.SingleMethodTestCase;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestCaseTest {

    @Test
    public void should_register_one_method() {
        SingleMethodTestCase singleMethodTestCase = new SingleMethodTestCase();
        assertThat(singleMethodTestCase.numberOfTestMethods(), is(1));
        assertThat(singleMethodTestCase.methodNames().size(), is(1));
        assertThat(singleMethodTestCase.methodNames(), is(Collections.singletonList("test")));
    }

    @Test
    public void should_get_successful_result_when_run_one_method() {
        SingleMethodTestCase singleMethodTestCase = new SingleMethodTestCase();
        TestCaseResult results = singleMethodTestCase.run();
        List<TestMethodResult> methodResults  = results.getMethodResults();

        assertThat(methodResults.size(), is(1));
        assertThat(methodResults.get(0).getMethodName(), is("test"));
        assertThat(methodResults.get(0).getResult(), is(TestMethodResult.Result.successful));
    }

    @Test
    public void should_get_fail_result_when_run_one_method() {
        SingleFailMethodTestCase singleMethodTestCase = new SingleFailMethodTestCase();
        TestCaseResult results = singleMethodTestCase.run();
        List<TestMethodResult> methodResults  = results.getMethodResults();

        assertThat(methodResults.get(0).getResult(), is(TestMethodResult.Result.failed));
        assertThat(methodResults.get(0).getMessage(), notNullValue());
    }

}
