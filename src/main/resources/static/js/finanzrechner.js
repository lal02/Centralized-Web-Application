
const ergebnisLabel = document.getElementById("zinsErgebnisLabel");
const zinsesZinsErgebnisLabel = document.getElementById("zinsesZinsErgebnisLabel");
const gesamtEinzahlungLabel = document.getElementById("gesamtEinzahlung");
const gesamtVermoegenLabel = document.getElementById("Gesamtvermoegen");

function zinsBerechnung(anlegesumme,rendite,anlegedauer,monatlicheSparsumme){
    let startwert = anlegesumme;
    let ergebnis = 0;
    let nachZahlungen = monatlicheSparsumme*12*anlegedauer;
    while(anlegedauer>0){
        console.log(anlegesumme);
        anlegesumme = anlegesumme + anlegesumme*(rendite/100);
        anlegesumme = anlegesumme + 12*monatlicheSparsumme;
        console.log(anlegesumme);
        anlegedauer--;
        console.log(anlegedauer);
    }
    ergebnis = anlegesumme-startwert-nachZahlungen;
    return ergebnis;
}



function zinsRenditeBerechnen(){
    zinsBerechnung(1);
    let zinsAnlegesumme = parseInt(document.getElementById('zinsAnlage').value);
    let zinsRendite = parseInt(document.getElementById('zinsRendite').value);
    const rendite = zinsAnlegesumme * (zinsRendite/100);
    ergebnisLabel.innerText = "Erhaltene Rendite: " + rendite;
}

function zinsesZinsRenditeBerechnen(){
    let zinsesZinsAnlegesumme = parseInt(document.getElementById('zinsesZinsAnlage').value);
    let zinsesZinsRendite = parseInt(document.getElementById('zinsesZinsRendite').value);
    let anlegeDauer = parseInt(document.getElementById('anlageDauer').value);
    let monatlicheSparsumme = parseInt(document.getElementById('monatlicheSparsumme').value);
    const rendite = zinsBerechnung(zinsesZinsAnlegesumme,zinsesZinsRendite,anlegeDauer,monatlicheSparsumme);
    const gesamtEinzahlung = zinsesZinsAnlegesumme + (12*monatlicheSparsumme*anlegeDauer);
    gesamtEinzahlungLabel.innerText ="Gesamte Einzahlungen: " + gesamtEinzahlung + "€";
    zinsesZinsErgebnisLabel.innerText = "Erhaltene Rendite: " + rendite +"€";
    gesamtVermoegenLabel.innerHTML ="<strong> Endkapital</strong> nach "+anlegeDauer +" Jahre: " + (gesamtEinzahlung + rendite) + "€";
}




