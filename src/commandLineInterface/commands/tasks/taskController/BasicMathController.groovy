package commandLineInterface.commands.tasks.taskController

import commandLineInterface.commands.CLICommand
import commandLineInterface.commands.tasks.helpers.Numbers
import commandLineInterface.commands.tasks.task.BasicMath

class BasicMathController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    private String[] commands = ["add", "subt", "mult", "divide"]

    // BasicMath allows us to perform simple calculations
    private BasicMath math = new BasicMath()

    // error message if invalid input is given
    private String errorMessage = "Invalid Input: Not All Arguments Are Valid Numeric Values"

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * help menu within our CLI project, but also to identify which commands belong
     * to which class
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    Map<String, String> commandDictionary() {

        def basicMathDictionary = [:] as HashMap

        // add
        basicMathDictionary.put(this.commands[0], "Performs addition on the supplied arguments")

        // subtract
        basicMathDictionary.put(this.commands[1], "Performs subtraction on the supplied arguments")

        // multiply
        basicMathDictionary.put(this.commands[2], "Performs multiplication on the supplied arguments")

        // divide
        basicMathDictionary.put(this.commands[3], "Performs division on the supplied arguments")

        basicMathDictionary
    }

    /**
     * Check if our supplied arguments are valid numbers before performing any
     * mathematical operation. Return a invalid arguments message if supplied
     * arguments are not all valid numeric values
     *
     * @param name the name of the desired mathematical operation (add, subt, mult, divide)
     * @param args the arguments to be checked for validity before being passed for evaluation
     * @return the result of the evaluated expression if supplied arguments are valid numeric values;
     *          an error message if all arguments are not valid numeric values
     */
    @Override
    String executeCommand(String commandName, List args) {
        def arguments = new Numbers(args)

        arguments.areNumeric() ? evaluateOperation(commandName, arguments) : this.errorMessage
    }

    /**
     * Based upon the command given, perform the desired mathematical operations with the
     * given arguments.
     *
     * @param operation the name of the desired mathematical operation (add, subt, mult, divide)
     * @param args the arguments to be given to the desired BasicMath method
     * @return the result of the evaluated expression
     */
    private String evaluateOperation(String operation, Numbers args) {

        // String to hold the expression result
        String output = "";

        def numericArgs = args.getIntValues() != null ? args.getIntValues() : args.getDoubleValues()

        switch (operation) {
        // add
            case commands[0]:
                output = this.math.add(numericArgs)
                break
        //subt
            case commands[1]:
                output = this.math.subt(numericArgs)
                break
        //mult
            case commands[2]:
                output = this.math.mult(numericArgs)
                break
        //divide
            case commands[3]:
                output = this.math.divide(numericArgs)
                break
            default:
                output = ""
                break
        }
        output
    }
}
