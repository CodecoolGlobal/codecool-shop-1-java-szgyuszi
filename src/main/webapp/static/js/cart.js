export function initCart() {
    initCarte()
}

function initCarte() {
    const cartBtn = document.querySelector('#cart');
    const modal = document.querySelector('#myModal');
    cartBtn.addEventListener("click", () => modal.style.display = "block");
    const closeBtn = document.querySelector('#close');
    closeBtn.addEventListener("click", () => modal.style.display = "none")
}