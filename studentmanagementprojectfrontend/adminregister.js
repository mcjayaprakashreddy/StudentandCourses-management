let form=document.forms[0]
console.log(form);

form.addEventListener("submit", async (e) => {
    e.preventDefault();
    let inputs=document.querySelectorAll("input")

    let adminName=inputs[0].value
    let adminEmail=inputs[1].value
    let adminPassword=inputs[2].value
    console.log(adminName,adminEmail,adminPassword);


    let admin={
        adminName : adminName,
        adminEmail : adminEmail,
        adminPassword : adminPassword
    }

    let x=await fetch("http://localhost:8080/saveAdmin",{
        method:"POST",
        headers:{
            "content-Type" : "application/json"
        },
        body : JSON.stringify(admin)
    })

    console.log(x);

    if (x.ok) {
        x.json()
        alert("Registered Successfully")
    }
    else{
        console.log("unable to register");
        
    }
})
