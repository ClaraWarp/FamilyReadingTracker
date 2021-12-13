<template>
  <div class="titleWithSubLine">
    <h2 id="familyTitle">{{curFamilyName}} Family</h2>
    <div id="familyDetails">
      <div id="isParent">{{isParent}}</div>
      <button class="leftButton">Add Family Member</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      curFamilyName: this.$store.state.family.name
    }
  },
  computed: {
    isParent() {
        return this.$store.state.family.role === true ? 'parent' : 'child'
    }
  },
  methods: {

  }
};
</script>

<style scoped>
#leftBar {
  grid-area: leftNav;
  display: flex;
  border: none;
  border-radius: 0px 20px 0px 0px;
  background-color: #6939c3;
  font-size: 35px;
  justify-content: flex-start;
  flex-direction: column;
}

.titleWithSubLine {
  line-height: 55px;
  margin: 10px 10px 5px 0px;
  border-radius: 0px 20px 20px 0px;
  padding: 5px;
  background-color: #a9d3ec;
}

#isParent {
  flex-grow: 3;
}

#familyTitle {
  margin: 20px 20px 5px 20px;
}

#familyDetails {
  display: flex;
}

.leftButton {
  color: white;
  background-color: #6939c3;
  border: 1px solid #6939c3;
  border-radius: 5px;
  padding: 2px 7px;
  margin: 2px 5px 5px 0px;
  font-size: 16px;
}

.leftButton:hover {
  color: #6930c3;
  background-color: white;
}
</style>