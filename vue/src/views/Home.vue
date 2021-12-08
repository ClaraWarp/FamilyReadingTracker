<template>
  <div class="home">
    <span class="homeNav">
    <div id="family">
      <h2 class="twoLines">Family Navigation</h2>
      <div class="bookSection"></div>
    </div>
    <div id="reading"><h2>Reading Activity</h2></div>
    <div id="prizes"><h2>Prizes</h2></div>
    </span>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;500&display=swap");

h2 {
  font-family: "Nunito", sans-serif;
  text-align: center;
  margin: 20px;
}

.bookSection {
  border: 1px solid;
  flex-grow: 1;
  margin: 5px 10px 10px 0px;
  border-radius: 0px 20px 20px 0px;
  background-color: #a9d3ec;
}

.twoLines {
  line-height: 55px;
  margin: 10px 10px 5px 0px;
  border: 1px solid;
  border-radius: 0px 20px 20px 0px;
  padding: 5px;
  background-color: #a9d3ec;
}

.home {
  font-family: "Nunito", sans-serif;
  
}

.homeNav {
  display: grid;
  column-gap: 5px;
  height: 100vh;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-areas: 
  "familyNav readingNav readingNav prizeNav"

}

#family{
  grid-area: familyNav;
  display: flex;
  border: none;
  border-radius: 0px 20px 0px 0px;
  justify-content: center;
  background-color: #6939c3;
  font-size: 35px;
  justify-content: flex-start;
  flex-direction: column;
}

#reading{
  grid-area: readingNav;
  display: flex;
  border: none;
  border-radius: 20px;
  justify-content: center;
  background-color: #53a6d9;
  font-size: 35px;
  
  
}

#prizes{
  grid-area: prizeNav;
  display:flex;
  border: none;
  border-radius: 20px 0px 0px 0px;
  justify-content: center;
  background-color: #a9d3ec;
  font-size: 35px;
  
}
</style>
