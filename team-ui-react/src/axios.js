import axios from 'axios'

const instance = axios.create({
    baseURL : 'http://localhost:8081/api'
})

instance.interceptors.request.use (request =>{
    return request;
}, error =>{
    return Promise.reject(error);
})
export default instance;