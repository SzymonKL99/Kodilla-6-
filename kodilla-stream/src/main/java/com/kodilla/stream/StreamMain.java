package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        PoemDecorator abcDecorator = (text) -> "ABC" + text + "ABC";
        poemBeautifier.beautify("Hello", abcDecorator);

        PoemDecorator uppercaseDecorator = String::toUpperCase;
        poemBeautifier.beautify("Hello mentor", uppercaseDecorator);

        PoemDecorator exclamationDecorator = (text) -> text + "!!!";
        poemBeautifier.beautify("Thanks mentor", exclamationDecorator);

        PoemDecorator duplicateDecorator = (text) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : text.toCharArray()) {
                sb.append(c).append(c);
            }
            return sb.toString();
        };
        poemBeautifier.beautify("Hello", duplicateDecorator);
    }

}
