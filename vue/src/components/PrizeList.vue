<template>
  <table id="prizeTable">
    <thead id="tableHead">
      <tr>
        <th id="list">Active Prizes</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="prize in $store.state.prizes" v-bind:key="prize.prizeId" class="prize">
        <td class="prize-details">
         
         Prize Name: {{ prize.name }}<br />
        {{ prize.description }}<br />
          {{prize.timeRequirement }} <br /> {{ prize.maxPrizes }} <br />
          {{ prize.startDate }} <br /> {{ prize.endDate }}
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
      // prizes: this.$store.state.prizes,
      // family: this.$store.state.family.id,
    };
  },
  created() {
    prizeService.getListOfPrizesByFamily(this.$store.state.family.id).then((response) => {
        if (response.status === 201) {
          this.$store.commit("SET_PRIZES", response.data);
          }
      });
  },
    // editPrize(prize) {
      // I need to access the id of the selected prize, router link to an edit page,
    // and use a put method to change that informtion
    // },
    // delete(prize) {
  // I also need to access the targeted prize, push the delete service using the router,
  // but I think both of these need params defined? Where do I define params??
    // },
    computed: {
      prizes() {
        return this.$store.state.prizes;
      },
      family() {
        return this.$store.state.family.id;
      }
    },
    methods: {
      retrievePrize() {
        prizeService
        .getPrizeById(this.$route.params.id)
        .then(response => {
          this.$store.commit("SET_PRIZE", response.data);
        });
      },
      deletePrize() {
        prizeService
        .deletePrize(this.prizes)
        .then(response => {
          if (response.status === 200) {
            alert("Prize successfully deleted");
            // this.$router.push{{ name: }}
          }
        })
      }
    }
};
</script>

<style scoped>
#list {
  text-align: center;
}

#prizeTable {
  display: flex;
  flex-direction: column;
}

#tableHead {
  display: flex;
  font-size: 1.25em;
  justify-content: center;
  margin: 30px 0px 0px 0px;
}

.prize {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 15px;
}

</style>