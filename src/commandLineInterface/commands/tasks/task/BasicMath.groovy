package commandLineInterface.commands.tasks.task

class BasicMath {

    /**
     * For the given values, add all of them together.
     *
     * @param the List of values
     * @return the sum of the given values
     */
    def add(List values) {
        values.sum()
    }

    /**
     * For the given values, subtract all values from the first value
     *
     * @param the List of values
     * @return the result from subtracting all values from the first value
     */
    def subt(List values) {
        values.inject {a,b -> a - b}
    }

    /**
     * For the given values, multiply all of them together.
     *
     * @param the List of values
     * @return the product of multiplying all values together
     */
    def mult(List values) {
        values.inject {a,b -> a * b}
    }

    /**
     * For the given values, divide all values from the first value
     *
     * @param the List of values
     * @return the quotient after dividing all values
     */
    def divide(List values) {
        values.inject {a,b -> a / b}
    }
}
