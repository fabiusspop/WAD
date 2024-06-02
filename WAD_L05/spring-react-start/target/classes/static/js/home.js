const prodDiv = document.getElementById("products");
const addProductButton = document.getElementById("addProductButton");

refreshProducts();

function refreshProducts(){
    fetch('/api/v1/products/')
        .then(response => response.json())
        .then(data => showProducts(data));
}

function showProducts(products){
    // Also, useful to see difference between imperative programming in Vanilla JS vs declarative in REACT
    prodDiv.innerHTML="";
    for(let i = 0; i< products.length; i++ ){
        let addedProd = document.createElement("div");
        addedProd.innerHTML = `${products[i].id} ${products[i].name} ${products[i].price}`
        prodDiv.appendChild(addedProd);
    }
}

addProductButton.onclick = () => {
    const productName = document.getElementById("productName").value;
    const productPrice = document.getElementById("productPrice").value;
    const product = {
        name: productName,
        price: productPrice
    };

    fetch('/api/v1/products/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
        .then(response => {
            if (response.ok) {
                refreshProducts();
            } else {
                console.error('Error adding product:', response.status);
            }
        });
};

const deleteProductButton = document.getElementById("deleteProductButton");
deleteProductButton.onclick = () => {
    const productId = document.getElementById("deleteProductId").value;

    fetch(`/api/v1/products/${productId}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                refreshProducts();
            } else {
                console.error('Error deleting product:', response.status);
            }
        });
};

const modifyProductButton = document.getElementById("modifyProductButton");
modifyProductButton.onclick = () => {
    const productId = document.getElementById("modifyProductId").value;
    const productName = document.getElementById("modifyProductName").value;
    const productPrice = document.getElementById("modifyProductPrice").value;
    const product = {
        name: productName,
        price: productPrice
    };

    fetch(`/api/v1/products/${productId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
        .then(response => {
            if (response.ok) {
                refreshProducts();
            } else {
                console.error('Error modifying product:', response.status);
            }
        });
};

