import axios from 'axios';

const http = axios.create ({
    baseURL: 'http://localhost:8080'
});

export default {

    getListOfPrizesByFamily(familyId){
        return http.get(`/prizes/${familyId}`);
    },

    getPrizeById(id){
        return http.get(`/prizes/${id}`);
    },

    createPrize(prize){
        return http.post('/prizes', prize);
    }
    
}