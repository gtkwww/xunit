package com.github.gtkwww.xunit.cases;

import com.github.gtkwww.xunit.TestCase;

public class SingleFailMethodTestCase extends TestCase {

    public SingleFailMethodTestCase() {
        super(SingleFailMethodTestCase.class.getName());
        this.register("test", this::test);
    }

    public void test() {
        throw new ArrayIndexOutOfBoundsException("数组溢出了！");
    }

}
