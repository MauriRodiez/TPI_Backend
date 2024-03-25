window.addEventListener('load', function(){
    /*-----------------------------------------------*/
    /*--                  Nodos                    --*/
    /*-----------------------------------------------*/
    const create = document.querySelector("#create");
    const page = document.querySelector(".page-patient");
    const box = document.querySelector(".box");

    /*-----------------------------------------------*/
    /*--                   Form                    --*/
    /*-----------------------------------------------*/
    const form = document.createElement("form");
    form.id = "createPatient";

    // Input name
    const nombreLabel = document.createElement("label");
    nombreLabel.textContent = "Nombre:";

    const nameInput = document.createElement("input");
    nameInput.type = "text";
    nameInput.name = "namePatient";

    // Button cargar
    const submitBtn = document.createElement('button');
    submitBtn.type = 'submit';
    submitBtn.textContent = 'Registrarse';

    // Add elements to form
    form.appendChild(nombreLabel);
    form.appendChild(nameInput);
    form.appendChild(submitBtn);
    box.appendChild(form);

    /*-----------------------------------------------*/
    /*--           Evento click Agregar Paciente    --*/
    /*-----------------------------------------------*/
    create.addEventListener("click", function(event){
        event.preventDefault();

        page.style.display = "block";
        page.innerHTML = '';
        page.appendChild(box);
    });
});
