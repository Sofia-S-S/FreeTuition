function getInfo(){
 
    //Start by creating an XMLHttpRequest object:

    let xhr = new XMLHttpRequest() //readyState 0

    //We need to define what we want to do when the readyState is 4 (meaning that the response body has been populated on the server side); 
    //in our case, we want to put info on the page for the user to see. We can use the onreadystatechange event listener to listen for changes to our readyState. In essence, this listener is invoked each time the readyState changes.

    xhr.onreadystatechange = function(){
        //You decide what to do each time the readyState changes in this function! Be sure to check that the readyState is 4 and and that the response code is 200 (meaning that everything went smoothly)

        if(xhr.readyState === 4 & xhr.status === 200){
            //JSON.parse is a convenience function for parsing JSON as a JavaScript object
            let employees = JSON.parse(xhr.response)
            console.log('the ready state was 4 and the status was 200')
            console.log(employees)
            let emptyDiv = document.getElementById('addHere')
         
            //Create new tr for each request and new td for each field
            //Assign text from JSON 
    
       for (let em of employees){      
           let row = document.createElement('tr')

       let firstName = document.createElement('td')
       firstName.innerHTML = em.firstName

       let lastName = document.createElement('td')
       lastName.innerHTML = em.lastName;

       let company = document.createElement('td')
       company.innerHTML = em.company;

       let position = document.createElement('td')
       position.innerHTML = em.position;

       let email = document.createElement('td')
       email.innerHTML = em.email;

       let contact = document.createElement('td')
       contact.innerHTML = em.contact;

       let manager = document.createElement('td')
       manager.innerHTML = em.manager.firstName +" "+ em.manager.lastName;

       let address = document.createElement('td')
       address.innerHTML = em.address;      

           //Append all td to tr  
           row.append(firstName);
           row.append(lastName);
           row.append(company);
           row.append(position);
           row.append(email);
           row.append(manager);
           row.append(contact);
           row.append(address);
           row.append(manager);

        //Append tr to table  
           emptyDiv.append(row)

         
 
        }
    }
}

    //Open my XMLHttpRequest, specifying my HTTP verb and the endpoint I would like to hit.

    xhr.open('GET', 'http://localhost:8080/FreeTuition/AllEmployeesServlet') //readyState 1
    xhr.send() //readyState 2
}


console.log("This is JS file new")
//Info will appear as soon as the web page loads. 
//Use window's onload event listener which fires immediately after the browser loads the window
window.onload = () => {
    getInfo()
}

