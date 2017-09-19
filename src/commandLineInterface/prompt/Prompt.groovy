package commandLineInterface.prompt

class Prompt {

    /*
	The command is responsible for the command the user
	wants to run, it may have zero of more arguments
	 */
    String command

    /*
	The arguments are the optional parameters that may
	be needed for certain commands
	 */
    List<String> arguments

    /*
	The prompt variable holds the icon that is printed
	on the screen showing that the cli program is running
	 */
    private String prompt = ">>> "

    /*
	The InputHelper class sets up a Scanner and a simple way
	to get Strings as input from the user
	 */
    private InputHelper input = new InputHelper()

    /**
     * Reads the String given at the CLI and separates the
     * command and its arguments, populating the appropriate variables
     */
    void getCLICommand() {

        String inputFromUser = input.askForString(prompt).trim()

        if (!inputFromUser.isEmpty()) {

            List<String> commandAndArgs = inputFromUser.split().toList()
            getCommandsAndArguments(commandAndArgs)
        }
    }

    /**
     * Separate the command and arguments, placing them in their
     * specified variables
     *
     * @param givenCommand the array containing the input from the user
     */
    private void getCommandsAndArguments(List<String> userInput) {
        command = userInput.first()
        arguments = userInput.size() > 1 ? userInput.tail() : null
    }
}
