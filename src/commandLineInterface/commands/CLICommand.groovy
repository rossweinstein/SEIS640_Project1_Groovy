package commandLineInterface.commands

interface CLICommand {

    Map<String, String> commandDictionary()
    String executeCommand(String commandName, List<String> args)
}