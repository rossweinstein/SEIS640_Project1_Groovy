package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.task.HelpMenu

class HelpMenuController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    final command = "help"

    // HelpMenu is able to build a menu which displays the contents of the other CLICommand
    // command dictionaries
    private HelpMenu helpMenu

    /**
     * Construct a new HelpMenuController from the supplied commandDictionary which holds
     * all the names and descriptions of the other CLICommands with the CLI project
     *
     * @param commandDictionary the master command dictionary composed from all other CLICommand classes
     */
    HelpMenuController(Map<String, String> commandDictionary) {
        helpMenu = new HelpMenu(commandDictionary)
    }

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * helpMenuBuilder menu within our CLI project, but also to identify which commands belong
     * to which class
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    Map<String, String> commandDictionary() {
        def helpDictionary = [:] as HashMap
        helpDictionary.put(command, "Shows all available commands and their functionality")
        helpDictionary
    }

    /**
     * This CLICommand does not need any command name nor arguments. It just
     * conforms to the CLICommand interface in order to be called easily. This
     * method just calls printHelpMenu from HelpMenu in order to display all
     * the commands and their functions.
     *
     * @param name the name of the desired mathematical operation (unused)
     * @param args the arguments to be given to the desired FunWithStrings method (unused)
     * @return the constructed helpMenuBuilder menu from all the commands and descriptions within the CLI
     */
    @Override
    String executeCommand(String commandName, List<String> args) {
        helpMenu.printHelpMenu()
    }
}
