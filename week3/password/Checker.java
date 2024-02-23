package ss.week3.password;

public interface Checker {



    /**Default implementation
     * @require suggestion.length() >= 6 && !suggestion.contains(" ")
     * @return true if input is acceptable, false if input is not acceptable*/
    default boolean acceptable(String suggestion) {
        return (suggestion.length() >= 6) && (!suggestion.contains(" "));
    }

    /**Generates password that meets requirements of acceptable()
     * @return acceptable String password
     * @ensure acceptable(String suggestion)*/
    String generatePassword();

}
