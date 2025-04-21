let fname = localStorage.getItem("fname");
let id = localStorage.getItem("id");
let lname = localStorage.getItem("lname");
let email = localStorage.getItem("email");
let address = localStorage.getItem("address");
let mobileNumber = localStorage.getItem("mobileNumber");
let password = localStorage.getItem("password");
let image=localStorage.getItem("img")

let profile = document.getElementById("profile");
profile.innerHTML = `
    <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">ID:</td>
            <td style="padding: 10px; color: #555;">${id}</td>
        </tr>
        <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">Fname:</td>
            <td style="padding: 10px; color: #555;">${fname}</td>
        </tr>
        <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">Lname:</td>
            <td style="padding: 10px; color: #555;">${lname}</td>
        </tr>
        <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">Email:</td>
            <td style="padding: 10px; color: #555;">${email}</td>
        </tr>
        <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">Address:</td>
            <td style="padding: 10px; color: #555;">${address}</td>
        </tr>
        <tr style="border-bottom: 1px solid #ddd;">
            <td style="padding: 10px; font-weight: bold; color: #333;">Mobile Number:</td>
            <td style="padding: 10px; color: #555;">${mobileNumber}</td>
        </tr>
        <tr>
            <td style="padding: 10px; font-weight: bold; color: #333;">Password:</td>
            <td style="padding: 10px; color: #555;">${password}</td>
        </tr>
`
let deletebtn = document.getElementById("deletebtn");
deletebtn.addEventListener("click", () => {
    fetch(`http://localhost:8080/students/deleteStudent/${id}`, {
        method: "DELETE"
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Failed to delete user");
        }
        return response.json();
    })
    .then(data => {
        alert("User deleted successfully!");

        localStorage.clear();

        window.location.href = "login.html";
    })
    .catch(error => {
        console.error("Error:", error);
        alert("Error while deleting user. Please try again.");
    });
});


let fileInput=document.getElementById("fileInput");
let uploadbtn=document.getElementById("uploadImageBtn")
uploadbtn.addEventListener("click",()=>{
    let file=fileInput.files[0];
    console.log(file);
    let formData=new FormData();
formData.append("id",id);
formData.append("file",file)
let y=fetch(`http://localhost:8080/uploadimage/${id}`,{
    method:"PUT",
    body:formData
})
console.log(y);
y.then((response)=>{
    console.log(response);
    // location.reload();
}).then(res=>{
console.log(res.msg);
alert(res.msg);
})
})

    

let x=fetch(`http://localhost:8080/fetchimg/${id}`)
console.log(x);

x.then(response=>{
    console.log(response);
    return response.blob()
    
})
.then(res=>{
    console.log(res);
    let y=URL.createObjectURL(res);
    console.log(y);
    document.getElementById("pic").src=y;
    
})
