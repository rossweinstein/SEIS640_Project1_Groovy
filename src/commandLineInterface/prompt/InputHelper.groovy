package commandLineInterface.prompt

class InputHelper {

    private Scanner input = new Scanner(System.in)

    def askForString(String prompt) {
        print(prompt)
        this.input.nextLine()
    }
}
