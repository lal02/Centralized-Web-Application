const titleTF = document.getElementById("title");
const authorTF = document.getElementById("author");
const languageTF = document.getElementById("language");
const pagesTF =  document.getElementById("pages");
const readTrueRB = document.getElementById("readTrue");
const readFalseRB = document.getElementById("readFalse");
const seriesTF = document.getElementById("series");
const formatTF = document.getElementById("format");
const seriesPlaceTF = document.getElementById("seriesPlace");

const submitButton = document.getElementById("submit");

let textFields = {titleTF,authorTF,languageTF,pagesTF,seriesTF,formatTF,seriesPlaceTF}


let title;
let author;
let language;
let pages;
let read;
let series;
let format;
let seriesPlace;

submitButton.onclick = function () {
    title = titleTF.value;
    author = authorTF.value;
    language = languageTF.value;
    pages = pagesTF.value;
    read = readTrueRB.checked && !readFalseRB.checked;
    series = seriesTF.value;
    format = formatTF.value;
    seriesPlace = seriesPlaceTF.value;

    console.log("-----------------------------------");
    console.log("create book:")
    console.log('Title:', title);
    console.log('Author:', author);
    console.log('Language:', language);
    console.log('Pages:', pages);
    console.log('Read:', read);
    console.log('Series:', series);
    console.log('Format:', format);
    console.log('Series Place:', seriesPlace);

    const requestBody = {
        title: title,
        author: author,
        language: language,
        pages: pages,
        read: read,
        bookSeriesModel: series,
        format: format,
        placeInSeries: seriesPlace,
    };
    console.log('Request Body:', JSON.stringify(requestBody));
    fetch("/book", {
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
            resultLabel.textContent = "Buch " + title + " erfolgreich gespeichert";
            for (let textFieldsKey in textFields) {
                textFields[textFieldsKey].value = "";
            }
            readTrueRB.checked = false;
            readFalseRB.checked = false;

        })
        .catch(error => {
            console.error('Fehler bei der POST-Anfrage:', error);
            resultLabel.textContent = "Server-Error beim Speichern, Input überprüfen";
        });
}