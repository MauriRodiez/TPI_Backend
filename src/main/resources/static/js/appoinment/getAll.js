window.addEventListener("load", function () {
  const getAll = document.querySelector("#v-pills-getallAppointments");
  let listOk = false;

  getAll.addEventListener("click", function (e) {
    e.preventDefault();

    const url = "http://localhost:8081/appointment/all";
    const settings = {
      method: "GET",
    };

    if (!listOk) {
      fetch(url, settings)
        .then((response) => response.json())
        .then((data) => {
          for (appointment of data.data.Appointments) {
            var table = document.getElementById("appointmentTable");
            var appointmentRow = table.insertRow();
            let tr_id = "tr_" + appointment.id;
            appointmentRow.id = tr_id;

            console.log("ESta es la info de turno: " + appointment);

            let deleteButton =
              "<button" +
              " id=" +
              '"' +
              "btn_delete_" +
              appointment.id +
              '"' +
              ' type="button" onclick="deleteBy(' +
              appointment.id +
              ')" class="btn btn-danger btn_delete">' +
              "<i class='bi bi-trash3'></i>" +
              "</button>";

            let updateButton =
              "<button" +
              " id=" +
              '"' +
              "btn_id_" +
              appointment.id +
              '"' +
              ' type="button" onclick="updateFindBy(' +
              appointment.id +
              ')" class="btn btn-info btn_id">' +
              "<i class='bi bi-pencil-square'></i>" +
              "</button>";

            appointmentRow.innerHTML =
              '<td class="td_date">' +
              appointment.dateAppointment +
              "</td>" +
              '<td class="td_patient">' +
              appointment.patient.id +
              "</td>" +
              '<td class="td_dentist">' +
              appointment.dentist.id +
              "</td>" +
              "<td>" +
              updateButton +
              "</td>" +
              "<td>" +
              deleteButton +
              "</td>";
          }
          listOk = true;
        })
        .catch((e) => {
          console.error("errorrrrrrrr", e);
          e.alert("error al cargar la info");
        });
    }
  });
});