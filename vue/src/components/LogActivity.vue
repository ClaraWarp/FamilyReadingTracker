<template>
 <form id= "activityForm">
     <label id="accountNameLabel" for="name-input">Name of Account:</label>
     <input
      class="name-input"
      type="text"
      placeholder="Account Name"
      v-model="readingActivity.accountForName"
    />
    <br/>

    <label id="readingFormatLabel" for="reading-format-input">Format:</label>
    <input
      class="reading-format-input"
      type="text"
      placeholder="Format Type"
      v-model="readingActivity.formatType"
    />
    <!-- need to switch to radio type which gives choices (maybe) -->
    <br/>

    <label id="timeReadLabel" for="time-read-input">Time Spent Reading(in minutes):</label>
    <input
      class="time-read-input"
      type="number" 
      placeholder="Time Spent Reading"
      v-model="readingActivity.timeRead"
    />
    <br/>

    <label id="bookNameLabel" for="book-name-input">Name of book:</label>
    <input
      class="book-name-input"
      type="text"
      placeholder="Book Name to add"
      v-model="readingActivity.bookNameToAdd"
    />
    <!-- need to switch to radio with options of all books that user added -->
    <br/>

    <button type="submit" id="submit-button"  @click.prevent="saveActivity">Save Activity</button>
    <button type="button" @click="toggleCreateActivity">Back</button>
 </form>

</template>

<script>
import ReadingActivityService from "@/services/ReadingActivityService";

export default {
  name: "logActivity",
  data() {
    return {
      readingActivity : {
        accountForName: '',
        formatType: '',
        timeRead: '',
        bookNameToAdd: '',
    
      },
    //   family: this.$store.state.family.id
    };
  },

  methods: {
    createActivity() {
      ReadingActivityService.createActivity(this.readingActivity ).then(response => {
        if (response.status === 201) {
          this.$store.commit("SET_ACTIVITY", this.readingActivity);
        }
      });
    },
    resetForm() {
      this.readingActivity = {};
      this.showForm = false;
    },
    toggleCreateActivity() {
      this.$emit("toggleCreateActivity");
    }
  },
};
</script>

<style>

</style>