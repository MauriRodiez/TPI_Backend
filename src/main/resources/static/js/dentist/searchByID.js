document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("search-byID");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const searchInput = document.getElementById("search").value;
    findBy(searchInput);
  });
});

function findBy(id) {
  const url = "http://localhost:8081/dentist/" + id;
  const settings = {
    method: "GET",
  };

  fetch(url, settings)
    .then((response) => response.json())
    .then((data) => {
      let dentist = data.data.Dentist;

      const dentistInfo = document.getElementById("dentist-info");
      dentistInfo.innerHTML = `
                <p>ID: ${dentist.id}</p>
                <p>Nombre: ${dentist.name}</p>
                <p>Apellido: ${dentist.surname}</p>
                <p>Matrícula: ${dentist.enrollment}</p>`;
    })
    .catch((error) => {
      alert("Error: " + error);
    });
}
