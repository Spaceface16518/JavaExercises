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
import java.util.Objects;

public final class RunLengthEncoding {
    private ArrayList<Encoding> encodings;

    public RunLengthEncoding() {
        encodings = new ArrayList<>();
    }

    public RunLengthEncoding(ArrayList<Encoding> encodings) {
        this.encodings = encodings;
    }

    @Override
    public String toString() {
//        String builder = "";
//        for (int i = 0; i < encodings.size(); i++) {
//            builder += encodings.get(i).toString();
//        }
//        return builder;

        StringBuilder builder = new StringBuilder();
        for (Encoding encoding : encodings) {
            builder.append(encoding.toString());
        }
        return builder.toString();
    }

    public void addAll(Object[] input) {
        for (Object o : input) this.add(o);
    }

    final public void add(Object element) {
        Encoding last = last();
        if (last != null && last.match(element)) {
            last.increment();
        } else {
            encodings.add(new Encoding(element));
        }
    }

    private Encoding last() {
        if (!encodings.isEmpty()) {
            return encodings.get(encodings.size() - 1);
        } else {
            return null;
        }
    }

    public ArrayList<Encoding> getEncodings() {
        return encodings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RunLengthEncoding)) return false;

        RunLengthEncoding encoding = (RunLengthEncoding) o;

        return Objects.equals(encodings, encoding.encodings);
    }

    @Override
    public int hashCode() {
        return encodings != null ? encodings.hashCode() : 0;
    }
}
