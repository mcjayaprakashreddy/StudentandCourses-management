let coursesContainer = document.getElementById("coursesContainer");
let x = fetch("http://localhost:8080/fetchAllCourses",{
    method:"GET"
});
console.log(x);
x.then(response=>{
    return (response.json());
}).then(res=>{
    console.log(res.data);
    res.data.map((obj)=>{
        coursesContainer.innerHTML += `
        <div class="course">
            <h2><span>${obj.cid}</span>.${obj.name}</h2>
            <p>${obj.duration}</p>
            <p>Cost : <b>${obj.cost}</b> Rs/-</p>
            <button onclick="fetchCourses(${obj.cid})">ADD</button>
        </div>
        `
    })
})



async function fetchCourses(cid){
    let sid=localStorage.getItem("id")
    console.log(sid)
    let x= await fetch(`http://localhost:8080/fetchcourses/${sid}`)
    console.log(x)
    let res= await x.json()
    console.log(res)
    let data= await res.data
    
    console.log(data)
   let courseIsPresent= data.some(coures=>{
        return coures.cid===cid
    })
    if(courseIsPresent){
        alert("coures is already added")
    }else{
        addCourse(cid)
    }
}

async function addCourse(cid){
    let sid=localStorage.getItem("id")
    console.log(sid)
    let x= await fetch(`http://localhost:8080/addcourse/${sid}/${cid}`,{
        method:"PUT"
    })
   console.log(x)
   let res= await x.json()
   console.log(res)
   alert(res.msg)
   let data= await res.data
    console.log(data)
}