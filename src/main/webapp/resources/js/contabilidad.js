$(document).ready(function () {
    var movimientos = document.getElementById("movimientosDt");

    $(".number").on('keyup', function () {
        let totalD = 15.00;
        let totalH = 21.00;
        $("#totalDebe").html(`$ ${totalD}`);
        $("#totalHaber").html(`$ ${totalH}`);
    });

    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            });
});

function addRowMovimiento(movimientos) {
    let append = movimientos.childNodes[3].children[0].innerHTML;
    let parent = movimientos.childNodes[3];
    let html = `<tr> ${append}</tr>`;
    parent.innerHTML += html;
}