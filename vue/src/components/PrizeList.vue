<template>
  <table id="prizeTable">
    <thead id="tableHead">
      <tr>
        <th id="list">Active Prizes</th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="prize in $store.state.prizes"
        v-bind:key="prize.prizeId"
        class="prize"
      >
        <td class="prize-details">
         <strong> Prize Name: </strong> {{ prize.name }}<br />
         <strong> Description: </strong> {{ prize.description }}<br />
         <strong> Time Read Requirement: </strong> {{ prize.timeRequirement }} <br />
         <strong> Total Winners: </strong> {{ prize.maxPrizes }} <br />
         <strong> Start Date: </strong> {{ prize.startDate }} <br />
         <strong> End Date: </strong> {{ prize.endDate }} <br/>
         <router-link class="editPrize" to="AddNewPrize" tag="button">Edit Prize</router-link>
          <button class="deletePrize" v-on:click="deletePrize"><span class="buttons">Delete Prize</span>
           </button>
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
    prizeService
      .getListOfPrizesByFamily(this.$store.state.family.id)
      .then((response) => {
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
    },
  },
  methods: {
    retrievePrize() {
      prizeService.getPrizeById(this.$route.params.id).then((response) => {
        this.$store.commit("SET_PRIZE", response.data);
      });
    },
    deletePrize() {
      prizeService.deletePrize(this.prizes).then((response) => {
        if (response.status === 200 || response.status === 204) {
          alert("Prize successfully deleted.");
          this.$store.commit("DELETE_PRIZE", this.prizes);
        }
      });
    },
    editPrize() {
      <router-link to="AddNewPrize"/>
    }
  },
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

/* .editPrize{
  background-color: royalblue;
} */

.deletePrize{
  background-color: #e64d27;
}

.buttons {
  color: black;
}
</style>