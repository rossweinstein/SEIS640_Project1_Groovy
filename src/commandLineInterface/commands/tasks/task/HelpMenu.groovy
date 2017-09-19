package commandLineInterface.commands.tasks.task

class HelpMenu {

    // the master list of all commands from each CLICommand
    private Map<String, String> commandDictionary

    /**
     * To use the HelpMenu, a Map of all the other CLICommand dictionaries
     * must be passed in otherwise no HelpMenu can be created
     *
     * @param commandDictionary master list of all CLICommand commandDictionaries
     */
    HelpMenu(Map<String, String> commandDictionary) {
        this.commandDictionary = commandDictionary
    }

    /**
     * The completed CLI help menu with each command and its function
     *
     * @return the CLI help menu with each command and its function
     */
    String printHelpMenu() {
        "\n".concat(helpBanner() + "\n")
                .concat(header())
                .concat(helpCommandList())
                .concat(drawDivider('*', 72) + "\n")
    }

    /**
     * Creates a banner with a divider of '*' along with a description of the menu
     *
     * @return a sep
     */
    private String helpBanner() {
        """\
        ${drawDivider('*', 72)}
        HELP MENU: CLI commands and their function descriptions
        """.stripIndent()
    }

    /**
     * Create a header for the table with labels for the commands and descriptions
     *
     * @return a header for the helpCommandList table
     */
    private String header() {
        """\
        command\t\t|\tdescription
        ${drawDivider('-', 72)}
        """.stripIndent()
    }

    /**
     * For all the commands provided from the other CLICommand classes, create a table
     * which includes each command and their function
     *
     * @return a table which states each command and their function
     */
    private String helpCommandList() {

        String output = ""

        for (key in commandDictionary.keySet()) {
            def spacer = key.length() > 5 ? "\t" : "\t\t"
            output += """  ${key}${spacer}|\t${commandDictionary.get(key)}\n"""
        }
        output
    }

    /**
     * Create a String of a single repeated character x amount of times used in this
     * program as a divider
     *
     * @param repeatingCharacter the character to be repeated
     * @param timesRepeated the number of times the character is to be repeated
     * @return a single line of the specified character repeated x amount of times
     */
    private String drawDivider(String symbol, int times) {
        return symbol * times
    }
}
