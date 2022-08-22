//비동기 방식
document.getElementById('button').addEventListener('click', loadData);

//Using Ajax, Load data
function loadData() {
    // XHR Object
    const xhr = new XMLHttpRequest();

    // console.log(xhr);

    //HTTP methods : GET, POST, PUT, DELETE 
    //Open
    xhr.open("GET", 'data.txt', true);
    
    
    
    // HTTP status
    // 404 error 해당 요청 페이지가 없습니다. 
    // 200~299, 2XX : Sucess
    // 4xx : 클라이언트 쪽 error
    // 5xx : 서버쪽 error
    xhr.onload = function() {
        console.log('readystate:',xhr.readyState);
        if(this.status == 200) {
            // console.log(xhr);
            document.getElementById('output').innerHTML = `<h1>${this.responseText}</h1>`
        }
        
    }

    //send request
    xhr.send();

    //readyState Values
    // 0 : request not initalized
    // 1 : server connection established
    // 2 : request received
    // 3 : processing request
    // 4 : request finished and response is ready

}