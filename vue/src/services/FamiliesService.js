import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getFamilyByName(name){
        return http.get(`/api/v1/families/${name}`);
    },

    createFamily(familyName) {
        return http.post(`/api/v1/families/${familyName}`);
    }
}