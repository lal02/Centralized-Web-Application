const tempGraph = document.getElementById("temperatureGraph").getContext('2d');
const soilGraph = document.getElementById("soilGraph").getContext('2d');
const lightGraph = document.getElementById("lightGraph").getContext('2d');
const AQGraph = document.getElementById("AQGraph").getContext('2d');

const todayButton = document.getElementById("todayButton");
const weekButton = document.getElementById("weekButton");
const monthButton = document.getElementById("monthButton");
const yearButton = document.getElementById("yearButton");
const alltimeButton = document.getElementById("alltimeButton");

const todaySoilButton = document.getElementById("todaySoilButton");
const weekSoilButton = document.getElementById("weekSoilButton");
const monthSoilButton = document.getElementById("monthSoilButton");
const yearSoilButton = document.getElementById("yearSoilButton");
const alltimeSoilButton = document.getElementById("alltimeSoilButton");

const todayLightButton = document.getElementById("todayLightButton");
const weekLightButton = document.getElementById("weekLightButton");
const monthLightButton = document.getElementById("monthLightButton");
const yearLightButton = document.getElementById("yearLightButton");
const alltimeLightButton = document.getElementById("alltimeLightButton");

const todayAQButton = document.getElementById("todayAQButton");
const weekAQButton = document.getElementById("weekAQButton");
const monthAQButton = document.getElementById("monthAQButton");
const yearAQButton = document.getElementById("yearAQButton");
const alltimeAQButton = document.getElementById("alltimeAQButton");

let aqGraphnew;
let temphumGraphnew;
let lightgraphnew;
let soilgraphnew;

todayButton.onclick = function () {
    renderTempGraph("today").then(r => null);
}
weekButton.onclick = function () {
    renderTempGraph("week").then(r => null);
}
monthButton.onclick = function () {
    renderTempGraph("month").then(r => null);
}
yearButton.onclick = function () {
    renderTempGraph("year").then(r => null);
}
alltimeButton.onclick = function () {
    renderTempGraph("all").then(r => null);
}


todaySoilButton.onclick = function () {
    renderSoilGraph("today").then(r => null);
}
weekSoilButton.onclick = function () {
    renderSoilGraph("week").then(r => null);
}
monthSoilButton.onclick = function () {
    renderSoilGraph("month").then(r => null);
}

yearSoilButton.onclick = function () {
    renderSoilGraph("year").then(r => null);
}

alltimeSoilButton.onclick = function () {
    renderSoilGraph("all").then(r => null);
}



todayLightButton.onclick = function () {
    renderLightGraph("today").then(r => null);
}
weekLightButton.onclick = function () {
    renderLightGraph("week").then(r => null);
}
monthLightButton.onclick = function () {
    renderLightGraph("month").then(r => null);
}

yearLightButton.onclick = function () {
    renderLightGraph("year").then(r => null);
}

alltimeLightButton.onclick = function () {
    renderLightGraph("all").then(r => null);
}

todayAQButton.onclick = function () {
    renderAQGraph("today").then(r => null);
}
weekAQButton.onclick = function () {
    renderAQGraph("week").then(r => null);
}
monthAQButton.onclick = function () {
    renderAQGraph("month").then(r => null);
}

yearAQButton.onclick = function () {
    renderAQGraph("year").then(r => null);
}

alltimeAQButton.onclick = function () {
    renderAQGraph("all").then(r => null);
}


async function fetchData(api){
        const response = await fetch(api);
        return await response.json();
}


async function renderTempGraph(time){
    const temperatureData = await fetchData("/api/temperatur/" + time);
    temperatureData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const temperatureLabels = temperatureData.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const temperatureYValues = temperatureData.map(data => data.value);
    if(time === "today"){
        for (let key in temperatureLabels) {
            temperatureLabels[key] = temperatureLabels[key].substring(temperatureLabels[key].length - 8);
        }
    }
    const humidityData = await fetchData("/api/humidity/" + time);
    humidityData.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));
    const humidityYValues = humidityData.map(data => data.value);

    if (temphumGraphnew) {
        // Update existing chart
        temphumGraphnew.data.labels = temperatureLabels;

        temphumGraphnew.data.datasets[0].data = temperatureYValues; // Update temperature data
        temphumGraphnew.data.datasets[1].data = humidityYValues;    // Update humidity data
        temphumGraphnew.update(); // Update the chart
    }
    else{
        temphumGraphnew = new Chart(tempGraph, {
            type: 'line',
            data: {
                labels: temperatureLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Temperatur',
                    data: temperatureYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgba(255, 0, 0, 0.2)',
                    borderColor: 'rgba(255, 0, 0, 1)',
                    borderWidth: 1
                }
                    ,
                    {
                        label: 'Humidity',
                        data: humidityYValues, // Y-Achsen-Werte
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }
                ]
            }
        });
    }

}

