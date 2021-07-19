$(document).ready(function () {

    var debes = document.querySelectorAll(".debe");
    var haberes = document.querySelectorAll(".haber");

    Array.prototype.slice.call(debes).forEach((debe) => {
        debe.addEventListener('keyup', function () {
            calcularTotalDebe(Array.prototype.slice.call(debes));
        });
    });

    Array.prototype.slice.call(haberes).forEach((haber) => {
        haber.addEventListener('keyup', function () {
            calcularTotalHaber(Array.prototype.slice.call(haberes));
        });
    });
    
    try {
        calcularTotalHaber(Array.prototype.slice.call(haberes));
    }catch (e){
        console.log(e);
    }

    $(".btn-close").on('click', function () {
        $(".alert").hide(100);
    });

    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    try {
                        let totalDebe = document.getElementById("totalDebe").value;
                        let totalHaber = document.getElementById("totalHaber").value;
                        
                        if (totalDebe != totalHaber) {
                            event.preventDefault()
                            event.stopPropagation()
                            console.log(totalDebe);
                            console.log(totalHaber);
                            $(".alert").show(100);
                        }
                    } catch (e) {
                        console.log(e);
                    }

                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }
                    form.classList.add('was-validated')
                }, false)
            });
});

function calcularTotalDebe(array) {
    let totalDebe = document.getElementById("totalDebe");
    let total = 0;
    array.forEach((element) => {
        total += parseFloat(element.value);
        console.log(element.value);
    });
    totalDebe.value = Number.parseFloat(total).toFixed(2);
}

function calcularTotalHaber(array) {
    let totalHaber = document.getElementById("totalHaber");
    let total = 0;
    array.forEach((element) => {
        total += parseFloat(element.value);
    });
    totalHaber.value = Number.parseFloat(total).toFixed(2);
}

function addRowMovimiento(movimientos) {
    let append = movimientos.childNodes[3].children[0].innerHTML;
    let parent = movimientos.childNodes[3];
    let html = `<tr> ${append}</tr>`;
    parent.innerHTML += html;
}