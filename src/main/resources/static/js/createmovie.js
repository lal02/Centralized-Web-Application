const titleTF = document.getElementById("title");
const platformTF = document.getElementById("platform")
const genreTF = document.getElementById("genre");
const subgenreTF =  document.getElementById("subgenre");
const movieTypeTF = document.getElementById("movieType");



const submitButton = document.getElementById("submit");

const resultLabel = document.getElementById("resultLabel");

let title;
let platform
let genre;
let subgenre;
let movieType;


let textFields = {titleTF,platformTF,genreTF,subgenreTF,movieTypeTF}

submitButton.onclick = function () {
    title = titleTF.value;
    platform = platformTF.value;
    genre = genreTF.value;
    subgenre = subgenreTF.value;
    movieType = movieTypeTF.value;

    console.log("-----------------------------------");
    console.log("create movie:")
    console.log('Title:', title);
    console.log('platform:', platform);
    console.log('genre:', genre);
    console.log('subgenre:', subgenre);
    console.log('movieType:', movieType);
    console.log("-----------------------------------");

    const requestBody = {
        title: title,
        platform: platform,
        genre: genre,
        subGenre: subgenre,
        movieType: movieType,
    };

    console.log('Request Body:', JSON.stringify(requestBody));
    fetch("/movie", {
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
        })
        .catch(error => {
            console.error('Fehler bei der POST-Anfrage:', error);
            resultLabel.textContent = "Server-Error beim Speichern, Input überprüfen";
        });
}