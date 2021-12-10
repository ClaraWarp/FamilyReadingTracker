<template>
  <form @submit.prevent="savePrize">
    <input
      class="name-input"
      type="text"
      placeholder="Prize Name"
      v-model="prizes.name"
    />
    <br />
    <input
      class="description-input"
      type="text"
      placeholder="Description"
      v-model="prizes.description"
    />
    <br />
    <input
      class="time-requirement-input"
      type="text"
      placeholder="Time Requirement"
      v-model="prizes.timeRequirement"
    />
    <br />
    <input
      class="max-prizes-input"
      type="text"
      placeholder="Maximum Prize Recipients"
      v-model="prizes.maxPrizes"
    />
    <br />
    <input
      class="start_date-input"
      type="text"
      placeholder="Start Date"
      v-model="prizes.startDate"
    />
    <br />
    <input
      class="end-date-input"
      type="text"
      placeholder="End Date"
      v-model="prizes.endDate"
    />
    <br />
    <button type="submit" @click="savePrize()">Create Prize</button>
  </form>
</template>

<script>
import prizeService from "@/services/PrizeService";

export default {
  name: "CreatePrize",
  data() {
    return {
      prizes: {
        name: "",
        description: "",
        timeRequirement: "",
        maxPrizes: "",
        startDate: "",
        endDate: "",
      },
    };
  },

  methods: {
    savePrize() {
      prizeService.createPrize(this.prize).then(response => {
        if (response.status === 201) {
          this.$router.push("/prizes");
        }
      });
    },
  },
};
</script>

<style scoped>
</style>