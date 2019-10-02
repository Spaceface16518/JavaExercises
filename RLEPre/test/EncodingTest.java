/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <https://unlicense.org>
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncodingTest {
    private Encoding encoding;
    private String expected;

    @BeforeEach
    void setUp() {
        encoding = new Encoding(2, 3);
        expected = "32";
    }

    @Test
    @DisplayName("Equals test")
    void EqualsTest() {
        assertEquals(encoding, new Encoding(2, 3));
        assertNotEquals(encoding, new Encoding(3, 3));
        assertNotEquals(encoding, new Encoding(2, 4));
    }

    @Test
    @DisplayName("ToString test")
    void ToStringTest() {
        assertEquals(expected, encoding.toString());
    }

    @Test
    @DisplayName("Match test")
    void MatchTest() {
        assertTrue(encoding.match(2));
        assertFalse(encoding.match(3));
    }

    @Test
    @DisplayName("Increment test")
    void IncrementTest() {
        encoding.increment();
        assertEquals(4, encoding.getFrequency());
    }

    @Test
    @DisplayName("TestIncrement by amount test")
    void IncrementByAmountTest() {
        encoding.increment(3);
        assertEquals(6, encoding.getFrequency());
    }
}