package commandLineInterface.commands

import commandLineInterface.commands.tasks.taskController.FunWithStringController

class CommandCollection {

    static List<CLICommand> getAllCommands() {

        def commandList = []

        try {

            commandList.add(onlyIfNamesUnique(commandList, new FunWithStringController()))

        } catch (Exception e) {
            println(e.getMessage())
        }

        commandList
    }

    private static CLICommand onlyIfNamesUnique(List<CLICommand> commandList, CLICommand command) {

        def duplicate = commandList.find {
            it.commandDictionary().containsKey(command)
        }

        if (duplicate != null) {
            throw new Exception("\nWARNING!!!\n" +
                    "Error adding new CLI Command. Command " + duplicate + " already exists. " +
                    "\nYou must change this command name before any new commands may be added to the CLI program.\n")
        }

        command
    }
}
