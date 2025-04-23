import React, { useState } from 'react';
import axios from 'axios';

/**
 * Componente para enviar notificaciones.
 * 
 * Este componente permite a los usuarios enviar notificaciones por correo electrónico,
 * SMS o Telegram mediante la interfaz de usuario. Realiza una solicitud HTTP a un 
 * backend para enviar la notificación y muestra el mensaje de confirmación o error.
 */
const NotificationPanel = () => {
  // Estado que guarda el mensaje de la respuesta de la API.
  const [message, setMessage] = useState("");

  /**
   * Función para enviar la notificación al backend.
   * 
   * Realiza una solicitud GET a la API en el backend (en este caso, localhost:8080)
   * pasando el tipo de notificación como parámetro en la URL.
   * 
   * @param {string} type - El tipo de notificación a enviar (puede ser "email", "sms", "telegram").
   */
  const notify = async (type) => {
    try {
      // Realiza la solicitud HTTP al backend.
      const res = await axios.get(`http://localhost:8080/api/notify/${type}`);
      // Al recibir la respuesta, actualiza el estado con el mensaje de la respuesta.
      setMessage(res.data);
    } catch (error) {
      // Si ocurre un error en la solicitud, muestra el mensaje de error.
      setMessage("Error al enviar la notificación");
      console.error(error);
    }
  };

  return (
    <div style={{ padding: 30 }}>
      {/* Título del panel */}
      <h1>Enviar Notificación</h1>
      {/* Botones para seleccionar el tipo de notificación */}
      <button onClick={() => notify("email")}>Correo</button>
      <button onClick={() => notify("sms")}>SMS</button>
      <button onClick={() => notify("telegram")}>Telegram</button>
      {/* Muestra el mensaje recibido desde el backend */}
      <p>{message}</p>
    </div>
  );
};

export default NotificationPanel;
