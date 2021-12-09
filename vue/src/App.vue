<template>
  <div id="app">
    <div id="nav" v-if="$store.state.token != ''">
      <router-link class="active" 
        v-bind:to="{ name: 'home' }" 
        >Home</router-link>&nbsp;|&nbsp;
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
  font-family: "Proxima Nova", sans-serif;
  display: inline-block;
  padding: 15px;
  top:0%;
  font-size: 20px;
}

#app {
  background-color: #53a6d9;
}

a.active {
  color: white;
  text-decoration: none;
  border: 1px solid #6939c3;
  border-radius: 5px;
  padding: 0px 7px;
  background-color: #6939c3;
  font-family: "Nunito", sans-serif;
}

a.active:hover {
  color: #6930c3;
  background-color: white;
}

</style>
