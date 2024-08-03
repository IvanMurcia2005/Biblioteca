var url = "http://localhost:8080/api/v1/usuarios/";

function consultarUsuarioID(id) {
    $.ajax({
        url: url + id,
        type: "GET",
        success: function (usuario) {
            document.getElementById("editIdUsuario").value = usuario.id;
            document.getElementById("editNombre").value = usuario.nombre;
            document.getElementById("editDireccion").value = usuario.direccion;
            document.getElementById("editCorreoElectronico").value = usuario.correoElectronico;
            document.getElementById("editTipoUsuario").value = usuario.tipo_de_usuario;
        },
        error: function (error) {
            console.error("Error al consultar el usuario:", error);
            Swal.fire({
                title: "Error",
                text: "Error al consultar el usuario.",
                icon: "error"
            });
        }
    });
}

function guardarCambiosUsuario() {
    let id = document.getElementById("editIdUsuario").value;
    let nombre = document.getElementById("editNombre").value;
    let direccion = document.getElementById("editDireccion").value;
    let correoElectronico = document.getElementById("editCorreoElectronico").value;
    let tipo_de_usuario = document.getElementById("editTipoUsuario").value;

    let formData = {
        nombre: nombre,
        direccion: direccion,
        correoElectronico: correoElectronico,
        tipo_de_usuario: tipo_de_usuario
    };

    $.ajax({
        url: url + id,
        type: "PUT",
        data: formData,
        success: function (result) {
            listarUsuarios();
            $('#modalEditarUsuario').modal('hide');
            Swal.fire({
                title: "¡Actualizado!",
                text: "El usuario ha sido actualizado correctamente.",
                icon: "success"
            });
        },
        error: function (error) {
            console.error("Error al actualizar el usuario:", error);
            Swal.fire({
                title: "Error",
                text: "Error al actualizar el usuario.",
                icon: "error"
            });
        }
    });
}

// Modificar el botón Editar
function listarUsuarios() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            console.log(result); 
            var cuerpoTabla = document.getElementById("cuerpoTabla");
            cuerpoTabla.innerHTML = ""; 

            result.forEach(function (usuarios) {
                var trRegistro = document.createElement("tr");

                var celdaId = document.createElement("td");
                var celdaNombre = document.createElement("td");
                var celdaDireccion = document.createElement("td");
                var celdaCorreoElectronico = document.createElement("td");
                var celdaTipo_de_usuario = document.createElement("td");
                var celdaAcciones = document.createElement("td");

                celdaId.innerText = usuarios.id;
                celdaNombre.innerText = usuarios.nombre;
                celdaDireccion.innerText = usuarios.direccion;
                celdaCorreoElectronico.innerText = usuarios.correoElectronico;
                celdaTipo_de_usuario.innerText = usuarios.tipo_de_usuario;

                var botonEditar = document.createElement("button");
                botonEditar.innerText = "Editar";
                botonEditar.className = "btn btn-warning";
                botonEditar.onclick = function () {
                    $('#modalEditarUsuario').modal('show');
                    consultarUsuarioID(usuarios.id);
                };

                var botonEliminar = document.createElement("button");
                botonEliminar.innerText = "Eliminar";
                botonEliminar.className = "btn btn-danger";
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
                            eliminar(usuarios.id);
                        }
                    });
                };

                var divBotones = document.createElement("div");
                divBotones.className = "btn-group";
                divBotones.appendChild(botonEditar);
                divBotones.appendChild(botonEliminar);

                celdaAcciones.appendChild(divBotones);

                trRegistro.appendChild(celdaId);
                trRegistro.appendChild(celdaNombre);
                trRegistro.appendChild(celdaDireccion);
                trRegistro.appendChild(celdaCorreoElectronico);
                trRegistro.appendChild(celdaTipo_de_usuario);

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


function eliminar(id) {
    $.ajax({
        url: url + id,
        type: "DELETE",
        success: function (result) {
            listarUsuarios();
            Swal.fire(
                '¡Eliminado!',
                'El usuario ha sido eliminado.',
                'success'
            );
        },
        error: function (error) {
            console.error("Error al eliminar el usuario:", error);
            Swal.fire({
                title: "Error",
                text: "Error al eliminar el usuario.",
                icon: "error"
            });
        }
    });
}


function registrarUsuario() {
    let nombre = document.getElementById("Nombre").value;
    let direccion = document.getElementById("Direccion").value;
    let correoElectronico = document.getElementById("CorreoElectronico").value;
    let tipo_de_usuario = document.getElementById("Tipo_de_usuario").value;


    let formData = {
        nombre: nombre,
        direccion: direccion,
        correoElectronico: correoElectronico,
        tipo_de_usuario: tipo_de_usuario, // Asegúrate de que el nombre del campo coincida con el esperado en el servidor
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