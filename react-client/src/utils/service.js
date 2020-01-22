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


// submitting answer to back-end
const postResult =  payLoad => {
 return fetch("http://localhost:8080/results", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(payLoad)
  })
  .then((res) => res.json())
  .then((data) => data)

};

// // getting all the user's responses 
// const getUserResponse = async name => {
//   const responses = await fetch(`http://localhost:8080/results/users/${name}`);
//   return responses.json();

// };

//getting all the user's highscores 
const highScores = () => {
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
    return response;
       });
    }

//getting a user's gamestats
const getGameStats = async(userId) => {
   const response = await fetch( `http://localhost:5000/scorecard/gamestats/${userId}`,
   {
     method: "GET",
   headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
   },
 });
    // .then(response =>  response.json())
    // .then(response => {
    //  return response;
    //     });

 const json = await response.json();

return json;
     }

//getting a user's userId 
const getUserId = (userId) => {
  return fetch( `http://localhost:5000/scorecard/gamestats/${userId}`,
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
     return response;
        });
     }

export { randomQuestion, getGameStats, postResult, highScores };
