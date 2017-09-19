package commandLineInterface.commands.tasks.task

class FunWithStrings {

    def length(String words) {
        words.length().toString()
    }

    def shout(String words) {
        words.toUpperCase()
    }

    def whistper(String words) {
        words.toLowerCase()
    }

    def reverse(String words) {
        words.reverse()
    }
}
