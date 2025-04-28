const textfield = document.getElementById("textInput");
const charCheckbox = document.getElementById("charsCheckbox");
const wordsCheckbox = document.getElementById("wordsCheckbox");
const emptyLinesCheckbox = document.getElementById("emptyLinesCheckbox");
const spaceCheckbox = document.getElementById("spaceCheckbox");

const countButton = document.getElementById("calculateButton");

const wordsResult = document.getElementById("wordsResult");
const charsResult = document.getElementById("charsResult");
const emptyLinesResult = document.getElementById("emptyLinesResult");
const spacesResult = document.getElementById("spacesResult");

countButton.onclick = function (){
let input = textfield.value;
    // count all words
    if (wordsCheckbox.checked) {
       let wordCount = input.trim().split(/\s+/).filter(word => word.length > 0).length; // Zähle die Wörter
        //console.log("2: Wörteranzahl: " + wordCount);
        wordsResult.textContent = "Wörter gesamt: " + wordCount;
    }
    else{
        wordsResult.textContent ="Wörter nicht gezählt";
    }

    // count all chars
    if (charCheckbox.checked) {
        let charCount = (input.match(/[^\n\t ]/g) || []).length; // Zähle alle Zeichen außer \n, \t und Leerzeichen
        //console.log("1: Zeichenanzahl: " + charCount);
        charsResult.textContent = "Zeichen gesamt: " + charCount;
    }
    else{
        charsResult.textContent ="Zeichen nicht gezählt";
    }
    // count all empty lines
    if (emptyLinesCheckbox.checked) {
        let emptyLineCount = input.split('\n').filter(line => line.trim().length === 0).length; // Zähle nur echte leere Zeilen
        if(input.length === 0){
            emptyLineCount = 0;
        }
        //console.log("3: Leere Zeilen: " + emptyLineCount);
        emptyLinesResult.textContent = "Leere Zeilen: " + emptyLineCount;
    }
    else{
        emptyLinesResult.textContent ="Leere Zeilen nicht gezählt";
    }
    // count all spaces
    if (spaceCheckbox.checked) {
        let spaceCount = (input.match(/ /g) || []).length; // Zähle die Leerzeichen
        //console.log("4: Leerzeichenanzahl: " + spaceCount);
        spacesResult.textContent = "Leerzeichen: " + spaceCount;
    }
    else{
        spacesResult.textContent = "Leerzeichen nicht gezählt";
    }

}





