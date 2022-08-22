document.getElementById('button1').addEventListener('click', loadCustomer);
document.getElementById('button2').addEventListener('click', loadCustomers);

//Load single customer
function loadCustomer() {
    const xhr = new XMLHttpRequest();

    xhr.open('GET', 'customer.json', true);

    xhr.send();

    xhr.onload = function() {
        if(this.status === 200) {
            // console.log(this.responseText);
            const customer = JSON.parse(this.responseText);
            // console.log(customer);
            const output = `
                <ul>
                    <li>ID: ${customer.id}</li>
                    <li>NAME: ${customer.name}</li>
                    <li>Age: ${customer.age}</li>
                    <li>Phone: ${customer.phone}</li>
                </ul>
                `;

                document.getElementById('customer').innerHTML = output;
        }
        
        
}
}

function loadCustomers() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'customers.json', true);
    xhr.send();

    xhr.onload = function() {
        if(this.status === 200) {
 
            let output = ``;
            const customers = JSON.parse(this.responseText);
            // console.log(customers)
            customers.forEach(function(customer) {

                // console.log(customer);
                output += `
                <ul>
                    <li>ID: ${customer.id}</li>
                    <li>NAME: ${customer.name}</li>
                    <li>Age: ${customer.age}</li>
                    <li>Phone: ${customer.phone}</li>
                </ul>
                `;
                // console.log(output)

            })
            document.getElementById('customers').innerHTML = output
           
        }
    }
}
