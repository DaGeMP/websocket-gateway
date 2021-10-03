package com.dagework.websocket.gateway.service.channel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleUUIDCodeGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGenerateWhenLengthIsBetween1And5_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 3;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assertions.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsExactly5_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 5;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assertions.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsExactly1_ShouldReturnACodeOfTheSpecifiedLength() {
        int expectedLength = 1;
        CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(expectedLength);

        String code = codeGenerator.generate();

        Assertions.assertEquals(expectedLength, code.length());
    }

    @Test
    void testGenerateWhenLengthIsHigherThan5_ShouldReturnException() {
        Assertions.assertThrows(InvalidLengthException.class, () -> {
            CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(6);

            codeGenerator.generate();
        });
    }

    @Test
    void testGenerateWhenLengthIsLowerThan1_ShouldReturnException() {
        Assertions.assertThrows(InvalidLengthException.class, () -> {
            CodeGenerator codeGenerator = new SimpleUUIDCodeGenerator(0);

            codeGenerator.generate();
        });
    }
}
