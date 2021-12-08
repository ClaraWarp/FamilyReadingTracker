import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getFamilyByName(name){
        return http.get(`/families/${name}`);
    }
}