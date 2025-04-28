const titleTF = document.getElementById("title");
const amountBooksTF = document.getElementById("amountbooks");
const genreTF = document.getElementById("genre");
const subgenreTF =  document.getElementById("subgenre");
const statusTF = document.getElementById("status");

const submitButton = document.getElementById("submit");

const resultLabel = document.getElementById("resultLabel");

let title;
let amountBooks;
let genre;
let subgenre;
let status;


let textFields = {titleTF,amountBooksTF,genreTF,subgenreTF,statusTF}

submitButton.onclick = function () {
    title = titleTF.value;
    amountBooks = amountBooksTF.value;
    genre = genreTF.value;
    subgenre = subgenreTF.value;
    status = statusTF.value;

    console.log("-----------------------------------");
    console.log("create bookseries:")
    console.log('Title:', title);
    console.log('amount of books:', amountBooks);
    console.log('genre:', genre);
    console.log('subgenre:', subgenre);
    console.log('Status:', status);
    console.log("-----------------------------------");

    const requestBody = {
        title: title,
        amountBooks: amountBooks,
        genre: genre,
        subgenre: subgenre,
        status: status,
    };
    console.log('Request Body:', JSON.stringify(requestBody));
    fetch("/bookseries", {
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
            resultLabel.textContent = "Buchserie " + title + " erfolgreich gespeichert";
            for (let textFieldsKey in textFields) {
                textFields[textFieldsKey].value = "";
            }
        })
        .catch(error => {
            console.error('Fehler bei der POST-Anfrage:', error);
            resultLabel.textContent = "Server-Error beim Speichern, Input überprüfen";
        });


}