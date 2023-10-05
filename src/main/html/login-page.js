const url = "http://localhost:8080/api/auth/login"

// Supposed to do this curl command on its own
// curl -X POST -H "Content-Type: application/json" -d '{"username":"Dave","password":"SecretSauce"}' http://localhost:8080/api/auth/login


function bob(evt) {
    console.log("hits");
    // collect username and password
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let header = {
        'Content-Type': 'application/json'
    }
    console.log("accepted elements");
    // create an object
    let authObj = {
        "username" : username.value,
        "password" : password.value
    }
    console.log(authObj);
    // post the authentication request
    axios.post(url, authObj, header)
       .then((response) => {
           console.log(response);
           if (response.status = "200") {
                window.location.replace("learner-dash.html");
           }
           }).catch((e) => {console.log("error", e)});
    console.log("all done");
}