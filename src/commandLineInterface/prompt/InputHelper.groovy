package commandLineInterface.prompt

class InputHelper {

    // a Scanner allows us to get user input from the keyboard
    private Scanner input = new Scanner(System.in)

    /**
     * Prompts user with a specified question and returns their answer
     * as a String.
     *
     * @param question what to display on the console for the user to respond to
     * @return the user's answer
     */
    def askForString(String prompt) {
        print(prompt)
        this.input.nextLine()
    }
}
