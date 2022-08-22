class SimpleHTTP {
    constructor() {
        this.http = new XMLHttpRequest();
    }

    get(url, callback) {
        this.http.open('GET', url, true);
        this.http.send();
        this.http.onload = () => {
            if(this.http.status === 200) {
                callback(null, this.http.responseText);
            } else {
                callback('Error: '+ this.http.status);
            }
        }
    }
    
    post(url, data, callback) {
        this.http.open('POST', url, true);
        // 서버에게 JSON을 보낸다고 헤더값을 정의
        //서버에 클라이언트가 보내는 데이터가 json파일임을 알려준다.
        this.http.setRequestHeader('Content-type', 'application/json');
        // GET이 아닌 POST 메소드이기 때문에 request에 데이터를 포함하여 보낸다.
        this.http.send(JSON.stringify(data));
        this.http.onload = () => {
            console.log(this.http.responseText);
        }
    }
    
    // PUT Request
    put(url, data, callback) {
        this.http.open('PUT', url, true);
        this.http.setRequestHeader('Content-type', 'application/json');
        this.http.send(JSON.stringify(data));

        this.http.onload = () => {
            callback(null, this.http.responseText);
        }
    }

    // DELETE Request
    delete(url, callback) {
        this.http.open('DELETE', url, true);
        this.http.send();

        this.http.onload = () => {
            if(this.http.status === 200) {
                callback(null, 'SUCCESS DELETE');
            } else {
                callback('Error: ' + this.http.status);
            }
        }
    }

}