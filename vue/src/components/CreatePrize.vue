<template>
  <form id="prizeForm" @submit.prevent="resetForm">
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
    <label id="startDateLabel" for="startDate">Start Date:</label>
    <br/>
    <input
      id="startDate"
      class="start-date-input"
      type="date"
      placeholder="Start Date"
      v-model="prizes.startDate"
    />
    <br />
    <label  id="endDateLabel" for="endDate">End Date:</label>
    <br/>
    <input
      id="endDate"
      class="end-date-input"
      type="date"
      placeholder="End Date"
      v-model="prizes.endDate"
    />
    <br />
    <button type="submit" id="submit-button"  @click.prevent="savePrize">Create Prize</button>
    <button type="button" @click="toggleCreatePrize">Back</button>
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
      family: this.$store.state.family.id
    };
  },

  methods: {
    savePrize() {
      prizeService.createPrize(this.prizes, this.family).then(response => {
        if (response.status === 201) {
          this.$store.commit("SET_PRIZE", this.prizes, this.family);
        }
      });
    },
    resetForm() {
      this.prizes = {};
      this.showForm = false;
    },
    toggleCreatePrize() {
      this.$emit("toggleCreatePrize");
    }
  },
};
</script>

<style scoped>

#prizeForm{
    text-align: center;
}

.name-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.description-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.time-requirement-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.max-prizes-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.start-date-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.end-date-input {
    text-align: center;
    font-size: 20px;
    margin: 5px;
}

.submit-button {
    font-size: 20px;
    margin: 5px;
    padding: 5px;
}

#endDateLabel {
  font-size: 18px;
  font-weight: bold;
}

#startDateLabel {
  font-size: 18px;
  font-weight: bold;
}

</style>