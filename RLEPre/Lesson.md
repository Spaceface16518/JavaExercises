# Run length encoding

Run length encoding is commonly implemented by beginners because of its limited size, yet slight difficulty. It also has some real world application, unlike most exercises and examples beginners go through.

## Background

### What is run length encoding?

_TODO_

### Example

Say we had the string

```text
aaaaabbbbbaaaaaccccddddfffg
```

Run length encoding this string would yield

```text
5a5b5a4c4d3fg
```

it is obvious how this run length encoded string displays compression of commonly repeated patterns and doesn't add excess pollution to the output.

This is because when we compress a pattern, say `aaaaa`, the string is trimmed to a length of two characters (from five): `5a`. If the pattern was just one character long (`a`), the string would be unaltered. If it were two characters long, for example `aa`, the string would not gain or lose any length (`2a`).

This makes run length encoding advantageous for compressing data containing much repeated data. Some examples of this would be faxed data, which contains a lot of white parts and sparse black spots.

## Classes

Our implementation will have three classes: `Main`, `Encoding`, and `RunLengthEncoder`.

#### `Main`

`Main` is the runner class of this exercise.

##### Responsibilities

* Read in the input data
* Encode the data using `RunLengthEncoder`
* Print out the encoded data

#### `RunLengthEncoder`

`RunLengthEncoder` is the heart of our program. This file will likely have the most code.

##### Responsibilities

* Store encoded data
* Take in new data (to be encoded)
* Properly encode data into `Encoding`s.

##### Notes

This class is also responsible for classifying data as the data is encoded. We will see what this means later on.

#### `Encoding`

`Encoding` is a small class that stores individual pieces of encoded data.

It has two parts: the **`element`** and the **`frequency`**. The `element` is the actual thing (for example, a character) that is represented by that `Encoding` and the `frequency` is the number of consecutive times that element has appears.

If the encoding of `aaaaa` is `5a`, then the `5` is the freqency and the `a` is the element.

##### Responsibilities

* Keep track of the frequency of an element
* Answer whether another element matches the element represented by this `Encoding`

## Initial code

There's never been a time where the first iteration of my code was the one I kept, but an important step to doing a project is actually starting it. Let's just get some initial code out there first, and we'll improve upon it later.

We're going to code our program by starting at the top (the point of execution) and descending, filling in the behavior of our program. This helps keep us from creating unnecessary complexity in our program, because we're only creating things when we need them.

### Level one: `Main`

The least interesting part of our program is our runner class, `Main`. Create it and fill it with a normal runner setup

```java
public class Main {
    public static void main(String[] args){
      System.out.println("Hello, world!");
    }
}
```

Yay.

Now let's think about what we need our runner class to do.

1. Read in the input
    a. Turn that input into a format `RunLengthEncoder` can understand. For now, that will be a `String`.
2. Make `RunLengthEncoder` encode all of our data.
3. Print out the encoded data

1 and 3 are easy

```java
// wire standard input
Scanner scanner = new Scanner(System.in);


// turn input to string
StringBuilder builder = new StringBuilder();
while (scanner.hasNext()) builder.append(scanner.next());
String input = builder.toString();
```

In the first line we set up a `Scanner`.

The next few are slightly more complex. `StringBuilder` is a class that helps us build strings. We have use the `.append()` and `.toString()` methods on it instead of `+=`, but in exchange, it improves the speed and memory usage of our program.

That funky looking `while` loop is just a single line `while`. Java knows that it can get verbose sometimes, so it allows us to omit {curly braces} if we only need one line inside the `while` loop. Our loop polls the `Scanner` for `String`s, and adds them to the `StringBuilder`.

Finally we build the `String` from the `StringBuilder` using the `.toString()` method.


Okay so now we have our input in a `String`. Let's pretend we've encoded it and are ready to print it out


```java
// wire standard input
Scanner scanner = new Scanner(System.in);


// turn input to string
StringBuilder builder = new StringBuilder();
while (scanner.hasNext()) builder.append(scanner.next());
String input = builder.toString();

// TODO: Encode input

System.out.println( /* Encoded stuff */ );
```

Simple enough. We'll fill in that placeholder once we have something to put there.

Now the only thing left is that `TODO: Encode input` that's sitting there mocking us. It seems that it's time to start descending into the actual behavior of our program. Let's begin!

### Level two: `RunLengthEncoder`

If we haven't already, create our `RunLengthEncoder` class

```java
class RunLengthEncoder {

}
```
