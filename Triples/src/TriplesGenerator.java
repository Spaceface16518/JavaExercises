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

import java.util.ArrayList;

public class TriplesGenerator {
    private int number;

    public TriplesGenerator(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Triple triple : this.triples()) {
            sb.append(triple.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    public ArrayList<Triple> triples() {
        ArrayList<Triple> triples = new ArrayList<>();

        for (int t = 1; t < number; t++) {
            for (int s = t + 1; s < number; s++) {
                // We don't want the decimal value of r, but we need it to
                // check if r is a perfect square
                double possible_r = Math.sqrt(2 * s * t);

                // check if r is a perfect square
                // aka check if r^2 = 2st
                // TODO: is there a better algorithm for this?
                if (possible_r - Math.floor(possible_r) == 0) {
                    int r = (int) possible_r; // make r an integer

                    // find the sides of the triangle
                    int a = r + s;
                    int b = r + t;
                    int c = r + s + t;

                    triples.add(new Triple(a, b, c));
                }
            }
        }
        return triples;
    }
}
