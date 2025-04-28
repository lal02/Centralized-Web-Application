const titleTF = document.getElementById("title");
const gamestudioTF = document.getElementById("gamestudio");
const platformTF = document.getElementById("platform")
const genreTF = document.getElementById("genre");
const subgenreTF =  document.getElementById("subgenre");
const bookseriesTF = document.getElementById("bookseries");

const durchgespieltRBTrue = document.getElementById("durchgespieltRB");
const durchgespieltRBFalse = document.getElementById("durchgespieltRBFalse");

const coopRBTrue = document.getElementById("coopRB");
const coopRBFalse = document.getElementById("coopRBFalse");

const pvpRBTrue = document.getElementById("pvpRB");
const pvpRBFalse = document.getElementById("pvpRBFalse");

const releasedRBTrue = document.getElementById("releasedRB");
const releasedRBFalse = document.getElementById("releasedRBFalse");


const submitButton = document.getElementById("submit");

const resultLabel = document.getElementById("resultLabel");

let title;
let gamestudio;
let platform
let genre;
let subgenre;
let bookseries;
let durchgespielt;
let coop;
let pvp;
let released;


let textFields = {titleTF,gamestudioTF,platformTF,genreTF,subgenreTF,bookseriesTF}

submitButton.onclick = function () {
    title = titleTF.value;
    gamestudio = gamestudioTF.value;
    platform = platformTF.value;
    genre = genreTF.value;
    subgenre = subgenreTF.value;
    bookseries = bookseriesTF.value;
    durchgespielt = durchgespieltRBTrue.checked && !durchgespieltRBFalse.checked;
    coop = coopRBTrue.checked && !coopRBFalse.checked;
    pvp = pvpRBTrue.checked && !pvpRBFalse.checked;
    released = releasedRBTrue.checked && !releasedRBFalse.checked;


    console.log("-----------------------------------");
    console.log("create game:")
    console.log('Title:', title);
    console.log('gamestudio:', gamestudio);
    console.log('platform:', platform);
    console.log('genre:', genre);
    console.log('subgenre:', subgenre);
    console.log('bookseries:', bookseries);
    console.log('durchgespielt:', durchgespielt);
    console.log('coop:', coop);
    console.log('pvp:', pvp);
    console.log('released:', released);
    console.log("-----------------------------------");

    const requestBody = {
        title: title,
        gamestudio: gamestudio,
        platform: platform,
        gameGenre: genre,
        subGenre: subgenre,
        bookSeriesModel: bookseries,
        completed: durchgespielt,
        coop: coop,
        pvp: pvp,
        released: released,
    };
    console.log('Request Body:', JSON.stringify(requestBody));
    fetch("/game", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(requestBody)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('POST-Anfrage erfolgreich:', data);
            resultLabel.textContent = "Game " + title + " erfolgreich gespeichert";
            for (let textFieldsKey in textFields) {
                textFields[textFieldsKey].value = "";
            }
            durchgespieltRBTrue.checked = false;
            durchgespieltRBFalse.checked = false;
            coopRBFalse.checked = false;
            coopRBTrue.checked = false;
            pvpRBFalse.checked = false;
            pvpRBTrue.checked = false;
            releasedRBFalse.checked = false;
            releasedRBTrue.checked = false;
        })
        .catch(error => {
            console.error('Fehler bei der POST-Anfrage:', error);
            resultLabel.textContent = "Server-Error beim Speichern, Input überprüfen";
        });


}