
let score = [{cs:0, ss:0}, {cs:0 , ss:0}]

let current = 1;
let target = 100;

turnChange();

let player1_name = prompt("Enter player 1 name");
let player2_name = prompt("Enter player 2 name");

document.getElementById("player1-name").innerHTML = player1_name;
document.getElementById("player2-name").innerHTML = player2_name;

function rollDice() {
    if(score[0].ss>=target || score[1].ss>=target)return;
    let Roll = Math.floor(Math.random() * 6) + 1;
    // document.getElementById('dice').src = `png`;
    document.getElementById("rolled_number").innerHTML = Roll;
    
    if (Roll == 1) {
        score[current].cs = 0;
        turnChange();
    } 
    else {
        score[current].cs += Roll;
    }
    changeScore();
  }

function saveScore(){
  
  score[current].ss += score[current].cs;
  score[current].cs = 0;
  
  changeScore();
  
  
  
  if(score[current].ss >= target){
    document.getElementById("winner_window").innerHTML = `${current?player2_name:player1_name} Wins`;
    document.getElementById("footer2").innerHTML = "Game over";
    document.getElementById("footer1").innerHTML = `Game over`;
    return;
  }
  turnChange();
  
}

function turnChange(){
  current = current?0:1;
  
  if(score[0].ss>=target || score[1].ss>=target)return;
  if(current){
    document.getElementById("footer2").innerHTML = "Your Turn";
    document.getElementById("footer1").innerHTML = ``;
  }
  else{
    document.getElementById("footer1").innerHTML = `Your Turn`;
    document.getElementById("footer2").innerHTML = "";
    
  }
  
  
  
}

function changeScore(){
  document.getElementById("p1cs").innerHTML = score[0].cs;
  document.getElementById("p2cs").innerHTML = score[1].cs;
  document.getElementById("p1ss").innerHTML = score[0].ss;
  document.getElementById("p2ss").innerHTML = score[1].ss;
}
function resetGame(){
  score[0].cs = 0;
  score[1].cs = 0;
  score[0].ss = 0;
  score[1].ss = 0;
  changeScore();
  
  document.getElementById("winner_window").innerHTML = `Game Reset`;
  
  
}

