package com.jrhcodes;

public class BowlingScorer {

    private static int bowlScore(char digit) { return  (digit=='-') ? 0 : digit - '0';}
    private static char getBowl(String frame, int index) { return frame.charAt(index);}

    private static boolean isStrike( String frame) {return frame.equals("X");};
    private static boolean isStrike( char bowl ) {return bowl == 'X';};
    private static boolean isSpare( char bowl ) {return bowl == '/';};

    public static int scoreBlowing(String scoresheet) {

        String[] frames= scoresheet.split(" ");

        int returnValue = 0;

        for(int frame = 0; frame < 10; frame ++ ) {
            String thisFrame = frames[frame];
            if (isStrike(thisFrame)) {
                final char nextBowl = getBowl(frames[frame + 1], 0);
                if (isStrike(nextBowl) ) {
                    final char bowlAfterThat = getBowl(frames[frame + 2], 0);
                    if (isStrike(bowlAfterThat)) {
                        returnValue += 30;
                    } else {
                        returnValue += 20 + bowlScore(bowlAfterThat);
                    }
                } else {
                    final char bowlAfterThat = getBowl(frames[frame + 1], 0);
                    if (isSpare(bowlAfterThat)) {
                        returnValue += 20;
                    } else {
                        returnValue += 10 + bowlScore(nextBowl) + bowlScore(bowlAfterThat);
                    }
                }
            } else if (isSpare(getBowl(thisFrame, 1))) { // spare
                final char nextBowl = getBowl(frames[frame + 1], 0);
                if (isStrike(nextBowl)) {
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