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
            dictionary.putAll(eachCommand.commandDicitonary())
        }

        dictionary
    }

    String performCommand(String commandName, List<String> args) {

        CLICommand selectedCommand = commands.find {
            it.commandDicitonary().containsKey(commandName)
        }

        println(selectedCommand)

        selectedCommand != null ? selectedCommand.executeCommand(commandName, args) : "BAD COMMAND"
    }
}
