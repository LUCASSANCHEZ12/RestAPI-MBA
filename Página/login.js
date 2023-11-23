function validateForm() {
    var code = document.getElementsByName('code')[0].value;
    var password = document.getElementsByName('password')[0].value;

    // Verificar el tipo de usuario
    var userType = getUserType(code, password);

    if (userType != 'invalid') {
      // Asignar el tipo de usuario al campo oculto
      document.getElementById('usertype').value = userType;
      updateFormAction(userType); // Actualizar la acción del formulario
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
    switch (userType) {
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