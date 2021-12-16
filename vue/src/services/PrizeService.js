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
        return http.post(`/api/v1/prizes/${familyId}`, prize);
    },

    deletePrize(prizeId, familyId) {
        return http.delete(`api/v1/prizes/${prizeId}/${familyId}`);
    },

    editPrize(prize) {
        return http.put('api/v1/prizes', prize);
    }

}