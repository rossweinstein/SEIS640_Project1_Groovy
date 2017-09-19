package commandLineInterface

import commandLineInterface.commands.CLICommands
import commandLineInterface.prompt.Prompt

class CommandLineInterface {

    private Prompt prompt
    private CLICommands commands

    public CommandLineInterface() {
        prompt = new Prompt()
        commands = new CLICommands()
    }

    void runCLI() {
        println(cliStartUpBanner())
        cliProgramLoop()
    }

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

    private String cliStartUpBanner() {
        "************************************************************************\n" +
        "** SEIS 640-01 | Project 1 - COMMAND LINE INTERFACE | Ross Weinstein  **\n" +
        "**                                                                    **\n" +
        "** type 'help' for list of available commands and their descriptions  **\n" +
        "************************************************************************\n";
    }
}
