let click = document.querySelector('.category');
let list = document.querySelector('.c-list');
let x = 0;

click.addEventListener('click', () => {
    if (x === 0) {
        list.style.transform = 'scaleY(1)';
        list.style.opacity = 1;
        x = 1;
    } else {
        list.style.transform = 'scaleY(0)';
        x = 0;
    }

});



let Clickdrop = document.querySelector('#user-popup-dropdown');
let drop = document.querySelector('.user-box-popup');
let a = 0;

Clickdrop.addEventListener('click', () => {
    if (a === 0) {
        drop.style.transform = 'scaleY(1)';
        drop.style.opacity = 1;
        a = 1;
    } else {
        drop.style.transform = 'scaleY(0)';
        a = 0;
    }

});