async function renderSoilGraph(time){


    const soilhumiditydata0 = await fetchData("/api/soilhumidity/" + time + "/0");
    console.log(soilhumiditydata0);
    soilhumiditydata0.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const soilHumidityLabels0 = soilhumiditydata0.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const soilHumidityYValues0 = soilhumiditydata0.map(data => data.value);

    const soilhumiditydata1 = await fetchData("/api/soilhumidity/" + time + "/1");
    console.log(soilhumiditydata1);
    soilhumiditydata1.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const soilHumidityLabels1 = soilhumiditydata1.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const soilHumidityYValues1 = soilhumiditydata1.map(data => data.value);


    if(time === "today"){
        for (let key in soilHumidityLabels0) {
            soilHumidityLabels0[key] = soilHumidityLabels0[key].substring(soilHumidityLabels0[key].length - 8);
        }
    }
    if (soilgraphnew) {
        // Update existing chart
        soilgraphnew.data.labels = soilHumidityLabels0;
        soilgraphnew.data.datasets[0].data = soilHumidityYValues0;    // Update humidity data
        soilgraphnew.data.datasets[1].data = soilHumidityYValues1;    // Update humidity data
        soilgraphnew.update(); // Update the chart
    }
    else{
        soilgraphnew = new Chart(soilGraph, {
            type: 'line',
            data: {
                labels: soilHumidityLabels0, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Rechte Pflanze',
                    data: soilHumidityYValues0, // Y-Achsen-Werte
                    backgroundColor: 'rgb(100,65,23,0.2)',
                    borderColor: 'rgb(100,65,23,1)',
                    borderWidth: 1
                },
                    {
                        label: 'Linke Pflanze',
                        data: soilHumidityYValues1, // Y-Achsen-Werte
                        backgroundColor: 'rgb(0, 255, 0, 0.2)',
                        borderColor: 'rgb(0, 255, 0, 1)',
                        borderWidth: 1
                    }
                ]
            }
        });
    }

}

async function renderLightGraph(time){
    const lightdata = await fetchData("/api/light/" + time);
    console.log(lightdata);
    lightdata.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const lightLabels = lightdata.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const lightYValues = lightdata.map(data => data.value);

    if(time === "today"){
        for (let lightLabelsKey in lightLabels) {
            lightLabels[lightLabelsKey] = lightLabels[lightLabelsKey].substring(lightLabels[lightLabelsKey].length - 8);        }
    }

    if (lightgraphnew) {
        // Update existing chart
        lightgraphnew.data.labels = lightLabels;
        lightgraphnew.data.datasets[0].data = lightYValues;    // Update humidity data
        lightgraphnew.update(); // Update the chart
    }
    else{
        lightgraphnew = new Chart(lightGraph, {
            type: 'line',
            data: {
                labels: lightLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Lux',
                    data: lightYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgb(240,230,140,0.2)',
                    borderColor: 'rgb(240,230,140,1)',
                    borderWidth: 1
                }]
            }
        });
    }

}


async function renderAQGraph(time){
    const aqdata = await fetchData("/api/aq/" + time);
    console.log(aqdata);
    aqdata.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const aqLabels = aqdata.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const aqYValues = aqdata.map(data => data.value);

    const codata = await fetchData("/api/co/" + time);
    console.log(codata);
    codata.sort((a,b)=>new Date(a.timestamp)- new Date(b.timestamp));

    const coLabels = codata.map(data => new Date(data.timestamp).toLocaleString()); // Konvertiert den Timestamp in ein Datum
    const coYValues = codata.map(data => data.value);


    if(time === "today"){
        for (let key in aqLabels) {
            aqLabels[key] = aqLabels[key].substring(aqLabels[key].length - 8);
            coLabels[key] = coLabels[key].substring(coLabels[key].length - 8);
        }
    }

    if (aqGraphnew) {
        // Update existing chart
        aqGraphnew.data.labels = aqLabels;
        aqGraphnew.data.datasets[0].data = aqYValues;    // Update humidity data
        aqGraphnew.data.datasets[1].data=coYValues;

        aqGraphnew.update(); // Update the chart
    }
    else{
        aqGraphnew = new Chart(AQGraph, {
            type: 'line',
            data: {
                labels: aqLabels, // X-Achsen-Beschriftungen
                datasets: [{
                    label: 'Allgemeine Luftqualität',
                    data: aqYValues, // Y-Achsen-Werte
                    backgroundColor: 'rgba(48, 42, 45, 0.2)',
                    borderColor: 'rgba(48, 42, 45, 1)',
                    borderWidth: 1
                }, {
                        label: 'Kohlenstoffmonoxid',
                        data: coYValues, // Y-Achsen-Werte
                        backgroundColor: 'rgb(0, 0, 139,0.2)',
                        borderColor: 'rgb(0, 0, 139,1)',
                        borderWidth: 1
                }]
            }
        });
    }

}




renderTempGraph("today").then(r => null);
renderSoilGraph("today").then(r => null);
renderLightGraph("today").then(r => null);
renderAQGraph("today").then();
