import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getFamilyByName(name){
        return http.get(`/api/v1/families/${name}`);
    },

    createFamily(familyName, userID) {
        return http.post(`/api/v1/families/${familyName}/${userID}`);
    },

    getFamilyByUser(userID) {
        return http.get(`/api/v1/${userID}/family`);
    }
}