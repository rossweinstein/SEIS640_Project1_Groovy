package commandLineInterface

import commandLineInterface.commands.CLICommands
import commandLineInterface.prompt.Prompt

class CommandLineInterface {

    /*
	The prompt is responsible for getting user input and
	separating that input into commands and arguments
	 */
    private Prompt prompt

    /*
    The master list of all the commands. Where the commands
    and arguments collected from the prompt will be given
    in order to perform different functions.
     */
    private CLICommands commands

    public CommandLineInterface() {
        prompt = new Prompt()
        commands = new CLICommands()
    }

    /**
     * Print the banner and run the CLI loop
     */
    void runCLI() {
        println(cliStartUpBanner())
        cliProgramLoop()
    }

    /**
     * Where the command line interface loop resides. It takes as many
     * commands as the user wants to give until the user enters 'quit' to
     * end the program.
     */
    private void cliProgramLoop() {

        boolean cliRunning = true
        while(cliRunning) {
            prompt.getCLICommand()

            if (prompt.command.equals("quit")) {
                cliRunning = false

            } else {
                println(commands.performCommand(prompt.command, prompt.arguments))
            }
        }
    }

    /**
     * Creates a simple banner to show that the CLI program has started. States
     * the class, project name, my name, and informs the user of the help menu
     *
     * @return the banner to be shown when the CLI program starts
     */
    private String cliStartUpBanner() {
        """
        ************************************************************************
        ** SEIS 640-01 | Project 1 - COMMAND LINE INTERFACE | Ross Weinstein  **
        **                                                                    **
        ** type 'help' for list of available commands and their descriptions  **
        ************************************************************************
        """.stripMargin().stripIndent()
    }
}
