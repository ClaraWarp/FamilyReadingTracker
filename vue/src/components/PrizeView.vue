<template>
  <div class="prizeView">
    <create-prize v-if="toggle" @toggleCreatePrize="toggle = false" />
    <prize-form v-if="!toggle" @toggleCreatePrize="toggle = true" />
  </div>
</template>

<script>
import CreatePrize from "./CreatePrize.vue";
import PrizeForm from "./PrizeForm.vue";

export default {
  components: { CreatePrize, PrizeForm },
  data() {
    return {
      toggle: false,
    };
  },
};
</script>

<style scoped>
</style>