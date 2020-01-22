import React from "react";
import { connect } from "react-redux";
import "./statistics.css";
const Statistics = props => {
  // console.log(props.attemptList);

  let renderList = <span>Loading ... </span>;
  if (!props.attemptList) {
    renderList = props.attemptList.map((item, index) => {
      return (
        <tr key={index}>
          <td>{item.localDateTime}</td>
          <td>{item.question}</td>
          <td>{item.answer}</td>
          <td>{item.correctAnswer}</td>
        </tr>
      );
    });
  }

  return (
    <div className="Statistics">
      <h1>Game Stats </h1>
      <table>
        <thead>
          <tr>
            <th style={{ width: "8%" }}>Username</th>
            <th style={{ width: "11%" }}>Total Score</th>
            <th style={{ width: "11%" }}>Badge</th>
          </tr>
        </thead>
        <tbody>{renderList}</tbody>
      </table>
    </div>
  );
};

const mapStateToProps = state => {
  return {
    attemptList: state.attemptList
  };
};

export default connect(mapStateToProps, null)(Statistics);
