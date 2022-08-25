document.getElementById('button-get').addEventListener('click', get);
document.getElementById("button-post").addEventListener('click', post);
document.getElementById("button-put").addEventListener('click', put);
document.getElementById("button-patch").addEventListener('click', patch);
document.getElementById("button-delete").addEventListener('click', Delete);
document.getElementById('button-submit').addEventListener('click',submit);


class UI {
    static printMultiple(datas) {

        if(!Array.isArray(datas)) {
            datas = [].concat(data);
        }
        let output = '';
        // console.log(datas);
        
        datas.forEach(customer => {
            output += `
            <ul id=${customer.id} class="list-group">
                <li class="list-group-item list-group-item-action active">name: ${customer.name}</li>
                <li class="list-group-item"  >age: ${customer.age} </li>
                <li class="list-group-item">grade: ${customer.grade}</li>
                <li class="list-group-item">Id: ${customer.id}</li>
                <div id=${customer.id} class="hover-btn">
                        <button type="button" id = 'edit-button' class="btn btn-primary">edit</button>
                        <button type="button" id = 'delete-button' class="btn btn-danger">Delete</button>
                </div>
            </ul>
            
            <br>
            `
        })
        document.getElementById("output").innerHTML = output;
    }

    // static printSingle(data){
    //     let output=''
    //     console.log(data);
    //     output = `
    //     <ul class = "list-group">
    //         <li class="list-group-item">name: ${data.name}</li>
    //         <li class="list-group-item">age: ${data.age}</li>
    //         <li class="list-group-item">grade: ${data.grade}</li>
    //         <li class="list-group-item">grade: ${data.id}</li>
    //     </ul>
    //     `;
    //     document.getElementById("output").innerHTML = output;
    }


// }
