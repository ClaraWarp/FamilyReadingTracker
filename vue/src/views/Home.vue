<template>
  <div class="home">
    <span class="homeNav">
    <div id="family">Family Navigation</div>
    <div id="reading">Reading Activity</div>
    <div id="prizes">Prizes</div>
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

.home {
  font-family: "Nunito", sans-serif;
  
}

.homeNav {
  display: grid;
  column-gap: 5px;
  height: 100vh;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
  "familyNav readingNav prizeNav"

}

#family{
  grid-area: familyNav;
  display: flex;
  border: none;
  border-radius: 20px;
  justify-content: center;
  background-color: #6939c3;
  font-size: 35px;
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
  border-radius: 20px;
  justify-content: center;
  background-color: #a9d3ec;
  font-size: 35px;
  
}
</style>
