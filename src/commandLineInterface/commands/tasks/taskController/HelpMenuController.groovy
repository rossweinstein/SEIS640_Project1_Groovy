package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.task.HelpMenu

class HelpMenuController implements CLICommand {

    final command = "help"
    private HelpMenu helpMenu

    HelpMenuController(Map<String, String> commandDictionary) {
        helpMenu = new HelpMenu(commandDictionary)
    }

    @Override
    Map<String, String> commandDictionary() {
        def helpDictionary = [:] as HashMap
        helpDictionary.put(command, "Shows all available commands and their functionality")
        helpDictionary
    }

    @Override
    String executeCommand(String commandName, List<String> args) {
        helpMenu.printHelpMenu()
    }
}
