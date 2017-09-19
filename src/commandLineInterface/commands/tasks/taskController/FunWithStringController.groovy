package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.task.FunWithStrings

class FunWithStringController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    final commands = ["say", "length", "shout", "whisper", "reverse"]

    // FunWithStrings allows us to perform string manipulations
    final stringManipulator = new FunWithStrings()

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * help menu within our CLI project, but also to identify which commands belong
     * to which class.
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    Map<String, String> commandDictionary() {
        def funWithStringDictionary = [:] as HashMap

        // say
        funWithStringDictionary.put(commands[0], "Prints the given string to the console")

        // length
        funWithStringDictionary.put(commands[1], "Prints the length of the given string")

        // shout
        funWithStringDictionary.put(commands[2], "Prints the given string in all capital letters")

        // whisper
        funWithStringDictionary.put(commands[3], "Prints the given string in all lower case letters")

        // reverse
        funWithStringDictionary.put(commands[4], "Prints the reverse of the given string")

        funWithStringDictionary
    }

    /**
     * Based upon the command given, perform the desired string manipulation with the
     * given arguments.
     *
     * @param name the name of the desired string operation (say, length, shout, whisper, reverse)
     * @param args the arguments to be given to the desired FunWithStrings method
     * @return the manipulated string
     */
    @Override
    String executeCommand(String commandName, List<String> args) {
        def output
        def argument = args.join(" ")

        switch (commandName) {

            // say
            case commands[0]:
                output = argument
                break

            // length
            case commands[1]:
                output = stringManipulator.length(argument)
                break

            // shout
            case commands[2]:
                output = stringManipulator.shout(argument)
                break

            // whisper
            case commands[3]:
                output = stringManipulator.whistper(argument)
                break

            // reverse
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
