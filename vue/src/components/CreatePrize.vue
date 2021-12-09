<template>
    <form>
        <input
            class="name-input"
            type="text"
            placeholder="Prize Name"
            v-model="prizes.name"
            /> <br/>
        <input
            class="description-input"
            type="text"
            placeholder="Description"
            v-model="prizes.description"
            /> <br/>
        <input
            class="time-requirement-input"
            type="text"
            placeholder="Time Requirement"
            v-model="prizes.time_requirement"
            /> <br/>
        <input
            class="max-prizes-input"
            type="text"
            placeholder="Maximum Prize Recipients"
            v-model="prizes.max_prizes"
            /> <br/>
        <input
            class="start_date-input"
            type="text"
            placeholder="Start Date"
            v-model="prizes.start_date"
            /> <br/>
        <input
            class="end-date-input"
            type="text"
            placeholder="End Date"
            v-model="prizes.end_date"
            /> <br/>
        <button type="submit">Create Prize</button>
    </form>
</template>

<script>
import PrizeService from "@/services/PrizeService";

export default {
    name: "created-prize",
    data() {
        return{
            prize: {
                name: "",
                description: "",
                time_requirement: "",
                max_prizes: "",
                start_date: "",
                end_date: "",
            },
        };
    }

}
</script>

<style scoped>

</style>