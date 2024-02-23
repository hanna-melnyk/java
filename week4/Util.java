package ss.week4;

import java.util.ArrayList;
import java.util.List;
//import java.lang.String;

public class Util {

    public static <E> List<E> zip  (List<E> l1, List<E> l2) {
        ArrayList<E> result = new ArrayList<>();

        for (int i = 0; i < l1.size(); i++) {
            result.add(l1.get(i));
            result.add(l2.get(i));
        }
        return result;

    }

    /**
     * signum function
     * 
     * @param i
     *            the function argument
     * @return -1, 0 or 1 if the argument is negative, 0 or positive
     */
    public static int signum(int i) {
        if (i < 0) {
            return -1;
        }
        else if (i > 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /*Checkstyle errors:
    * Checkstyle found 28 item(s) in 1 file(s)
Util.java : 28 item(s)
Wrong lexicographical order for 'java.lang.String' import. Should be before 'java.util.List'. (5:1) [CustomImportOrder]
Missing a Javadoc comment. (7:1) [MissingJavadocType]
'method def modifier' has incorrect indentation level 4, expected level should be 2. (9:5) [Indentation]
Missing a Javadoc comment. (9:5) [MissingJavadocMethod]
Method type name 'Element' must match pattern '(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)'. (9:20) [MethodTypeParameterName]
'method def lparen' has incorrect indentation level 12, expected level should be 2. (10:13) [Indentation]
'(' should be on the previous line. (10:13) [MethodParamPad]
'method def' child has incorrect indentation level 8, expected level should be 4. (11:9) [Indentation]
Abbreviation in name 'RESULT' must contain no more than '1' consecutive capital letters. (11:28) [AbbreviationAsWordInName]
Local variable name 'RESULT' must match pattern '^[a-z]([a-z0-9][a-zA-Z0-9]*)?$'. (11:28) [LocalVariableName]
'for' has incorrect indentation level 8, expected level should be 4. (12:9) [Indentation]
'for' child has incorrect indentation level 12, expected level should be 6. (13:13) [Indentation]
'for' child has incorrect indentation level 12, expected level should be 6. (14:13) [Indentation]
'for rcurly' has incorrect indentation level 8, expected level should be 4. (15:9) [Indentation]
'method def' child has incorrect indentation level 8, expected level should be 4. (16:9) [Indentation]
'method def rcurly' has incorrect indentation level 4, expected level should be 2. (17:5) [Indentation]
First sentence of Javadoc is missing an ending period. (19:0) [SummaryJavadoc]
Javadoc tag '@param' should be preceded with an empty line. (22:0) [RequireEmptyLineBeforeBlockTagGroup]
'method def modifier' has incorrect indentation level 4, expected level should be 2. (26:5) [Indentation]
'if' construct must use '{}'s. (27:9) [NeedBraces]
'if' has incorrect indentation level 8, expected level should be 4. (27:9) [Indentation]
'if' is not followed by whitespace. (27:9) [WhitespaceAfter]
WhitespaceAround: 'if' is not followed by whitespace. Empty blocks                may only be represented as {} when not part of a multi-block statement (4.1.3) (27:9) [WhitespaceAround]
'else' has incorrect indentation level 8, expected level should be 4. (29:9) [Indentation]
'if' construct must use '{}'s. (29:14) [NeedBraces]
'else' construct must use '{}'s. (31:9) [NeedBraces]
'else' has incorrect indentation level 8, expected level should be 4. (31:9) [Indentation]
'method def rcurly' has incorrect indentation level 4, expected level should be 2. (33:5) [Indentation]*/
}
