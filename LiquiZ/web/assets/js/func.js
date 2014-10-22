/*
 *This is file is for javascript
 */
 
 
/*
 *warning pattern
 */
function showNumberWarning(id,n) {
    var x = $("#"+id).val();
    $("#FW"+id).empty();
    
    eval("var pattern = /[0-9]+.[0-9]{"+n+"}/;");
  
    if (x.match(pattern)==null){
        $("#FW"+id).append("Wrong input!");
    } 
}

function changeQuestion(obj) {
    if (obj.value=="FillIn") {
        document.getElementById("fillin_attribute").style.display="";
        document.getElementById("multichoice_attribute").style.display="none";
    }else{
        document.getElementById("fillin_attribute").style.display="none";
        document.getElementById("multichoice_attribute").style.display="";
    }
}

function showWarningPatternAttribute(obj) {
    if (obj.checked) {
        document.getElementById("warningPattern_attribute").style.display="";
    }else{
        document.getElementById("warningPattern_attribute").style.display="none";
    }
}

function showRegexQuestionAttribute(obj) {
    if (obj.checked) {
        document.getElementById("regexQuestion_attribute").style.display="";
    }else{
        document.getElementById("regexQuestion_attribute").style.display="none";
    }
}

function showNumberQuestionAttribute(obj) {
    if (obj.checked) {
        document.getElementById("numberQuestion_attribute").style.display="";
    }else{
        document.getElementById("numberQuestion_attribute").style.display="none";
    }
}

function createChoices(obj) {
    var empty="";
    document.getElementById("choices").innerHTML=empty;
    for (var i=0;i<obj.value;i++) {
        empty+="Choices"+(i+1)+"&nbsp&nbsp<input type=\"text\" name=\"choices"+(i+1)+"\"></br>";
    }
    document.getElementById("choices").innerHTML=empty;
}

function setColor(obj) {
    if (obj.value=="default") {
        document.getElementById("title").className="defaultColor";
        document.getElementById("level").className="defaultColor";
        document.getElementById("points").className="defaultColor";
        document.getElementById("answer").className="defaultColor";
      //  document.getElementById("warningPattern").className="defaultColor";
        document.getElementById("warningPatternLimit").className="defaultColor";
      //  document.getElementById("regex").className="defaultColor";
        document.getElementById("regexString").className="defaultColor";
       // document.getElementById("number").className="defaultColor";
        document.getElementById("NumberQuestion_ExactNumber").className="defaultColor";
        document.getElementById("NumberQuestion_Approximate").className="defaultColor";
        document.getElementById("multichoice_number").className="defaultColor";
    }
    else if (obj.value=="red") {
        document.getElementById("title").className="red";
        document.getElementById("level").className="red";
        document.getElementById("points").className="red";
        document.getElementById("answer").className="red";
       // document.getElementById("warningPattern").className="red";
        document.getElementById("warningPatternLimit").className="red";
       // document.getElementById("regex").className="red";
        document.getElementById("regexString").className="red";
       // document.getElementById("number").className="red";
        document.getElementById("NumberQuestion_ExactNumber").className="red";
        document.getElementById("NumberQuestion_Approximate").className="red";
        document.getElementById("multichoice_number").className="red";
    }
    else if (obj.value=="blue") {
        document.getElementById("title").className="blue";
        document.getElementById("level").className="blue";
        document.getElementById("points").className="blue";
        document.getElementById("answer").className="blue";
      //  document.getElementById("warningPattern").className="blue";
        document.getElementById("warningPatternLimit").className="blue";
      //  document.getElementById("regex").className="blue";
        document.getElementById("regexString").className="blue";
       // document.getElementById("number").className="blue";
        document.getElementById("NumberQuestion_ExactNumber").className="blue";
        document.getElementById("NumberQuestion_Approximate").className="blue";
        document.getElementById("multichoice_number").className="blue";
    }
    else if (obj.value=="green") {
        document.getElementById("title").className="green";
        document.getElementById("level").className="green";
        document.getElementById("points").className="green";
        document.getElementById("answer").className="green";
     //   document.getElementById("warningPattern").className="green";
        document.getElementById("warningPatternLimit").className="green";
       // document.getElementById("regex").className="green";
        document.getElementById("regexString").className="green";
        //document.getElementById("number").className="green";
        document.getElementById("NumberQuestion_ExactNumber").className="green";
        document.getElementById("NumberQuestion_Approximate").className="green";
        document.getElementById("multichoice_number").className="green";
    }
}