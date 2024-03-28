function confirmDelete(id) {
    return confirm("¿Estás seguro de eliminar el paciente " + id + "?");
}

function deleteBy(id) {
    const url = '/patient/delete/' + id;
    const settings = {
        method: 'DELETE'
    };

    if (confirmDelete(id)) {
        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    let row_id = "#tr_" + id;
                    document.querySelector(row_id).remove();
                } else {
                    throw new Error('Error al eliminar el paciente');
                }
            })
            .catch(error => {
                console.error('Error:', error.message);
                alert('Error al eliminar el paciente: ' + error.message);
            });
    }
}
