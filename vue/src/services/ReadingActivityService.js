import axios from 'axios';

const http = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {

    getActivityById(id) {
        return http.get(`/api/v1/activity/${id}`);
    },

    createActivity(readingActivity) {
        return http.post('/api/v1/activity', readingActivity);
    },

    getTotalMinutesRead(userId) {
        return http.get(`/api/v1/${userId}/activities/readingBank`);
    }

}