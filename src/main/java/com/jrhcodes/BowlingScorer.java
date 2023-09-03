package com.jrhcodes;

public class BowlingScorer {

    private static int bowlScore(char digit) { return  (digit=='-') ? 0 : digit - '0';}
    private static char getBowl(String frame, int index) { return frame.charAt(index);}


    public static int scoreBlowing(String scoresheet) {

        String[] frames= scoresheet.split(" ");

        int returnValue = 0;

        for(int frame = 0; frame < 10; frame ++ ) {
            String thisFrame = frames[frame];
            if (thisFrame.equals("X")) {
                final char nextBowl = getBowl(frames[frame + 1], 0);
                if (nextBowl == 'X') {
                    final char bowlAfterThat = getBowl(frames[frame + 2], 0);
                    if (bowlAfterThat == 'X') {
                        returnValue += 30;
                    } else {
                        returnValue += 20 + bowlScore(bowlAfterThat);
                    }
                } else {
                    final char bowlAfterThat = getBowl(frames[frame + 1], 0);
                    if (bowlAfterThat == '/') {
                        returnValue += 20;
                    } else {
                        returnValue += 10 + bowlScore(nextBowl) + bowlScore(bowlAfterThat);
                    }
                }
            } else if (getBowl(thisFrame, 1) == '/') { // spare
                final char nextBowl = getBowl(frames[frame + 1], 0);
                if (nextBowl == 'X') {
                    returnValue += 20;
                } else {
                    returnValue += 10 + bowlScore(nextBowl);
                }
            } else {
                returnValue += bowlScore(getBowl(thisFrame, 0)) + bowlScore(getBowl(thisFrame, 1));
            }
        }

        return returnValue;
    }

}