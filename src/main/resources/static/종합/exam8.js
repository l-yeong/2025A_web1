console.log("exam8 check")

const WaitingAdd = ( ) =>{
    console.log("Add")
    let data={"wPhone":123,"wCount":123}
    let option ={
    method:"POST",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(data)
    }//option end

    fetch("/wait",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//func end

const WaitingList = ( ) => {
    console.log("Print")
    let option={method:"GET"}

    fetch("/wait",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//func end

const WaitingEdit = ( ) =>{
    console.log("Edit")
    let data={"wno":3,"wCount":7}
    let option={
    method:"PUT",
    headers:{"Content-Type":"application/json"},
    body:JSON.stringify(data)
    }
    fetch("/wait",option)
    .then(response => response.json())
    .then(data =>{console.log(data)})
    .catch(error => {console.log(error)})
}//func end

const WaitingDelete = ( ) =>{
    console.log("Delete")
    let wno=4;
    let option={method:"DELETE"}

    fetch(`/wait?wno=${wno}`,option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})

}//func end