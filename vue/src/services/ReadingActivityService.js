import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getActivityById(id) {
        return http.get(`/activity/${id}`);
    },

    createActivity(readingActivity) {
        return http.post('/activity', readingActivity);
    }

}