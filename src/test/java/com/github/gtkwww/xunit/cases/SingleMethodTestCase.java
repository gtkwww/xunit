package com.github.gtkwww.xunit.cases;

import com.github.gtkwww.xunit.TestCase;

public class SingleMethodTestCase extends TestCase {

    public SingleMethodTestCase() {
        super(SingleMethodTestCase.class.getName());
        this.register("test", this::test);
    }

    public void test() {

    }

}
