package com.github.gtkwww.xunit.cases;

import com.github.gtkwww.xunit.TestSuite;

public class SingleCaseTestSuite extends TestSuite {

    public SingleCaseTestSuite() {
        super(SingleCaseTestSuite.class.getName());
        this.registerCase(new SingleMethodTestCase());
    }

}
