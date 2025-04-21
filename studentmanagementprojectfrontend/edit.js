let fname = localStorage.getItem("fname");
let id = localStorage.getItem("id");
let lname = localStorage.getItem("lname");
let email = localStorage.getItem("email");
let address = localStorage.getItem("address");
let mobileNumber = localStorage.getItem("mobileNumber");
let password = localStorage.getItem("password");

let fnameInput = document.getElementById("fnameInput");
let lnameInput = document.getElementById("lnameInput");
let idInput = document.getElementById("idInput");
let emailInput = document.getElementById("emailInput");
let addressInput = document.getElementById("addressInput");
let passwordInput = document.getElementById("passwordInput");
let mobileNumberInput = document.getElementById("mobileNumberInput");

fnameInput.value = fname;
lnameInput.value = lname;
idInput.value = id;
emailInput.value = email;
addressInput.value = address;
passwordInput.value = password;
mobileNumberInput.value = mobileNumber;

let updateBtn = document.getElementById("updateBtn");
updateBtn.addEventListener("click",(e)=>{
    e.preventDefault();
    let student = {
        id : idInput.value,
        fname : fnameInput.value,
        lname : lnameInput.value,
        email : emailInput.value,
        password : passwordInput.value,
        mobileNumber : mobileNumberInput.value,
        address : addressInput.value,
        img:""

    }
    console.log(student);

    let x = fetch("http://localhost:8080/students/updateStudent",{
        method : "PUT",
        headers : {
            "content-Type" : "application/json"
        },
        body : JSON.stringify(student)
    })
    console.log(x);
    x.then(res=>res.json())
    .then(res=>{
        console.log(res.data)
        localStorage.setItem("id",res.data.id);
        localStorage.setItem("fname",res.data.fname);
        localStorage.setItem("lname",res.data.lname);
        localStorage.setItem("address",res.data.address);
        localStorage.setItem("email",res.data.email);
        localStorage.setItem("password",res.data.password);
        localStorage.setItem("mobileNumber",res.data.mobileNumber);
        window.open("./profile.html")

    });






})