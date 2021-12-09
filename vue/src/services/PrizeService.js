import axios from 'axios';

const http = axios.create ({
    baseURL: 'http://localhost:8080'
});

export default {

    getListOfPrizesByFamily(familyId){
        return http.get(`/api/v1/prizes/${familyId}`);
    },

    getPrizeById(id){
        return http.get(`/api/v1/prizes/${id}`);
    },

    createPrize(prize){
        return http.post('/api/v1/prizes', prize);
    }

}