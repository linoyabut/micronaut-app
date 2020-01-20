// generating randomQuestions
const randomQuestion = async () => {
  let response = await fetch("http://localhost:8080/questions");
  let data = await response.json();

  const newData = {
    ...data,
    choices: data.choices.split("|"),
    choices1: data.choices
  };

  //console.log(JSON.stringify(newData) + "new Data");

  return newData;
};

// getting all the gamestats 
const getGameStats = async userId => {
  const gameStats = await fetch(
    `http://localhost:5000/scorecard/gamestats/${userId}`
  );

  return gameStats;
};

// submitting answer to back-end
const postResult = payLoad => {
  fetch("http://localhost:8080/results", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(payLoad)
  })
    .then(response => response.json()) // => problem causing inability to save data into database
    .then(data => {console.log(data)})
    .catch(err => {
      console.log(err);
    });
};

// getting all the user's responses 
const getUserResponse = async name => {
  const responses = await fetch(`http://localhost:8080/results/users/${name}`);
  return responses.json();

};

//getting all the user's highscores 
const highScores = () => {
    const scores = [];
 return fetch(`http://localhost:5000/scorecard/leaderboard`,
  {
    method: "GET",
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json',
  },
}
  )
   .then(response =>  response.json())
   .then(response => {
    console.log(response + "data highscores")
    // scores.push(data);
    return response;
       });

  
 // console.log(scores + "scores array");
  // return scores;
}

export { randomQuestion, getGameStats, postResult, getUserResponse, highScores };
