//SIDEBAR
const menuItems = document.querySelectorAll('.menu-item');

//MESSAGES
const messagesNotification = document.querySelector('#messages-notification');
const messages = document.querySelector('.messages');
const message = messages.querySelectorAll('.message');
const messageSearch = document.querySelector('#message-search');

//theme
const theme = document.querySelector('#theme');
/**
 * Esta línea de código es el puente entre tu JavaScript y tu HTML. Su función es buscar un elemento específico en tu página web para que puedas manipularlo (cambiarle el color, el texto, añadirle un evento, etc.).

Aquí te explico el desglose:

const theme: Crea una variable (un nombre) para guardar la referencia al elemento. Se usa const porque normalmente no vas a reasignar esta variable a otro elemento diferente después.

document: Es el objeto global que representa toda tu página web.

.querySelector(): Es un método (una herramienta) que busca elementos usando selectores de CSS.

('#theme'): El símbolo # le indica a JavaScript que busque un elemento que tenga el atributo id="theme".
 * 
 * 
 * **/ 
const themeModal = document.querySelector('.customize-theme');
const fontSizes = document.querySelectorAll('.choose-size span');
var root = document.querySelector(':root');
const colorPalette = document.querySelectorAll('.choose-color span');
const Bg1 = document.querySelector('.bg-1');
const Bg2 = document.querySelector('.bg-2');
const Bg3 = document.querySelector('.bg-3');

//========= SIDEBAR ========


///eliminar la clase activa de todos los elementos del menú
const changeActiveItem = () => {
    menuItems.forEach(item => {
        item.classList.remove('active');
    });
};

/**
 * Esta es una función de limpieza. Su único trabajo es "apagar" o quitar el estado activo de todos los elementos de un menú antes de encender el que el usuario acaba de tocar.

Imagina un menú donde el botón seleccionado se pone de color azul. Si haces clic en "Inicio" y luego en "Perfil", no quieres que ambos se vean azules; quieres que "Inicio" se apague y "Perfil" se encienda.

El desglose paso a paso:
const changeActiveItem = () => { ... }; Estás definiendo una función de flecha (arrow function) y guardándola en una constante.

menuItems.forEach(item => { ... }); Aquí le dices a JavaScript: "Toma la lista de todos los elementos del menú (menuItems) y recorre uno por uno". La variable item representa a cada elemento individual mientras se hace el recorrido.

item.classList.remove('active'); Esta es la acción: a cada elemento que encuentra, le quita la clase CSS llamada 'active'. No importa si la tiene o no; JavaScript se asegura de que desaparezca.
*/

menuItems.forEach(item => {
    item.addEventListener('click', () => {
        changeActiveItem();
        item.classList.add('active');
        if(item.id != 'notifications'){
            document.querySelector('.notifications-popup').style.display = 'none';
        }else{
            document.querySelector('.notifications-popup').style.display = 'block';
            document.querySelector('#notifications .notifications-count').style.display = 'none';
        }
    });
});

//======== MEnsajes===========
//searches chats
const searchMessage = () => {
    const val = messageSearch.value.toLowerCase();

    message.forEach(chat => {
       let name = chat.querySelector('h5').textContent.toLowerCase();
        if(name.indexOf(val) != -1){
            chat.style.display = 'flex';
        }else{
            chat.style.display = 'none';
        }
    });
}

//search chats
messageSearch.addEventListener('keyup', searchMessage); 



//Resaltar la tarjeta de mensajes cuando se hace clic en el elemento del menú de mensajes
messagesNotification.addEventListener('click', () => {
    messages.style.boxShadow = '0 0 1rem var(--color-primary)';
    messagesNotification.querySelector('.notifications-count').style.display = 'none';
    setTimeout(() => 
        {
            messages.style.boxShadow = 'none'; 
        }, 2000);
});

//THEME/DISPLAY CUSTOMIZATION

//open modal
const openThemeModal = () => {
    themeModal.style.display = 'grid';
}

