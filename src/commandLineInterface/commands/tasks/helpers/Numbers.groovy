package commandLineInterface.commands.tasks.helpers

class Numbers {

    /*
   If the supplied numbers are numeric and all are
   valid ints (no doubles), then this variable will
   hold all those values after they are casted as ints
    */
    private List intValues

    /*
    If the supplied numbers are numeric and any are
    valid doubles, then this variable will hold all
    those values after they are casted as doubles
    */
    private List doubleValues

    /*
    The initial list of String before it is determined
    if they are valid numbers or not
     */
    final List unconvertedNumber

    /**
     * Take in an array of Strings to be analyzed if they are
     * valid numbers or not
     *
     * @param unconvertedNumbers the String to be analyzed
     */
    public Numbers(List unconvertedNumbers) {
        this.intValues = null
        this.doubleValues = null
        this.unconvertedNumber = unconvertedNumbers
    }

    /**
     * Cast the Strings as ints and return those values as an array.
     * If any Strings cannot be casted as an int; array is null.
     *
     * @return the Strings casted as ints; null if any exceptions
     */
    List getIntValues() {
        makeInteger()
        intValues
    }

    /**
     * Cast the Strings as doubles and return those values as an array.
     * If any Strings cannot be casted as an double; array is null.
     *
     * @return the Strings casted as doubles; null if any exceptions
     */
    List getDoubleValues() {
        makeDouble()
        doubleValues
    }

    /**
     * Examines each value within the supplied String array to see if
     * they are all valid numeric values.
     *
     * @return true if all values are valid numeric values; false otherwise
     */
    boolean areNumeric() {

        def isActuallyNumeric = true

        for (eachValue in unconvertedNumber) {
            if(!isValidInteger(eachValue) && !isValidDouble(eachValue)) {
                isActuallyNumeric =  false
            }
        }
        isActuallyNumeric
    }

    /**
     * Examines each value within the supplied String array to see if
     * all values are valid ints. This is needed to see if after the Strings
     * are validated as numeric, if we can cast them as ints or doubles.
     *
     * @return true if all values are valid ints; false otherwise
     */
    boolean canBeInteger() {

        def areAllIntegers = true

        for (eachValue in this.unconvertedNumber) {
            if(!isValidInteger(eachValue)) {
                areAllIntegers = false;
            }
        }
        areAllIntegers
    }

    /**
     * Tests a single String to determine if it is a valid int or not
     *
     * @param possibleInteger the String to be tested
     * @return true if a valid int; false otherwise
     */
    private boolean isValidInteger(String possibleInteger) {
        hasNoLeadingZeros(possibleInteger) && possibleInteger.matches("[-+]?[0-9]+")
    }

    /**
     * Tests a single String to determine if it as a valid double or not
     *
     * @param possibleDouble the String to be tested
     * @return true if a valid double; false otherwise
     */
    private boolean isValidDouble(String possibleDouble) {
        hasNoLeadingZeros(possibleDouble) && possibleDouble.matches("[-+]?[0-9]*\\.?[0-9]+")
    }

    ////////////////////////////////////////////////////////////////////////////////
    /*

    This next group of booleans all deal with determining if there are leading zeros
    within the string. Leading zeros, for example, are '09' or '0.3'.  In the case of
    '09' they make the number invalid, where with '0.3', they are perfectly fine.

     */
    ////////////////////////////////////////////////////////////////////////////////

    /**
     * Tests to see if a String has any leading zeros or not. For example, a leading
     * zero is '09' or '0.3'.  It is invalid in the case of '09', but valid in the case
     * of '0.3'.
     *
     * @param possibleNumber the String to be tested
     * @return true if the String has no leading zeros, or if it has valid leading zero; false if it
     *          has an invalid leading zero
     */
    private boolean hasNoLeadingZeros(String possibleNumber) {
        couldHaveLeadingZeros(possibleNumber) ? checkForLeadingZeros(possibleNumber) : true
    }

    /**
     * Tests if there is the possibility of a leading zero. Any String with the first character
     * of '0' or '-' will need further testing.
     *
     * @param numInQuestion the String to be tested
     * @return true if the String is longer that 1 character and the first character is '0' or '-';
     *          false othewise
     */
    private boolean couldHaveLeadingZeros(String numInQuestion) {
        numInQuestion.length() > 1 && numInQuestion.charAt(0) == '0' || numInQuestion.charAt(0) == '-'
    }

    /**
     * Based on if the number if positive or negative, check the String for invalid leading zeros.
     *
     * @param number the String to be tested
     * @return true if the String has a valid leading zero; false otherwise
     */
    private boolean checkForLeadingZeros(String number) {
        isNegativeNumber(number) ? this.negativeValidation(number) : this.positiveValidation(number)
    }

    /**
     * Tests negative numbers for leading zeros
     *
     * @param possibleNumber the String to be tested
     * @return true if the leading zero is valid; false otherwise
     */
    private boolean negativeValidation(String possibleNumber) {
        this.isValid(possibleNumber, 1)
    }

    /**
     * Tests positive numbers for leading zeros
     *
     * @param possibleNumber the String to be tested
     * @return true if the leading zero is valid; false otherwise
     */
    private boolean positiveValidation(String possibleNumber) {
        this.isValid(possibleNumber, 0)
    }

    /**
     * To aid in readability, determines if a number is negative or not
     *
     * @param possibleNumber the String to be tested
     * @return true if the number is negative; false if positive
     */
    private boolean isNegativeNumber(String possibleNumber) {
        possibleNumber.charAt(0) == '-'
    }

    /**
     * Checks the string if the character after a zero is '.'. If not, then the leading
     * zero is invalid.
     *
     * @param possibleNumber the String to be tested
     * @param startOffset where to start checking. If the number is positive, start at character 0,
     *                    if the number is negative, start at character 1.
     * @return true if the leading zero is valid; false otherwise
     */
    private boolean isValid(String possibleNumber, int startOffset) {
        possibleNumber.charAt(0 + startOffset) == '0' ? possibleNumber.charAt(1 + startOffset) == '.' : true
    }

    ///// End leading zero section ///////

    /**
     * If all the values within the String array are numeric and ints, cast
     * each value as an int and place it in our intValues array
     */
    void makeInteger() {
        if (areNumeric() && canBeInteger()) {

            intValues = []

            for (value in this.unconvertedNumber) {
                this.intValues.add(Integer.parseInt(value));
            }
        }
    }

    /**
     * If all the values within the String array are numeric, cast
     * each value as an double and place it in our doubleValues array
     */
    void makeDouble() {
        if (this.areNumeric()) {

            this.doubleValues = [];

            for (value in this.unconvertedNumber) {
                this.doubleValues.add(Double.parseDouble(value));
            }
        }
    }
}
