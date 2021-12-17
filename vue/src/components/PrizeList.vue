<template>
  <table id="prizeTable">
    <thead id="tableHead">
      <tr>
        <th id="list">Active Prizes</th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="prize in this.$store.state.prizes"
        v-bind:key="prize.prizeId"
        class="prize"
      >
        <td class="prize-details">
          <strong> Prize Name: </strong> {{ prize.name }}<br />
          <strong> Description: </strong> {{ prize.description }}<br />
          <strong> Time Read Requirement: </strong> {{ prize.timeRequirement }}
          <br />
          <strong> Total Winners: </strong> {{ prize.maxPrizes }} <br />
          <strong> Start Date: </strong> {{ prize.startDate }} <br />
          <strong> End Date: </strong> {{ prize.endDate }} <br />
          <!-- <router-link class="editPrize" to="AddNewPrize" tag="button"
            >Edit Prize</router-link > -->
          <button class="deletePrize" v-on:click="deletePrize(prize.prizeId)">
            <span class="buttons">Delete Prize</span>
          </button>
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import prizeService from "@/services/PrizeService.js";
import familiesService from "@/services/FamiliesService.js";

export default {
  name: "prize-list",

  data() {
    return {
      // prizes: this.$store.state.prizes,
      // family: this.$store.state.family.id,
    };
  },
  created() {
    familiesService
      .getFamilyByUser(this.$store.state.user.id)
      .then((famResponse) => {
        if (famResponse.status === 200) {
          prizeService
            .getListOfPrizesByFamily(famResponse.data.familyId)
            .then((response) => {
              if (response.status === 200) {
                this.$store.commit("SET_PRIZES", response.data);
              }
            });
        }
      });
  },
  props: ["users"],
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
    deletePrize(prizeId) {
        prizeService
          .deletePrize(prizeId, this.$store.state.family.id)
          .then((response) => {
            if (response.status === 200 || response.status === 204) {
              if (confirm("Do you want to delete this prize?")) {
              alert("Prize successfully deleted.");
              this.$store.commit("DELETE_PRIZE", prizeId);
            }
          }
      });
    },
    editPrize() {
      <router-link to="AddNewPrize" />;
    },
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
  border: dashed 3px   #6939c3;
  margin: 30px 70px;
}

/* .editPrize{
  background-color: royalblue;
} */

.deletePrize {
  background-color: #e64d27;
}

.buttons {
  color: black;
}

.prizeDetails {
  border: solid 2px black;
}
</style>