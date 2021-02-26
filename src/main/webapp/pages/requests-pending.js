function getInfo(){
 
    //Start by creating an XMLHttpRequest object:

    let xhr = new XMLHttpRequest() //readyState 0

    //We need to define what we want to do when the readyState is 4 (meaning that the response body has been populated on the server side); 
    //in our case, we want to put info on the page for the user to see. We can use the onreadystatechange event listener to listen for changes to our readyState. In essence, this listener is invoked each time the readyState changes.

    xhr.onreadystatechange = function(){
        //You decide what to do each time the readyState changes in this function! Be sure to check that the readyState is 4 and and that the response code is 200 (meaning that everything went smoothly)

        if(xhr.readyState === 4 & xhr.status === 200){
            //JSON.parse is a convenience function for parsing JSON as a JavaScript object
            let requests = JSON.parse(xhr.response)
            console.log('the ready state was 4 and the status was 200')
            console.log(requests)
            let emptyDiv = document.getElementById('addHere')
         
            //Create new tr for each request and new td for each field
            //Assign text from JSON 
    
       for (let r of requests){      
           let row = document.createElement('tr')

       let id = document.createElement('td')
       id.innerHTML = r.requestId;

       let employee = document.createElement('td')
       employee.innerHTML = r.employeeId;

       let school = document.createElement('td')
       school.innerHTML = r.school;

       let course = document.createElement('td')
       course.innerHTML = r.course;

       let type = document.createElement('td')
       type.innerHTML = r.type;

       let price = document.createElement('td')
       price.innerHTML = r.price;

       let graduation = document.createElement('td')
       graduation.innerHTML = r.graduation;

       let receipt = document.createElement('td')
       receipt.innerHTML = r.receipt;

       let date = document.createElement('td')
       date.innerHTML = r.date;

       //Create 2 buttons in a collumn Resolve
       let resolve = document.createElement('td')

    //    let form =  document.createElement('form')
    //    form.action = "approve.html";
       let approve = document.createElement('button')
       approve.innerHTML = "approve";
       approve.className = "btn"
      
       let reject = document.createElement('button')
       reject.innerHTML = "reject";
       reject.className = "btn";

           //Append all td to tr  
           row.append(id);
           row.append(employee);
           row.append(school);
           row.append(course);
           row.append(type);
           row.append(price);
           row.append(graduation);
           row.append(receipt);
           row.append(date);
           row.append(resolve);
        //Append tr to table  
           emptyDiv.append(row)
//------------------------------------------------------------------------------
//----------APPROVE btn---------------------------------------------------------
       
    //    approve.className = "btn";
    //    approve.formMethod = "POST"

    //    form.append(approve)
    //    resolve.append(form);

     resolve.append(approve)
     function approveRequest(e){
        //Stop page from refreshing
         e.preventDefault()

                  //hide buttons
                  approve.style.display = "none"
                  reject.style.display = "none"
        //Create form
         let formA = document.createElement("form")
         formA.action = "../approve"
         formA.method = "POST"

         //Add inputs
         let idA = document.createElement("input")
         idA.name = "idA"
         idA.value = r.requestId;
         idA.type = "hidden"
         formA.append(idA)

         let emplA = document.createElement("input")
         emplA.name = "emplA"
         emplA.value = r.employeeId;
         emplA.type = "hidden"
         formA.append(emplA)

         let schoolA = document.createElement("input")
         schoolA.name = "schoolA"
         schoolA.value = r.school;
         schoolA.type = "hidden"
         formA.append(schoolA)

         let courseA = document.createElement("input")
         courseA.name = "courseA"
         courseA.value = r.course;
         courseA.type = "hidden"
         formA.append(courseA)

         let typeA = document.createElement("input")
         typeA.name = "typeA"
         typeA.value = r.type;
         typeA.type = "hidden"
         formA.append(typeA)

         let priceA = document.createElement("input")
         priceA.name = "priceA"
         priceA.value = r.price;
         priceA.type = "hidden"
         formA.append(priceA)
         
         let graduationA = document.createElement("input")
         graduationA.name = "graduationA"
         graduationA.value = r.graduation;
         graduationA.type = "hidden"
         formA.append(graduationA)
         
         let receiptA = document.createElement("input")
         receiptA.name = "receiptA"
         receiptA.value = r.receipt;
         receiptA.type = "hidden"
         formA.append(receiptA)
         
         let dateA = document.createElement("input")
         dateA.name = "dateA"
         dateA.value = r.date;
         dateA.type = "hidden"
         formA.append(dateA)
    
         let amount = document.createElement('input')
         amount.name = "amount"
         amount.type = "text"
         amount.placeholder = "Amount in $"
         formA.append(amount)

         //add submition button
         let go = document.createElement('button')
        go.innerHTML = "submit"
         go.className = "btn"
         formA.append(go)

         resolve.append(formA)


    }
    approve.addEventListener('click', approveRequest)
      
       let form2 =  document.createElement('form')
       form2.action = "approve.html";


       form2.append(reject)
       resolve.append(form2);

   

    
        }
    }
}

    //Open my XMLHttpRequest, specifying my HTTP verb and the endpoint I would like to hit.

    xhr.open('GET', 'http://localhost:8080/FreeTuition/RequestsPendingServlet') //readyState 1
    xhr.send() //readyState 2
}
// function approveRequest(){
//     console.log("Replace this with function")
// }
// approve.addEventListener("click", approveRequest)
// let reject = document.createElement('button')
 

console.log("This is JS file")
//Info will appear as soon as the web page loads. 
//Use window's onload event listener which fires immediately after the browser loads the window
window.onload = () => {
    getInfo()
}

// save.addEventListener('click', approveRequest)


