// script.js

document.addEventListener("DOMContentLoaded", function() {
    // Fetch products from the backend
    fetch('http://localhost:8080/products')
        .then(response => response.json())
        .then(products => {
            // Update the UI with the product list
            const productList = document.getElementById('productList');

            products.forEach(product => {
                const productCard = document.createElement('div');
                productCard.className = 'product-card';
                productCard.textContent = `${product.prodId} - ${product.prodName} - Cost: ${product.prodCost}`;
                productList.appendChild(productCard);
            });
        })
        .catch(error => console.error('Error:', error));
});

// Display the modal when the "Add Product" button is clicked
const addProductBtn = document.getElementById('addProductBtn');
const modal = document.getElementById('myModal');
const overlay = document.getElementById('overlay');
const closeModalBtn = document.getElementById('closeModal');

addProductBtn.addEventListener('click', function() {
    modal.style.display = 'block';
    overlay.style.display = 'block';
});

closeModalBtn.addEventListener('click', function() {
    modal.style.display = 'none';
    overlay.style.display = 'none';
});


// Handle the "Add Product" form submission
function addProduct() {
    const prodId = document.getElementById('prodId').value;
    const prodName = document.getElementById('prodName').value;
    const prodCost = document.getElementById('prodCost').value;

    // Make a POST request to add the product
    fetch('http://localhost:8080/products', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ prodId, prodName, prodCost }),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);

        // Close the modal after successful submission
        closeModal();

        // Update the UI by adding the new product to the product list
        const productList = document.getElementById('productList');
        const productCard = document.createElement('div');
        productCard.className = 'product-card';
        productCard.textContent = `${prodId} - ${prodName} - Cost: ${prodCost}`;
        productList.appendChild(productCard);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

// Function to close the modal
function closeModal() {
    modal.style.display = 'none';
    overlay.style.display = 'none';
}




// Function to Delete All Products
function deleteAllProducts() {
    fetch('http://localhost:8080/products/deleteAll', {
        method: 'DELETE'
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        console.log('Success:', data);
        // Perform any additional actions after successful deletion
          // Refresh the page
                location.reload();
    })
    .catch(error => {
        console.error('Error:', error);
    });
}


//Display the DeleteProductById when it is clicked
const deleteModal = document.getElementById('deleteIdModal');
const closeProductModal = document.getElementById('closeProductModal');
const deleteProductById = document.getElementById('deleteProductByIdBtn');

deleteProductById.addEventListener('click' , function(){
    deleteModal.style.display= 'block';
    overlay.style.display='block';
});

closeProductModal.addEventListener('click', function(){
    deleteModal.style.display = 'none';
    overlay.style.display = 'none';
});




//Function to Delete Product By Id
function deleteProductByIdBtn1(){
var id = document.getElementById('productId').value;
fetch('http://localhost:8080/products/'+id ,{
    method: 'DELETE'
    });

}
