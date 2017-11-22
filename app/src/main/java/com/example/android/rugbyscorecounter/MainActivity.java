package com.example.android.rugbyscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /**
     * Global variables
     */
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int teamATries = 0;
    int teamBTries = 0;
    int undoA = 0;
    int undoB = 0;
    int undoTriesA;
    int undoTriesB;
    boolean aob = true;
    boolean add1ToTryTally = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Team A methods below
     */

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Displays the given tries for Team A.
     */
    public void displayTriesTeamA(int teamATries) {
        TextView scoreView = (TextView) findViewById(R.id.try_tally_team_a);
        scoreView.setText(String.valueOf(teamATries));
    }

    /**
     * Updates the given score by 5pts and adds another Try for Team A.
     */
    public void TryA(View view) {
        aob = true;
        add1ToTryTally = true;
        undoA = scoreTeamA;
        undoTriesA = teamATries;
        scoreTeamA = scoreTeamA + 5;
        teamATries = teamATries +1;
        displayForTeamA(scoreTeamA);
        displayTriesTeamA(teamATries);
    }

    /**
     * Updates the given score by 7pts and adds another Try for Team A.
     */
    public void ConTryA(View view) {
        aob = true;
        add1ToTryTally = true;
        undoA = scoreTeamA;
        undoTriesA = teamATries;
        scoreTeamA = scoreTeamA + 7;
        teamATries = teamATries +1;
        displayForTeamA(scoreTeamA);
        displayTriesTeamA(teamATries);
    }

    /**
     * Updates the given score by 3pts for Team A.
     */
    public void GoalA(View view) {
        aob = true;
        add1ToTryTally = false;
        undoA = scoreTeamA;
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Team B methods below
      */

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Displays the given tries for Team B.
     */
    public void displayTriesTeamB(int teamBTries) {
        TextView scoreView = (TextView) findViewById(R.id.try_tally_team_b);
        scoreView.setText(String.valueOf(teamBTries));
    }

    /**
     * Updates the given score by 5pts and adds another Try for Team B.
     */
    public void TryB(View view) {
        aob = false;
        add1ToTryTally = true;
        undoB = scoreTeamB;
        undoTriesB = teamBTries;
        scoreTeamB = scoreTeamB + 5;
        teamBTries = teamBTries +1;
        displayForTeamB(scoreTeamB);
        displayTriesTeamB(teamBTries);
    }

    /**
     * Updates the given score by 7pts and adds another Try for Team B.
     */
    public void ConTryB(View view) {
        aob = false;
        add1ToTryTally = true;
        undoB = scoreTeamB;
        undoTriesB = teamBTries;
        scoreTeamB = scoreTeamB + 7;
        teamBTries = teamBTries +1;
        displayForTeamB(scoreTeamB);
        displayTriesTeamB(teamBTries);
    }

    /**
     * Updates the given score by 3pts for Team B.
     */
    public void GoalB(View view) {
        aob = false;
        add1ToTryTally = false;
        undoB = scoreTeamB;
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Method for undoing last change.
     */
    public void undo(View v) {
        if (aob == true) {
            scoreTeamA = undoA;
        }
        if (aob == false) {
            scoreTeamB = undoB;
        }
        if ((aob == true) && (add1ToTryTally == true)) {
            teamATries = undoTriesA;
        }
        if ((aob == false) && (add1ToTryTally == true)) {
            teamBTries = undoTriesB;
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayTriesTeamA(teamATries);
        displayTriesTeamB(teamBTries);
    }

    /**
     * Method for resetting scores and Try tally for both teams.
     */
    public void reset(View view) {
        undoA = 0;
        undoB = 0;
        undoTriesA = 0;
        undoTriesB = 0;
        scoreTeamA = 0;
        scoreTeamB = 0;
        teamATries = 0;
        teamBTries = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayTriesTeamA(teamATries);
        displayTriesTeamB(teamBTries);
        aob = true;
        add1ToTryTally = false;
    }

    /**
     * Method for saving data.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
        // Save the user's current game state
        savedInstanceState.putInt("StateScoreA", scoreTeamA);
        savedInstanceState.putInt("StateScoreB", scoreTeamB);
        savedInstanceState.putInt("StateTriesA", teamATries);
        savedInstanceState.putInt("StateTriesB", teamBTries);
    }

    /**
     * Method for restoring and displaying data after switching device orientation.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
        scoreTeamA = savedInstanceState.getInt("StateScoreA");
        scoreTeamB = savedInstanceState.getInt("StateScoreB");
        teamATries = savedInstanceState.getInt("StateTriesA");
        teamBTries = savedInstanceState.getInt("StateTriesB");
        }
        displayForTeamA(scoreTeamA);
        displayTriesTeamA(teamATries);
        displayForTeamB(scoreTeamB);
        displayTriesTeamB(teamBTries);
    }
}