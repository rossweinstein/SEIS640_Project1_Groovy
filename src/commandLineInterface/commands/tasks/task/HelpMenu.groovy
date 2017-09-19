package commandLineInterface.commands.tasks.task

/**
 * Created by rweinstein on 9/19/17.
 */
class HelpMenu {

    final Map<String, String> commandDictionary

    HelpMenu(Map<String, String> commandDictionary) {
        commandDictionary = commandDictionary
    }

    private String helpBanner() {
        "\n" + this.drawDivider('*', 72) + "\n" + "HELP MENU: CLI commands and their function descriptions\n"

    }

    private String header() {
        "command\t\t|\tdescription" + "\n" + this.drawDivider('-', 72)
    }

    private String helpCommandList() {

        def output

        for (key in this.commandDictionary.keySet()) {
            def spacer = key.length() > 5 ? "\t" : "\t\t"
            output += "  " + key + spacer + "|\t" + this.commandDictionary.get(key) + "\n"
        }
        output
    }


    private String drawDivider(char repeatingCharacter, int timesRepeated) {
        def output
        for (int i = 0; i < timesRepeated; i++) {
            output += repeatingCharacter
        }
        return output
    }
}
