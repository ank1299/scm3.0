console.log("Script loaded");

//change theme start
let currentTheme=getTheme();
// initial
document.addEventListener("DOMContentLoaded",()=>{
    changeTheme(currentTheme);
});

//TODO
function changeTheme(){
    //set to web page
    changePageTheme(currentTheme,currentTheme);
    //set the listener to chnage theme button
    const changeThemeButton=document.querySelector('#theme_change_button');
   
    changeThemeButton.addEventListener("click",(event) => {
        console.log("Change theme button clicked");
        let oldTheme = currentTheme;
        if(currentTheme == "dark"){
            currentTheme = "light";
        }else{
            currentTheme = "dark";
        }
        changePageTheme(currentTheme,oldTheme);
    });
    
}

//set theme to localstorage
function setTheme(theme){
    localStorage.setItem("theme",theme);
}

//get theme from localstorage
function getTheme(){
    let theme = localStorage.getItem("theme");
     console.log(theme + "curren theme");
    if (theme) return theme;
    else return "light";
}

//change current page theme
function changePageTheme(currentTheme,oldTheme){
    document.querySelector('html').classList.remove(oldTheme);
    document.querySelector('html').classList.add(currentTheme);
    setTheme(currentTheme);
    //change text of button
    document.querySelector('#theme_change_button').querySelector("span").textContent = currentTheme=="light"?"Dark":"Light";   
}

//change theme end