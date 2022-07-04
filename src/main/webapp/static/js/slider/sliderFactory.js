import {fragments} from "./htmlFactory.js";


 export async function initSlider() {
    const products = await getProducts();
    createSlider(products);

}

async function getProducts() {
    const response = await fetch(`/api/get-movies-all`)
    return await response.json()
}

function createSlider(products) {
    const root = document.querySelector('#slider-root');
    let firstIndex = 0;
    let endIndex = 3;
    const numberOfGroups = products.length / 3;
    for (let i = 0; i < numberOfGroups; i++) {
        let productsInGroup = products.slice(firstIndex, endIndex)
        const group = createGroup(productsInGroup, i+1, numberOfGroups);
        root.insertAdjacentHTML('beforeend', group)
        firstIndex = endIndex;
        endIndex += 3;
    }
    root.insertAdjacentHTML('beforeend', fragments.navigationIndicators)
    document.querySelector('#main-root').insertAdjacentHTML('beforeend', fragments.scroller)
}

function createGroup(products, groupNumber, maxGroups) {
    let previousGroup = groupNumber === 1 ? 1 : groupNumber-1;
    let nextGroup = groupNumber === maxGroups ? 1 : groupNumber+1;
    return `
    <div class="media-group" id="group-${groupNumber}">
        <a class="previous" href="#group-${previousGroup}">
            <svg>
                <use href="#previous"></use>
            </svg>
        </a>
        <div class="media-element">
            <img data-id="${products[0].id}"
                 src='static/img/product_${products[0].id}.jpg'
                 alt="">
        </div>
        <div class="media-element">
            <img data-id="${products[1].id}"
                 src='static/img/product_${products[1].id}.jpg'
                 alt="">
        </div>
        <div class="media-element">
            <img data-id="${products[2].id}"
                 src='static/img/product_${products[2].id}.jpg'
                 alt="">
        </div>
        <a class="next" href="#group-${nextGroup}" aria-label="next">
            <svg>
                <use href="#next"></use>
            </svg>
        </a>
    </div>
    `

}
