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
    console.log("ww")
    const addButtons = document.querySelectorAll('.add-to-cart')
    console.log(addButtons)
    for (let button of addButtons){
        let buttonId = button.id
        console.log(buttonId)
        button.addEventListener("click", ()=> initAddMovie(buttonId))
    }
}


async function initAddMovie(id){
    console.log('ss')
    const modalContent = document.querySelector('.modal-content')
    const movie = document.createElement('p')
    let product =  await getProduct(id)

    movie.textContent = product.id
    modalContent.append(movie)

}

async function getProduct(id){
    const response = await fetch(`/api/movie?id=${id}`)
    return await response.json()
}