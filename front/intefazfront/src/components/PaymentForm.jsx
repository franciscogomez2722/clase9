import React, { useState } from 'react';
import axios from 'axios';

const PaymentForm = () => {
  // Estado para manejar el monto y el método de pago
  const [amount, setAmount] = useState('');
  const [method, setMethod] = useState('');

   /**
   * Maneja el evento de envío del formulario.
   * Realiza una solicitud POST para procesar el pago con el monto y método proporcionados.
   * 
   * @param {Event} e El evento de envío del formulario.
   */

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8080/api/payment', { amount, method });
      alert('Pago procesado con éxito');
    } catch (error) {
      alert('Error al procesar el pago');
      console.error(error);
    }
  };

  return (
    <div>
      <h1>Formulario de Pago</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Monto:
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          Método de pago:
          <select value={method} onChange={(e) => setMethod(e.target.value)} required>
            <option value="paypal">PayPal</option>
            <option value="stripe">Stripe</option>
            <option value="cashBack">CashBack</option>
            <option value="tacos">Tacos</option>
          </select>
        </label>
        <br />
        <button type="submit">Pagar</button>
      </form>
    </div>
  );
};

export default PaymentForm;
