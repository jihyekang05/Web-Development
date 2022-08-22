const http = new SimpleHTTP();

//GET
http.get('https://jsonplaceholder.typicode.com/posts',
    function(err, posts) {
        if(err) {
            console.log(err);
        } else {
            console.log(posts);
        }
    });

//Create Data
const data ={
    title: "Test Post",
    body: "This is Test Post"

}

//POST
http.post('https://jsonplaceholder.typicode.com/posts',data, function(err, post) {
    if(err) {
        console.log(err);
    } else {
        console.log(post);
    }
})

//PUT
http.put('https://jsonplaceholder.typicode.com/posts/1',data, function(err, post) {
    if(err) {
        console.log(err);
    } else {
        console.log(post);
    }
})

//DELETE
http.delete('https://jsonplaceholder.typicode.com/posts/1', function(err, response) {
    if(err) {
                console.log(err);
            } else {
                console.log(response);
            }
        
    })
