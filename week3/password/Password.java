package ss.week3.password;

public class Password  {

    private String currentPass;

    //were static first
    private Checker checker;
    private String factoryPassword;



    /*3.6 instance variable checker (of type Checker) and an instance variable
    factoryPassword(of type String), with appropriate queries (getChecker()and getFactoryPassword()).*/
    //was static
    public Checker getChecker() {
        return checker;
    }


    //was static
    public String getFactoryPassword() {
        return factoryPassword;
    }

    //    private final int lengthRestriction = 6;
//    private final String charactersRestriction = " ";



    /***3.6  The ﬁrst constructor receives a Checker as parameter and sets checker and factoryPassword to an
     appropriate value.*/
    public Password(Checker checker) {
        this.checker = checker;
        this.factoryPassword = checker.generatePassword();
        currentPass = factoryPassword;
    }
    /**3.6  The second constructor has no parameters. It sets the checker by creating a BasicChecker object
     and calling the ﬁrst constructor with this object as parameter.*/

    // calls the Password(Checker checker) constructor in case there's no checker yet
    public Password() {
        this(new BasicChecker());
    }



    /**Test if a given string is an acceptable password.
     Not acceptable: A word with less than 6 characters
     or a word that contains a space.
     @param suggestion - Word that should be tested
     @return true if suggestion is acceptable
     @ensure returns true if the suggestion has at least 6 characters and no spaces
     */

    public boolean acceptable(String suggestion) {
        return checker.acceptable(suggestion);
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
