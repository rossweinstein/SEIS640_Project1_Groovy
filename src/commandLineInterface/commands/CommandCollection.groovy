package commandLineInterface.commands

import commandLineInterface.commands.tasks.taskController.BasicMathController
import commandLineInterface.commands.tasks.taskController.FunWithStringController

class CommandCollection {

    /**
     * Collect all the CLICommands that need to be included within the CLI program. Each
     * command is checked to ensure that all command names are unique. If any names are
     * duplicates, throws an exception and stops adding commands to list.
     *
     * @return the collected list of all CLICommands
     */
    static List<CLICommand> getAllCommands() {

        def commandList = []

        try {

            /*
            !!!ADD NEW CLI COMMANDS HERE!!!

            be sure to user the helper method onlyIfAllCommandNamesUnique to avoid name collision
             */
            commandList.add(onlyIfNamesUnique(commandList, new FunWithStringController()))
            commandList.add(onlyIfNamesUnique(commandList, new BasicMathController()))


        } catch (Exception e) {
            println(e.getMessage())
        }

        commandList
    }

    /**
     * Checks that there are no duplicates names within our commandList.
     *
     * @param commandList the list to check duplicate names against
     * @param command the new command names to be verified for uniqueness
     * @return the new Command, if verified; exception if any name collision
     * @throws Exception when we try to add a new command where the already exists
     *                  a command with that same name
     */
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
