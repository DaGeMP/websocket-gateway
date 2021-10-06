package com.dagework.websocket.gateway.service.channel;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

class SimpleUUIDCodeGeneratorTest {

    @BeforeMethod
    void setUp() {
    }

    @AfterMethod
    void tearDown() {
    }

    @Test
    void testGenerateWhenLengthIsBetween1And5_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 3;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assert.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsExactly5_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 5;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assert.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsExactly1_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 1;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assert.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsHigherThan5_ShouldReturnException() {
        Assert.assertThrows(InvalidLengthException.class, () -> {
            CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(6);

            codeGenerator.generate();
        });
    }

    @Test
    void testGenerateWhenLengthIsLowerThan1_ShouldReturnException() {
        Assert.assertThrows(InvalidLengthException.class, () -> {
            CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(0);

            codeGenerator.generate();
        });
    }
}
