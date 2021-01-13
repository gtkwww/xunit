package com.github.gtkwww.xunit;

import com.github.gtkwww.xunit.cases.EmptyTestSuite;
import com.github.gtkwww.xunit.cases.SingleCaseTestSuite;
import com.github.gtkwww.xunit.cases.SingleMethodTestCase;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestSuiteTest {

    @Test
    public void should_register_zero_case() {
        EmptyTestSuite emptyTestSuite = new EmptyTestSuite();
        assertThat(emptyTestSuite.numberOfTestCases(), is(0));
    }

    @Test
    public void should_register_one_case() {
        SingleCaseTestSuite singleCaseTestSuite = new SingleCaseTestSuite();

        assertThat(singleCaseTestSuite.numberOfTestCases(), is(1));
        assertThat(singleCaseTestSuite.caseNames(), is(Collections.singletonList(SingleMethodTestCase.class.getName())));
    }

    @Test
    public void should_get_result_when_run_one_case() {
        SingleCaseTestSuite singleCaseTestSuite = new SingleCaseTestSuite();
        List<TestCaseResult> results = singleCaseTestSuite.run();

        assertThat(results.size(), is(1));
        assertThat(results.get(0).getMethodResults().size(), is(1));
        assertThat(results.get(0).getMethodResults().get(0).getResult(), is(TestMethodResult.Result.successful));
    }

}
