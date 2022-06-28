import {initCart} from "./cart.js";

initCart()
init();

function init() {
    addEventToCards()
}


function addEventToCards() {
    const cards = document.querySelectorAll(".media-element");
    for (let card of cards) {
        card.addEventListener("click", (event)=> {
            const id = event.target.dataset.id
            window.location.href = `/movie?id=${id}`;
        })
    }
}