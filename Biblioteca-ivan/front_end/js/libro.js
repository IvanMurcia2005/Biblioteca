var url = "http://localhost:8080/api/v1/libros/";

function listarLibro() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            console.log(result); 
            var cuerpoTabla = document.getElementById("cuerpoTabla");
            cuerpoTabla.innerHTML = ""; 

            result.forEach(function (libro) {
                var trRegistro = document.createElement("tr");

                var celdaId = document.createElement("td");
                var celdaTitulo = document.createElement("td");
                var celdaAutor = document.createElement("td");
                var celdaGenero = document.createElement("td");
                var celdaIsbn = document.createElement("td");
                var celdaCantidad_Disponible = document.createElement("td");
                var celdaCantidad_Ocupada = document.createElement("td");
                var celdaAcciones = document.createElement("td");

                celdaId.innerText = libro.id;
                celdaTitulo.innerText = libro.titulo;
                celdaAutor.innerText = libro.autor;
                celdaGenero.innerText = libro.genero;
                celdaIsbn.innerText = libro.isbn;
                celdaCantidad_Disponible.innerText = libro.numero_de_ejemplares_disponibles;
                celdaCantidad_Ocupada.innerText = libro.numero_de_ejemplares_ocupados;

                var botonEditarLibro = document.createElement("button");
                botonEditarLibro.innerText = "Editar";
                botonEditarLibro.className = "btn btn-warning Editar_Libro";
                botonEditarLibro.onclick = function () {
                    $('#modal_del_Libro').modal('show');
                    consultarLibroID(libro.id);
                };

                var botonEliminar = document.createElement("button");
                botonEliminar.innerText = "Eliminar";
                botonEliminar.className = "btn btn-danger eliminar";
                botonEliminar.onclick = function () {
                    Swal.fire({
                        title: '¿Estás seguro?',
                        text: "¡No podrás revertir esto!",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#d33',
                        confirmButtonText: 'Sí, eliminarlo'
                    }).then((result) => {
                        if (result.isConfirmed) {
                            eliminar(libro.id);
                        }
                    });
                };

                var divBotones = document.createElement("div");
                divBotones.className = "btn-group";
                divBotones.appendChild(botonEditarLibro);
                divBotones.appendChild(botonEliminar);

                celdaAcciones.appendChild(divBotones);

                trRegistro.appendChild(celdaId);
                trRegistro.appendChild(celdaTitulo);
                trRegistro.appendChild(celdaAutor);
                trRegistro.appendChild(celdaGenero);
                trRegistro.appendChild(celdaIsbn);
                trRegistro.appendChild(celdaCantidad_Disponible);
                trRegistro.appendChild(celdaCantidad_Ocupada);
                trRegistro.appendChild(celdaAcciones);

                cuerpoTabla.appendChild(trRegistro);
            });
        },
        error: function (error) {
            console.error("Error en la petición:", error);
            alert("Error en la petición: " + error.statusText);
        }
    });
}

function consultarLibroID(id) {
    $.ajax({
        url: url + id,
        type: "GET",
        success: function (libro) {
            $('#editIdLibro').val(libro.id);
            $('#editTitulo').val(libro.titulo);
            $('#editAutor').val(libro.autor);
            $('#editIsbn').val(libro.isbn);
            $('#editGenero').val(libro.genero);
            $('#editNumeroDeEjemplaresDisponibles').val(libro.numero_de_ejemplares_disponibles);
            $('#editNumeroDeEjemplaresOcupados').val(libro.numero_de_ejemplares_ocupados);
        },
        error: function (error) {
            console.error("Error al consultar el libro:", error);
            Swal.fire({
                title: "Error",
                text: "Error al consultar los datos del libro.",
                icon: "error"
            });
        }
    });
}
function editarLibro() {
    var id = $('#editIdLibro').val();
    var titulo = $('#editTitulo').val();
    var autor = $('#editAutor').val();
    var isbn = $('#editIsbn').val();
    var genero = $('#editGenero').val();
    var numero_de_ejemplares_disponibles = $('#editNumeroDeEjemplaresDisponibles').val();
    var numero_de_ejemplares_ocupados = $('#editNumeroDeEjemplaresOcupados').val();

    var datosEditados = {

        titulo: titulo,
        autor: autor,
        isbn: isbn,
        genero: genero,
        numero_de_ejemplares_disponibles: numero_de_ejemplares_disponibles,
        numero_de_ejemplares_ocupados: numero_de_ejemplares_ocupados
    };

    $.ajax({
        url: url + id,
        type: "PUT",
        data: JSON.stringify(datosEditados),
        contentType: "application/json",
        success: function (result) {
            $('#modal_del_Libro').modal('hide');
            listarLibro();  // Asegúrate de que esta función actualice la tabla correctamente
            Swal.fire({
                title: "¡Excelente!",
                text: "Libro actualizado correctamente.",
                icon: "success"
            });
        },
        error: function (error) {
            console.error("Error al actualizar el libro:", error);
            Swal.fire({
                title: "Error",
                text: "Error al actualizar el libro.",
                icon: "error"
            });
        }
    });
}

function eliminar(id) {
    $.ajax({
        url: url + id,
        type: "DELETE",
        success: function (result) {
            listarLibro();
            Swal.fire(
                '¡Eliminado!',
                'El libro ha sido eliminado.',
                'success'
            );
        },
        error: function (error) {
            console.error("Error al eliminar el libro:", error);
            Swal.fire({
                title: "Error",
                text: "Error al eliminar el libro.",
                icon: "error"
            });
        }
    });
}

function registrarLibro() {
    let titulo = document.getElementById("Titulo").value;
    let autor = document.getElementById("Autor").value;
    let genero = document.getElementById("Genero").value;
    let ISBN = document.getElementById("Isbn").value;
    let numero_de_ejemplares_disponibles = document.getElementById("numero_de_ejemplares_disponibles").value;
    let numero_de_ejemplares_ocupados = document.getElementById("numero_de_ejemplares_ocupados").value;

    let formData = {
        titulo: titulo,
        autor: autor,
        genero: genero,
        ISBN: ISBN, // Asegúrate de que el nombre del campo coincida con el esperado en el servidor
        numero_de_ejemplares_disponibles: numero_de_ejemplares_disponibles,
        numero_de_ejemplares_ocupados: numero_de_ejemplares_ocupados
    };

 

    $.ajax({
        url: url,
        type: "POST",
        data: formData,
        success: function (result) {
            Swal.fire({
                title: "¡Excelente!",
                text: "Se guardó correctamente",
                icon: "success"
            });

        },
        error: function (error) {
            console.error("Error al guardar el libro:", error);
            Swal.fire({
                title: "Error",
                text: "Error al guardar el libro",
                icon: "error"
            });
        }
    });
}