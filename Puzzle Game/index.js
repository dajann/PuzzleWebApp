const statusDisplay = document.querySelector(".game--status");
let gameActive = true;
handleRestartGame();

const winningMessage = `You won!`;

function display(array) {
  let cells = document.querySelectorAll(".cell");
  for (let i = 0; i < cells.length; i++) {
    let cell = cells[i];
    if (array[i] === 0) {
      cell.innerHTML = "";
    } else {
      cell.innerHTML = array[i].toString();
    }
  }
  fetch("http://localhost:8080/end")
    .then((response) => {
      return response.json(); // convert response to JSON format
    })
    .then((response) => {
      if (response) {
        document.querySelector(".game--title").innerHTML = winningMessage;
        gameActive = false;
      }
    })
    .catch((error) => {
      // Handle any errors
      console.error(error);
    });
}
function handleCellPlayed(clickedCell, clickedCellIndex) {
  const buttonToUpdate = clickedCellIndex;

  fetch("http://localhost:8080/update", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ x: buttonToUpdate }),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Network response was not ok");
      }
    })
    .then((resultArray) => {
      display(resultArray);
    })
    .catch((error) => {
      console.error("There was a problem with the fetch operation:", error);
    });
}

function handleCellClick(clickedCellEvent) {
  if (gameActive) {
    const clickedCell = clickedCellEvent.target;
    const clickedCellIndex = parseInt(
      clickedCell.getAttribute("data-cell-index")
    );
    handleCellPlayed(clickedCell, clickedCellIndex);
  }
}

function handleRestartGame() {
  gameActive = true;
  fetch("http://localhost:8080/restart")
    .then((response) => {
      return response.json(); // convert response to JSON format
    })
    .then((response) => {
      display(response);
    })
    .catch((error) => {
      // Handle any errors
      console.error(error);
    });
}

document
  .querySelectorAll(".cell")
  .forEach((cell) => cell.addEventListener("click", handleCellClick));
document
  .querySelector(".game--restart")
  .addEventListener("click", handleRestartGame);
