package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testProvidedExample1() {
        assertEquals("vRaNgeUY", app.processPolymer("vRaKkNgeUYTt"));
    }

    @Test
    void testProvidedExample2() {
        assertEquals("WySrKeqEzAYUYulZGrjfdEvSxYQxTqp", app.processPolymer("WySrKeqEzAYyYUQqYuIicrRClZGrjfdEvSxYcCQxcCTqpUu"));
    }

    @Test
    void testProvidedExample3() {
        // This is also the original main method example
        assertEquals("mJYBlrleUsyuNOfOgZtb", app.processPolymer("mJYBPpluUqQrleJjgGUWwTtsywWdDuMmNOSsLlfXxOtTCcFfgXxZGgthHb"));
    }

    @Test
    void testOriginalCommentExample() {
        assertEquals("efB", app.processPolymer("AaefxxXXB"));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", app.processPolymer(""));
    }

    @Test
    void testNoReactions() {
        assertEquals("abcde", app.processPolymer("abcde"));
    }

    @Test
    void testAllReact() {
        assertEquals("", app.processPolymer("abBA"));
    }

    @Test
    void testAlternatingReactivePairs() {
        assertEquals("", app.processPolymer("aAbBcCdD"));
    }

    @Test
    void testSimpleReaction() {
        assertEquals("", app.processPolymer("aA"));
    }

    @Test
    void testReactionAtBeginning() {
        assertEquals("abc", app.processPolymer("xXabc"));
    }

    @Test
    void testReactionAtEnd() {
        assertEquals("abc", app.processPolymer("abcXx"));
    }

    @Test
    void testMixedCaseNoReaction() {
        assertEquals("abCDef", app.processPolymer("abCDef"));
    }

    // Test for long string with multiple reactions is covered by testProvidedExample2 and testProvidedExample3
}
