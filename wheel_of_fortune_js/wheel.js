/************************************************/
/*                                              */
/*   ███████╗██╗██╗     ██╗██████╗              */
/*   ██╔════╝██║██║     ██║██╔══██╗             */
/*   █████╗  ██║██║     ██║██████╔╝             */
/*   ██╔══╝  ██║██║     ██║██╔═══╝              */
/*   ██║     ██║███████╗██║██║                  */
/*   ╚═╝     ╚═╝╚══════╝╚═╝╚═╝                  */
/*                                              */
/************************************************/

let canvas;
let context;
let image;
let rotation = 0;

document.addEventListener("DOMContentLoaded", function() {
    canvas = document.getElementById("canvas");
    context = canvas.getContext("2d");
    image = document.getElementById("wheel");
    image.style.display = "none";

    redraw();
    let interval = setInterval(redraw, 20);

    window.addEventListener("beforeunload", function() {
        clearInterval(interval);
    });
});

function redraw() {
    context.clearRect(0, 0, 500, 500);
    context.save();
    context.translate(250, 250);
    context.rotate(rotation);
    context.drawImage(image, -225, -225);
    context.restore();
    rotation += (2 * Math.PI) / 360;
}
