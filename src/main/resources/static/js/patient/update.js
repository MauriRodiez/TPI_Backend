window.addEventListener('load', function () {

const form = document.querySelector('#update_patient_form');

form.addEventListener('submit', function (e) {

        e.preventDefault();

        let patientId = document.querySelector('#patient_id').value;

        const patientData = {
            id: document.querySelector('#patient_id').value,
            name: document.querySelector("#name_patient_up").value,
            surname: document.querySelector("#surname_patient_up").value,
            dni: document.querySelector("#dni_up").value,
            registrationDate: document.querySelector("#registration_date_up").value,
            address: {
                 street: document.querySelector("#street_Up").value,
                 number: document.querySelector("#street_num_up").value,
                 state: document.querySelector("#state_up").value
                     }
            };

        const url = '/patient/update';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(patientData)
        }

        fetch(url, settings)
        .then(response => {
               if (response.ok) {
                    // Actualización exitosa, puedes realizar cualquier acción necesaria
                   console.log('Paciente actualizado correctamente');
                   } else {
                      throw new Error('Error al actualizar el paciente');
                   }
                })
        .catch(error => {
               console.error('Error:', error);
               alert('Error al actualizar el paciente: ' + error.message);
               });


    })
 })

function findBy(id) {
          const url = '/patient'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let patient = data;
              document.querySelector('#patient_id').value = patient.id;
              document.querySelector('#name_patient_up').value = patient.name;
              document.querySelector('#surname_patient_up').value = patient.surname;
              document.querySelector('#dni_up').value = patient.dni;
              document.querySelector('#registration_date_up').value = patient.registrationDate;
              //document.querySelector('#street_Up').value = patient.address.street;
              //document.querySelector('#street_num_up').value = patient.address.number;
              //document.querySelector('#state_up').value = patient.address.state;

              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_patient_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
     })
}