package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.task.FunWithStrings

class FunWithStringController implements CLICommand {

    final commands = ["say", "length", "shout", "whisper", "reverse"]
    final stringManipulator = new FunWithStrings()


    @Override
    Map<String, String> commandDicitonary() {
        def funWithStringDictionary = [:] as HashMap
        funWithStringDictionary.put(commands[0], "Prints the given string to the console")
        funWithStringDictionary.put(commands[1], "Prints the length of the given string")
        funWithStringDictionary.put(commands[2], "Prints the given string in all capital letters")
        funWithStringDictionary.put(commands[3], "Prints the given string in all lower case letters")
        funWithStringDictionary.put(commands[4], "Prints the reverse of the given string")
        funWithStringDictionary

    }

    @Override
    String executeCommand(String commandName, List<String> args) {
        def output
        def argument = args.join(" ")

        switch (commandName) {
            case commands[0]:
                output = argument
                break
            case commands[1]:
                output = stringManipulator.length(argument)
                break
            case commands[2]:
                output = stringManipulator.shout(argument)
                break
            case commands[3]:
                output = stringManipulator.whistper(argument)
                break
            case commands[4]:
                output = stringManipulator.reverse(argument)
                break
            default:
                output = ""
                break
        }
        output
    }
}
