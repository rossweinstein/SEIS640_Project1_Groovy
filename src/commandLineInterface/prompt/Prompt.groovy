package commandLineInterface.prompt

class Prompt {

    String command
    List<String> arguments
    private String prompt = ">>> "
    private InputHelper input = new InputHelper()

    void getCLICommand() {

        String inputFromUser = input.askForString(prompt).trim()

        if (!inputFromUser.isEmpty()) {

            List<String> commandAndArgs = inputFromUser.split().toList()
            getCommandsAndArguments(commandAndArgs)
        }
    }

    private void getCommandsAndArguments(List<String> userInput) {
        command = userInput.first()
        arguments = userInput.size() > 1 ? userInput.tail() : null
    }
}
