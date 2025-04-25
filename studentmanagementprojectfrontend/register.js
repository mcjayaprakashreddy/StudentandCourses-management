let form=document.forms[0]
console.log(form);

form.addEventListener("submit",async (e)=>{
    e.preventDefault();
    let inputs=document.querySelectorAll("input");

    let fname=inputs[0].value
    let lname=inputs[1].value
    let email=inputs[2].value
    let number=inputs[3].value
    let password=inputs[4].value
    let address=inputs[5].value
    // let img=inputs[6].value
    console.log(fname,lname,email,number,password,address);


    let student={
        fname : fname,
        lname : lname,
        email : email,
        mobileNumber : number,
        password : password,
        address : address
        // img:img
    }
  
    let x=await fetch("http://localhost:8080/savestudent",{
        method:"POST",
        headers:{
            "content-Type" : "application/json"
        },
        body : JSON.stringify(student)
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