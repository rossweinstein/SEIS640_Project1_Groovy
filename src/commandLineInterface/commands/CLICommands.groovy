package commandLineInterface.commands

import commandLineInterface.commands.tasks.taskController.HelpMenuController

class CLICommands {

    // this is the master list of all the commands the CLI is able to perform
    List<CLICommand> commands

    // a map to hold the commands and a description of their functionality
    Map<String, String> commandDictionary

    public CLICommands() {
        commands = CommandCollection.getAllCommands()
        commandDictionary = buildCommandDictionary()

        /*
		Once all the commands are placed in the dictionary,
        the help menu is created so each command can be displayed with
        its description
         */
        commands.add(new HelpMenuController(commandDictionary))
    }

    /**
     * Build the master command dictionary by combining all the command
     * dictionaries from each individual CLICommand class
     *
     * @return completed dictionary with all commands and functions
     */
    private Map<String, String> buildCommandDictionary() {

        /*
		 quit is added when we create the Map because it is not apart of a CLICommand class.
		 Its only function is to end the loop, so it is added here to be included
		 in the help menu when displayed in the program
		  */
        def dictionary = ["quit":"Leave CLI program"]

        for (eachCommand in commands) {
            dictionary.putAll(eachCommand.commandDictionary())
        }

        dictionary
    }

    /**
     * Finds what CLICommand class the supplied command is found within and
     * executes that command by providing the command name and arguments, if needed
     *
     * @param command the CLI command to be performed
     * @param args the arguments needed for the command, if any
     * @return the result of the specified command being performed. If no command
     *          is found, it returns a "BAD COMMAND" String
     */
    String performCommand(String commandName, List<String> args) {

        CLICommand selectedCommand = findSelectedCommand(commandName)

        selectedCommand != null ? selectedCommand.executeCommand(commandName, args) : "BAD COMMAND"
    }

    /**
     * Searches through the defined CLI commands for a match; returns null
     * if no command is found
     *
     * @param command the desired command
     * @return a CLICommand which contains the given command within its command dictionary
     */
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
