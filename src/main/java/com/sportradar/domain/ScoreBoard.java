package com.sportradar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard {
    private final List<Match> matches = new ArrayList<>();

    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam));
    }

    public void finishMatch() {
        if (!matches.isEmpty()) {
            matches.remove(matches.size() - 1);
        }
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.updateScore(homeScore, awayScore);
                return;
            }
        }
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator
                        .comparingInt(Match::getTotalScore)
                        .thenComparingInt(matches::indexOf).reversed())
                .toList();
    }

    public String getMatchInfo(Match match) {
        return match.getHomeTeam() + " " + match.getHomeTeamScore() + " - " + match.getAwayTeam() + " " + match.getAwayTeamScore();
    }
}
