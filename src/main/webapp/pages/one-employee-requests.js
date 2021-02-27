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

       let school = document.createElement('td')
       school.innerHTML = r.school;

       let course = document.createElement('td')
       course.innerHTML = r.course;

       let price = document.createElement('td')
       price.innerHTML = r.price;

       let receipt = document.createElement('td')
       receipt.innerHTML = r.receipt;

       let status = document.createElement('td')
       status.innerHTML = r.status;

       let manager = document.createElement('td')
       manager.innerHTML = r.manager.firstName +" "+ r.manager.lastName;

       let comments = document.createElement('td')
       comments.innerHTML = r.comments;      

           //Append all td to tr  
           row.append(id);

           row.append(school);
           row.append(course);
           row.append(price);
           row.append(receipt);
           row.append(manager);
           row.append(status);
           row.append(manager);
           row.append(comments);
        //Append tr to table  
           emptyDiv.append(row)

         
 
        }
    }
}

    //Open my XMLHttpRequest, specifying my HTTP verb and the endpoint I would like to hit.

    xhr.open('GET', 'http://localhost:8080/FreeTuition/OneEmployeeRequestsServlet') //readyState 1
    xhr.send() //readyState 2
}


console.log("This is JS file new")
//Info will appear as soon as the web page loads. 
//Use window's onload event listener which fires immediately after the browser loads the window
window.onload = () => {
    getInfo()
}

