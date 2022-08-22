// document.querySelector('.get-jokes').addEventListener('click', getJoke);
document.querySelector('.get-jokes').addEventListener('click',getJokes);
var number = document.getElementById('number');

function getJoke(e) {
    const xhr = new XMLHttpRequest();

    xhr.open('GET','http://api.icndb.com/jokes/random' ,true);

    xhr.onload = function() {
        if(this.status === 200) {
            
            const response = JSON.parse(this.responseText);
            console.log(response);
            let output = '';

            if(response.type === 'success') {
                // console.log(response.value);
                output += `<li>${response.value.joke}</li>`;

            } else {
                output = `<li>Failed to fetch!</li>`;
            }
            document.querySelector('.jokes').innerHTML = output;
        }
    }

    xhr.send();
    e.preventDefault();

   

}

function getJokes(e) {
    const xhr = new XMLHttpRequest();
    // console.log(number.value);
    const number = document.getElementById('number').value;

    console.log(number);
    
    xhr.open('GET',`http://api.icndb.com/jokes/random/${number}`, true);

    xhr.onload = function() {
        if(this.status === 200) {

            const response = JSON.parse(this.responseText);
            console.log(response);
            
            let output = '';

            if(response.type === 'success') {
                response.value.forEach(function(data) {
                    console.log(data);
                    output += `<li>${data.joke}</li>`;
                });        
            } else{
                output = `<li>Failed to fetch!</li>`;
            }
            document.querySelector('.jokes').innerHTML = output;
        }
    }
    xhr.send();
    e.preventDefault();
}

