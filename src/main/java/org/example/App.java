package org.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
// Iterator is not directly used in the final version of reactPolymerLogic loop
// import java.util.Iterator; 
// Stack is also not used

/**
 * Hello world!
 * <p>
 * <p>
 * There is a processing plant that needs to be optimized, and we need your help.
 * <p>
 * The processing plant creates chemical polymers made of 26 monomers,
 * and 26 reactive monomers. When a monomer, and it's corresponding
 * reactive monomer touch, they will react, and disappear from the chain.
 * <p>
 * Each monomer has a symbol corresponding to a lower case letter in the alphabet ie: `a-z`.
 * Each monomer's reactive cousin is given an upper case letter, ie: `A-Z`.
 * <p>
 * In a chain, when a reactive pair, ie `Aa` or `aA` touch, they will
 * disappear and the chain will re-attach.
 * <p>
 * This means that in a polymer chain like `AaefxxXXB`,
 * it will react to form: `efB`. It forms this by the following process:
 * 1. `Aa` will react, creating `efaaAAB`
 * 2. `xX` will react, creating `efxXB`
 * 3. `xX` will react, creating `efB`
 * 4. `efB` is now stable and will no longer react.
 * <p>
 * Your task is to code an algorithm that prints out the stable and
 * fully reacted polymer given any polymer chain input.
 * <p>
 * To help you, here are some examples:
 * <p>
 * 1. `vRaKkNgeUYTt` will become `vRaNgeUY`
 * 2. `WySrKeqEzAYyYUQqYuIicrRClZGrjfdEvSxYcCQxcCTqpUu`
 * will become `WySrKeqEzAYUYulZGrjfdEvSxYQxTqp`
 * 3. `mJYBPpluUqQrleJjgGUWwTtsywWdDuMmNOSsLlfXxOtTCcFfgXxZGgthHb`
 * will become `mJYBlrleUsyuNOfOgZtb`
 * <p>
 * Must return the string of reacted polymer.
 */
public class App {

    private String reactPolymerLogic(String inputPolymerString) {
        Deque<Character> stack = new LinkedList<>();
        for (char currentChar : inputPolymerString.toCharArray()) {
            if (!stack.isEmpty() &&
                    Character.isLetter(stack.peek()) &&
                    Character.isLetter(currentChar) &&
                    Math.abs(stack.peek() - currentChar) == 32) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }
        // Convert stack to string in the correct order.
        // Elements are popped from the stack (which gives top-to-bottom order)
        // and added to a temporary list. This list will be in reverse order
        // of the final string (e.g., for "abc", stack top is 'c', list becomes [c,b,a]).
        // Then, this list is reversed and joined.
        List<Character> tempList = new ArrayList<>();
        while (!stack.isEmpty()) {
            tempList.add(stack.pop());
        }
        Collections.reverse(tempList); // Reverse to get correct order (e.g., [a,b,c])
        return tempList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String processPolymer(String input) {
        return reactPolymerLogic(input);
    }

    public static void main(String[] args) {
        String input = "mJYBPpluUqQrleJjgGUWwTtsywWdDuMmNOSsLlfXxOtTCcFfgXxZGgthHb";
        // Example of direct usage for clarity, though AppTest covers this.
        App app = new App();
        String reactedPolymer = app.processPolymer(input);
        System.out.println(reactedPolymer); // Expected: mJYBlrleUsyuNOfOgZtb
    }
}
