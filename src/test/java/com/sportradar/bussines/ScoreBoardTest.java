package com.sportradar.bussines;

import com.sportradar.domain.Match;
import com.sportradar.domain.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {
    private ScoreBoard scoreBoard;

    @BeforeEach
    public void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void testStartMatch() {
        scoreBoard.startMatch("Mexico", "Canada");

        List<Match> matches = scoreBoard.getSummary();
        assertEquals(1, matches.size());

        Match match = matches.get(0);
        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
    }

    @Test
    public void testUpdateScore() {
        scoreBoard.startMatch("Mexico", "Canada");

        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        List<Match> matches = scoreBoard.getSummary();
        Match match = matches.get(0);
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(5, match.getAwayTeamScore());
    }

    @Test
    public void testFinishMatch() {
        scoreBoard.startMatch("Mexico", "Canada");

        scoreBoard.finishMatch();

        List<Match> matches = scoreBoard.getSummary();
        assertEquals(0, matches.size());
    }

    @Test
    public void testGetSummary() {
        scoreBoard.startMatch("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        scoreBoard.startMatch("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);

        scoreBoard.startMatch("Germany", "France");
        scoreBoard.updateScore("Germany", "France", 2, 2);

        scoreBoard.startMatch("Uruguay", "Italy");
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);

        scoreBoard.startMatch("Argentina", "Australia");
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<Match> summary = scoreBoard.getSummary();
        assertEquals("Uruguay 6 - Italy 6", scoreBoard.getMatchInfo(summary.get(0)));
        assertEquals("Spain 10 - Brazil 2", scoreBoard.getMatchInfo(summary.get(1)));
        assertEquals("Mexico 0 - Canada 5", scoreBoard.getMatchInfo(summary.get(2)));
        assertEquals("Argentina 3 - Australia 1", scoreBoard.getMatchInfo(summary.get(3)));
        assertEquals("Germany 2 - France 2", scoreBoard.getMatchInfo(summary.get(4)));
    }
}
