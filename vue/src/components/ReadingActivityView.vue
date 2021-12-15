<template>
  <div class="readingActivityView">
    <log-activity v-if="toggle" @toggleLogActivity="toggle = false" />
    <log-activity-form v-if="!toggle" @toggleLogActivity="toggle = true" />
    <log-activity/>
    <log-activity-form/>
  </div>
</template>

<script>
import LogActivity from "./LogActivity.vue";
import LogActivityForm from "./LogActivityForm.vue";

export default {
  components: { LogActivity, LogActivityForm },
  data() {
    return {
      toggle: false,
    };
  },
};
</script>

<style scoped>
</style>