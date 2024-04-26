import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:3333', // URL base da sua API
});

// Adiciona um interceptor para incluir o token JWT em todas as requisições
api.interceptors.request.use(
  config => {
    const token = localStorage.getItem('userToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

export default api;
