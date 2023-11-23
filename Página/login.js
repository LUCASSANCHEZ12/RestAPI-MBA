function validateForm() {
    var username = document.getElementsByName('code')[0].value;
    var password = document.getElementsByName('password')[0].value;

  console.log(username); 
  console.log(password);

const url = 'http://24.144.89.34:8080/MBA/Chatbot/login';
const username1 = username;
const password1 = password;

// Crear un objeto con los datos a enviar
const data = {
  codigoUsuario: username1,
  password: password1
};

// Convertir el objeto a una cadena de consulta (query string)
const queryString = Object.keys(data)
  .map(key => encodeURIComponent(key) + '=' + encodeURIComponent(data[key]))
  .join('&');

// Agregar la cadena de consulta a la URL
const urlWithQueryString = `${url}?${queryString}`;

// Realizar la solicitud GET
fetch(urlWithQueryString, {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json'
    // Puedes agregar más encabezados según sea necesario
  }
})
.then(response => response.json()) 
.then(data => {

  const {
      codigoUsuario, 
      cargoId,
      password,
      apellidoPaterno,
      segundoNombre,
      primerNombre,
      apellidoMaterno,
      telefono,
      email 
    } = data.valor1;

  const {
    cargoID,
    nombreCargo
  } = data.valor2;

  console.log(primerNombre); 
  console.log(segundoNombre);

})
  .catch(error => {
    // Manejar errores
    console.error('Error:', error);
  });

    var userType = getUserType(nombreCargo, password);

    if (userType != 'invalid') {
      // Asignar el tipo de usuario al campo oculto
      document.getElementById('usertype').value = userType;
      updateFormAction(nombreCargo); // Actualizar la acción del formulario
      return true;
    } else {
      alert('Credenciales inválidas');
      return false;
    }
  }

  function updateFormAction(userType) {
    var form = document.querySelector('form');
    var actionURL;

    // Determinar la URL de acción según el tipo de usuario
    switch (nombreCargo) {
      case 'admin':
        actionURL = 'homeAdmin.html';
        break;
      case 'docente':
        actionURL = 'homeTeacher.html';
        break;
      case 'estudiante':
        actionURL = 'homeStudent.html';
        break;
    }

    // Actualizar la acción del formulario con la URL correspondiente
    form.setAttribute('action', actionURL);
  }

  function getUserType(username, password) {
    switch (username) {
      case 'admin':
        return 'admin';
      case 'docente':
        return 'docente';
      case 'estudiante':
        return 'estudiante';
      default:
        return 'invalid';
    }
  }