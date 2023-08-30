package com.jrhcodes;

public class BowlingScorer {

    private static int digitToInt(char digit) { return digit - '0';}
    public static int scoreBlowing(String scoresheet) {
        String[] frames= scoresheet.split("");

      int returnValue = 0;

      for(int frame = 0; frame < 10; frame ++ ) {
          String thisFrame = frames[frame];
          if (thisFrame.equals("X")) {
              final char nextBowl = frames[frame + 1].charAt(0);
              if (nextBowl == 'X') {
                  final char bowlAfterThat = frames[frame + 2].charAt(0);
                  if (bowlAfterThat == 'X') {
                      returnValue += 30;
                  } else {
                      returnValue += 20 + digitToInt(bowlAfterThat);
                  }
              } else {
                  final char bowlAfterThat = frames[frame + 1].charAt(1);
                  if (bowlAfterThat == '/') {
                      returnValue += 20;
                  } else {
                      returnValue += 10 + digitToInt(nextBowl) + digitToInt(bowlAfterThat);
                  }
              }
          } else if (thisFrame.charAt(1) == '/') { // spare
              final char nextBowl = frames[frame + 1].charAt(0);
              if (nextBowl == 'X') {
                  returnValue += 20;
              } else {
                  returnValue += 10 + digitToInt(nextBowl);
              }
          } else {

              returnValue += digitToInt(thisFrame.charAt(0)) + digitToInt(thisFrame.charAt(1));
          }
      }

      return returnValue;
    }

}