function validateForm() {
    var code = document.getElementsByName('code')[0].value;
    var password = document.getElementsByName('password')[0].value;

  console.log(code); 
  console.log(password);

const url = 'http://24.144.89.34:8080/MBA/Chatbot/login';
const code1 = code;
const password1 = password;

// Crear un objeto con los datos a enviar
const data = {
  codigoUsuario: code1,
  password: password1
};

// Convertir el objeto a una cadena de consulta (query string)
const queryString = Object.keys(data)
  .map(key => encodeURIComponent(key) + '=' + encodeURIComponent(data[key]))
  .join('&');

// Agregar la cadena de consulta a la URL
const urlWithQueryString = `${url}?${queryString}`;

// Realizar la solicitud GET
fetch(queryString, {
  method: 'GET',
  headers: {
    'Content-Type': 'application/json'
    // Puedes agregar más encabezados según sea necesario
  }, 
  body: JSON.stringify(data)
})
.then(response => response.json()) 
.then(data => {

  const {
      codigoUsuario,
      password,
      cargoId,
      segundoNombre,
      primerNombre,
      apellidoPaterno,
      apellidoMaterno,
      email,
      telefono
    } = data.valor1;

  const {
    cargoID,
    nombreCargo,
    descripcion
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

  function getUserType(code, password) {
    switch (code) {
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