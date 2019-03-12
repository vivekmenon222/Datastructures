package com.company;

/**
 *
 */
public class KmpMatcher {

    public int findPattern(String text, String pattern)
    {
        if(pattern==null || pattern.length()==0)
        {
            return 0;
        }

        int[] positions=new int[pattern.length()];
        generatePrefixTable(pattern,positions);

        return match(text,pattern,positions);
    }

    private int match(String text, String pattern,int[] positions)
    {
        int strPtr=0;
        int patternPtr=0;
        int patternEndIdx=pattern.length()-1;

        while(strPtr<text.length())
        {
            if(text.charAt(strPtr)==pattern.charAt(patternPtr))
            {
                if(patternPtr==patternEndIdx)
                {
                    return (strPtr-patternPtr);
                }
                strPtr++;
                patternPtr++;
            }
            else
            {
                if(patternPtr!=0)
                {
                    patternPtr=positions[patternPtr-1];
                }
                else
                {
                    strPtr++;
                }

            }



        }

        return -1;

    }

    private void generatePrefixTable(String pattern, int[] positions)
    {
        int i=0;
        int j=1;

        while(j<pattern.length())
        {
            if(pattern.charAt(i)==pattern.charAt(j))
            {
                positions[j]=(i+1);
                i++;
                j++;

            }
            else
            {
                if(i>0)
                {
                    i=positions[i-1];
                }
                else {
                    j++;
                }
            }

        }

    }
}
