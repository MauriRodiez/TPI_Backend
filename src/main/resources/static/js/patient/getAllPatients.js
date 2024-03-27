window.addEventListener("load", function () {
  const getAll = document.querySelector("#getAll");
  const page = document.querySelector(".get-patient");
  const pageCreate = document.querySelector(".page-patient");

  getAll.addEventListener("click", function (e) {
    e.preventDefault();
    pageCreate.style.display = "none";
    page.style.display = "block";

    const url = "http://localhost:8081/patient/all";
    const settings = {
      method: "GET",
    };

    fetch(url, settings)
      .then((response) => response.json())
      .then((data) => {
        // const

        for (patient of data.data[0].Patients) {
          var table = document.getElementById("patientTable");
          var patientRow = table.insertRow();
          let tr_id = "tr_" + patient.id;
          patientRow.id = tr_id;

          let deleteButton =
            "<button" +
            " id=" +
            '"' +
            "btn_delete_" +
            patient.id +
            '"' +
            ' type="button" onclick="deleteBy(' +
            patient.id +
            ')" class="btn btn-danger btn_delete">' +
            "&times" +
            "</button>";

          let updateButton =
            "<button" +
            " id=" +
            '"' +
            "btn_id_" +
            patient.id +
            '"' +
            ' type="button" onclick="findBy(' +
            patient.id +
            ')" class="btn btn-info btn_id">' +
            "<i class='bi bi-pencil-square'></i>" +
            "</button>";

          patientRow.innerHTML =
            '<td class="td_nombre">' +
            patient.name.toUpperCase() +
            "</td>" +
            '<td class="td_apellido">' +
            patient.surname.toUpperCase() +
            "</td>" +
            '<td class="td_dni">' +
            patient.dni.toUpperCase() +
            "</td>" +
            '<td class="td_fecha">' +
            patient.registrationDate +
            "</td>" +
            '<td class="td_calle">' +
            patient.address.street.toUpperCase() +
            "</td>" +
            '<td class="td_numero">' +
            patient.address.number +
            "</td>" +
            '<td class="td_estado">' +
            patient.address.state.toUpperCase() +
            "</td>" +
            "<td>" +
            updateButton +
            "</td>" +
            "<td>" +
            deleteButton +
            "</td>";
        }
      })
      .catch((e) => {
        console.error("errorrrrrrrr", e);
        e.alert("error al cargar la info");
      });
  });
});
