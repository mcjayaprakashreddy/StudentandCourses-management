
//student

let loginbtn=document.getElementById("loginbtn")
let logoutbtn=document.getElementById("logoutbtn")
let login=document.getElementById("login")

if (localStorage.getItem("id")==null) {
    logoutbtn.style.display="none"
}
else{
    // loginbtn.style.display="none"
    login.style.display="none"
}

logoutbtn.addEventListener("click",()=>{
    localStorage.clear();
    window.close();
})

let profilebtn=document.getElementById("profilebtn")
profilebtn.addEventListener("click",()=>{
    let id=localStorage.getItem("id")
    console.log("id is "+id);
    if (id==null) {
        alert("please login")
    }
    // else{
    //     window.open(./profile.html)
    // }

    
})


//admin

let adminloginbtn=document.getElementById("adminloginbtn")
let adminlogoutbtn=document.getElementById("adminlogoutbtn")

if (localStorage.getItem("aid")==null) {
    adminlogoutbtn.style.display="none"
   
}
else{
    // loginbtn.style.display="none"
    login.style.display="none"
    
}

adminlogoutbtn.addEventListener("click",()=>{
    localStorage.clear();
    window.close();
})

if (localStorage.getItem("aid")==null && localStorage.getItem("id")==null) {
    logout.style.display="none"
}