import {cartFactory} from "./cartFactory.js";

initCart();

function initCart() {
    addMovieToCart()
}



function addMovieToCart(){
    const addButtons = document.querySelectorAll('.add-to-cart')
    for (let button of addButtons){
        let buttonId = button.id
        button.addEventListener("click", ()=> initAddMovie(buttonId))
    }
}


async function initAddMovie(id){
    document.querySelector('#place-holder').innerHTML = "";
    let product =  await getProduct(id)
    cartFactory(product)
    document.querySelector('#total-price').textContent = product.price + ' USD';


}

async function getProduct(id){
    const response = await fetch(`/api/movie?id=${id}`)
    return await response.json()
}