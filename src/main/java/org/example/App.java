package org.example;

import java.util.List;
import java.util.stream.Collectors;

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
    List<Character> list;
    boolean everythingIsOK = true;

    public boolean pairExists(char currentLetter, char prevLetter) {
        return (Character.isUpperCase(currentLetter)
                && Character.isLowerCase(prevLetter))
                ||
                (Character.isLowerCase(currentLetter)
                        && Character.isUpperCase(prevLetter));
    }

    public void optimize(List<Character> input) {

        for (int i = 1; i < input.size(); i++) {

            String currentLetter = input.get(i).toString();
            String prevLetter = input.get(i - 1).toString();

            if (pairExists(currentLetter.charAt(0), prevLetter.charAt(0))
                    &&
                    prevLetter.equalsIgnoreCase(currentLetter)) {

                everythingIsOK = false;
                list.remove(i);
                list.remove(i - 1);
                break;

            } else {
                everythingIsOK = true;
            }
        }

        if (!everythingIsOK) {
            optimize(getList());
        }
    }

    public void printList() {
        list.forEach(System.out::print);
    }

    public void setList(String input) {
        this.list = input.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
    }

    public List<Character> getList() {
        return list;
    }

    public static void main(String[] args) {

        String input = "mJYBPpluUqQrleJjgGUWwTtsywWdDuMmNOSsLlfXxOtTCcFfgXxZGgthHb";

        App app = new App();
        app.setList(input);
        app.optimize(app.getList());
        app.printList();

    }
}
