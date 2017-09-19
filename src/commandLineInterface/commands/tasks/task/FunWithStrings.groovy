package commandLineInterface.commands.tasks.task

class FunWithStrings {

    /**
     * Finds the length of the given string
     *
     * @param words the String to find the length of
     * @return the length of the given string
     */
    def length(String words) {
        words.length().toString()
    }

    /**
     * Takes any character that is not uppercase and makes them uppercase
     *
     * @param words the String to manipulate
     * @return a String with all uppercase letters
     */
    def shout(String words) {
        words.toUpperCase()
    }

    /**
     * Takes any character that is not lowercase and makes them lowercase
     *
     * @param words the String to manipulate
     * @return a String with all lowercase letters
     */
    def whistper(String words) {
        words.toLowerCase()
    }

    /**
     * Reverses the characters of a String.
     *
     * @param words the String to manipulate
     * @return a String with all the characters in reverse order
     */
    def reverse(String words) {
        words.reverse()
    }
}
