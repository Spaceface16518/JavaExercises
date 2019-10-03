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

import java.util.Objects;

public final class Encoding {
    private Object element;
    private int frequency;

    public Encoding(Object element, int frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    public Encoding(Object element) {
        this.element = element;
        this.frequency = 1;
    }

    @Override
    public int hashCode() {
        int result = element != null ? element.hashCode() : 0;
        result = 31 * result + frequency;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encoding)) return false;

        Encoding encoding = (Encoding) o;

        if (frequency != encoding.frequency) return false;
        return Objects.equals(element, encoding.element);
    }

    @Override
    public final String toString() {
        return (frequency > 1 ? String.valueOf(frequency) : "") + element.toString();
    }

    public final boolean match(Object other) {
        return element == other;
    }

    public final void increment() {
        frequency++;
    }

    public final void increment(int amount) {
        frequency += amount;
    }

    public Object getElement() {
        return element;
    }

    public int getFrequency() {
        return frequency;
    }
}
