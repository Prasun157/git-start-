
let score=0;
let current_question=0;
let quiz_questions=[];
let Question_amout=10;
let timetime;
let options=[];

function startQuiz(){
    document.getElementById("start-page").classList.add("hidden");
    document.getElementById("quiz-page").classList.remove("hidden");
    document.getElementById("end-page").classList.add("hidden");

    let category = document.getElementById("category").value ; 
    let difficulty_num = document.getElementById("difficulty").value;
    let difficulty = difficulty_num == 1 ? "easy" : (difficulty_num == 2 ? "medium" :"hard" );

    document.getElementById("selected_category_difficulty").innerHTML =` Difficulty: ${difficulty}`;
   
    //fetch from API

    async function getData() {
        try {
            let response = await fetch(`https://opentdb.com/api.php?amount=${Question_amout}&category=${category}&difficulty=${difficulty}&type=multiple`);
            let data = await response.json();
            quiz_questions=data.results;
            console.log("Working");
            loadQuiz();
        } catch (error) {
            console.error(`Server side Issue : ${error}`);
        }
    }

    getData(); 
     
}


function loadQuiz(  ){   
    
    clearInterval(timetime);

    document.getElementById("result").innerHTML=" ";
    document.getElementById('the_timer').style.color = 'white';
    document.getElementById("score_board").innerHTML = "";

    if(current_question == quiz_questions.length){
        endscreen();
    }

    let theQuestion = quiz_questions[current_question];    
    options = [...theQuestion.incorrect_answers, theQuestion.correct_answer].sort();

    document.getElementById("question").innerHTML=`Q${current_question+1}: ${theQuestion.question}`;
    document.getElementById("options").innerHTML=`<button onclick="showResult('${options[0]}','${theQuestion.correct_answer}')"> ${options[0]}</button><br>
    <button onclick = "showResult('${options[1]}','${theQuestion.correct_answer}')"> ${options[1]}</button><br>
    <button onclick = "showResult('${options[2]}','${theQuestion.correct_answer}')"> ${options[2]}</button><br>
    <button onclick = "showResult('${options[3]}','${theQuestion.correct_answer}')"> ${options[3]}</button><br>`;
    
    QuizTimer(); 
    current_question++; 

}

function QuizTimer(){
    let current_time=16;  
    
    timetime = setInterval(() => {        

        if(current_time < 7){
            document.getElementById('the_timer').style.color = '#bd1e51';
        }        
        if(current_time <= 1){
            clearInterval(timetime);  
            showResult(false , quiz_questions[current_question-1].correct_answer);  
        }
        current_time--;
        document.getElementById("the_timer").innerText=current_time;
            
    }, 1000);  

}

function showResult(clicked,right_ans){
    
    clearInterval(timetime); 
    document.getElementById("options").innerHTML=" ";

    if(clicked == right_ans){
        document.getElementById("result").innerHTML =  "Correct!!!";
        document.getElementById("result").style.color = "cyan" ;
        score++;
    }
    else if(clicked==false){
        document.getElementById("result").innerHTML=`Time Up!! Correct answer is ${right_ans}`;
        document.getElementById("result").style.color = '#bd1e51';
                
    }
    else{
        document.getElementById("result").innerHTML=`Wrong!! Correct answer is ${right_ans}`;
        document.getElementById("result").style.color = '#bd1e51' ;
        

    }
    document.getElementById("score_board").innerHTML = `Your Score: ${score}` ;
        
    
    setTimeout(loadQuiz ,3000);   

}

function endscreen(){

    document.getElementById("start-page").classList.add("hidden");
    document.getElementById("quiz-page").classList.add("hidden");
    document.getElementById("end-page").classList.remove("hidden");

    document.getElementById("final_score").innerHTML=score;


    clearInterval(timetime);

}

function restartGame() {

    current_question = 0; score = 0;
    document.getElementById("end-page").classList.add("hidden");
    document.getElementById("start-page").classList.remove("hidden");
}
			
				