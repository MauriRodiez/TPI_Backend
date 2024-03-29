document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("search-byID");

  form.addEventListener("submit", function (event) {
    event.preventDefault(); // Evitar que el formulario se envíe de forma predeterminada

    const searchInput = document.getElementById("search").value;
    findBy(searchInput);
  });
});

function findBy(id) {
  const url = "/patient/" + id;
  const settings = {
    method: "GET",
  };

  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      console.log("Datos recibidos:", data);
      let patient = data.data.Patient;
      // Mostrar la información del paciente en algún lugar de la página
      const patientInfo = document.getElementById("patient-info");
      patientInfo.innerHTML = `
                <p>ID: ${patient.id}</p>
                <p>Nombre: ${patient.name}</p>
                <p>Apellido: ${patient.surname}</p>
                <p>DNI: ${patient.dni}</p>
                <p>Fecha de registro: ${patient.registrationDate}</p>
                <p>Dirección: ${patient.address.street}, ${patient.address.number}, ${patient.address.state}</p>`;
    })
    .catch((error) => {
      alert("Error: " + error);
    });
}
