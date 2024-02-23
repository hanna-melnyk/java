package ss.week3.password;


public class StrongChecker extends BasicChecker {
    @Override
    public boolean acceptable(String suggestion){
        boolean basicCheckPassed = super.acceptable(suggestion);

        char firstCh = suggestion.charAt(0);
        char lastCh = suggestion.charAt(suggestion.length()-1);
        boolean startsWLetter;
        boolean endsWDigit;
        startsWLetter = Character.isLetter(firstCh);
        endsWDigit = Character.isDigit(lastCh);

        return basicCheckPassed && startsWLetter && endsWDigit;

    }

    @Override
    public String generatePassword() {
        return "generatedPassword0";
    }
}
