<template>
  <div id="app">
    <div id="nav" >
      <router-link class="active" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="active"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Nunito:wght@400;500&display=swap");
#nav {
  font-family: "Nunito", sans-serif;
  display: ;
  padding: 15px;
  top:0%;
  font-size: 20px;
  background-color: #BEE1E6;
}
  
</style>
