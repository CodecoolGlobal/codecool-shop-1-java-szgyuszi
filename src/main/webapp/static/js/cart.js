import {cartFactory} from "./cartFactory.js";

export function initCart() {
    initCarte()
    addMovieToCart()

}

function initCarte() {
    const cartBtn = document.querySelector('#cart');
    const modal = document.querySelector('#myModal');
    cartBtn.addEventListener("click", () => modal.style.display = "block");
    const closeBtn = document.querySelector('#close');
    closeBtn.addEventListener("click", () => modal.style.display = "none")
}

function addMovieToCart(){
    const addButtons = document.querySelectorAll('.add-to-cart')
    for (let button of addButtons){
        let buttonId = button.id
        button.addEventListener("click", ()=> initAddMovie(buttonId))
    }
}


async function initAddMovie(id){
    let product =  await getProduct(id)
    cartFactory(product)
    document.querySelector('#quantity').textContent = product.price;


}

async function getProduct(id){
    const response = await fetch(`/api/movie?id=${id}`)
    return await response.json()
}