window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        loadUsers();
        new datatablesSimple.DataTable(datatablesSimple);
    }
});



async function loadUsers(){
    const request = await fetch('api/usuarios', {
        method: 'GET',
        headers: {
        'Accept' : 'application/json',
        'Content-Type' : 'application/json'
        }
    });
    const requestOcupation = await fetch('api/ocupacion', {
            method: 'GET',
            headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
            }
    });
    const requestTool = await fetch('api/herramienta', {
            method: 'GET',
            headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
            }
    });
    const requestPlayer = await fetch('api/jugador', {
                method: 'GET',
                headers: {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
                }
    });


    const ocupations = await requestOcupation.json();
    const tools = await requestTool.json();
    const players = await requestPlayer.json();
    const users = await request.json();

    let listHTML = '';
    let userOcupation = 0;
    let userTool = 0;
    let userPlayer = '';


    for(let user of users){
        let secondName = user.u_nombre_2 == null ? '' : user.u_nombre_2;
        let secondLName = user.u_apellido_m == null ? '' : user.u_apellido_m;

        for(let ocupation of ocupations){
            if(ocupation.id_ocupacion == user.u_fk_ocupacion){
                userOcupation = ocupation.ocupacion;
                break;
            }

        }

        for(let tool of tools){
            if(tool.id_uso_h == user.u_fk_uso_h){
                userTool = tool.motivo;
                break;
            }
        }

        for(let player of players){
            if(player.id_jugador == user.u_fk_jugador ){
                userPlayer = player.j_nombre;
                break;
            }
        }

        let userHTML = `<tr>
                            <td> ${user.id_usuario} </td>
                            <td> ${user.u_nombre_1} ${secondName} ${user.u_apellido_p} ${secondLName} </td>
                            <td> ${userPlayer} </td>
                            <td> ${userOcupation} </td>
                            <td> ${userTool} </td>
                            <td> ${user.u_correo_e} </td>
                            <td> ${user.u_nacimiento} </td>
                        </tr>`;

        listHTML += userHTML;
    }


    document.querySelector('#datatablesSimple tbody').outerHTML = listHTML;

}


async function registrarUsuario(){

    let datos = {};

    datos.name = document.getElementById("name").value;
    datos.middlename = document.getElementById("middleName").value;
    datos.lastname = document.getElementById("lastName").value;
    datos.secondlastname = document.getElementById("secondLastName").value;
    datos.jugador = document.getElementById("player").value;
    datos.email = document.getElementById("email").value;

    let fecha = new Date(document.getElementById("bornDate").value);

    datos.dia = fecha.getDate()+1;
    datos.mes = fecha.getMonth()+1;
    datos.anio = fecha.getFullYear();

    datos.herramienta = document.getElementById("tool").value;
    datos.ocupacion = document.getElementById("ocupation").value;
    datos.password = document.getElementById("password").value;

    let passwordConfirm = document.getElementById("passwordConfirm").value;

    if(passwordConfirm != datos.password){
            alert("The typed password is different");
            return;
    }


    const request = await fetch('api/usuarioReal', {
        method: 'POST',
        headers: {
        'Accept' : 'application/json',
        'Content-Type' : 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("Account created successfully");
    window.location.href="login.html";

}