package commandLineInterface.commands

interface CLICommand {

    Map<String, String> commandDicitonary()
    String executeCommand(String commandName, List<String> args)
}