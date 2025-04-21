let form=document.forms[0]
console.log(form);

form.addEventListener("submit",async(e)=>{
    e.preventDefault();
    let inputs=document.querySelectorAll("input")

    let adminEmail=inputs[0].value
    let adminPassword=inputs[1].value

    console.log(adminEmail,adminPassword);
    
    let admin={
        adminEmail:adminEmail,
        adminPassword:adminPassword
    }
    
    let x=fetch("http://localhost:8080/adminLogin",{
        method:"POST",
        headers:{
            "content-Type" : "application/json"
        },
        body : JSON.stringify(admin)
    })
    x.then(res=>{console.log(res); return res.json()}).
    then(res=>{
        if (typeof res.data == "string") {
            alert(res.data)
        }
        else{
            console.log(res.data);
            let {aid,adminEmail,adminPassword}=res.data
            
            localStorage.setItem("adminEmail",adminEmail)
            localStorage.setItem("adminPassword",adminPassword)
            localStorage.setItem("aid",aid)
            
            window.open("./index.html")
            
        }
    })
    })