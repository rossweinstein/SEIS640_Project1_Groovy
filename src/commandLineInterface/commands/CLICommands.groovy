package commandLineInterface.commands

import commandLineInterface.commands.tasks.taskController.HelpMenuController

class CLICommands {

    List<CLICommand> commands
    Map<String, String> commandDictionary

    public CLICommands() {
        commands = CommandCollection.getAllCommands()
        commandDictionary = buildCommandDictionary()
        commands.add(new HelpMenuController(commandDictionary))
    }

    private Map<String, String> buildCommandDictionary() {

        def dictionary = ["quit":"Leave CLI program"]

        for (eachCommand in commands) {
            dictionary.putAll(eachCommand.commandDictionary())
        }

        dictionary
    }

    String performCommand(String commandName, List<String> args) {

        CLICommand selectedCommand = findSelectedCommand(commandName)

        selectedCommand != null ? selectedCommand.executeCommand(commandName, args) : "BAD COMMAND"
    }

    private CLICommand findSelectedCommand(String command) {

        CLICommand selectedCommand = null

        for (eachCommand in commands) {
            if (eachCommand.commandDictionary().containsKey(command)) {
                selectedCommand = eachCommand
            }
        }
        selectedCommand
    }
}
