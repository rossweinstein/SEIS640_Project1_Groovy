package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.task.HelpMenu

/**
 * Created by rweinstein on 9/19/17.
 */
class HelpMenuController implements CLICommand {

    final command = "help"
    private HelpMenu helpMenu

    HelpMenuController(Map<String, String> commandDictionary) {
        helpMenu = new HelpMenu(commandDictionary)
    }

    @Override
    Map<String, String> commandDicitonary() {
        def helpDictionary = [:] as HashMap
        helpDictionary.put(command, "Shows all available commands and their functionality")
        helpDictionary
    }

    @Override
    String executeCommand(String commandName, List<String> args) {
        helpMenu.printHelpMenu()
    }
}
