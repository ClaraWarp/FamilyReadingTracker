<template>
  <table>
    <thead>
      <tr>
        <th>Active Prizes</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="prize in prizes" v-bind:key="prize.prizeId" class="prize">
        <td class="prize-details">
          {{ prizes.name }}<br />{{ prizes.description }}<br />{{ prizes.timeRequirement }}
          <br />{{prizes.maxPrizes }} <br/> {{ prizes.startDate}} <br/> {{ prizes.endDate }}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import prizeService from "@/services/PrizeService.js";

export default {
    name: "prize-list",

    data() {
        return {
            user: this.$store.state.user
        };
    },
    prizeCreated() {
        prizeService.getListOfPrizesByFamily(this.user.id).then((response) => {
            if (response.status === 200) {
                this.$store.commit('SET_PRIZE', response.data);
            }
        });
    },
    computed: {
        prizes() {
            return this.$store.state.prizes;
        }
    }
};
</script>

<style scoped>
</style>