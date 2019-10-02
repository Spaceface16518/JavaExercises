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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunLengthEncodingTest {
    ArrayList<Encoding> encodings;
    ArrayList<Integer> args;
    String expected;

    @BeforeEach
    void setUp() {
        encodings = new ArrayList<>(List.of(new Encoding(1, 1), new Encoding(2, 2), new Encoding(3, 3), new Encoding(4, 4), new Encoding(5, 5)));
        args = new ArrayList<>(List.of(1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5));
        expected = "122334455";
    }

    @Test
    @DisplayName("ToString test")
    void ToStringTest() {
        RunLengthEncoding actual = new RunLengthEncoding(encodings);
        assertEquals(expected, actual.toString());
    }

    @Test
    @DisplayName("AddAll test")
    void AddAllTest() {
        RunLengthEncoding encoding = new RunLengthEncoding();
        encoding.addAll(args.toArray());
        assertEquals(encodings, encoding.getEncodings());
    }

    @Test
    @DisplayName("Add test")
    void AddTest() {
        RunLengthEncoding encoding = new RunLengthEncoding(encodings);
        encoding.add(6);

        encodings.add(new Encoding(6, 1));
        assertEquals(encodings, encoding.getEncodings());
    }
}