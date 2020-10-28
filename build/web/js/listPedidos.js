function showInfo(value){
    console.log(value);
    if(document.getElementById(value + 'card').style.display =="flex"){
        document.getElementById(value + 'card').style.display ="none"

    }else{
        document.getElementById(value + 'card').style.display ="flex"
    }
    
}