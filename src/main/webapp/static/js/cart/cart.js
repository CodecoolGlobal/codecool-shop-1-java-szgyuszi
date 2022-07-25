import {cartFactory} from "./cartFactory.js";

initCart();

function initCart() {
    initAddToCart()
    addEventToCart()
    addEventToCheckout()
}



function initAddToCart(){
    const addButtons = document.querySelectorAll('.add-to-cart')
    for (let button of addButtons){
        let buttonId = button.id
        button.addEventListener("click", ()=> {
            initAddMovie(buttonId)
        })
        modifyCartBadge(button)
    }
}


async function initAddMovie(id){
    document.querySelector('#place-holder').innerHTML = "";
    let product = await getProduct(id)
    addEventToClosingModal(product)
    saveProductDetailsToMemory(product)


}

async function getProduct(id){
    const response = await fetch(`/api/movie?id=${id}`)
    return await response.json()
}

function addEventToCart() {
    const cartButton = document.querySelector('#cart');
    cartButton.addEventListener('click', () => {
        const product = JSON.parse(window.localStorage.getItem('product'))
        if (product !== null) {
            cartFactory(product)
        }

    })
}

function saveProductDetailsToMemory({name, price, id}) {

    const product = {
        name: name,
        price: price,
        id: id,
        quantity: 1,
    }
    window.localStorage.setItem('product', JSON.stringify(product))
}

function addEventToClosingModal(product) {
    const closeButton = document.querySelector('#cross');
    const cancelButton = document.querySelector('#close-modal-btn');

    closeButton.addEventListener("click", ()=>
        saveProductDetailsToMemory(product));

    cancelButton.addEventListener("click", () =>
        saveProductDetailsToMemory(product));
}

function modifyCartBadge(button) {
    button.addEventListener("click", ()=> {
        const badge = document.querySelector('#s-c-badge');
        const badgeContent = parseInt(document.querySelector('#s-c-badge').textContent);
        badge.textContent = `${badgeContent+1}`
    })
}

function addEventToCheckout() {
    const checkoutBtn = document.querySelector("#checkout-btn")
    const checkoutCross = document.querySelector("#cross-checkout")
    const checkoutModal = document.querySelector("#checkout-modal")
    checkoutBtn.addEventListener("click", () => showCheckoutModal(checkoutModal))
    checkoutCross.addEventListener("click", () => hideCheckoutModal(checkoutModal))
}

function showCheckoutModal(modal){
    modal.classList.remove("hide-modal")
    modal.classList.add("show-modal")
}

function hideCheckoutModal(modal){
    modal.classList.remove("show-modal")
    modal.classList.add("hide-modal")
}


