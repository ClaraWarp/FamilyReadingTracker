import axios from 'axios';

const http = axios.create ({
    baseURL: 'http://localhost:8080'
});

export default {

    getListOfPrizesByFamily(familyId){
        return http.get(`/api/v1/prizes/family/${familyId}`);
    },

    getPrizeById(id){
        return http.get(`/api/v1/prizes/${id}`);
    },

    createPrize(prize, familyId){
        return http.post(`/api/v1/prizes?familyId=${familyId}`, prize);
    },

    deletePrize(id) {
        return http.delete(`api/v1/prizes/${id}`);
    },

    editPrize(prize) {
        return http.put('api/v1/prizes', prize);
    }

}