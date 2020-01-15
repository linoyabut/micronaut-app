import React from "react";
import "./medaltally.css";
const MedalTally = () => {
  return (
    <div className="MedalTally">
      <h1>Attempts</h1>
      <table>
        <thead style = {{width: '50%'}}>
          <tr>
            <th style = {{width: '30%'}}>Date</th>
            <th>Question</th>
            <th>Answer</th>
            <th>Correct</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>02-01-2020</td>
            <td>Who is the president of the USA?</td>
            <td>Trump</td>
            <td>True</td>
          </tr>
          <tr>
            <td>02-01-2020</td>
            <td>What is the real name of Superman?</td>
            <td>Clark Kent</td>
            <td>True</td>
          </tr>
          <tr>
            <td>02-01-2020</td>
            <td>Who is the founder of Microsoft?</td>
            <td>Bill Gates</td>
            <td>True</td>
          </tr>
          <tr>
            <td>02-01-2020</td>
            <td>Who is the founder of Apple Inc?</td>
            <td>Steve Jobs</td>
            <td>True</td>
          </tr>
          <tr>
            <td>02-01-2020</td>
            <td>What's the real name of Batman?</td>
            <td>Bruce Wayne</td>
            <td>True</td>
          </tr>
          <tr>
            <td>02-01-2020</td>
            <td>What's the real name of Spiderman?</td>
            <td>Peter Parker</td>
            <td>False</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default MedalTally;
