import {initCart} from "./cart.js";

init();

function init() {
    initCart()
    addEventToCards()
}


function addEventToCards() {
    const cards = document.querySelectorAll(".media-element");
    for (let card of cards) {
        card.addEventListener("click", (event)=> {
            const id = event.target.dataset.id
            if (id !== undefined) {
                window.location.href = `/movie?id=${id}`;
            }
        })
    }
}