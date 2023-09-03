package com.jrhcodes;

import com.jrhcodes.BowlingScorer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingScorerTest {


    @ParameterizedTest
    @CsvFileSource(resources = "scoresheetExpected.csv")
    public void testScoreBowlingVsExpectedScores(String scoresheet, int expectedScore) {
        assertEquals(BowlingScorer.scoreBlowing(scoresheet), expectedScore);
    }
}
