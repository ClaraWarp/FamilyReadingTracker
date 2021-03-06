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
    },

    getUsers() {
        return http.get('/api/v1/users/');
    },

    // add post for relational table
    addUserToFamily(userIdForFamily, userIdToAdd, isParent) {
        return (http.get(`/api/v1/post/${userIdToAdd}/family/${userIdForFamily}/${isParent}`))
    }
}