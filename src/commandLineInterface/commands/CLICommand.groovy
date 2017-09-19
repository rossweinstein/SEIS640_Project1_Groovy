package commandLineInterface.commands

interface CLICommand {
    // within each class, what are the names of each command and what can they perform
    Map<String, String> commandDictionary()

    // for any command to execute, you need the command name and the arguments, if any
    String executeCommand(String commandName, List<String> args)
}