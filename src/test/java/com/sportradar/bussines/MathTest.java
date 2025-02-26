package com.sportradar.bussines;

import com.sportradar.domain.Match;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathTest {
    private Match match;

    @BeforeEach
    public void setUp() {
        match = new Match("Mexico", "Canada");
    }

    @Test
    public void testUpdateScore() {
        match.updateScore(1, 2);
        assertEquals(1, match.getHomeTeamScore());
        assertEquals(2, match.getAwayTeamScore());
    }
}
