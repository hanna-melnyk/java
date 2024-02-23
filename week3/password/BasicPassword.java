package ss.week3.password;

public class BasicPassword {

/** the standard initial password*/
//P.3.3 - doesn't say to what value should INITIAL equal. I've put "null" String in order for it to pass the BasicPasswordTest
    public static final String INITIAL = "default";
    private String currentPass;
//    private final int lengthRestriction = 6;
//    private final String charactersRestriction = " ";

    private String test;
    /**Constructs a Password with the initial word provided in INITIAL.\
     * @ensure testWord(INITIAL) is true for each newly created BasicPassword object*/

    public BasicPassword() {
        this.currentPass = INITIAL;
    }

    /**Test if a given string is an acceptable password.
     Not acceptable: A word with less than 6 characters
     or a word that contains a space.
     @param suggestion - Word that should be tested
     @return true if suggestion is acceptable
     @ensure returns true if the suggestion has at least 6 characters and no spaces
     */

    public boolean acceptable(String suggestion) {
        if (suggestion.length() >= 6 && !suggestion.contains(" ")) {
            return true;
        }
        return false;
    }

    /**Changes this password.
     * @param oldPass - current password
     * @param newPass - new password
     * @return true if oldPass is equal to the current password and newPass is a acceptable password
     * @require oldpass != null, newpass != null
     * @ensure returns true if the old password is correct and the new one is accceptable
     * */

    public boolean setWord(String oldPass, String newPass) {
        assert oldPass != null: "Error: Old password should not equal to null";
        assert newPass != null: "Error: New password should not equal to null";
        if (oldPass.equals(currentPass) && acceptable(newPass)) {
            this.currentPass = newPass;
            return true;
        }
        return false;
    }

    /**Tests if a given word is equal to the current password.
     * @param test - word that should be tested
     * @return true if test is equal to the current password\
     * @require test != null*/
    public boolean testWord(String test) {
        assert test != null: "Error: Input password can not be null";
        return test.equals(currentPass);
    }



}
