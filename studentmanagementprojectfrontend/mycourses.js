let courses=document.getElementById("courses")
let sid=localStorage.getItem("id")
let  x=fetch(`http://localhost:8080/fetchcourses/${sid}`,{
    method:"GET"
})
console.log(x)
x.then(res=>{

  return res.json();
})
.then(response=>{
    console.log(response.data);
    let data=response.data
    data.map(((course)=>{
     let{cid,cost,duration,name}=course
    console.log(course)
    courses.innerHTML+=`
     <div id="course">
            <h1>Name:${name}</h1>
            <p>Duration:${duration}</p>
            <p>Price:${cost} </p>
            <button id="deleteCoures" onClick="deleteCouresFromStudent(${cid})">Delete</button>
        </div>
    `
    }))
})

 async function deleteCouresFromStudent(cid){
    console.log(cid)
    let x=await fetch(`http://localhost:8080/deletcourse/${sid}/${cid}`,{
        method:"DELETE"
    })
   let response=await x.json()
   alert(response.msg)
   location.reload()
   console.log(response)
   let res=await response.data
   console.log(res)
   
}