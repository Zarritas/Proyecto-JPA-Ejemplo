function pintarTabla(data) {
    const documento = document.getElementById("tabla_departamentos")

    for (const dept of data) {
        const tr = document.createElement("tr")
        tr.innerHTML = `
            <td>${dept.numero}</td>
            <td><a href="/departamentos/detalle/${dept.id}?editable=false">${dept.nombre}</a></td>
            <td>${dept.localidad}</td>
            <td>${dept.fechaCreacion}</td>
            <td class="botones editar"><a href="/departamentos/detalle/${dept.id}?editable=true">&#128398;</a></td>
            <td class="botones borrar"><div onclick="borrarDepartamento('${dept.id}', '${dept.nombre}')">&#128503;</div></td>
        `
        documento.appendChild(tr)
    }
}
function borrarDepartamento(id,nombre) {
    if (confirm("¿Seguro que quieres borrar el departamento " + nombre + "?")) {
        alert("Departamento " + nombre + " borrado");
        window.location.href = "borrar/"+id;
    }
}
fetch("http://localhost:8080/departamento/listado")
    .then(r => r.json())
    .then(data => pintarTabla(data))
