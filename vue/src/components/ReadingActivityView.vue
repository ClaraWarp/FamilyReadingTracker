<template>
  <div class="readingActivityView">
    <!-- <log-activity v-if="toggle" @toggleLogActivity="toggle = false" />
    <log-activity-form v-if="!toggle" @toggleLogActivity="toggle = true" /> -->
    <reading-bank-bar/>
    <log-activity/>
    <log-activity-form/>
  
  </div>
</template>

<script>
import LogActivity from "./LogActivity.vue";
import LogActivityForm from "./LogActivityForm.vue";
import ReadingBankBar from "./readingBankBar.vue"

export default {
  components: { LogActivity, LogActivityForm, ReadingBankBar },
  data() {
    return {
      toggle: false,
    };
  },
};
</script>

<style scoped>
.readingActivityView {
  display: 
}
</style>