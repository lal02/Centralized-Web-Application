const daysInput = document.getElementById("daysInput");
const hoursInput = document.getElementById("hoursInput");
const minutesInput = document.getElementById("minutesInput");
const calculateButton = document.getElementById("calculateButton");
const resultLabel = document.getElementById("resultLabel");


function calculateRemainingTime(days,hours,minutes){
    if(!Number.isInteger(days) || !Number.isInteger(hours)||!Number.isInteger(minutes)){
        throw new Error("NaN");
    }

    let remainingTime = (days*24*60) + hours*60 + minutes;
    let remainingHours;
    let remainingMinutes;
    let remainingSeconds;
    console.log("remaining time in minutes before boost: " + remainingTime);

    let workDuringBoost = 600;
    remainingTime = remainingTime-workDuringBoost;

    // wird während dem Boost fertig
    if(remainingTime<0){
        remainingMinutes = 60-Math.abs(remainingTime/10);
        remainingHours = remainingMinutes/60;
        if(remainingHours<1){
            // X,xx minutes
            if( remainingMinutes % 1 !== 0){
                //console.log(Math.floor(remainingMinutes %1));
                remainingSeconds = Math.floor((remainingMinutes %1) * 60);
                remainingMinutes = Math.floor(remainingMinutes);
                console.log(remainingMinutes + " minutes " + remainingSeconds + " seconds");
                resultLabel.textContent = remainingMinutes + " minutes " + remainingSeconds + " seconds";
            }
            // X minutes
            else{
                console.log(remainingMinutes + " minutes");
                resultLabel.textContent = remainingMinutes + " minutes";
            }
        }
        // mehr als 1 stunde
        else{
            // X,nn Stunden
            if( remainingHours % 1 !== 0){
                remainingMinutes = Math.floor((remainingHours % 1 ) * 60);
                remainingHours = Math.floor(remainingHours);
                console.log(remainingHours + " hours " + remainingMinutes + " minutes");
                resultLabel.textContent = remainingHours + " hours " + remainingMinutes + " minutes";
            }
            // X Stunden
            else{
                console.log("remaining hours: " + remainingHours);
                resultLabel.textContent = "remaining hours: " + remainingHours;
            }
        }
    }
    //wird nach dem boost erst fertig
    else{
        let remainingDays = (remainingTime / 60 )/ 24;
        // weniger als 1 Tag
        if(remainingDays<1){
            let remainingHours = remainingDays*24;
            // X,nn Stunden
            if(remainingHours % 1 !== 0){
                let remainingMinutes = Math.floor((remainingHours % 1) * 60);
                remainingHours = Math.floor(remainingHours);
                console.log(remainingHours + " hours " + remainingMinutes + " minutes");
                resultLabel.textContent = remainingHours + " hours " + remainingMinutes + " minutes";
            }
            // X stunden
            else{
                console.log(remainingHours + " hours");
                resultLabel.textContent = remainingHours + " hours";
            }
        }
        //mehr als 1 Tag
        else{
            // X,nn Tage
            if(remainingDays % 1 !== 0){
                let remainingHours = (remainingDays %1)*24;
                // X Tage
                remainingDays = Math.floor(remainingDays);
                // X,nn Stunden
                if(remainingHours % 1 !== 0){
                    let remainingMinutes = Math.floor((remainingHours % 1) * 60);
                    remainingHours = Math.floor(remainingHours);

                    console.log(remainingDays + " days " + remainingHours + " hours " + remainingMinutes + " minutes remaining");
                    resultLabel.textContent = remainingDays + " days " + remainingHours + " hours " + remainingMinutes + " minutes remaining";
                }
                //genau n tage n Stunden
                else{
                    console.log(remainingDays + " days " + remainingHours + " hours");
                    resultLabel.textContent = remainingDays + " days " + remainingHours + " hours";
                }
            }
            // genau n Tage
            else{
                console.log("remaining time: " + remainingDays + " days");
                resultLabel.textContent = "remaining time: " + remainingDays + " days";
            }
        }
    }
}

calculateButton.onclick = function () {
   // console.log(daysInput.value + " " + hoursInput.value + " " + minutesInput.value);
   // calculateRemainingTime(parseInt(daysInput.value),parseInt(hoursInput.value),parseInt(minutesInput.value));
    let days = 0;
    let minutes = 0;
    let hours = 0;
    if(daysInput.value !== ""){
        days = parseInt(daysInput.value);
    }
    if(hoursInput.value !==""){
        hours = parseInt(hoursInput.value);
    }
    if(minutesInput.value !==""){
        minutes = parseInt(minutesInput.value);
    }
    //calculateRemainingTime(21,3,4);
    calculateRemainingTime(days,hours,minutes);

}