//close modal
const closeThemeModal = (e) => {
    if(e.target.classList.contains('customize-theme')){
        themeModal.style.display = 'none';
    }
}

//close modal
themeModal.addEventListener('click', closeThemeModal);

//close modal
theme.addEventListener('click', openThemeModal);




//================= FONTS ===================
//eliminar la clase activa de los selectores de tamaño de fuente o spans
const removeSizeSelector = () => {
    fontSizes.forEach(size => {
        size.classList.remove('active');
    });
}


fontSizes.forEach(size => {
    size.addEventListener('click', () => {

    removeSizeSelector();
    let fontSize;
    size.classList.toggle('active');

 if(size.classList.contains('font-size-1')){
    fontSize = '10px';
    root.style.setProperty('--sticky-top-left', '5.4rem');
    root.style.setProperty('--sticky-top-right', '5.4rem');
}else if(size.classList.contains('font-size-2')){
    fontSize = '13px';
    root.style.setProperty('--sticky-top-left', '5.4rem');
    root.style.setProperty('--sticky-top-right', '-7rem');
}else if(size.classList.contains('font-size-3')){
    fontSize = '16px';
    root.style.setProperty('--sticky-top-left', '-2rem');
    root.style.setProperty('--sticky-top-right', '-17rem');
}else if(size.classList.contains('font-size-4')){
    fontSize = '19px';
    root.style.setProperty('--sticky-top-left', '-5rem');
    root.style.setProperty('--sticky-top-right', '-25rem');
}else if(size.classList.contains('font-size-5')){
    fontSize = '22px';
    root.style.setProperty('--sticky-top-left', '-12rem');
    root.style.setProperty('--sticky-top-right', '-35rem');
}

//cambiar el tamaño de fuente del elemento html raíz
document.querySelector('html').style.fontSize = fontSize;

    });
})


//eliminar la clase activa de colores
const changeActiveColorClass = () => {
    colorPalette.forEach(colorPicker => {
        colorPicker.classList.remove('active');
    });
}


//cambiar colores primarios
colorPalette.forEach(color => {
    color.addEventListener('click', () => {
        let primary;
        //eliminar la clase activa de colores
        changeActiveColorClass();

        if(color.classList.contains('color-1')){
            primaryHue = 252;
           
        }else if(color.classList.contains('color-2')){
            primaryHue = 52;
        }else if(color.classList.contains('color-3')){
            primaryHue = 352;
        }else if(color.classList.contains('color-4')){
            primaryHue = 152;
        }else if(color.classList.contains('color-5')){
            primaryHue = 202;
        }
        color.classList.add('active');

        root.style.setProperty('--primary-color-hue', primaryHue);
    });
});

//valores de FONDO del tema
let lightColorLightness;
let whiteColorLightness;
let darkColorLightness;


//cambiar color de fondo
const changeBg = () => {
    root.style.setProperty('--light-color-lightness', lightColorLightness);
    root.style.setProperty('--white-color-lightness', whiteColorLightness);
    root.style.setProperty('--dark-color-lightness', darkColorLightness);
}


//cambiar el color de fondo
Bg1.addEventListener('click', () => {
    //Añadir clase activa
    Bg1.classList.add('active');    
    //Eliminar clase activa de las demás
    Bg2.classList.remove('active');
    Bg3.classList.remove('active');
//Eliminar cambios personalizados del almacenamiento local
    window.location.reload();
});



Bg2.addEventListener('click', () => {
    darkColorLightness = '95%';
    whiteColorLightness = '20%';
    lightColorLightness = '15%';

    //Añadir clase activa
    Bg2.classList.add('active');
    //Eliminar clase activa de las demás
    Bg1.classList.remove('active');
    Bg3.classList.remove('active');
    changeBg();
});

Bg3.addEventListener('click', () => {
    darkColorLightness = '95%';
    whiteColorLightness = '10%';
    lightColorLightness = '0%';

    //Añadir clase activa
    Bg3.classList.add('active');
    //Eliminar clase activa de las demás
    Bg1.classList.remove('active');
    Bg2.classList.remove('active');
    changeBg();
});