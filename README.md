For this project, the approach used is **Test Driven Development (TDD)**, which means that we follow the TDD strategy of writing test procedures prior to writing code. The basic premise of TDD is to ensure that the code fulfills its intended purpose, contains no errors, and is easy to modify for further improvements later.

## Key Concepts

- **Tests First**: Tests are written to define the desired functionality of the system before the implementation begins.

- **Iterative Approach**: Code is developed step by step. Each portion of the code is written, and then the tests are run to verify that the addition works as expected.

## Testing Summary

The following procedures are validated to check the effectiveness of the scoreboard system.

### ScoreBoard Tests (ScoreBoardTest)

- **testStartMatch**: Ensures that a match can be started with the given teams, setting the score to 0-0.

- **testUpdateScore**: Verifies that the match’s score can be updated for both the home and away teams.

- **testFinishMatch**: Confirms that a match can be finished (deleted from the scoreboard).

- **testGetSummary**: Validates that the matches are ordered by total score, with the most recent starts breaking any ties.
