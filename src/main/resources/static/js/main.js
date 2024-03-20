function borrarDepartamento(id,nombre) {
    if (confirm("¿Seguro que quieres borrar el departamento " + nombre + "?")) {
        alert("Departamento " + nombre + " borrado");
        window.location.href = "borrar/"+id;
    }
}
[[${mensaje}]]!==null?alert("[[${mensaje}]]"):null