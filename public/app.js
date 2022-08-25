document.getElementById("button-get").addEventListener('click', get);
document.getElementById("button-post").addEventListener('click', post);
document.getElementById("button-put").addEventListener('click', put);
document.getElementById("button-patch").addEventListener('click', patch);
document.getElementById("button-delete").addEventListener('click', Delete);
document.getElementById('button-submit').addEventListener('click',submit);
// document.getElementById('edit-button').addEventListener('click',edit_data);
const modal = document.querySelector('.modal-container');
const correct = document.getElementById('correct');
var cancle_btn = document.querySelector('.cancle');
var edit_btn = document.querySelector('.edit');




//POST할 변수 받아오기
var names = document.getElementById('name');
var ages = document.getElementById('age');
var grades = document.getElementById('grade');


//edit값 받아오기
var name_edited = document.getElementById('name_edit');
var ages_edited = document.getElementById('age_edit');
var grades_edited = document.getElementById('grade_edit');

// //GET
async function get() {
    try{
    res = await fetch(`/customers`);
    datas = await res.json();
    customers = datas;
    UI.printMultiple(datas);
    } catch(err) {
        console.log(err);
    }
}

dummydata = {
    id: 4,
    name: "Jessica",
    age: 31,
    grade: "vip"
}

//POST
async function post() {
    try{
        res = await fetch('/customers',
        {
            method:'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dummydata)        
        });
        data = await res.json();
        console.log(data);
        UI.printMultiple(data);
    } catch(err) {
        console.log(err);
    }
        
};

//PUT
async function put() {
    try{
        res = await fetch('/customers/4',
        {
            method:'PUT',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({
                                    name: "Jessica",
                                    age: 31,
                                    grade: "regular"})
                
        });
         data = await res.json();
        console.log(data);
        UI.printMultiple(data);
    }catch(err) {
        console.error(err);
    }
}

//PATCH
async function patch() {
    try{
        res = await fetch('/customers/4',
        {
            method:'PATCH',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({age: 50})
                
        });
        data = await res.json();
        console.log(data);
        UI.printMultiple(data);
    }catch(err) {
        console.log(err);
    }
}

//DELETE
async function Delete() {
    
    try{
        res = await fetch('/customers/4',
        {
            method:'DELETE',
            headers: {'Content-Type': 'application/json'},
            
                
        });
        const data = await res.json();
        console.log(data);
        alert('delete completed');
    }catch(err) {
        console.log(err);
    }
}

//값을 입력하면 POST하기
async function submit() {
    if(names.value!='' && age.value!='' && grades.value!='' && id.value!=''){
// console.log(names.value);
        try{
            res = await fetch('/customers',
            {
                method:'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                name:names.value,
                age: ages.value,
                grade: grades.value
                })        
            });
            data = await res.json();
            console.log(data);
            UI.printMultiple(data);
        } catch(err) {
            console.log(err);
        }
    } else {
        alert('칸을 다 채우시오');
    }
    
}



//삭제하는 버튼 눌렀을 때
setTimeout(function() {
    document.getElementById('delete-button').addEventListener('click', (e) => DEL_BTN(e))}
,2000);

async function DEL_BTN(e) {
    document.getElementById('output').addEventListener('click', (e)=>{
    
        console.log(e.target.parentNode.id);
        
        try{
        res = fetch(`/customers/${e.target.parentNode.id}`,
        {
            method:'DELETE',
            headers: {'Content-Type': 'application/json'},
              
        });
        alert('delete completed');
        }catch(err) {
            console.log(err);
        }
    
    
    })
}
    
    
//수정하는 함수
setTimeout(function() {
    document.getElementById('edit-button').addEventListener('click',(e) => {
       //수정함수 구현
       modal.style.display = 'block';
       
       
       console.log(e.target.parentNode.id);
        ee = e.target.parentNode.id;
    //    console.log(e.target.parentNode)
    //수정하기 누른 후에 PUT하려고 할 때
        edit_btn.addEventListener('click' , (e) => {
        console.log(ee);
        try{
            res =  fetch(`/customers/${ee}`,
            {
                method:'PUT',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({
                                        name: name_edited.value,
                                        age: ages_edited.value,
                                        grade: grades_edited.value})
                    
            });
             data = res.json();
            console.log(data);
            UI.printMultiple(data);
        }catch(err) {
            console.error(err);
        }
        modal.style.display='none';
});
       
    })
},2000);



//수정하기 누른 후에 닫기 눌렀을 때
cancle_btn.addEventListener('click',() => {
    modal.style.display = 'none';
});




