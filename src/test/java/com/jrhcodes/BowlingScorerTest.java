package com.jrhcodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import com.jrhcodes.BowlingScorer.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingScorerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "scoresheetExpected.csv")
    public static void testScoreBowlingVsExpectedScores( String scoresheet, int expectedScore ) {
        assertEquals(BowlingScorer.scoreBlowing(scoresheet), expectedScore);
    }
}
