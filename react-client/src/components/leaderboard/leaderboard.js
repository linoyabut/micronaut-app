import React from "react";
import "./leaderboard.css";
/*
Fake table that shows the leaderboard - sample 
*/

const LeaderBoard = () => {
  return (
    <div className="LeaderBoard">
      <h1>High Scores</h1>
      <table>
        <thead>
          <tr>
            <th style = {{width: '50%'}}>Username</th>
            <th style = {{width: '50%'}}>Total Score</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Sam</td>
            <td>90</td>
          </tr>
          <tr>
            <td>John</td>
            <td>50</td>
          </tr>
          <tr>
            <td>Ryan</td>
            <td>20</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default LeaderBoard;
